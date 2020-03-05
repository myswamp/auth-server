package com.myswamp.authserver.controller;

import com.myswamp.authserver.dto.ClientDTO;
import com.myswamp.authserver.service.ClientDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientDetailsServiceImpl clientDetailsService;


    @PostMapping
    public void createClient(@RequestBody ClientDTO clientDTO) {
        clientDetailsService.createClient(clientDTO);
    }


    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable String clientId) {
        clientDetailsService.deleteClient(clientId);
    }

}