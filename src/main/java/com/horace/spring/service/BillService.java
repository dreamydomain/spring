package com.horace.spring.service;

import com.horace.spring.model.Bill;
import com.horace.spring.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BillService {
    @Autowired
    private BillRepository billRepository;

    public Bill findOneByTitle(String title) {
        return billRepository.findOneByTitle(title);
    }
}
