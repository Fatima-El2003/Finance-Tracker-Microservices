package com.microservices.Goals.service;

import com.microservices.Goals.exception.ResourceNotFoundException;
import com.microservices.Goals.model.Advice;
import com.microservices.Goals.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdviceServiceImpl implements AdviceService {
    private final AdviceRepository adviceRepository;
    @Autowired
    public AdviceServiceImpl(AdviceRepository adviceRepository){
        this.adviceRepository = adviceRepository;
    }
    @Override
    public Advice addAdvice(Advice advice) {
        return adviceRepository.save(advice);
    }

    @Override
    public Advice getAdviceById(Long idAdvice) {
        return adviceRepository.findById(idAdvice).orElseThrow(() -> new ResourceNotFoundException("le personnel ave cet id n'existe pas" + idAdvice ));
    }

    @Override
    public List<Advice> getAllAdvices() {
        return adviceRepository.findAll();
    }

    @Override
    public void deleteAdvice(Long idAdvice) {
        adviceRepository.deleteById(idAdvice);
    }

}
