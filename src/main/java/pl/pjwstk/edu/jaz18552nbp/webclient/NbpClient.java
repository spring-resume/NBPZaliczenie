package pl.pjwstk.edu.jaz18552nbp.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.pjwstk.edu.jaz18552nbp.model.Result;
import pl.pjwstk.edu.jaz18552nbp.webclient.dto.RootDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Component
public class NbpClient {
    private final RestTemplate restTemplate;
    private final String url;

    public NbpClient(RestTemplate restTemplate, @Value("${my.adress}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Result getResult(String startDate, String endDate) {
        String path = createPath(startDate, endDate);
        RootDto[] root = restTemplate.getForObject(path, RootDto[].class);
        return Result.builder()
                .startDate(LocalDate.parse(startDate))
                .endDate(LocalDate.parse(endDate))
                .price(getAvgPrice(Arrays.stream(Objects.requireNonNull(root)).toList()))
                .executeQuestion(LocalDateTime.now())
                .build();
    }

    private String createPath(String... var) {
        return url + String.join("/", var) + "?format=json";
    }

    private double getAvgPrice(List<RootDto> root) {
        return root.stream()
                .mapToDouble(RootDto::getCena)
                .average()
                .orElse(0.0);
    }
}
