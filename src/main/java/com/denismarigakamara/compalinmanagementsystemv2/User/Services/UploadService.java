package com.denismarigakamara.compalinmanagementsystemv2.User.Services;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.Upload;
import com.denismarigakamara.compalinmanagementsystemv2.User.Repository.uploadRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UploadService {
    private final uploadRepo uploadRepo;

    public UploadService(uploadRepo uploadRepo) {
        this.uploadRepo = uploadRepo;
    }

    public Upload saveUpload(MultipartFile file) {
        String uploadName = file.getOriginalFilename();
        try {
            Upload upload = new Upload(uploadName, file.getContentType(), file.getBytes());
           return uploadRepo.save(upload);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Upload> getUpload(String user) {
        return uploadRepo.findUploadByUsername(user);
    }

    public Upload getById(Long id) {
        return uploadRepo.findById(id).orElse(null);
    }

}
