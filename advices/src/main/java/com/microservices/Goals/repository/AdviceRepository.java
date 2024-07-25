package com.microservices.Goals.repository;

import com.microservices.Goals.model.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {
}
