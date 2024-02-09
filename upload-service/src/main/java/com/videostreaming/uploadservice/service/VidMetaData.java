package com.videostreaming.uploadservice.service;

import org.springframework.security.core.context.SecurityContextHolder;

public class VidMetaData {
    private String _id;
    private String vidName;
    private String vidDescription;
    private String url;
    private String publisher;

    public VidMetaData() {
    }

    public VidMetaData( String vidName, String vidDescription) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        this._id = "";
        this.vidName = vidName;
        this.vidDescription = vidDescription;
        this.url = "https://atypon-video-stream.s3.us-east-2.amazonaws.com/" + vidName.replace(' ','+');
        this.publisher = username;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getVidName() {
        return vidName;
    }

    public void setVidName(String vidName) {
        this.vidName = vidName;
    }

    public String getVidDescription() {
        return vidDescription;
    }

    public void setVidDescription(String vidDescription) {
        this.vidDescription = vidDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

