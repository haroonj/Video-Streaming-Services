package com.videostreaming.streamingservice.controller;


import com.videostreaming.streamingservice.service.VidDBService;
import com.videostreaming.streamingservice.service.VidMetaData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StreamingController {

    private final VidDBService vidDBService;

    public StreamingController(VidDBService vidDBService) {
        this.vidDBService = vidDBService;
    }

    @GetMapping(value = {"/play/{id}", "/play", "/"})
    public String play(@PathVariable(required = false) Integer id, Model model) {
        List<VidMetaData> list = vidDBService.getVidToDB();
        VidMetaData selectedVideo;
        if (id == null)
            selectedVideo = list.get(0);
        else
            selectedVideo = list.get(list.indexOf(new VidMetaData(id)));

        model.addAttribute("videos", list);
        model.addAttribute("selected", selectedVideo);
        return "video";
    }

}
