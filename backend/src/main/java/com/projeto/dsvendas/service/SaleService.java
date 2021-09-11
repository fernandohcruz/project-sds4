package com.projeto.dsvendas.service;

import java.util.List;

import com.projeto.dsvendas.dto.SaleDTO;
import com.projeto.dsvendas.dto.SaleSuccessDTO;
import com.projeto.dsvendas.dto.SaleSumDTO;
import com.projeto.dsvendas.entities.Sale;
import com.projeto.dsvendas.repositories.SaleRepository;
import com.projeto.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {
    
    @Autowired
    SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map(element -> new SaleDTO(element));
    }

    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepository.amountGroupedBySeller();
    }

    public List<SaleSuccessDTO> successGroupedBySeller() {
        return saleRepository.successGroupedBySeller();
    }
}
