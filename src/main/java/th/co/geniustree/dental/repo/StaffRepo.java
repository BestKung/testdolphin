/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.model.Staff;

/**
 *
 * @author Best
 */
public interface StaffRepo extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff>{
   
    public Staff findByEmail(String email);
}
