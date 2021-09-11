package com.projeto.dsvendas.controllers;

import java.util.List;

import com.projeto.dsvendas.dto.SaleDTO;
import com.projeto.dsvendas.dto.SaleSuccessDTO;
import com.projeto.dsvendas.dto.SaleSumDTO;
import com.projeto.dsvendas.service.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> result = saleService.findAll(pageable);       
        return ResponseEntity.ok(result); 
    }
    
    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> result = saleService.amountGroupedBySeller();       
        return ResponseEntity.ok(result); 
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
        List<SaleSuccessDTO> result = saleService.successGroupedBySeller();       
        return ResponseEntity.ok(result); 
    }
    
}
