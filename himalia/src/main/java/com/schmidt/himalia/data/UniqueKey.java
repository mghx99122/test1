/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.data;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

/**
 * This unique key is used to find or delete entity with values of unique key. It implements <b>exists</b>, 
 * <b>get</b> and <b>delete</b> methods for every unique key.
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 * @param <E> the type of entity class
 */
public class UniqueKey<E> {

	/**
	 * the entity manager
	 */
	private EntityManager entityManager;

	/**
	 * the from HQL clause
	 */
	private String from = "";
	
	/**
	 * the entity class
	 */
	private Class<E> entityClass;
	
	/**
	 * @param entityManager the entity manager
	 * @param entityClass the entity class
	 * @param name the index name that is defined in Table annotation
	 */
	protected UniqueKey(final EntityManager entityManager, final Class<E> entityClass, final String name) {
		
		Table table = entityClass.getAnnotation(Table.class);
		if (table == null) {
			throw new IllegalArgumentException("Calss " + entityClass.getName() + " is not annotated with @Table.");
		}
		
		javax.persistence.Index index = null;
		for (int i = 0; i < table.indexes().length; i++) {
			if (name.equalsIgnoreCase(table.indexes()[i].name())) {
				index = table.indexes()[i];
				break;
			}
		}
		if (index == null) {
			throw new IllegalArgumentException("Unique " + name + " is not defined in calss " + entityClass.getName());
		}
		if (!index.unique()) {
			throw new IllegalArgumentException("Unique " + name + " is required in calss " + entityClass.getName());
		}
		
		this.entityClass = entityClass;
		this.entityManager = entityManager;
		
		for (String column : index.columnList().split(",")) {
			this.from += " and " + column.trim().split(" ")[0] + " = ?"; 
		}
		this.from = "from " + entityClass.getName() + " where " + this.from.substring(5);
	}

	/**
	 * <p>Test whether an entity exists in data source or not by values of columns in unique key. </p>
	 * 
	 * @param args the values of columns in unique key
	 * @return <code>true</code> if entity exists in data source
	 */
	public boolean exists(final Object... args) {
		return this.get(args) != null;
	}

	/**
	 * @return the get query
	 */
	public TypedQuery<E> createGetQuery() {
		return this.entityManager.createQuery(this.from, this.entityClass);
	}
	
	/**
	 * <p>Find an entity instance from data source by values of columns in unique key. </p> 
	 * 
	 * @param args the values of columns in unique key
	 * @return entity instance or <code>null</code> if does not exists
	 */
	public E get(final Object... args) {

		TypedQuery<E> query = this.createGetQuery();
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.getSingleResult();
	}

	/**
	 * @return the delete query
	 */
	public Query createDeleteQuery() {
		return this.entityManager.createQuery("delete " + this.from);
	}
	
	/**
	 * <p>Delete an entity from data source by values of columns in unique key. </p>
	 * 
	 * @param args the values of columns in unique key
	 * @return <code>true</code> if entity has been deleted from data source
	 */
	public int delete(final Object... args) {
		
		Query query = this.createDeleteQuery();
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.executeUpdate();
	}
}
