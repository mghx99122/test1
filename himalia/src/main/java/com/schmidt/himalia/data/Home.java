/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.data;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * This is the interface for entity home, just like Data Access Object (DAO). It implements most often used methods
 * for an entity.
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 * @param <E> the type of entity class
 * @param <K> the type of primary key
 */
public interface Home<E, K> {

	/**
	 * @param name the name of unique constraint
	 * @return the unique key or <code>null</code> if does not exist
	 */
	UniqueKey<E> getUniqueKey(String name);
	
	/**
	 * @param name the name of index key
	 * @return the index or <code>null</code> if does not exist
	 */
	Index<E> getIndex(String name);
	
	/**
	 * @param pk the object of primary key
	 * @return whether entity exist by object of primary key
	 */
	boolean exists(K pk);
	
	/**
	 * <p>Find an entity instance (table record) from database by primary key (argument k). </p> 
	 * 
	 * @param pk the values of the primary key
	 * @return the entity instance or <code>null</code> if does not exists
	 */
	E get(K pk);
	
	/**
	 * <p>Delete an entity instance (table record) from database by primary key (argument k). </p>
	 * 
	 * @param pk the primary key
	 * @return whether object exists and deleted
	 */	
	boolean delete(K pk);
	
	/**
	 * <p>Insert a new entity instance into database. Before update, this method will check
	 * whether id of entity is not <code>null</code>. If id is not <code>null</code>, it will 
	 * throw an exception. </p>
	 * 
	 * @param e the entity instance
	 */	
	void create(E e);
	
	/**
	 * @return the query to list all records
	 */
	TypedQuery<E> createListQuery();
	
	/**
	 * @param sql the query language 
	 * @return the query
	 */
	TypedQuery<E> createListQuery(String sql);
	
	/**
	 * @param columns the column name
	 * @return the query
	 */
	TypedQuery<E> createListQuery(String[] columns);
	
	/**
	 * @return all entity instances (table record) from database
	 */
	List<E> list();

	/**
	 * <p>Find a set of entity instances (table record) from database by after FROM [ENTITY] SQL and
	 * its numbered parameters (argument args) from database. </p>
	 * 
	 * <p>NOTES: this method will return a ZERO array event find nothing from database, but never return
	 * <code>null</code> array. </p>
	 * 
	 * @param sql the after FROM [ENTITY] SQL statement
	 * @param args the numbered parameters
	 * @return the array of entity instances
	 */
	List<E> list(String sql, Object... args);

	/**
	 * <p>Find a set of entity instances (table record) from database by after FROM [ENTITY] SQL and
	 * its named parameters (argument names and args) from database. </p>
	 * 
	 * <p>NOTES: this method will return a ZERO array event find nothing from database, but never return
	 * <code>null</code> array. </p>
	 * 
	 * @param sql the after FROM [ENTITY] SQL statement
	 * @param names the parameter names
	 * @param args the parameter values
	 * @return the array of entity instances
	 */
	List<E> list(String sql, String[] names, Object[] args);

	/**
	 * list entities with columns and values of columns
	 * 
	 * @param columns the columns
	 * @param args the value of columns
	 * @return the list of entity instances
	 */
	List<E> list(String[] columns, Object[] args);
	
	/**
	 * @return the count all query
	 */
	Query createCountQuery();
	
	/**
	 * @param sql count SQL statement
	 * @return the count query by SQL statement
	 */
	Query createCountQuery(String sql);
	
	/**
	 * @param columns the table columns
	 * @return the count query by table columns
	 */
	Query createCountQuery(String[] columns);
	
	/**
	 * <p>This method will count how many records in this table. </p>
	 * 
	 * @return how many records in this table
	 */
	long count();

	/**
	 * <p>This method will count how many records in this table with a filter argument SQL and its 
	 * parameters. </p>
	 * 
	 * @param sql the after FROM [ENTITY] SQL statement
	 * @param args the parameter values
	 * @return how many records after filter in this table
	 */
	long count(String sql, Object... args);

	/**
	 * <p>This method will count how many records in this table with a filter argument SQL and its 
	 * parameters. </p>
	 * 
	 * @param sql the after FROM [ENTITY] SQL statement
	 * @param names the parameter names
	 * @param args the parameter values
	 * @return how many records after filter in this table
	 */
	long count(String sql, String[] names, Object... args);

	/**
	 * @param columns the column names
	 * @param args the column values
	 * @return how many rows are filtered by columns and values 
	 */
	long count(String[] columns, Object... args);
	
	/**
	 * @param sql the JQL statement
	 * @return the query by JQL statement
	 */
	Query createUpdateQuery(String sql);
	
	/**
	 * <p>This method is used to batch update entity instances in database. </p>
	 * 
	 * @param sql the after UPDATE [ENTITY] SQL statement
	 * @param args the numbered parameter values
	 * @return how many records have been updated
	 */
	int update(String sql, Object... args);

	/**
	 * <p>This method is used to batch update entity instances in database. </p>
	 * 
	 * @param sql the after UPDATE [ENTITY] SQL statement
	 * @param names the parameter names
	 * @param args the parameter values
	 * @return how many records have been updated
	 */
	int update(String sql, String[] names, Object[] args);

	/**
	 * @param sql the DELETE JQL statement
	 * @return the query for DELETE JQL statement 
	 */
	Query createDeleteQuery(String sql);
	
	/**
	 * @param columns the table columns
	 * @return the query for DELETE JQL statement
	 */
	Query createDeleteQuery(String[] columns);
	
	/**
	 * <p>This method is used to batch delete entity instances from database. </p>
	 * 
	 * @param sql the after DELETE FROM [ENTITY] SQL statement
	 * @param args the numbered parameter values
	 * @return how many records has been deleted
	 */
	int delete(String sql, Object... args);

	/**
	 * <p>This method is used to batch delete entity instances from database. </p>
	 * 
	 * @param sql the after DELETE FROM [ENTITY] SQL statement
	 * @param names the parameter names
	 * @param args the parameter values
	 * @return how many records has been deleted
	 */
	int delete(String sql, String[] names, Object[] args);
	
	/**
	 * @param columns the column name
	 * @param args the value arguments
	 * @return how many records has been deleted
	 */
	int delete(String[] columns, Object[] args);
}
