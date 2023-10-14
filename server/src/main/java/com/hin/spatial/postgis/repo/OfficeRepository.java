package com.hin.spatial.postgis.repo;

import com.hin.spatial.postgis.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {

}
