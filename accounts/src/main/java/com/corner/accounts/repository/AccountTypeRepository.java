package com.corner.accounts.repository;

import com.corner.accounts.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {
}
