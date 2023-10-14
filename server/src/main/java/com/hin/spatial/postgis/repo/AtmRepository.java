package com.hin.spatial.postgis.repo;

import java.util.List;

import com.hin.spatial.postgis.model.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vividsolutions.jts.geom.Point;

@Repository
public interface AtmRepository extends JpaRepository<Atm, String> {

    //@Query(value="SELECT * from atm where ST_DistanceSphere(geom, POINT() < :distanceM", nativeQuery = true)
    @Query(value = "SELECT * from atm LIMIT 1000", nativeQuery = true)
    List<Atm> findNearWithinDistance(Point p, double distance);
}
