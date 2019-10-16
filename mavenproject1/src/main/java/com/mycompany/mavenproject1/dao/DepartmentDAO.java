/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.model.Department;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aluno
 */
public class DepartmentDAO extends GenericDAO<Department> {
    @PersistenceContext(unitName = "TestePU")
    private EntityManager em;
    
    public DepartmentDAO() {
        super(Department.class);
    }

    @Override
    protected EntityManager getManager() {
        return em;
    }
    
    public Optional<Department> findByCode(String code) throws Exception {
        return this.read().stream().filter(e -> e.getCode().equals(code)).findAny();
    }
}
