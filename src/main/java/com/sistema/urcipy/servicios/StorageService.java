package com.sistema.urcipy.servicios;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

public interface StorageService {
    void init() throws IOException;
    String store(MultipartFile file);
    public String storeLocation(MultipartFile file, String location);

    Resource loadAsResource(String filename);
    public Resource loadAsResourceFolder(String folder,String filename);
}
