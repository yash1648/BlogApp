package org.bloggingapp.blogapp.commons.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

private String message;
}
