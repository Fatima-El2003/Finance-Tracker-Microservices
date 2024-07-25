package com.microservices.Incomes.repository;

import com.microservices.Incomes.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    Income findBySource(String source);
}
