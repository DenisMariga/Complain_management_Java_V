package com.denismarigakamara.compalinmanagementsystemv2.User.Entity;

import javax.persistence.*;


@Entity
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] upload;
    private String uploadName;
    private String uploadType;
    private String username;

    public Upload() {
    }

    public Upload( String uploadName, String uploadType, byte[] upload) {
        this.uploadName = uploadName;
        this.uploadType = uploadType;

        this.upload = upload;
    }

    public Upload(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getUpload() {
        return upload;
    }

    public void setUpload(byte[] upload) {
        this.upload = upload;
    }

    public String getUploadName() {
        return uploadName;
    }

    public void setUploadName(String uploadName) {
        this.uploadName = uploadName;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }
}
