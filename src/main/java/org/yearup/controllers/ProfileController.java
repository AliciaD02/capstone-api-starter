package org.yearup.controllers;

// created this ProfileController to receive requests and communicated with the profileService

import org.springframework.web.bind.annotation.*;
import org.yearup.models.Profile;
import org.yearup.service.ProfileService;
import org.yearup.service.UserService;

import java.security.Principal;

// this class handles API
@RestController
//"/profile"
@RequestMapping("/profile")
@CrossOrigin
public class ProfileController {

    private final ProfileService profileService;
    private final UserService userService;

    public ProfileController(ProfileService profileService, UserService userService) {
        this.profileService = profileService;
        this.userService = userService;
    }

    // gets the profile of hte user who is currently logged in
    @GetMapping
    public Profile getProfile(Principal principal) {
        //Gets the logged in user's username
        String username = principal.getName();
        // then uses the username to find the user's id
        int userId = userService.getIdByUsername(username);
        // Gets the user's profile from the database
        return profileService.getById(userId);
    }

    // Updates the profile of the logged in user.
    @PutMapping
    public Profile updateProfile(@RequestBody Profile profile, Principal principal) {
        // Gets the logged in user's username.
        String username = principal.getName();

        // Uses the username to find the user's id.
        int userId = userService.getIdByUsername(username);

        // Updates the profile and saves the changes.
        return profileService.update(userId, profile);
    }
}