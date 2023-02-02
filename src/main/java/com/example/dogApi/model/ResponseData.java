package com.example.dogApi.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseData {
    private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
}
