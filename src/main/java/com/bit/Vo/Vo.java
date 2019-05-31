package com.bit.Vo;

import org.springframework.web.multipart.MultipartFile;

public class Vo {
    private MultipartFile fileupload;
 
    public MultipartFile getFileupload() {
        return fileupload;
    }
 
    public void setFileupload(MultipartFile fileupload) {
        this.fileupload = fileupload;
    }
}


