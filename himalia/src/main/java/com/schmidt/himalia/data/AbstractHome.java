/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * the helper class of data access object (DAO) ({@link Home}) for an entity
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 * @param <E> the type of entity class
 * @param <K> the type of primary key
 */
public abstract class AbstractHome<E, K> implements Home<E, K>  {

	/**
	 * @return the entity manager
	 */
	public abstract EntityManager getEntityManager();
	
	/**
	 * @return the entity class
	 */
	public abstract Class<E> getEntityClass();
	
	/**
	 * @return the entity name
	 */
	private String getEntityName() {
		return this.getEntityClass().getName();
	}
	
	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#getUniqueKey(java.lang.String)
	 */
	public UniqueKey<E> getUniqueKey(final String name) {
		return new UniqueKey<E>(this.getEntityManager(), this.getEntityClass(), name);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#getIndex(java.lang.String)
	 */
	public Index<E> getIndex(final String name) {
		return new Index<E>(this.getEntityManager(), this.getEntityClass(), name);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#exists(java.lang.Object)
	 */
	public boolean exists(final K pk) {
		return this.get(pk) != null;
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#get(java.lang.Object)
	 */
	public E get(final K pk) {
		return this.getEntityManager().find(this.getEntityClass(), pk);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#delete(java.lang.Object)
	 */
	public boolean delete(final K pk) {
		
		E e = this.get(pk);
		if (e != null) {
			this.getEntityManager().remove(e);
		}
		return e != null;
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#create(java.lang.Object)
	 */
	public void create(final E e) {
		this.getEntityManager().persist(e);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createListQuery()
	 */
	public TypedQuery<E> createListQuery() {
		return this.getEntityManager().createQuery("from " + this.getEntityName(), this.getEntityClass());
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createListQuery(java.lang.String)
	 */
	public TypedQuery<E> createListQuery(final String sql) {
		return this.getEntityManager().createQuery("from " + this.getEntityName() + " " + sql, this.getEntityClass());
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createListQuery(java.lang.String[])
	 */
	public TypedQuery<E> createListQuery(final String[] columns) {
		
		String sql = "";
		if (columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql = sql + " and " + columns[i] + " = :" + columns[i];
			}
			sql = sql.substring(5);
		}
		return this.createListQuery(sql);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#list()
	 */
	public List<E> list() {
		return this.createListQuery().getResultList();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#list(java.lang.String, java.lang.Object[])
	 */
	public List<E> list(final String sql, final Object... args) {
		
		TypedQuery<E> query = this.createListQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#list(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<E> list(final String sql, final String[] names, final Object[] args) {
		
		TypedQuery<E> query = this.createListQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#list(java.lang.String[], java.lang.Object[])
	 */
	public List<E> list(final String[] columns, final Object[] args) {

		TypedQuery<E> query = this.createListQuery(columns);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createCountQuery()
	 */
	public Query createCountQuery() {
		return this.getEntityManager().createQuery("select count(e) from " + this.getEntityName() + " e");
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createCountQuery(java.lang.String)
	 */
	public Query createCountQuery(final String sql) {
		return this.getEntityManager().createQuery("select count(e) from " + this.getEntityName() + " e where " + sql);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createCountQuery(java.lang.String[])
	 */
	public Query createCountQuery(final String[] columns) {
		
		String sql = "";
		if (columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql = sql + " and e." + columns[i] + " = :" + columns[i];
			}
			sql = sql.substring(5);
		}
		return this.getEntityManager().createQuery("select count(e) from " + this.getEntityName() + " e where " + sql);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#count()
	 */
	public long count() {
		return ((Number) this.createCountQuery().getSingleResult()).longValue();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#count(java.lang.String, java.lang.Object[])
	 */
	public long count(final String sql, final Object... args) {
		
		Query query = this.createCountQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return ((Number) query.getSingleResult()).longValue();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#count(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public long count(final String sql, final String[] names, final Object... args) {

		Query query = this.createCountQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(names[i], args[i]);
		}
		return ((Number) query.getSingleResult()).longValue();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#count(java.lang.String[], java.lang.Object[])
	 */
	public long count(final String[] columns, final Object... args) {

		Query query = this.createCountQuery(columns);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(columns[i], args[i]);
		}
		return ((Number) query.getSingleResult()).longValue();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createUpdateQuery(java.lang.String)
	 */
	public Query createUpdateQuery(final String sql) {
		return this.getEntityManager().createQuery("update " + this.getEntityName() + " set " + sql);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#update(java.lang.String, java.lang.Object[])
	 */
	public int update(final String sql, final Object... args) {
		
		Query query = this.createUpdateQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.executeUpdate();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#update(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public int update(final String sql, final String[] names, final Object[] args) {
		
		Query query = this.createUpdateQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(names[i], args[i]);
		}
		return query.executeUpdate();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createDeleteQuery(java.lang.String)
	 */
	public Query createDeleteQuery(final String sql) {
		return this.getEntityManager().createQuery("delete from " + this.getEntityName() + " " + sql);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#createDeleteQuery(java.lang.String[])
	 */
	public Query createDeleteQuery(final String[] columns) {
		
		String sql = "";
		if (columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql = sql + " and " + columns[i] + " = :" + columns[i];
			}
			sql = sql.substring(5);
		}
		return this.createDeleteQuery(sql);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#delete(java.lang.String, java.lang.Object[])
	 */
	public int delete(final String sql, final Object... args) {
		
		Query query = this.createDeleteQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		return query.executeUpdate();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#delete(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public int delete(final String sql, final String[] names, final Object[] args) {

		Query query = this.createDeleteQuery(sql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(names[i], args[i]);
		}
		return query.executeUpdate();
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.Home#delete(java.lang.String[], java.lang.Object[])
	 */
	public int delete(final String[] columns, final Object[] args) {

		Query query = this.createDeleteQuery(columns);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(columns[i], args[i]);
		}
		return query.executeUpdate();
	}
}
