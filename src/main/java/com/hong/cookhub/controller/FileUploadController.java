package com.hong.cookhub.controller;

import com.hong.cookhub.model.FileUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hong2 on 2018. 10. 14.
 * Time : PM 5:57
 */

@RequestMapping("/file/upload")
@Controller
public class FileUploadController {
    @RequestMapping(method = RequestMethod.POST)
    public String upload(FileUploadForm form) {

        return "redirect:/file/upload?complete";
    }
}
