package com.example.dogApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dog_post")

public class DogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String dogName;
    private String address;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "dogPost", cascade = CascadeType.ALL)
    private Set<DogImage> dogImages;


    
}
