package com.snkit.springbootdemo.custorder;

import java.util.ArrayList;
import java.util.List;

public class CustOrderResp {
	
	public List<CustomerOrderVO> custOrderVOList ;
	
	public CustOrderResp() {
		custOrderVOList = new ArrayList<CustomerOrderVO>();
	}

	public List<CustomerOrderVO> getCustOrderVOList() {
		return custOrderVOList;
	}

	public void setCustOrderVOList(List<CustomerOrderVO> custOrderVOList) {
		this.custOrderVOList = custOrderVOList;
	}

}
