package com.example.demo.advices;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDTO> handleNPException(){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Product Not Found");

        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity(errorDTO, HttpStatusCode.valueOf(404));
        return responseEntity;
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDTO> handlePNFException(){
//        ErrorDTO errorDTO = new ErrorDTO();
//        errorDTO.setMessage("Product Not Found in get");
//
//        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity(errorDTO, HttpStatusCode.valueOf(404));
//        return responseEntity;
//    }

    @ExceptionHandler(Exception.class)
    public void handleException(){

    }
}
