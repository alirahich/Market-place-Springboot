package com.marketplace.services;

import com.Auth.Entities.AppUser;
import com.Auth.Repository.AppUserRepository;
import com.marketplace.models.Payment;
import com.marketplace.repository.PaymentRepository;
import com.marketplace.models.Produits;
import com.marketplace.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public Payment createPayment(String idProduit) {
        Payment payment = new Payment();
        Produits produits = produitRepository.getProduitsById(idProduit);
        payment.setTo(produits.getUser());
        payment.setAmount(produits.getPrice());
        payment.setProduit(idProduit);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = appUserRepository.findByUsername((String) auth.getPrincipal());
        String from  = appUser.getId();
        payment.setFrom(from);

        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> listFromUserPayments() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = appUserRepository.findByUsername((String) auth.getPrincipal());
        String from  = appUser.getId();
        return paymentRepository.findAllByFrom(from);
    }
    @Override
    public List<Payment> listToUserPayments() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = appUserRepository.findByUsername((String) auth.getPrincipal());
        String to  = appUser.getId();
        return paymentRepository.findAllByTo(to);
    }
    @Override
    public List<Payment> listProduitPayments(String produit) {
        return paymentRepository.findAllByProduit(produit);
    }

}
