package com.videostreaming.uploadservice.controller;


import com.videostreaming.uploadservice.service.UploadService;
import com.videostreaming.uploadservice.service.VidDBService;
import com.videostreaming.uploadservice.service.VidMetaData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    private final VidDBService vidDBService;
    private final UploadService uploadService;

    public UploadController(VidDBService vidDBService, UploadService uploadService) {
        this.vidDBService = vidDBService;
        this.uploadService = uploadService;
    }

    @GetMapping(value = {"/","upload"})
    public String uploadPage() {
        return "upload";
    }


    @PostMapping("uploadF")
    public String uploadFile(@RequestParam("name") String name,
                             @RequestParam("des") String description,
                             @RequestParam("file") MultipartFile file,
                             Model model) {
        String message;
        try {
            if (uploadService.upload(name, file)) {
                if (vidDBService.putVidToDB(new VidMetaData(name, description)))
                    message = "The video has been uploaded successfully";
                else
                    throw new Exception();
            } else
                throw new Exception();

        } catch (Exception e) {

            message = "Error uploading the video";
        }
        model.addAttribute("message", message);
        return "upload";
    }
}
