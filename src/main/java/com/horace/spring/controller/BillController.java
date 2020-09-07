package com.horace.spring.controller;

import com.horace.spring.common.enums.ErrorType;
import com.horace.spring.model.mongo.Bill;
import com.horace.spring.model.mongo.ResponseDto;
import com.horace.spring.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;

    @RequestMapping("bill/getAllBills")
    public ResponseDto getAllBills() {
        List<Bill> entity = this.billRepository.findAll();
        return new ResponseDto(entity, "", true, ErrorType.SUCCESS);
    }
}
