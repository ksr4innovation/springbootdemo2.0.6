package com.snkit.springbootdemo;

public class ThirdPartyException extends PaymentModuleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ThirdPartyException(String code,String msg) {
		super(code,msg);
	
	}
}
