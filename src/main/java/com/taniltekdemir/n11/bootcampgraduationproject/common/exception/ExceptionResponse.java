package com.taniltekdemir.n11.bootcampgraduationproject.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private String exceptionMessage;
    private String exceptionDetail;
    private Date exceptionDateTime;
}
