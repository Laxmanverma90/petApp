package com.hcl.pets.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.pets.bean.ErrorResposne;

@ControllerAdvice
public class PetPeersGlobalException {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResposne> notFoundException(CustomException errMsg) {
		ErrorResposne resposne = new ErrorResposne();
		resposne.setMessage(errMsg.getMessage());
		return new ResponseEntity<ErrorResposne>(resposne, HttpStatus.NOT_FOUND);
	}
	
/*	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResposne> badRequestException(CustomException errMsg) {
		ErrorResposne resposne = new ErrorResposne();
		resposne.setMessage(errMsg.getMessage());
		return new ResponseEntity<ErrorResposne>(resposne, HttpStatus.BAD_REQUEST);
	}*/
}