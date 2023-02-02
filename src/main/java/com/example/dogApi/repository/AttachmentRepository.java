package com.example.dogApi.repository;

import com.example.dogApi.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,String> {
}
