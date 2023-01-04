package com.assignment.order_management.controller;

import com.assignment.order_management.model.Customer;
import com.assignment.order_management.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
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

import java.util.Optional;

@RunWith(SpringRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private RequestAttributes attributes;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private CustomerService customerService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        RequestContextHolder.setRequestAttributes(attributes);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void addCustomerTest() throws Exception {
        Customer customer=new Customer();
        customer.setId(1);
        customer.setUsername("shashank");
        Mockito.when(customerService.addCustomer("shashank")).thenReturn(customer);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/add-customer/username/shashank")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findUserByIdTest() {
        Integer customerID=1;
        Customer customer=new Customer();
        customer.setId(customerID);
        Mockito.when(customerService.findCustomerById(customerID)).thenReturn(Optional.of(customer));
        Assert.assertNotNull(customer);
        Assert.assertNotNull(customerID);
        Assert.assertNotNull(customerService.findCustomerById(customerID));

    }
}
