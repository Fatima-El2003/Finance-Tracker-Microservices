package com.microservices.Expenses.service;

import com.microservices.Expenses.exception.ResourceNotFoundException;
import com.microservices.Expenses.model.Expense;
import com.microservices.Expenses.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j //when this service will be called while it's taking long time before responding
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Long idExpense, Expense updatedexpense) {
        Expense expense = getExpenseById(idExpense);
        expense.setAmount(updatedexpense.getAmount());
        expense.setDate(updatedexpense.getDate());
        expense.setCategory(updatedexpense.getCategory());
        return expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long idExpense) {
        return expenseRepository.findById(idExpense).orElseThrow(() -> new ResourceNotFoundException("le personnel ave cet id n'existe pas" +idExpense ));
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public void deleteExpense(Long idExpense) {
        expenseRepository.deleteById(idExpense);
    }

    @Override
    public Expense getExpenseByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }
}
