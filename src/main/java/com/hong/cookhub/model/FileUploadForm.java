package com.hong.cookhub.model;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by hong2 on 2018. 10. 14.
 * Time : PM 5:47
 */

@Getter
public class FileUploadForm implements Serializable {
    private MultipartFile file;
}
