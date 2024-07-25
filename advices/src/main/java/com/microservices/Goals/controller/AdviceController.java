package com.microservices.Goals.controller;

import com.microservices.Goals.model.Advice;
import com.microservices.Goals.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advices")
public class AdviceController {
     private final AdviceService adviceService;
     @Autowired
     public AdviceController(final AdviceService adviceService) {
         this.adviceService = adviceService;
     }
    @PostMapping
    public ResponseEntity<Advice> createAdvice(@RequestBody Advice advice) {
        Advice savedAdvice = adviceService.addAdvice(advice);
        return ResponseEntity.ok(savedAdvice);
    }
    @GetMapping
    public ResponseEntity<List<Advice>> getAllAdvices() {
         return ResponseEntity.ok(adviceService.getAllAdvices());
    }
    @GetMapping("{idAdvice}")
    public ResponseEntity<Advice> getAdviceById(@PathVariable("idAdvice") Long idAdvice){
        return ResponseEntity.ok(adviceService.getAdviceById(idAdvice));
    }
    @DeleteMapping("{idAdvice}")
    public ResponseEntity<String> deleteAdvice(@PathVariable("idAdvice") Long idAdvice) {
         adviceService.deleteAdvice(idAdvice);
         return ResponseEntity.ok("Advice Deleted");
    }
}
