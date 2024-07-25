package com.microservices.Incomes.service;

import com.microservices.Incomes.exception.ResourceNotFoundException;
import com.microservices.Incomes.model.Income;
import com.microservices.Incomes.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    @Autowired
    public IncomeServiceImpl(IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }
    @Override
    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Income updateIncome(Long idIncome, Income updatedincome) {
        Income income = getIncomeById(idIncome);
        income.setAmount(updatedincome.getAmount());
        income.setDate(updatedincome.getDate());
        income.setSource(updatedincome.getSource());
        return incomeRepository.save(income);
    }

    @Override
    public Income getIncomeById(Long idIncome) {
        return incomeRepository.findById(idIncome).orElseThrow(() -> new ResourceNotFoundException("le personnel ave cet id n'existe pas" +idIncome ));
    }

    @Override
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    @Override
    public void deleteIncome(Long idIncome) {
        incomeRepository.deleteById(idIncome);
    }

    @Override
    public Income getIncomeBySource(String source) {
        return incomeRepository.findBySource(source);
    }
}
