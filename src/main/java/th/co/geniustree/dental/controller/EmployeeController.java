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
import th.co.geniustree.dental.model.SearchData;
import th.co.geniustree.dental.repo.EmployeePictureRepo;
import th.co.geniustree.dental.repo.EmployeeRepo;
import th.co.geniustree.dental.service.EmployeeSearchService;

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
    @Autowired
    private EmployeeSearchService employeeSearchService;

    @RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
    public void saveEmployee(@Validated @RequestBody Employee employee) {
//        if (employeePicture.getContentImage() != null) {
//            employee.setEmployeePicture(employeePicture);
//        }
//        else if(employee.getEmployeePicture() != null){
//            
//        }
        employeeRepo.save(employee);
       // employeePicture = new EmployeePicture();
    }

    @RequestMapping(value = "/saveemployeeimage", method = RequestMethod.POST)
    public EmployeePicture saveEmployeePicture(MultipartRequest file) throws IOException {
        System.out.println("--------------------------------------------------------->"+file.getFileNames());
         //System.out.println("--------------------------------------------------------->"+file.getFileNames());
          System.out.println("--------------------------------------------------------->"+file.getFileMap());
        EmployeePicture employeePicture = new EmployeePicture();
        employeePicture.setContentImage(file.getFile("file").getBytes());
        employeePicture.setName(file.getFile("file").getOriginalFilename());
        employeePicture.setType(file.getFile("file").getName());
        return employeePicture;
    }

    @RequestMapping(value = "/getnoimage", method = RequestMethod.GET)
    public EmployeePicture getFileReader() {
        EmployeePicture emppicture = employeePictureRepo.findOne(1);
        return emppicture;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public Page<Employee> getEmployee(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @RequestMapping(value = "/totalemployee", method = RequestMethod.GET)
    public Long getTotalEmployee() {
        return employeeRepo.count();
    }

    @RequestMapping(value = "/searchemployee", method = RequestMethod.POST)
    public Page<Employee> search(@RequestBody SearchData searchData, Pageable pageable) {
        String keyword = searchData.getKeyword();
        String searchBy = searchData.getSearchBy();
        Page<Employee> employees = null;
        System.out.println("----------------------------------------------------------------------->" + keyword);
        System.out.println("----------------------------------------------------------------------->" + searchBy);
        if ("Email".equals(searchBy)) {
            employees = employeeSearchService.searchByEmail(keyword, pageable);
            System.out.println("--------------------------------------->Email");
        }
        if ("Name".equals(searchBy)) {
            employees = employeeSearchService.searchByName(keyword, pageable);
            System.out.println("--------------------------------------------->Name");
        }
        if ("Mobile".equals(searchBy)) {
            employees = employeeSearchService.searchByMobile(keyword, pageable);
            System.out.println("-------------------------------------------------->Mobile");
        }
        if ("Personal ID".equals(searchBy)) {
            employees = employeeSearchService.searchByPid(keyword, pageable);
            System.out.println("---------------------------------------------------->Personal Id");
        }
        System.out.println(employees);
        return employees;
    }

    @RequestMapping(value = "/getemployeeimage", method = RequestMethod.GET)
    public EmployeePicture getEmployeePicture(Integer id) {
        System.out.println("----------------------------------------------------------->" + id);
        return employeePictureRepo.findOne(id);
    }

    @RequestMapping(value = "/deleteemployee", method = RequestMethod.POST)
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeRepo.delete(employee);
    }
}
