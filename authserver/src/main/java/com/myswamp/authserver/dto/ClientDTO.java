package com.myswamp.authserver.dto;

import java.util.List;
import java.util.Set;

import com.myswamp.authserver.domain.Client;

import lombok.Data;

@Data
public class ClientDTO {
    private String clientId;
    private String clientSecret;
    private Set<String> resourceIds;
    private Set<String> scopes;
    private Set<String> authorizedGrantTypes;
    private Set<String> registeredRedirectUris;
    private List<String> authorities;


    public Client toClient() {
        Client client = new Client();
        client.setClientId(this.getClientId());
        client.setClientSecret(this.getClientSecret());
        client.setResourceIds(this.getResourceIds());
        client.setScopes(this.getScopes());
        client.setAuthorizedGrantTypes(this.getAuthorizedGrantTypes());
        client.setRegisteredRedirectUris(this.getRegisteredRedirectUris());
        client.setAuthorities(this.getAuthorities());
        return client;
    }
}