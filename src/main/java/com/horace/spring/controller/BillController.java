package com.horace.spring.controller;

import com.horace.spring.common.enums.ErrorType;
import com.horace.spring.common.utils.StringUtil;
import com.horace.spring.model.mongo.Bill;
import com.horace.spring.model.mongo.ResponseDto;
import com.horace.spring.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")  // 处理同源阻止访问的问题，一般前后端分离会遇到这种问题
@RequestMapping(value = "/bill")
public class BillController {
    @Autowired
    private BillRepository billRepository;

    @GetMapping("/getAllBills")
    public ResponseDto getAllBills() {
        List<Bill> entity = this.billRepository.findAll();
        return new ResponseDto(entity, "", true, ErrorType.SUCCESS);
    }

    @GetMapping("/FindById")
    public ResponseDto FindById(@RequestParam String id) {
        Bill bill = this.billRepository.findOneById(id);
        return new ResponseDto(bill, "", true, ErrorType.SUCCESS);
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody Bill bill) {
        if (StringUtil.isNullOrEmpty(bill.getId())) {
            bill.setCreateTime(new Date());
        } else {
            bill.setEditTime(new Date());
        }
        this.billRepository.save(bill);
        return new ResponseDto(bill, "保存成功！", true, ErrorType.SUCCESS);
    }

    @PostMapping("/delete")
    public ResponseDto delete(@RequestBody String id) {
        this.billRepository.deleteById(id);
        return new ResponseDto(null, "删除成功！", true, ErrorType.SUCCESS);
    }
}
