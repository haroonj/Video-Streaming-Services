package com.videostreaming.database.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;

@Enabled
@Data
@AllArgsConstructor
public class VidMetaData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String vidName;
    private String vidDescription;
    private String url;
    private String publisher;
}