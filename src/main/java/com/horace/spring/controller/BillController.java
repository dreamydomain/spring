package com.horace.spring.controller;

import com.horace.spring.common.enums.ErrorType;
import com.horace.spring.model.mongo.Bill;
import com.horace.spring.model.mongo.ResponseDto;
import com.horace.spring.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")  // 处理同源阻止访问的问题，一般前后端分离会遇到这种问题
@RequestMapping(value = "/bill")
public class BillController {
    @Autowired
    private BillRepository billRepository;

    @RequestMapping("/getAllBills")
    public ResponseDto getAllBills() {
        List<Bill> entity = this.billRepository.findAll();
        return new ResponseDto(entity, "", true, ErrorType.SUCCESS);
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody Bill bill) {
        this.billRepository.save(bill);
        return new ResponseDto(bill, "", true, ErrorType.SUCCESS);
    }
}
