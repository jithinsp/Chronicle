package com.corner.accounts.service;

import com.corner.accounts.dto.CreateCashRequest;
import com.corner.accounts.entity.Cash;

import java.util.List;

public interface CashService {
    List<Cash> getAllCash();

    Cash getCashById(Long id);

    Cash createCash(CreateCashRequest createCashRequest);

    void deleteCashById(Long id);
}
