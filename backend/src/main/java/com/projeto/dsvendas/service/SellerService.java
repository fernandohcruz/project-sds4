package com.projeto.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto.dsvendas.dto.SellerDTO;
import com.projeto.dsvendas.entities.Seller;
import com.projeto.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    
    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerDTO> findAll(){
        List<Seller> result =  sellerRepository.findAll();
        return result.stream().map(element -> new SellerDTO(element)).collect(Collectors.toList());
    }
}
