/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.repo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.dental.model.Employee;

/**
 *
 * @author Best
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

    public Employee findByEmail(String email);
    
}
