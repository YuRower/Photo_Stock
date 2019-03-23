package ua.univer.photostock.service;

import java.util.Optional;

import ua.univer.photostock.exception.ObjectNotFoundException;
import ua.univer.photostock.model.domain.Profile;

public interface ProfileService {

    Profile findById(Long id) throws ObjectNotFoundException;
    
    Profile findByUid(String uid) throws ObjectNotFoundException;
    
    Optional<Profile> findByEmail(String email);
    
    void signUp(Profile profile, boolean uploadProfileAvatar);
    
    void update(Profile profile);
    
}