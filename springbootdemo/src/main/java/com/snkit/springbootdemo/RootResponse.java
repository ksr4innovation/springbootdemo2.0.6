package com.snkit.springbootdemo;

import java.util.ArrayList;
import java.util.List;

public class RootResponse {
	
	private String corelationId;
	
	private String errorType;
	
	private String errorCode;
	
	private String errorMsg;
	
	private List<String> inputValidationMsgs;
	
	public RootResponse(){
		inputValidationMsgs = new ArrayList<String>();
	}

	public String getCorelationId() {
		return corelationId;
	}

	public void setCorelationId(String corelationId) {
		this.corelationId = corelationId;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<String> getInputValidationMsgs() {
		return inputValidationMsgs;
	}

	public void setInputValidationMsgs(List<String> inputValidationMsgs) {
		this.inputValidationMsgs = inputValidationMsgs;
	}
	
	
	
	

}
