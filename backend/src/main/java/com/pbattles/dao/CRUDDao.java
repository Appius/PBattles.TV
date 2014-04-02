package com.pbattles.dao;

/**
 * Created by Nazar_Sheremeta on 4/2/14.
 */
public interface CRUDDao<T> {
    public void insert(T entity);
    public T findById(Object id);
    public void update(T entity);
    public void remove(T entity);
}
