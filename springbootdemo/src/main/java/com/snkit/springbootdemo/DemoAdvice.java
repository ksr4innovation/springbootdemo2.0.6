package com.snkit.springbootdemo;

import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DemoAdvice {	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> mediaTypeNotsupported(MethodArgumentNotValidException e){
		RootResponse resp = new RootResponse();
		resp.setErrorType("E");
		resp.setErrorCode("400");
		resp.setErrorMsg(" MethodArgumentNotValidException   ===================   ");
		List<ObjectError> objError = e.getBindingResult().getAllErrors();
		
		for (ObjectError objEr: objError) {
			resp.getInputValidationMsgs().add(objEr.getDefaultMessage());
		}
		
		
				
		return new ResponseEntity<>((Object)resp,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<Object> mediaTypeNotsupported(HttpMediaTypeNotSupportedException e){
		RootResponse resp = new RootResponse();
		resp.setErrorType("E");
		resp.setErrorCode("415");
		resp.setErrorMsg(" HttpMediaTypeNotSupportedException   ===================   ");		
		return new ResponseEntity<>((Object)resp,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		
	}	
	@ExceptionHandler(PaymentModuleException.class)
	public ResponseEntity<RootResponse> handleAppExcepiotn(PaymentModuleException e){		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();		
		map.add("ErrorType", "E");
		map.add("ErrorCode", e.getCode());
		map.add("Msg", e.getMsg());		
		return new ResponseEntity(map,HttpStatus.OK);		
	}
	

}
