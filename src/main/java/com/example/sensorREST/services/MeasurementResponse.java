package com.example.sensorREST.services;

import com.example.sensorREST.dto.MeasurementDTO;
import com.example.sensorREST.models.Measurement;
import org.springframework.stereotype.Component;

import java.util.List;

public class MeasurementResponse {
    private List<MeasurementDTO> measurements;

    public MeasurementResponse(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
