package ua.univer.photostock.service;

import java.util.List;

import ua.univer.photostock.enums.SortMode;
import ua.univer.photostock.exception.ObjectNotFoundException;
import ua.univer.photostock.model.AsyncOperation;
import ua.univer.photostock.model.ImageResource;
import ua.univer.photostock.model.OriginalImage;
import ua.univer.photostock.model.Pageable;
import ua.univer.photostock.model.domain.Photo;
import ua.univer.photostock.model.domain.Profile;

public interface PhotoService {

    List<Photo> findProfilePhotos(Long profileId, Pageable pageable);

    List<Photo> findPopularPhotos(SortMode sortMode, Pageable pageable);

    long countAllPhotos();

    String viewLargePhoto(Long photoId) throws ObjectNotFoundException;

    OriginalImage downloadOriginalImage(Long photoId)
            throws ObjectNotFoundException;

    void uploadNewPhoto(Profile currentProfile, ImageResource imageResource,
            AsyncOperation<Photo> asyncOperation);
}
