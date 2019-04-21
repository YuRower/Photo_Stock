package service.impl;

import static net.coobird.thumbnailator.geometry.Positions.CENTER;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.enterprise.context.ApplicationScoped;

import com.univer.config.ImageCategory;

import net.coobird.thumbnailator.Thumbnails;
import service.ImageResizerService;
import ua.univer.photostock.exception.ApplicationException;

@ApplicationScoped
public class ThumbnailatorImageResizerService implements ImageResizerService {

    @Override
    public void resize(Path sourcePath, Path destinationPath,
            ImageCategory imageCategory) {
        try {
            Thumbnails.Builder<File> builder = Thumbnails
                    .of(sourcePath.toFile());
            if (imageCategory.isCrop()) {
                builder.crop(CENTER);
            }
            builder.size(imageCategory.getWidth(), imageCategory.getHeight())
                    .outputFormat(imageCategory.getOutputFormat())
                    .outputQuality(imageCategory.getQuality())
                    .allowOverwrite(true).toFile(destinationPath.toFile());
        } catch (IOException ex) {
            throw new ApplicationException(
                    "Can't resize image: " + ex.getMessage(), ex);
        }
    }
}