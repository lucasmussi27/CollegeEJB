/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aluno
 */
public abstract class GenericDAO<T> {
    private Class<T> entityClass;
    
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getManager();
    
    public void create(T obj) throws Exception {
        getManager().persist(obj);
    }
    
    public List<T> read() throws Exception {
        return getManager().createQuery("from " + entityClass, 
                entityClass).getResultList();
    }
    
    public void update(T obj) throws Exception {
        getManager().merge(obj);
    }
    
    public void delete(Object id) throws Exception {
        getManager().remove(getManager().find(entityClass, id));
    }
    
    public T findById(Object id) throws Exception {
        return getManager().find(entityClass, id);
    }
}
