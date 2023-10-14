package com.hin.spatial.postgis.service;

import com.hin.spatial.postgis.model.Atm;
import com.hin.spatial.postgis.model.Office;
import com.hin.spatial.postgis.repo.AtmRepository;
import com.hin.spatial.postgis.repo.OfficeRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class AtmService {

    @Autowired
    private AtmRepository repo;
    @Autowired
    private OfficeRepository officeRepo;

    private final GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

    public List<Atm> findAll() {
        return repo.findAll();
    }

    public List<Office> getAll() {
        return officeRepo.findAll();
    }

    public void add(Atm atm) {
        repo.save(atm);
    }

    public void addOffice(Office office) {
        System.out.println(office);
        officeRepo.save(office);
    }

    public List<Atm> findAround(double lat, double lon, double distance) {
        System.out.format("Looking for city around (%s, %s) withing %s meters", lat, lon, distance);
        Point p = factory.createPoint(new Coordinate(lon, lat));
        return repo.findNearWithinDistance(p, distance);
    }
}
