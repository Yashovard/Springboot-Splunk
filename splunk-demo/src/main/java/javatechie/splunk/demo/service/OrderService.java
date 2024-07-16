package javatechie.splunk.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.mapper.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javatechie.splunk.demo.dto.Order;

@Service
public class OrderService {

	private List<Order> orderList=new ArrayList<>();

	Logger logger=LogManager.getLogger(Order.class);

	public Order addOrder(Order order) {
		logger.info("OrderService:addOrder execution started..");
		
		order.setOrderPlacedDate(new Date());
		order.setTransactionId(UUID.randomUUID().toString());
		orderList.add(order);
		logger.info("OrderService:addOrder execution ended..");
		return order;
	}

	public List<Order> getOrders() {
		logger.info("OrderService:getOrders execution started..");
		List<Order> list = null;
		list = orderList;
		
		logger.info("OrderService:getOrders execution ended..");
		return list;
	}

	public Order getOrder(int id) {
		logger.info("OrderService:getOrder execution started..");
		Order order = orderList.stream()
				.filter(ord -> ord.getId() == id)
				.findAny().orElseThrow(() -> new RuntimeException("Order not found with id : " + id));
		logger.info("OrderService:getOrder execution ended..");
		return order;
	}

}
