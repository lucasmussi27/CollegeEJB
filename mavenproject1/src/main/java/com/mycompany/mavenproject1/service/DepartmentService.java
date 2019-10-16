/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import com.mycompany.mavenproject1.dao.DepartmentDAO;
import com.mycompany.mavenproject1.model.Department;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Aluno
 */
@Stateless
public class DepartmentService {
    @Inject
    private DepartmentDAO dao;
    
    public List<Department> listAll() throws Exception {
        return dao.read();
    }
    
    public void add(Department dep) throws Exception {
        dao.create(dep);
    }
    
    public void edit(Department dep) throws Exception {
        dao.update(dep);
    }
    
    public void remove(Department dep) throws Exception {
        dao.delete(dep.getId());
    }
    
    public Department findById(Object id) throws Exception {
        return dao.findById(id);
    }
    
    public Optional<Department> findByCode(String code) throws Exception {
        return dao.findByCode(code);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
