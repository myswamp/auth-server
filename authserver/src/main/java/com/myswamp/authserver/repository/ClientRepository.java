package com.myswamp.authserver.repository;

import java.util.Optional;

import com.myswamp.authserver.domain.Client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    public Optional<Client> findByClientId(String clientId);

    public int deleteByClientId(String clientId);

}