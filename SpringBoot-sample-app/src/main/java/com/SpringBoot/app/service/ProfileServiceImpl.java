package com.SpringBoot.app.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.SpringBoot.app.repository.ProfileRepository;
import com.SpringBoot.app.model.Profile;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService{
	private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    
    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileById(Integer id) {
        return profileRepository.findById(id).orElse(null);
    }
}
