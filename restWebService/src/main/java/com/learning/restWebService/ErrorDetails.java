package com.learning.restWebService;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorDetails {

    LocalDateTime localDate;

    String message;

    String details;

}
