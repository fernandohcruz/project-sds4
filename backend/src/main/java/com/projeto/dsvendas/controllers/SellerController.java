package com.projeto.dsvendas.controllers;

import java.util.List;

import com.projeto.dsvendas.dto.SellerDTO;
import com.projeto.dsvendas.service.SellerService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<SellerDTO> listSeller = sellerService.findAll();
        return ResponseEntity.ok(listSeller);
    }
}
