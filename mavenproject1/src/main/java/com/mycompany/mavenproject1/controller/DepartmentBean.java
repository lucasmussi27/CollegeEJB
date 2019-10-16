/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.model.Department;
import com.mycompany.mavenproject1.service.DepartmentService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author Aluno
 */
@Named(value = "depBean")
@SessionScoped
public class DepartmentBean implements Serializable {
    @EJB
    private DepartmentService service;
    private Department department;
    private List<Department> list;
    
    public void novo() {
        department = new Department();
    }
    
    public void select(ActionEvent event) throws Exception {
        int id = (int) event.getComponent().getAttributes().get("id");
        department = service.findById(id);
    }
    
    public void add() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            service.add(department);
            novo();
            context.addMessage(null, new FacesMessage("Department edited successfully!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Error during editing department!"));
            Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void edit() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            service.edit(department);
            novo();
            context.addMessage(null, new FacesMessage("Department removed successfully!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Error during removing department!"));
            Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void remove() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            service.remove(department);
            novo();
            context.addMessage(null, new FacesMessage("Department added successfully!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Error during adding department!"));
            Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public List<Department> getDepartments() throws Exception {
        list = service.listAll();
        return list;
    }
    
    public void setDepartments(List<Department> list) {
        this.list = list;
    }
}
