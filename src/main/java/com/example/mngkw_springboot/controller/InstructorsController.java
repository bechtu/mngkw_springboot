package com.example.mngkw_springboot.controller;

import com.example.mngkw_springboot.entity.Camps;
import com.example.mngkw_springboot.entity.Instructors;
import com.example.mngkw_springboot.services.InstructorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorsController {

    public final InstructorsService instructorsService;

    public InstructorsController(InstructorsService instructorsService) {
        this.instructorsService = instructorsService;
    }

    @GetMapping
    public ResponseEntity<List<Instructors>> getAllInstructors(){
        List<Instructors> instructors = instructorsService.findAllInstructors();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructors> getInstructorsById(@PathVariable("id")String id){
        Instructors instructors = instructorsService.findInstructorsById(id);
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Instructors> addInstructors(@RequestBody Instructors instructors){
        Instructors newInstructors = instructorsService.addInstructors(instructors);
        return new ResponseEntity<>(newInstructors, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Instructors> updateInstructors(@RequestBody Instructors instructors){
        Instructors updateInstructors = instructorsService.updateInstructors(instructors);
        return new ResponseEntity<>(updateInstructors, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")String id){
        instructorsService.deleteInstructorsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
