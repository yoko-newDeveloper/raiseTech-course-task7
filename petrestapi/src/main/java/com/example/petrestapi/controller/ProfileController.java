package com.example.petrestapi.controller;

import com.example.petrestapi.form.ProfileCreateForm;
import com.example.petrestapi.form.ProfileUpdateForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class ProfileController {

    @GetMapping("/profiles")
    public List<String> getProfile() {
        return List.of("ALBA", "VANILLA");
    }

    @PostMapping("/profiles")
    public ResponseEntity<Map<String, String>> createProfile(@RequestBody @Validated ProfileCreateForm form) {

        // バリデーションが成功
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/profiles/id")
                .build()
                .toUri();

        return ResponseEntity.created(url).body(Map.of("message", "profiles successfully created"));
    }

    @PatchMapping("/profiles/{id}")
    public ResponseEntity<Map<String, String>> updateProfile(@PathVariable("id") int id, @RequestBody ProfileUpdateForm profileUpdateForm) {
        return ResponseEntity.ok(Map.of("message", "profiles successfully updated"));
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Map<String, String>> deleteProfile(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "profiles successfully deleted"));
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {

        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "path", request.getRequestURI());

        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
}
