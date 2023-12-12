package com.corner.chronicleregister.repository;

import com.corner.chronicleregister.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members,Long> {
}
