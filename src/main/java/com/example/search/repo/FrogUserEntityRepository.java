package com.example.search.repo;

import com.example.search.entity.FrogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrogUserEntityRepository extends JpaRepository<FrogEntity, Long> {
}
