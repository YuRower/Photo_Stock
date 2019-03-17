package ua.karazina.photostock.service;

import java.util.Optional;

import ua.karazina.photostock.exception.ObjectNotFoundException;
import ua.karazina.photostock.model.domain.Profile;

public interface ProfileService {

    Profile findById(Long id) throws ObjectNotFoundException;
    
    Profile findByUid(String uid) throws ObjectNotFoundException;
    
    Optional<Profile> findByEmail(String email);
    
    void signUp(Profile profile, boolean uploadProfileAvatar);
    
    void update(Profile profile);
    
}