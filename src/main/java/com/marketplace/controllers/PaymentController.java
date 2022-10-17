package com.marketplace.controllers;

import com.marketplace.models.Payment;
import com.marketplace.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public List<Payment> payments (){
        return paymentService.listPayments();
    }

    @PostMapping("/createPayment/{idProduit}")
    public Payment createPay(@PathVariable String idProduit){
        return paymentService.createPayment(idProduit);
    }

    @GetMapping("/usersFromPayment")
    public List<Payment> UserFromPayment(){
        return paymentService.listFromUserPayments();
    }
    @GetMapping("/usersToPayment")
    public List<Payment> UserToPayment(){
        return paymentService.listToUserPayments();
    }

    @GetMapping("/listProduitPayment/{id}")
    public List<Payment> ListProdPaymt(@PathVariable String id){
        return paymentService.listProduitPayments(id);
    }

}



