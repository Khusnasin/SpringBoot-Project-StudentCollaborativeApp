package com.SpringBoot.app.controller;

import com.SpringBoot.app.model.Profile;
import com.SpringBoot.app.service.ProfileService;
import com.SpringBoot.app.standardControllers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

	private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/saveprofile")
    public ResponseEntity<?> saveProfile(@RequestBody Profile profile) {
        try {
            Profile newProfile = profileService.saveProfile(profile);
            return ResponseEntity.ok("Information saved Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/getallprofiles")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        try {
            List<Profile> profiles = profileService.getAllProfiles();
            return ResponseEntity.ok(profiles);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/getprofilebyid/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Integer id) {
        try {
            Profile profile = profileService.getProfileById(id);

            if (profile != null) {
                return ResponseEntity.ok(profile);
            } else {
                return ResponseEntity.status(404).body(new ErrorResponse("Profile not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ErrorResponse(e.getMessage()));
        }
    }
	
}
