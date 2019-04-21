package ua.univer.photostock.model;

import ua.univer.photostock.exception.ApplicationException;

public class ConfigException extends ApplicationException {

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}