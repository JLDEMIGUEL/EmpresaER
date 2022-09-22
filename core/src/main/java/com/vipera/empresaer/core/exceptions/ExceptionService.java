package com.vipera.empresaer.core.exceptions;



import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.core.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionService.class);

    @ExceptionHandler(RestException.class)
    public ResponseEntity<TemplateException> handleRestException(RestException exception){
        LOGGER.error(LogUtils.coreMarker, "CORE - ExceptionService - handleRestException - Exception code: " +
                exception.getCode() + ", message: " + exception.getMessage() + ", status: " + exception.getStatus());
        TemplateException template = new TemplateException(exception.getCode(), exception.getMessage());
        return new ResponseEntity<>(template, exception.getStatus());
    }

}
