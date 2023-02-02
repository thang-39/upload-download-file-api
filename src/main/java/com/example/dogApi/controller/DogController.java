package com.example.dogApi.controller;

import com.example.dogApi.entity.DogImage;
import com.example.dogApi.entity.DogPost;
import com.example.dogApi.model.DogModel;
import com.example.dogApi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    DogService dogService;

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Long> addDog(@RequestPart("dogModel") DogModel dogModel,
                                       @RequestPart("imageFile") MultipartFile[] files) {
//        return new ResponseEntity<>(dogService.addDog(dogModel), HttpStatus.CREATED);
        try {
            Set<DogImage> images = uploadImage(files);
            dogModel.setImages(images);
            return new ResponseEntity<>(dogService.addDog(dogModel), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<DogImage> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<DogImage> dogImages = new HashSet<>();

        for (MultipartFile file: multipartFiles) {
            DogImage dogImage = new DogImage(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            dogImages.add(dogImage);
        }
        return dogImages;
    }
}
