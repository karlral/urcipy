package com.sistema.urcipy.controladores;

import com.sistema.urcipy.servicios.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/media")
@CrossOrigin("*")
public class MediaController {

    private  StorageService storageService;
    private final HttpServletRequest request;

    public MediaController(StorageService storageService, HttpServletRequest request) {
        this.storageService = storageService;
        this.request = request;
    }

    @PostMapping("/upload")
    public Map<String,String> uploadFile(@RequestParam("file") MultipartFile multipartFile){
        System.out.println("funciona1");
        String path = storageService.store(multipartFile);
        System.out.println("funciona1"+path);
        String host =request.getRequestURL().toString().replace(request.getRequestURI(),"");
        System.out.println("funciona1"+host);
        String url= ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/media/")
                .path(path)
                .toUriString();
        System.out.println("funciona1"+url);
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", url);
        return map;
    }
    @GetMapping("{fielname:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String fielname) throws IOException {
        Resource file = storageService.loadAsResource(fielname);
        String contentType= Files.probeContentType(file.getFile().toPath());

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE,contentType)
                .body(file);
    }
    @GetMapping("/{folder}/{fielname:.+}")
    public ResponseEntity<Resource> getFileFolder(@PathVariable String folder,@PathVariable String fielname) throws IOException {
        Resource file = storageService.loadAsResourceFolder(folder,fielname);
        String contentType= Files.probeContentType(file.getFile().toPath());

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE,contentType)
                .body(file);
    }


}
