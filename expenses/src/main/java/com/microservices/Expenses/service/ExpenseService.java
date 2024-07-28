package com.microservices.Expenses.service;

import com.microservices.Expenses.model.Expense;

import java.util.List;


public interface ExpenseService {
    Expense addExpense(Expense expense);
    Expense updateExpense(Long idExpense, Expense updatedExpense);
    Expense getExpenseById(Long idExpense);
    List<Expense> getAllExpenses();
    void deleteExpense(Long idExpense);
    Expense getExpenseByCategory(String category);
}
