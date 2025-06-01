package com.srt.accounts.controller;

import com.srt.accounts.entities.CabDriver;
import com.srt.accounts.service.CabDriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cab-driver")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class CabDriverController {

    private final CabDriverService cabDriverService;

    @GetMapping("/all")
    public List<CabDriver> getAllDrivers() {
        log.info("Request received to get all cab drivers");
        List<CabDriver> drivers = cabDriverService.findAllDrivers();
        log.info("Returning {} cab drivers", drivers.size());
        return drivers;
    }

    @GetMapping("/find/{id}")
    public CabDriver getDriverById(Long id) {
        log.info("Request received to find cab driver by ID: {}", id);
        CabDriver driver = cabDriverService.findDriverById(id);
        log.info("Returning cab driver: {}", driver);
        return driver;
    }

    @PostMapping("/add-update")
    public CabDriver addOrUpdateDriver(@RequestBody CabDriver cabDriver) {
        log.info("Request received to add or update cab driver: {}", cabDriver);
        CabDriver savedDriver = cabDriverService.addOrUpdateDriver(cabDriver);
        log.info("Cab driver saved successfully: {}", savedDriver);
        return savedDriver;
    }
}
