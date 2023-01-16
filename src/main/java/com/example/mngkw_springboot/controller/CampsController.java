package com.example.mngkw_springboot.controller;

import com.example.mngkw_springboot.entity.Camps;
import com.example.mngkw_springboot.services.CampsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camps")
public class CampsController {

    public final CampsService campsService;

    public CampsController(CampsService campsService) {
        this.campsService = campsService;
    }

    @GetMapping
    public ResponseEntity<List<Camps>> getAllCamps(){
        List<Camps> camps = campsService.findAllCamps();
        return new ResponseEntity<>(camps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camps> getCampsById(@PathVariable("id")String id){
        Camps camps = campsService.findCampsById(id);
        return new ResponseEntity<>(camps, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Camps> addCamps(@RequestBody Camps camps){
        Camps newCamps = campsService.addCamps(camps);
        return new ResponseEntity<>(newCamps, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Camps> updateCamps(@RequestBody Camps camps){
        Camps updateCamps = campsService.updateCamps(camps);
        return new ResponseEntity<>(updateCamps, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")String id){
        campsService.deleteCampsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
