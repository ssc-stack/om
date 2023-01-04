package com.assignment.order_management.controller;

import com.assignment.order_management.model.Customer;
import com.assignment.order_management.model.Order;
import com.assignment.order_management.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@RunWith(SpringRunner.class)
public class OrderControllerTest {

    @InjectMocks
    private OrderController customerController;

    @Mock
    private RequestAttributes attributes;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private OrderService orderService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        RequestContextHolder.setRequestAttributes(attributes);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void createOrderTest() throws Exception {
        Customer customer=new Customer();
        customer.setId(1);
        customer.setUsername("shashank");
        Order order=new Order();
        order.setId(1);
        order.setCustomer(customer);
        order.setAmount(100);

        Mockito.when(orderService.createOrder(1,100)).thenReturn(order);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/create-order/cust-id/1/amount/100")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(order))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
