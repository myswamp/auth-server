package com.myswamp.authserver.service;

import com.myswamp.authserver.dto.ClientDTO;
import com.myswamp.authserver.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientRepository.findByClientId(clientId)
        .orElseThrow(() -> new ClientRegistrationException(clientId));
    }


    public void createClient(ClientDTO clientDTO) {
        clientRepository.insert(clientDTO.toClient());
    }

    public void deleteClient(String clientId) {
        clientRepository.deleteByClientId(clientId);
    }   


}