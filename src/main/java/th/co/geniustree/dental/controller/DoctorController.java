/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import th.co.geniustree.dental.model.Doctor;
import th.co.geniustree.dental.model.DoctorPicture;
import th.co.geniustree.dental.repo.DoctorRepo;

/**
 *
 * @author Best
 */
@RestController
public class DoctorController {
    
    @Autowired
    private DoctorRepo doctorRepo;
    
    @RequestMapping(value = "/savedoctor" , method = RequestMethod.POST)
    private void saveDoctor(@Validated @RequestBody Doctor doctor){
    doctorRepo.save(doctor);
    }
    
    @RequestMapping(value = "/selectpicture" , method = RequestMethod.POST)
    private DoctorPicture selectPicture(MultipartRequest file) throws IOException{
    DoctorPicture doctorPicture = new DoctorPicture();
    doctorPicture.setName(file.getFile("file").getOriginalFilename());
    doctorPicture.setContent(file.getFile("file").getBytes());
    doctorPicture.setMimeType(file.getFile("file").getName());
    return doctorPicture;
    }
    
    
    
}
