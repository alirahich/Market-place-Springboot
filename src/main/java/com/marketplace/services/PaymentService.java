package com.marketplace.services;

import com.marketplace.models.Payment;

import java.util.List;

public interface PaymentService {
    public Payment createPayment(String idProduit);
    public List<Payment> listPayments();
    public List<Payment> listFromUserPayments();
    public List<Payment> listToUserPayments();
    public List<Payment> listProduitPayments(String id);
}

