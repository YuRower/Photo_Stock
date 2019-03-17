package ua.karazina.photostock.service;

import java.util.List;

import ua.karazina.photostock.enums.SortMode;
import ua.karazina.photostock.exception.ObjectNotFoundException;
import ua.karazina.photostock.model.domain.Photo;

public interface PhotoService  {

    List<Photo> findProfilePhotos(Long profileId);
    
    List<Photo> findPopularPhotos(SortMode sortMode);
    
    long countAllPhotos();
    
    String viewPhoto(Long photoId) throws ObjectNotFoundException; 
    
    
    void uploadNewPhoto();
}
