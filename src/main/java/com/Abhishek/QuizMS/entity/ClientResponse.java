package com.Abhishek.QuizMS.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClientResponse{

    private Long id;
    private String response;
}
