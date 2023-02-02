package com.example.dogApi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DogImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String name;
    private String type;

    @Column(length = 50000000)
    @Lob
    private byte[] picByte;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dog_post_id", referencedColumnName = "id")
    private DogPost dogPost;

    public DogImage(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
