/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

/**
 * This index is used to find or delete entities with values of index. It implements <b>list</b> and 
 * <b>delete</b> methods for every index
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 * @param <E> the type of entity class
 */
public class Index<E> {

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
	protected Index(final EntityManager entityManager, final Class<E> entityClass, final String name) {
		
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
			throw new IllegalArgumentException("Index " + name + " is not defined in calss " + entityClass.getName());
		}
		
		this.entityClass = entityClass;
		this.entityManager = entityManager;
		
		for (String column : index.columnList().split(",")) {
			this.from += " and " + column.trim().split(" ")[0] + " = ?"; 
		}
		this.from = "from " + entityClass.getName() + " where " + this.from.substring(5);
	}
	
	/**
	 * @return the count query with all index columns
	 */
	public Query createCountQuery() {
		return this.entityManager.createQuery("select count(*) " + this.from);
	}
	
	/**
	 * @param args the value of all columns for count
	 * @return how many rows have been counted
	 */
	public long count(final Object... args) {

		Query query = this.createCountQuery();
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return ((Number) query.getSingleResult()).longValue();
	}
	
	/**
	 * @return the list query
	 */
	public TypedQuery<E> createListQuery() {
		return this.entityManager.createQuery(this.from, this.entityClass);
	}
	
	/**
	 * 
	 * @param args the values of index fields
	 * @return the entities that matched with argument values according to index
	 */
	public List<E> list(final Object... args) {
		
		TypedQuery<E> query = this.createListQuery();
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.getResultList();
	}

	/**
	 * @return the delete query
	 */
	public Query createDeleteQuery() {
		return this.entityManager.createQuery("delete " + this.from);
	}
	
	/**
	 * 
	 * @param args the values of index fields
	 * @return how many entities has been deleted with argument values according to index
	 */
	public int delete(final Object... args) {
		
		Query query = this.createDeleteQuery();
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.executeUpdate();
	}
}
