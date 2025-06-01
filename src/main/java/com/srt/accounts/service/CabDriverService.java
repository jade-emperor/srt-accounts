package com.srt.accounts.service;

import com.srt.accounts.entities.CabDriver;
import com.srt.accounts.repo.CabDriverRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CabDriverService {

    private final CabDriverRepo cabDriverRepo;

    public CabDriver addOrUpdateDriver(CabDriver cabDriver) {
        log.info("Adding new cab driver: {}", cabDriver);
        return cabDriverRepo.save(cabDriver);
    }

    public CabDriver findDriverById(Long id) {
        log.info("Finding cab driver by ID: {}", id);
        return cabDriverRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cab driver not found with ID: " + id));
    }

    public List<CabDriver> findAllDrivers() {
        log.info("Retrieving all cab drivers");
        return cabDriverRepo.findAll();
    }
}
