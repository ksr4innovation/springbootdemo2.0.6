package com.snkit.springbootdemo.custorder;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.snkit.springbootdemo.OrderVO;

@Service(value="custOrderInterface")
public class CustOrderServiceImpl implements CustOrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustOrderServiceImpl.class);
	

	
	CustomerRepository custRepository;
	
	
	public CustOrderServiceImpl(CustomerRepository customerRepository) {
		this.custRepository = customerRepository;
	}

	@Override
	public String saveOrder(CustomerOrderReq req) {		
		
		String response;
		CustomerEntity cust = new CustomerEntity();		
		cust.setAddhar(req.getAddhar());
		cust.setEmail(req.getEmail());
		cust.setName(req.getName());	
		
		req.getOrderList().forEach(inputOrder-> {
			OrderEntity order = new OrderEntity();
			
			order.setAmt(inputOrder.getAmt());
			order.setCustomerEntity(cust);
			order.setQuantity(inputOrder.getQuantity());
			
			cust.getOrderEntityList().add(order);
		});
	
		
		CustomerEntity returnEntity = custRepository.save(cust);
		
		if (returnEntity.getId() !=  null) {
			response= "Success";
		}else {
			response ="failure";
		}
		
		return response;
		
	}

	private CustomerOrderVO parseCustEntity(List<CustomerEntity> custEntityList) {
		CustomerOrderVO resp = new CustomerOrderVO();
		
		
		
		System.out.println(" Customer list size  "+custEntityList.size());
		
		custEntityList.forEach(cust -> {
			resp.setAddhar(cust.getAddhar());
			resp.setEmail(cust.getEmail());
			resp.setName(cust.getName());
			resp.setCustId(cust.getId());	
					
			cust.getOrderEntityList().forEach(orderEntity -> {
				OrderVO order = new OrderVO();
				
				order.setAmt(orderEntity.getAmt());				
				order.setQuantity(orderEntity.getQuantity());
				order.setOrderId(orderEntity.getId());				
				resp.getOrderList().add(order);
			});	
		
		});
		
		return resp;
	}
	
	@Override
	public CustomerOrderVO getCustToAvoidNPlus1(CustomerOrderReq req) {
		
		System.out.println("    getCustToAvoidNPlus1   ============================ ");
		
		List<CustomerEntity> custEntityList = custRepository.getCustEmpDetailswithOutJoin(req.getName());
		return parseCustEntity(custEntityList);
	}
	
	@Override
	public CustomerOrderVO findCustInfoByName(CustomerOrderReq req) {
		List<CustomerEntity> custEntityList = custRepository.findByName(req.getName());
		return parseCustEntity(custEntityList);
	}

	@Override
	public CustomerOrderVO findCustInfoNameAndEmail(CustomerOrderReq req) {
		String[] input = {req.getName(),req.getEmail()};
		List<CustomerEntity> custEntityList = custRepository.findByNameAndEmail(req.getName(),req.getEmail());
		return parseCustEntity(custEntityList);
	}

	@Override
	public CustomerOrderVO findCustInfoNameAndEmailAndAddhar(CustomerOrderReq req) {
		String[] input = {req.getName(),req.getEmail(),req.getAddhar()};
		List<CustomerEntity> custEntityList = custRepository.findByNameAndEmailAndAddhar(req.getName(),req.getEmail(),req.getAddhar());
		return parseCustEntity(custEntityList);
	}
	@Override
	public List<CustomerNativeVO> getCustNaviteQuery(CustomerOrderReq req){
		
		logger.info(" Entring   getCustNaviteQuery   ============================ ");
		return custRepository.getCustByNativeQuery(req.getName());
	}
	
	@Override
	public CustOrderResp getCustBySpecification(CustomerOrderReq req){
		
		logger.info(" Entring   getCustBySpecification   ============================ ");
		CustAddressSpecification spec = new CustAddressSpecification(req);
		
		List<CustomerEntity> custEntityList = custRepository.findAll(spec);
		logger.info(" Exist   getCustBySpecification   ============================ ");
		return parseCustOrderEntity(custEntityList);
		
	}
	
	private CustOrderResp parseCustOrderEntity(List<CustomerEntity> custEntityList) {
		CustOrderResp resp = new CustOrderResp();
		
		
		
		logger.info(" Customer list size  "+custEntityList.size());
		
		custEntityList.forEach(cust -> {
			
			CustomerOrderVO orderVO = new CustomerOrderVO();
			orderVO.setAddhar(cust.getAddhar());
			orderVO.setEmail(cust.getEmail());
			orderVO.setName(cust.getName());
			orderVO.setCustId(cust.getId());	
					
			cust.getOrderEntityList().forEach(orderEntity -> {
				OrderVO order = new OrderVO();
				
				order.setAmt(orderEntity.getAmt());				
				order.setQuantity(orderEntity.getQuantity());
				order.setOrderId(orderEntity.getId());				
				orderVO.getOrderList().add(order);
			});	
			
			resp.getCustOrderVOList().add(orderVO);
		
		});
		
		return resp;
	}
}
