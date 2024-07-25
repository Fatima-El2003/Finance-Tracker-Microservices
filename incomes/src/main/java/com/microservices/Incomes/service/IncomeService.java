package com.microservices.Incomes.service;

import com.microservices.Incomes.model.Income;

import java.util.List;

public interface IncomeService {
    Income addIncome(Income income);
    Income updateIncome(Long idIncome, Income updatedIncome);
    Income getIncomeById(Long idIncome);
    List<Income> getAllIncomes();
    void deleteIncome(Long idIncome);
    Income getIncomeBySource(String source);
}
