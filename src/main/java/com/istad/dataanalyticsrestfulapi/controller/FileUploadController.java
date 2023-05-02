package com.istad.dataanalyticsrestfulapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class FileUploadController {
    @PostMapping("/upload-file")
    public String uploadImage(@RequestParam("sifu")MultipartFile file) throws IOException {

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());

        String Path_Directory="D:\\Spring\\data-analytics-restful-api\\src\\main\\resources\\static\\image";
        Files.copy(file.getInputStream(), Paths.get(Path_Directory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        return "Successfully Image is Uploaded";
    }
}
