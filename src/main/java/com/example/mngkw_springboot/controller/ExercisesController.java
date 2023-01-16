package com.example.mngkw_springboot.controller;

import com.example.mngkw_springboot.entity.Exercises;
import com.example.mngkw_springboot.services.ExercisesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExercisesController {

    public final ExercisesService exercisesService;

    public ExercisesController(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
    }

    @GetMapping
    public ResponseEntity<List<Exercises>> getAllExercises(){
        List<Exercises> exercises = exercisesService.findAllExercises();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercises> getExercisesById(@PathVariable("id")String id){
        Exercises exercises = exercisesService.findExercisesById(id);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @PostMapping("/{add}")
    public ResponseEntity<Exercises> addExercises(@RequestBody Exercises exercises){
        Exercises newExercises = exercisesService.addExercises(exercises);
        return new ResponseEntity<>(newExercises, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Exercises> updateExercises(@RequestBody Exercises exercises){
        Exercises updateExercises = exercisesService.updateExercises(exercises);
        return new ResponseEntity<>(updateExercises, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")String id){
        exercisesService.deleteExercisesById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
