package com.corner.accounts.service;

import com.corner.accounts.dto.CreateCashRequest;
import com.corner.accounts.entity.Cash;
import com.corner.accounts.repository.CashRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CashServiceImpl implements CashService{
    @Autowired
    CashRepository cashRepository;

    public List<Cash> getAllCash() {
        return cashRepository.findAll();
    }

    public Cash getCashById(Long id) {
        return cashRepository.findById(id).orElseThrow();
    }

    public Cash createCash(CreateCashRequest createCashRequest) {
        Cash cash = new Cash();
        BeanUtils.copyProperties(createCashRequest,cash);
        cash.setEnteredDate(LocalDateTime.now());
        cash.setEnteredBy("Junior Accountant"); //replace this with currently logged in user
        cash.setVerified(false);
        Cash createdCash = cashRepository.save(cash);
        cash.setId(createdCash.getId());
        return cash;
    }

    public void deleteCashById(Long id) {
        cashRepository.deleteById(id);
    }
}
