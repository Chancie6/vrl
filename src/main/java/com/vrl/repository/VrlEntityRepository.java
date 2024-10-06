package com.vrl.repository;

import com.vrl.entity.VrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VrlEntityRepository extends JpaRepository<VrlEntity, Long> {
}