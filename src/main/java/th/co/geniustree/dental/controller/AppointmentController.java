/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.dental.model.Appointment;
import th.co.geniustree.dental.repo.AppointmentRepo;

/**
 *
 * @author Best
 */
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @RequestMapping(value = "/saveappointment" , method = RequestMethod.POST)
    private void saveAppointment(@RequestBody Appointment appointment) {
        appointmentRepo.save(appointment);
    }

}
