/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.dental.model.OrderHeal;
import th.co.geniustree.dental.repo.OrderHealRepo;


/**
 *
 * @author Jasin007
 */
@RestController
public class OrderHealController {
    
    @Autowired
    OrderHealRepo orderHealRepo;
    
    @RequestMapping(value = "/loadorderheal")
    public Page<OrderHeal> loadOrderHeal(Pageable pageable){
        return orderHealRepo.findAll(pageable);
    }
    
    
}
