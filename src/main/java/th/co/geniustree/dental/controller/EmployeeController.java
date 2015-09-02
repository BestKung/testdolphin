/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.model.EmployeePicture;
import th.co.geniustree.dental.repo.EmployeePictureRepo;
import th.co.geniustree.dental.repo.EmployeeRepo;

/**
 *
 * @author Best
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeePictureRepo employeePictureRepo;
    private EmployeePicture employeePicture;

    @RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
    public void saveEmployee(@Validated @RequestBody Employee employee) {
        if (employeePicture != null) {
            employee.setEmployeePicture(employeePicture);
        }
        employeeRepo.save(employee);
        employeePicture = new EmployeePicture();
    }

    @RequestMapping(value = "/saveemployeeimage", method = RequestMethod.POST)
    public void saveEmployeePicture(MultipartRequest file) throws IOException {
        employeePicture.setContent(file.getFile("file").getBytes());
        employeePicture.setName(file.getFile("file").getOriginalFilename());
        employeePicture.setType(file.getFile("file").getName());
    }

    @RequestMapping(value = "/getnoimage", method = RequestMethod.GET)
    public EmployeePicture getFileReader() {
        EmployeePicture emppicture = employeePictureRepo.findOne(1);
        return emppicture;
    }

    @RequestMapping(value = "/employees" , method = RequestMethod.GET)
    public Page<Employee> getEmployee(Pageable pageable){
    return employeeRepo.findAll(pageable);
    }
}
