package com.microservices.Goals.service;

import com.microservices.Goals.exception.ResourceNotFoundException;
import com.microservices.Goals.model.Goal;
import com.microservices.Goals.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoalServiceImpl implements GoalService {
    private final GoalRepository goalRepository;
    @Autowired
    public GoalServiceImpl(GoalRepository goalRepository){
        this.goalRepository = goalRepository;
    }
    @Override
    public Goal addGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public Goal updateGoal(Long idGoal, Goal updatedgoal) {
        Goal goal = getGoalById(idGoal);
        goal.setTargetAmount(updatedgoal.getTargetAmount());
        goal.setCurrentAmount(updatedgoal.getCurrentAmount());
        goal.setDueDate(updatedgoal.getDueDate());

        return goalRepository.save(goal);
    }

    @Override
    public Goal getGoalById(Long idGoal) {
        return goalRepository.findById(idGoal).orElseThrow(() -> new ResourceNotFoundException("le personnel ave cet id n'existe pas" +idGoal ));
    }

    @Override
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @Override
    public void deleteGoal(Long idGoal) {
        goalRepository.deleteById(idGoal);
    }

}
