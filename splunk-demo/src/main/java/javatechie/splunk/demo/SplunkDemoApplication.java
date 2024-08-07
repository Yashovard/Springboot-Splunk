package javatechie.splunk.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javatechie.splunk.demo.dto.Order;
import javatechie.splunk.demo.service.OrderService;
import javatechie.splunk.demo.utill.Mapper;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class SplunkDemoApplication {

	Logger logger=LogManager.getLogger(SplunkDemoApplication.class);

	@Autowired
	private OrderService service;

	@PostMapping
	public Order placeOrder(@RequestBody Order order)
	{
		logger.info("OrderController:placeOrder persist order request {}", Mapper.mapTOJsonString(order));
		//Order order= service.addOrder(order);
		Order addOrder=service.addOrder(order);
		logger.info("OrderController:placeOrder response from service {}", Mapper.mapTOJsonString(addOrder));
		return addOrder;
	}

	@GetMapping
	public List<Order> getOrders()
	{
		List<Order> orders=service.getOrders();
		logger.info("OrderController:placeOrder response from service {}", Mapper.mapTOJsonString(orders));
		return orders;
	}

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable int id)
	{
		logger.info("OrderController:getOrder fetch order by id {}", id);
		Order order=service.getOrder(id);

		logger.info("OrderController:getOrder fetch order response {}", Mapper.mapTOJsonString(order));
		return order;
	}




	public static void main(String[] args) {
		SpringApplication.run(SplunkDemoApplication.class, args);
	}

}
