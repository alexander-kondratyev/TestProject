package com.kapitalbank;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/test")
    public ResponseEntity<String> getTestData(@RequestParam(required = false) String param) {
        if (param == null) {
            return new ResponseEntity<>("Missing parameter", HttpStatus.BAD_REQUEST);
        }
        if (param.equals("forbidden")) {
            return new ResponseEntity<>("Access denied", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("Test data: " + param, HttpStatus.OK);
    }
}