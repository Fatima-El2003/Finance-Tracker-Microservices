package com.microservices.Goals.service;

import com.microservices.Goals.model.Advice;

import java.util.List;

public interface AdviceService {
    Advice addAdvice(Advice advice);
    Advice getAdviceById(Long idAdvice);
    List<Advice> getAllAdvices();
    void deleteAdvice(Long idAdvice);
}
