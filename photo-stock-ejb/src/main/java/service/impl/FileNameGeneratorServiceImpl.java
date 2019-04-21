package service.impl;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import service.FileNameGeneratorService;

@ApplicationScoped
public class FileNameGeneratorServiceImpl implements FileNameGeneratorService {

    @Override
    public String generateUniqueFileName() {
        return UUID.randomUUID().toString() + ".jpg";
    }
}