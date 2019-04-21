package service;

import java.nio.file.Path;

import com.univer.config.ImageCategory;

import ua.univer.photostock.model.OriginalImage;

public interface ImageStorageService {

    String saveProtectedImage(Path path);

    String savePublicImage(ImageCategory imageCategory, Path path);

    void deletePublicImage(String url);

    OriginalImage getOriginalImage(String originalUrl);
}