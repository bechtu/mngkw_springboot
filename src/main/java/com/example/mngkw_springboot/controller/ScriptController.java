package com.example.mngkw_springboot.controller;

import com.example.mngkw_springboot.services.ScriptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/script")

public class ScriptController {

    private final ScriptService scriptService;

    public ScriptController(ScriptService scriptService) {
        this.scriptService = scriptService;
    }

    @PutMapping("")
    public ResponseEntity<String> execScript(@RequestBody String script){
        return new ResponseEntity<>(scriptService.exec(script), HttpStatus.ACCEPTED);
    }

}
