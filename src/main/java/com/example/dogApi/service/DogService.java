package com.example.dogApi.service;


import com.example.dogApi.entity.DogPost;
import com.example.dogApi.model.DogModel;

public interface DogService {
    long addDog(DogModel dogModel);
}
