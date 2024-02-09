package com.videostreaming.streamingservice.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String userName;
    private String password;
}

