package com.bslnd.seva.card.config;

import com.bslnd.seva.card.model.Sevadar;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("objectMapper")
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean("csvMapper")
    public CsvMapper csvMapper() {
        return new CsvMapper();
    }

    @Bean("allSevadars")
    public List<Sevadar> allSevadars() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(new Sevadar(null,"Dr. Jagdeep Oberoi", "Mr. Oberoi", "M", "Joberoi.gmail.com", "0899443001",
                "Madhu Hotel", "Haryana", "YamunaNagar", "135001", "Doctor", "M.D", "2007",
                "Hindi", "Oberoi", "19-12-1965","04:00AM", "YamunaNagar", "India")));

        return new ArrayList<>(List.of(
                new Sevadar(null,"Dr. Jagdeep Oberoi", "Mr. Oberoi", "M", "Joberoi.gmail.com", "0899443001",
                        "Madhu Hotel", "Haryana", "YamunaNagar", "135001", "Doctor", "M.D", "2007",
                        "Hindi", "Oberoi", "19-12-1965","04:00AM", "YamunaNagar", "India"),
        new Sevadar(null,"Mohit Jain", "Mr. Jain", "M", "mjain.gmail.com", "0899443001",
                "Madhu Hotel", "Haryana", "YamunaNagar", "135001", "Doctor", "M.D", "2003",
                "Hindi", "Oberoi", "19-12-1975","04:00AM", "YamunaNagar", "India"),
        new Sevadar(null,"Harshit Bansal", "Mr. Bansal", "M", "hbansal.gmail.com", "0899443001",
                "Pahari Bazar", "Haryana", "Bilaspur", "135102", "Software Engineer", "B.Tech", "2005",
                "Hindi", "Oberoi", "19-12-1992","05:27AM", "YamunaNagar", "India")
        ));
    }

}
