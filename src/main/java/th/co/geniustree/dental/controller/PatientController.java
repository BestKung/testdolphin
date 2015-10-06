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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;
import th.co.geniustree.dental.model.MedicalHistory;
import th.co.geniustree.dental.model.Patient;
import th.co.geniustree.dental.model.PatientPicture;
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

    @RequestMapping(value = "/getmedicalhistory", method = RequestMethod.GET)
    private Page<MedicalHistory> getmedicalHistory(Pageable pageable) {
        return medicalHistoryRepo.findAll(pageable);
    }

    @RequestMapping(value = "/savepatient", method = RequestMethod.POST)
    private void savePatient(@RequestBody Patient patient) {
        patientRepo.save(patient);
    }

    @RequestMapping(value = "/savepatientpicturexray", method = RequestMethod.POST)
    private PatientPicture savePatientPictureXray(MultipartRequest multipartRequest) throws IOException {
        PatientPicture picture = new PatientPicture();
        System.out.println("----------------------------------------------->xray");
        picture.setNameXrayFilm(multipartRequest.getFile("xray").getOriginalFilename());
        picture.setContentXrayFilm(multipartRequest.getFile("xray").getBytes());
        picture.setMimeTypeXrayFilm(multipartRequest.getFile("xray").getName());

        return picture;
    }

    @RequestMapping(value = "/savepatientpicturebefore", method = RequestMethod.POST)
    private PatientPicture savePatientPictureBefore(MultipartRequest multipartRequest) throws IOException {
        PatientPicture picture = new PatientPicture();
        picture.setNameBefore(multipartRequest.getFile("before").getOriginalFilename());
        picture.setContentBefore(multipartRequest.getFile("before").getBytes());
        picture.setMimeTypeBefore(multipartRequest.getFile("before").getName());

        return picture;
    }

    @RequestMapping(value = "/savepatientpicturecurrent", method = RequestMethod.POST)
    private PatientPicture savePatientPictureCurrent(MultipartRequest multipartRequest) throws IOException {
        PatientPicture picture = new PatientPicture();
        picture.setNameCurrent(multipartRequest.getFile("current").getOriginalFilename());
        picture.setContentCurrent(multipartRequest.getFile("current").getBytes());
        picture.setMimeTypeCurrent(multipartRequest.getFile("current").getName());

        return picture;
    }

    @RequestMapping(value = "/savepatientpictureafter", method = RequestMethod.POST)
    private PatientPicture savePatientPictureAfter(MultipartRequest multipartRequest) throws IOException {
        PatientPicture picture = new PatientPicture();
        picture.setNameAfter(multipartRequest.getFile("after").getOriginalFilename());
        picture.setContentAfter(multipartRequest.getFile("after").getBytes());
        picture.setMimeTypeAfter(multipartRequest.getFile("after").getName());

        return picture;
    }
}
