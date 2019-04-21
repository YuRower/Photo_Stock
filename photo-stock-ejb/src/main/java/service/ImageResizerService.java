package service;

import java.nio.file.Path;

import com.univer.config.ImageCategory;

public interface ImageResizerService {

    void resize(Path sourcePath, Path destinationPath,
            ImageCategory imageCategory);
}