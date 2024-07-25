package com.microservices.Incomes.controller;

import com.microservices.Incomes.model.Income;
import com.microservices.Incomes.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {
     private final IncomeService incomeService;
     @Autowired
     public IncomeController(final IncomeService incomeService) {
         this.incomeService = incomeService;
     }
    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody Income income) {
        Income savedIncome = incomeService.addIncome(income);
         return ResponseEntity.ok(savedIncome);
    }
    @GetMapping
    public ResponseEntity<List<Income>> getAllIncomes() {
         return ResponseEntity.ok(incomeService.getAllIncomes());
    }
    @GetMapping("/id/{idIncome}")
    public ResponseEntity<Income> getIncomeById(@PathVariable("idIncome") Long idIncome){
        return ResponseEntity.ok(incomeService.getIncomeById(idIncome));
    }
    @GetMapping("/source/{source}")
    public ResponseEntity<Income> getIncomeBySource(@PathVariable("source") String source){
        return ResponseEntity.ok(incomeService.getIncomeBySource(source));
    }
    @PutMapping("{idIncome}")
    public ResponseEntity<Income> updateIncome(@RequestBody Income income, @PathVariable("idIncome") Long idIncome) {
         return ResponseEntity.ok(incomeService.updateIncome(idIncome, income));
    }
    @DeleteMapping("{idIncome}")
    public ResponseEntity<String> deleteIncome(@PathVariable("idIncome") Long idIncome) {
        incomeService.deleteIncome(idIncome);
         return ResponseEntity.ok("Income Deleted");
    }
}
