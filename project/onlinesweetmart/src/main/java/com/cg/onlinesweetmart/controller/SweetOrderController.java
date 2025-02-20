package com.cg.onlinesweetmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinesweetmart.entity.SweetOrder;
import com.cg.onlinesweetmart.service.impl.SweetOrderServiceImpl;

@RestController
@RequestMapping("/api/sweetorders")
public class SweetOrderController {
	
    @Autowired
    private SweetOrderServiceImpl sweetOrderServiceImpl;
    
    @PostMapping("/{userId}")
    public ResponseEntity<SweetOrder> addSweetOrder(@PathVariable Long userId, @RequestBody SweetOrder sweetOrder) {
        SweetOrder sweetOrder2 = sweetOrderServiceImpl.addSweetOrder(userId, sweetOrder);
        return new ResponseEntity<SweetOrder>(sweetOrder2, HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<SweetOrder> updateSweetOrder(@RequestBody SweetOrder sweetOrder) {
        SweetOrder sweetOrder2 = sweetOrderServiceImpl.updateSweetOrder(sweetOrder);
        return new ResponseEntity<>(sweetOrder2, HttpStatus.OK);
    }
    
    @DeleteMapping("/{sweetOrderId}")
    public ResponseEntity<SweetOrder> cancelSweetOrder(@PathVariable("sweetOrderId") Long sweetOrderId) {
        SweetOrder sweetOrder2 = sweetOrderServiceImpl.cancelSweetOrder(sweetOrderId);
        return new ResponseEntity<>(sweetOrder2, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<SweetOrder>> showAllSweetOrders() {
        List<SweetOrder> sweetOrderList = sweetOrderServiceImpl.showAllSweetOrders();
        return new ResponseEntity<>(sweetOrderList, HttpStatus.OK);
    }
    
    @GetMapping("/{sweetOrderId}")
    public ResponseEntity<Double> calculateTotalCost(@PathVariable() Long sweetOrderId) {
        Double total = sweetOrderServiceImpl.calculateTotalCost(sweetOrderId);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
