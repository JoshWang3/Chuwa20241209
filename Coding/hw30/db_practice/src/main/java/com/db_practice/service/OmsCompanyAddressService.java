package com.db_practice.service;

import com.db_practice.entity.mongo.OmsCompanyAddressMongo;
import com.db_practice.repository.mongo.OmsCompanyAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OmsCompanyAddressService {

    private final OmsCompanyAddressRepository customMongoRepository;

    public OmsCompanyAddressService(OmsCompanyAddressRepository customMongoRepository) {
        this.customMongoRepository = customMongoRepository;
    }

    public List<OmsCompanyAddressMongo> findAll() {
        return customMongoRepository.findAll();
    }

    public Optional<OmsCompanyAddressMongo> findById(String id) {
        return customMongoRepository.findById(id);
    }

    public List<OmsCompanyAddressMongo> findByCity(String city) {
        return customMongoRepository.findByCustomCriteria(city);
    }

    public void save(OmsCompanyAddressMongo omsCompanyAddressMongo) {
        customMongoRepository.save(omsCompanyAddressMongo);
    }

    public void deleteById(String id) {
        customMongoRepository.deleteById(String.valueOf(id));
    }
}
