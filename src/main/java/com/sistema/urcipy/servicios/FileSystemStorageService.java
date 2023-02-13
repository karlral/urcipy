package com.sistema.urcipy.servicios;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService{

    @Value("${media.location}")
    private String mediaLocation;
    private Path rootLocation;

    @Override
    @PostConstruct
    public void init() throws IOException {
        System.out.println("inicializacion en init");
        rootLocation=Paths.get(mediaLocation);
        Files.createDirectories(rootLocation);
    }

    @Override
    public String store(MultipartFile file) {
        System.out.println("funcion interno 1");
        try {

            if (file.isEmpty()) {
                throw new RuntimeException("Fallo al guardar archivo vacio");
            }
            String filename = file.getOriginalFilename();
            System.out.println("funcion interno 1"+filename);
            Path destinationFile = rootLocation.resolve(Paths.get(filename)).normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return filename;
        }catch (IOException e) {
            throw new RuntimeException("Fallo al guardar el archivo "+e);
        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource= new UrlResource((file.toUri()));
            if (resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("No puedo leer el archivo: "+filename);
            }

        }catch (MalformedURLException e){
            throw new RuntimeException("No puedo leer el archivo: "+filename);
        }
    }

}
