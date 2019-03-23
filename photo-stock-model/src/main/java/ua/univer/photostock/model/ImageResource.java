package ua.univer.photostock.model;

import javax.validation.Path;

public interface ImageResource extends AutoCloseable{

    Path getTempPath();
}