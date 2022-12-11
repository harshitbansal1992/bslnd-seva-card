package com.bslnd.seva.card.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

//@RestController
public class TestController {

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return new ResponseEntity<>("true", HttpStatus.OK);
    }
}