package com.snkit.springbootdemo.custorder;

import java.util.List;

public interface CustOrderService {
	
	
	String saveOrder(CustomerOrderReq req);
	
	CustomerOrderVO  findCustInfoByName(CustomerOrderReq req);
	
	CustomerOrderVO  findCustInfoNameAndEmail(CustomerOrderReq req);
	
	CustomerOrderVO  findCustInfoNameAndEmailAndAddhar(CustomerOrderReq req);
	
	CustomerOrderVO  getCustToAvoidNPlus1(CustomerOrderReq req);
	
	List<CustomerNativeVO> getCustNaviteQuery(CustomerOrderReq req);
	
	CustOrderResp getCustBySpecification(CustomerOrderReq req);
}
