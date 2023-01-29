package com.globallogic.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private Date timestamp;
    private HttpStatus httpStatus;
    private String message;
    private String path;
}
