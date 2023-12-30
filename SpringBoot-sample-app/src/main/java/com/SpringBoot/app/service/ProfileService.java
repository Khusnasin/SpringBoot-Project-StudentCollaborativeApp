package com.SpringBoot.app.service;


import com.SpringBoot.app.model.Profile;

import java.util.List;

public interface ProfileService {
		 Profile saveProfile(Profile profile);
		 Profile getProfileById(Integer id);
		 List<Profile> getAllProfiles();

}
