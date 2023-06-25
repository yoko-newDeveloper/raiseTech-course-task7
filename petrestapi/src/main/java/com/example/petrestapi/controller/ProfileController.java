package com.example.petrestapi.controller;

import com.example.petrestapi.form.ProfileCreateForm;
import com.example.petrestapi.form.ProfileUpdateForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class ProfileController {

    @GetMapping("/profiles")
    public List<String> getProfile() {
        return List.of("ALBA", "VANILLA");
    }

    @PostMapping("/profiles")
    public ResponseEntity<Map<String, String>> createProfile(@RequestBody ProfileCreateForm form) {
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
}
