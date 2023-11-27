package com.example.sensorREST.util;

import com.example.sensorREST.models.Sensor;
import com.example.sensorREST.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        Optional<Sensor> byName = sensorService.findByName(sensor.getName());
        if (byName.isPresent()){
            errors.rejectValue("name","",
                    "Sensor with such name is already exists!");
        }
    }
}
