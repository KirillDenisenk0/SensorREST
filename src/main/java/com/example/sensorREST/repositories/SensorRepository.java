package com.example.sensorREST.repositories;

import com.example.sensorREST.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SensorRepository extends JpaRepository<Sensor,String> {

    Optional<Sensor> findByName(String name);
}
