package com.example.aprovechapp.controller;

import com.example.aprovechapp.service.impl.AdministradorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ClientesControllerTest {
    AdministradorServiceImpl administradorServiceImpl;
    private MockMvc mockMvc;


    @BeforeEach
    public void setup() {
        administradorServiceImpl = new AdministradorServiceImpl(); // Instantiate your service implementation
        ClientesController controller = new ClientesController(); // Pass the service implementation to the controller
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    private Authentication mockAuthentication() {
        // Create a simple mock Authentication for testing
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMINISTRADOR");

        User user = new User("test@example.com", "password", Collections.singletonList(authority));

        return new UsernamePasswordAuthenticationToken(user, "password", Collections.singletonList(authority));
    }
    @Test
    public void testIndexAuthenticated() throws Exception {
        // MockMvc setup
        ClientesController controller = new ClientesController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Mock authentication (replace with your own implementation)
        Authentication authentication = mockAuthentication(); // You need to implement this method

        // Perform the request
        MvcResult result = mockMvc.perform(get("/").principal(authentication))
                .andExpect(status().isOk())
                .andExpect(view().name("index-authenticated.html"))
                .andExpect(model().attributeExists("username", "nombre"))
                .andReturn();

        // Add additional assertions if needed
    }

    @Test
    public void testIndexNotAuthenticated() throws Exception {
        // MockMvc setup
        ClientesController controller = new ClientesController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Perform the request
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index.html"))
                .andExpect(model().size(0)); // No attributes in the model when not authenticated
    }

    // Add more tests as needed

}

