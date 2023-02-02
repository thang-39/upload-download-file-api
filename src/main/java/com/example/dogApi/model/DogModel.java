package com.example.dogApi.model;

import com.example.dogApi.entity.DogImage;
import lombok.*;

import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DogModel {
    private String dogName;
    private String address;
    private String description;
    private Set<DogImage> images;
}
