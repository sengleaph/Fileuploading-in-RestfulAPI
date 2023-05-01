package com.istad.dataanalyticsrestfulapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.MulticastChannel;

@RestController
public class FileUploadController {
    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;
    @PostMapping("/uploadFile")
    public ResponseEntity <Object> fileUpload(@RequestParam("File")MultipartFile file) throws IOException {
        File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return new ResponseEntity<Object>("File UpLoaded Successfully", HttpStatus.OK);
    }
}
