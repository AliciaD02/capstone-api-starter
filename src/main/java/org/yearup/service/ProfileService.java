package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.Profile;
import org.yearup.repository.ProfileRepository;

@Service
public class ProfileService
{
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository)
    {
        this.profileRepository = profileRepository;
    }

    public Profile create(Profile profile)
    {
        return profileRepository.save(profile);
    }
    // Gets a profile using the user id
    public Profile getById(int userId)
    {
        //looks for the user's profile in the database.
        return profileRepository.findById(userId)
                .orElse(null);
    }
    //update the user id
    public Profile update(int userId, Profile profile)
    {
        // this will save the changes
        profile.setUserId(userId);
        return profileRepository.save(profile);
    }
}
