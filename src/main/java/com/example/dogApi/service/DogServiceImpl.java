package com.example.dogApi.service;

import com.example.dogApi.entity.DogPost;
import com.example.dogApi.model.DogModel;
import com.example.dogApi.repository.DogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements DogService{
    @Autowired
    DogRepository dogRepository;

    @Override
    public long addDog(DogModel dogModel) {
        DogPost newDogPost = new DogPost();
        BeanUtils.copyProperties(dogModel, newDogPost);
        dogRepository.save(newDogPost);
        return newDogPost.getId();
    }
}
