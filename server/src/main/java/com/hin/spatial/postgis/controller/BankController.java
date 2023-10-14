package com.hin.spatial.postgis.controller;

import com.hin.spatial.postgis.model.Atm;
import com.hin.spatial.postgis.model.Office;
import com.hin.spatial.postgis.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bank")
public class BankController {

    @Autowired
    private AtmService service;

    @GetMapping
    public List<Atm> getCityPage() {
        return service.findAll();
    }


    @PostMapping("/add")
    public void addAtm(@RequestBody Atm atm) {
        service.add(atm);
    }

    public static class OfficeDto {
        public Office office;
    }

    @PostMapping(value = "/addOffice", consumes = "application/json", produces = "application/json")
    public void addOffice(@RequestBody OfficeDto atm) {
        service.addOffice(atm.office);
    }

    @GetMapping("{lat}/{lon}/{distance}")
    public List<Atm> getCityNear(
            @PathVariable double lat,
            @PathVariable double lon,
            @PathVariable double distance) {
        return service.findAround(lat, lon, distance);
    }
}
