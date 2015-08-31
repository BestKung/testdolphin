/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void saveEmployee(@RequestBody Employee employee) {
        System.out.println("------------------------------------------------------------------------------>" + employee);
        System.out.println("--------------------------------------------------------->" + employeePicture);
        if (employeePicture != null) {
            employee.setEmployeePicture(employeePicture);
        }
        employeeRepo.save(employee);
        employeePicture = new EmployeePicture();
    }

    @RequestMapping(value = "/saveemployeeimage", method = RequestMethod.POST)
    public void saveEmployeePicture(MultipartRequest file) throws IOException {
        System.out.println("------------------------------------------------>" + file.getFile("file"));
        employeePicture.setContent(file.getFile("file").getBytes());
        System.out.println("--------------------------------------------------------->" + file.getFile("file").getBytes());
        employeePicture.setName(file.getFile("file").getOriginalFilename());
        System.out.println("--------------------------------------------------------->" + file.getFile("file").getOriginalFilename());
        employeePicture.setType(file.getFile("file").getName());
        System.out.println("--------------------------------------------------------->" + file.getFile("file").getName());
    }

    @RequestMapping(value = "/getnoimage", method = RequestMethod.GET)
    public EmployeePicture getFileReader() {
        EmployeePicture emppicture = employeePictureRepo.findOne(1);
        return emppicture;
    }

}
