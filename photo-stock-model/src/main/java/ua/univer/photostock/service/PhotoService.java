package ua.univer.photostock.service;

import java.util.List;

import ua.univer.photostock.enums.SortMode;
import ua.univer.photostock.exception.ObjectNotFoundException;
import ua.univer.photostock.model.domain.Photo;

public interface PhotoService  {

    List<Photo> findProfilePhotos(Long profileId);
    
    List<Photo> findPopularPhotos(SortMode sortMode);
    
    long countAllPhotos();
    
    String viewPhoto(Long photoId) throws ObjectNotFoundException; 
    
    
    void uploadNewPhoto();
}
