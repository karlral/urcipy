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
    @Value("${media.location}/banderas")
    private String mediaLocationBanderas;
    @Value("${media.location}/carnet/2016")
    private String mediaLocation2016;
    @Value("${media.location}/carnet/2017")
    private String mediaLocation2017;
    @Value("${media.location}/carnet/2018")
    private String mediaLocation2018;
    @Value("${media.location}/carnet/2019")
    private String mediaLocation2019;
    @Value("${media.location}/carnet/2020")
    private String mediaLocation2020;
    @Value("${media.location}/carnet/2021")
    private String mediaLocation2021;
    @Value("${media.location}/carnet/2022")
    private String mediaLocation2022;
    @Value("${media.location}/carnet/2023")
    private String mediaLocation2023;
    private Path rootLocation;

    private Path rootLocationBanderas;
    private Path rootLocation2016;
    private Path rootLocation2017;
    private Path rootLocation2018;
    private Path rootLocation2019;
    private Path rootLocation2020;
    private Path rootLocation2021;
    private Path rootLocation2022;
    private Path rootLocation2023;
    @Override
    @PostConstruct
    public void init() throws IOException {
        //System.out.println("inicializacion en init");
        rootLocation=Paths.get(mediaLocation);
        rootLocationBanderas=Paths.get(mediaLocationBanderas);
        rootLocation2016=Paths.get(mediaLocation2016);
        rootLocation2017=Paths.get(mediaLocation2017);
        rootLocation2018=Paths.get(mediaLocation2018);
        rootLocation2019=Paths.get(mediaLocation2019);
        rootLocation2020=Paths.get(mediaLocation2020);
        rootLocation2021=Paths.get(mediaLocation2021);
        rootLocation2022=Paths.get(mediaLocation2022);
        rootLocation2023=Paths.get(mediaLocation2023);
        //System.out.println("Localizacion del archivo: "+rootLocation);
       // Files.createDirectories(rootLocation);
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

    @Override
    public Resource loadAsResourceFolder(String folder,String filename) {
        try {
            Path file = rootLocation2016.resolve(filename);

            if (folder.equals("banderas")){
                 file = rootLocationBanderas.resolve(filename);
            } else if (folder.equals("2016")) {
                file = rootLocation2016.resolve(filename);
            }else if (folder.equals("2017")) {
                file = rootLocation2017.resolve(filename);
            }else if (folder.equals("2018")) {
                file = rootLocation2018.resolve(filename);
            }else if (folder.equals("2019")) {
                file = rootLocation2019.resolve(filename);
            }else if (folder.equals("2020")) {
                file = rootLocation2020.resolve(filename);
            }else if (folder.equals("2021")) {
                file = rootLocation2021.resolve(filename);
            }else if (folder.equals("2022")) {
                file = rootLocation2022.resolve(filename);
            }else if (folder.equals("2023")) {
                file = rootLocation2023.resolve(filename);
            }


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
