package com.example.mngkw_springboot.services;


import com.example.mngkw_springboot.entity.Instructors;
import com.example.mngkw_springboot.exception.InstructorsNotFoundException;
import com.example.mngkw_springboot.repository.InstructorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorsService {

    private final InstructorsRepository instructorsRepository;

    public InstructorsService(InstructorsRepository instructorsRepository) {
        this.instructorsRepository = instructorsRepository;
    }

    public List<Instructors> findAllInstructors(){
        return instructorsRepository.findAll();
    }

    public Instructors findInstructorsById(String id){
        return instructorsRepository.findById(id)
                .orElseThrow(() -> new InstructorsNotFoundException("Nie znaleziono instruktora o danym id:" + id));
    }

    public Instructors addInstructors(Instructors instructors){
        return instructorsRepository.save(instructors);
    }

    public Instructors updateInstructors(Instructors instructors){
        return instructorsRepository.save(instructors);
    }

    public void deleteInstructorsById(String id){ instructorsRepository.deleteById(id); }
}
