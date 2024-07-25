package com.microservices.Goals.service;

import com.microservices.Goals.model.Goal;

import java.util.List;

public interface GoalService {
    Goal addGoal(Goal goal);
    Goal updateGoal(Long idGoal, Goal updatedGoal);
    Goal getGoalById(Long idGoal);
    List<Goal> getAllGoals();
    void deleteGoal(Long idGoal);
}
