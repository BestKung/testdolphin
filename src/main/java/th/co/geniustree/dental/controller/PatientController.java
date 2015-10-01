/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.dental.model.MedicalHistory;
import th.co.geniustree.dental.model.Patient;
import th.co.geniustree.dental.repo.MedicalHistoryRepo;
import th.co.geniustree.dental.repo.PatientRepo;

/**
 *
 * @author Best
 */
@RestController
public class PatientController {
    
    @Autowired
    private PatientRepo patientRepo;
    
    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;
    
    @RequestMapping(value = "/getmedicalhistory" , method = RequestMethod.GET)
    private Page<MedicalHistory> getmedicalHistory(Pageable pageable){
    return medicalHistoryRepo.findAll(pageable);
    }
            
    @RequestMapping(value = "/savepatient" , method = RequestMethod.POST)
    private void savePatient(@RequestBody Patient patient){
    patientRepo.save(patient);
    }
    
}
