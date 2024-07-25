package com.microservices.Expenses.controller;

import com.microservices.Expenses.model.Expense;
import com.microservices.Expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
     private final ExpenseService expenseService;
     @Autowired
     public ExpenseController(final ExpenseService expenseService) {
         this.expenseService = expenseService;
     }
    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
         Expense savedExpense = expenseService.addExpense(expense);
         return ResponseEntity.ok(savedExpense);
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
         return ResponseEntity.ok(expenseService.getAllExpenses());
    }
    @GetMapping("/id/{idExpense}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("idExpense") Long idExpense){
        return ResponseEntity.ok(expenseService.getExpenseById(idExpense));
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<Expense> getExpenseByCategory(@PathVariable("category") String category){
        return ResponseEntity.ok(expenseService.getExpenseByCategory(category));
    }
    @PutMapping("{idExpense}")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense, @PathVariable("idExpense") Long idExpense) {
         return ResponseEntity.ok(expenseService.updateExpense(idExpense, expense));
    }
    @DeleteMapping("{idExpense}")
    public ResponseEntity<String> deleteExpense(@PathVariable("idExpense") Long idExpense) {
         expenseService.deleteExpense(idExpense);
         return ResponseEntity.ok("Expense Deleted");
    }
}
