package com.videostreaming.database.controller;

import com.videostreaming.database.entity.VidMetaData;
import com.videostreaming.database.service.VidMetaDataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VMDController {
    private final VidMetaDataService vidMetaDataService;

    public VMDController(VidMetaDataService vidMetaDataService) {
        this.vidMetaDataService = vidMetaDataService;
    }

    @GetMapping("/")
    public List<VidMetaData> getVideos() {
        return vidMetaDataService.getAllVideos();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public VidMetaData addVid(@RequestBody VidMetaData vidMetaData) {
        return vidMetaDataService.addVid(vidMetaData);
    }
}
