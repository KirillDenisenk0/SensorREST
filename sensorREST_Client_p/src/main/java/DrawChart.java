
import dto.MeasurementDTO;
import dto.MeasurementResponse;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class DrawChart {
    public static void main(String[] args) {
        List<Double> temperatures = getTemperaturesFromServer();
        drawChart(temperatures);
    }

    private static List<Double> getTemperaturesFromServer(){
        final RestTemplate restTemplate = new RestTemplate();

        final String url = "http://localhost:8080/measurements";

        MeasurementResponse jsonResponse = restTemplate.getForObject(url, MeasurementResponse.class);

        if(jsonResponse == null || jsonResponse.getMeasurements() == null){
            return Collections.emptyList();
        } else {
            return jsonResponse.getMeasurements().stream().map(MeasurementDTO::getValue).
                    collect(Collectors.toList());
        }
    }

    private static void drawChart(List<Double> temperatures){
        double [] xData = IntStream.range(0, temperatures.size()).asDoubleStream().toArray();
        double [] yData = temperatures.stream().mapToDouble(x -> x).toArray();

        XYChart xyChart = QuickChart.getChart("Temperatures", "X", "Y", "temperature",
                xData, yData);


        new SwingWrapper(xyChart).displayChart();
    }
}
