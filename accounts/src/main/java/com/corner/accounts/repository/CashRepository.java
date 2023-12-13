package com.corner.accounts.repository;

import com.corner.accounts.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRepository extends JpaRepository<Cash,Long> {
}
