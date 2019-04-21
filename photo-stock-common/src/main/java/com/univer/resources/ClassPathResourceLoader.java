package com.univer.resources;

import java.io.InputStream;

import javax.enterprise.context.ApplicationScoped;

import ua.univer.photostock.model.ConfigException;

@ApplicationScoped
public class ClassPathResourceLoader implements ResourceLoader {

    @Override
    public boolean isSupport(String resourceName) {
        return resourceName.startsWith("classpath:");
    }

    @Override
    public InputStream getInputStream(String resourceName) {
        String classPathResourceName = resourceName.replace("classpath:", "");
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        if (classLoader != null) {
            InputStream inputStream = classLoader
                    .getResourceAsStream(classPathResourceName);
            if (inputStream != null) {
                return inputStream;
            }
        }
        throw new ConfigException(
                "Classpath resource not found: " + classPathResourceName);
    }
}
