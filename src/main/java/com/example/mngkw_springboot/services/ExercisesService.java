package com.example.mngkw_springboot.services;


import com.example.mngkw_springboot.entity.Exercises;
import com.example.mngkw_springboot.exception.ExercisesNotFoundException;
import com.example.mngkw_springboot.repository.ExercisesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesService {

    private final ExercisesRepository exercisesRepository;

    private final CampsService campsService;

    private final InstructorsService instructorsService;

    public ExercisesService(ExercisesRepository exercisesRepository, CampsService campsService, InstructorsService instructorsService) {
        this.exercisesRepository = exercisesRepository;
        this.campsService = campsService;
        this.instructorsService = instructorsService;
    }

    public List<Exercises> findAllExercises(){
        return exercisesRepository.findAll();
    }

    public Exercises findExercisesById(String id){
        return exercisesRepository.findById(id)
                .orElseThrow(() -> new ExercisesNotFoundException("Nie znaleziono zajęcia o danym id:" + id));
    }

    public Exercises addExercises(Exercises exercises){

        String c= exercises.getCampId().getId();
        exercises.setCampId(campsService.findCampsById(c));

        String i= exercises.getInstructorId().getId();
        exercises.setInstructorId(instructorsService.findInstructorsById(i));

        return exercisesRepository.save(exercises);
    }

    public Exercises updateExercises(Exercises exercises){
        return exercisesRepository.save(exercises);
    }

    public void deleteExercisesById(String id){ exercisesRepository.deleteById(id); }
}
