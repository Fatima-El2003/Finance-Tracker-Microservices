package com.microservices.Goals.controller;

import com.microservices.Goals.model.Goal;
import com.microservices.Goals.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {
     private final GoalService goalService;
     @Autowired
     public GoalController(final GoalService goalService) {
         this.goalService = goalService;
     }
    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal savedGoal = goalService.addGoal(goal);
        return ResponseEntity.ok(savedGoal);
    }
    @GetMapping
    public ResponseEntity<List<Goal>> getAllGoals() {
         return ResponseEntity.ok(goalService.getAllGoals());
    }
    @GetMapping("{idGoal}")
    public ResponseEntity<Goal> getGoalById(@PathVariable("idGoal") Long idGoal){
        return ResponseEntity.ok(goalService.getGoalById(idGoal));
    }
    @PutMapping("{idGoal}")
    public ResponseEntity<Goal> updateGoal(@RequestBody Goal goal, @PathVariable("idGoal") Long idGoal) {
         return ResponseEntity.ok(goalService.updateGoal(idGoal, goal));
    }
    @DeleteMapping("{idGoal}")
    public ResponseEntity<String> deleteGoal(@PathVariable("idGoal") Long idGoal) {
         goalService.deleteGoal(idGoal);
         return ResponseEntity.ok("Goal Deleted");
    }
}
