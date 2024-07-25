package com.microservices.Expenses.repository;

import com.microservices.Expenses.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Expense findByCategory(String category);
}
