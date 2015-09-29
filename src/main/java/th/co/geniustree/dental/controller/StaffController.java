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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.model.Staff;
import th.co.geniustree.dental.model.StaffPicture;
import th.co.geniustree.dental.model.SearchData;
import th.co.geniustree.dental.repo.EmployeeRepo;
import th.co.geniustree.dental.repo.StaffPictureRepo;
import th.co.geniustree.dental.repo.StaffRepo;
import th.co.geniustree.dental.service.StaffSearchService;
import th.co.geniustree.dental.spec.StaffSpec;

/**
 *
 * @author Best
 */
@RestController
public class StaffController {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private StaffPictureRepo staffPictureRepo;
    @Autowired
    private StaffSearchService employeeSearchService;

    @RequestMapping(value = "/savestaff", method = RequestMethod.POST)
    public void saveStaff(@Validated @RequestBody Staff staff) {
        staffRepo.save(staff);
    }

    @RequestMapping(value = "/savestaffimage", method = RequestMethod.POST)
    public StaffPicture saveStaffPicture(MultipartRequest file) throws IOException {
        StaffPicture staffPicture = new StaffPicture();
        staffPicture.setContentImage(file.getFile("file").getBytes());
        staffPicture.setName(file.getFile("file").getOriginalFilename());
        staffPicture.setType(file.getFile("file").getName());
        return staffPicture;
    }

    @RequestMapping(value = "/getnoimage", method = RequestMethod.GET)
    public StaffPicture getNoImage() {
        StaffPicture staffPicture = staffPictureRepo.findOne(1);
        return staffPicture;
    }

    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public Page<Staff> getStaff(Pageable pageable) {
        return staffRepo.findAll(pageable);
    }

    @RequestMapping(value = "/totalstaff", method = RequestMethod.GET)
    public Long getTotalStaff() {
        return staffRepo.count();
    }
    
   
     @RequestMapping(value = "/searchstaff/count" , method = RequestMethod.POST)
    public Long getTotalSearch(@RequestBody SearchData searchData){
    String searchBy = searchData.getSearchBy();
    String keyword = searchData.getKeyword();
    Long count = null;
    if ("Email".equals(searchBy)) {
            count = staffRepo.count(StaffSpec.emailLike("%"+keyword+"%"));
        }
        if ("Name".equals(searchBy)) {
            count = staffRepo.count(StaffSpec.nameLike("%"+keyword+"%"));
        }
        if ("Mobile".equals(searchBy)) {
            count = staffRepo.count(StaffSpec.mobileLike("%"+keyword+"%"));
         }
        if ("Personal ID".equals(searchBy)) {
            count = staffRepo.count(StaffSpec.pidLike("%"+keyword+"%"));
        }
        return count;
    }

    
    @RequestMapping(value = "/searchstaff", method = RequestMethod.POST)
    public Page<Staff> search(@RequestBody SearchData searchData, Pageable pageable) {
        String keyword = searchData.getKeyword();
        String searchBy = searchData.getSearchBy();
        Page<Staff> staff = null;
        if ("Email".equals(searchBy)) {
            staff = employeeSearchService.searchByEmail(keyword, pageable);
        }
        if ("Name".equals(searchBy)) {
            staff = employeeSearchService.searchByName(keyword, pageable);
        }
        if ("Mobile".equals(searchBy)) {
            staff = employeeSearchService.searchByMobile(keyword, pageable);
         }
        if ("Personal ID".equals(searchBy)) {
            staff = employeeSearchService.searchByPid(keyword, pageable);
        }
        return staff;
    }

    @RequestMapping(value = "/getstaffimage", method = RequestMethod.GET)
    public StaffPicture getStaffPicture(Integer id) {
        return staffPictureRepo.findOne(id);
    }

    @RequestMapping(value = "/deletestaff", method = RequestMethod.POST)
    public void deleteStaff(@RequestBody Staff staff) {
        staffRepo.delete(staff);
    }
    
      @RequestMapping(value = "/startpagestaff", method = RequestMethod.GET)
    public Employee getCurrentLogin() {
        Employee employee = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer id = employeeRepo.findByEmail(employee.getEmail()).getId();
       return employeeRepo.findOne(id);
    }
}
