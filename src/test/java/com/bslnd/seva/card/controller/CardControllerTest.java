package com.bslnd.seva.card.controller;

import com.bslnd.seva.card.Application;
import com.bslnd.seva.card.TestUtil;
import com.bslnd.seva.card.model.Sevadar;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
//@ContextConfiguration(classes=Application.class)
@SpringBootTest(properties = {
        "bslnd.seva.card.localdata.directoryPath=dir/",
        "bslnd.seva.card.localdata.fileName=sevadar",
        "bslnd.seva.card.localdata.columnNames=uuid,fullName,fatherName,gender,email,phone,address,state,city,pin,profession,qualification,pathYear,knownLanguage,gotra,dob,tob,pob,nationality",
        "bslnd.seva.card.localdata.recordsPerFile=1",
        "bslnd.seva.card.uploads.directoryPath=uploads/"

})
public class CardControllerTest {

    private final String MEDIA_TYPE = "multipart/form-data";

    private final String ACCEPT = "application/json";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    @Qualifier("objectMapper")
    ObjectMapper mapper;

    @AfterEach
    public void cleanUp() {
        //mapper = new ObjectMapper();
        //TestUtil.deleteDirectory("dir/");
        //TestUtil.deleteDirectory("uploads/");
    }

    //@Test
    public void saveSevadar2() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/sevadar"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //fail("FIXME");


        /*MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("sevadar", mapper.writeValueAsString(TestUtil.getSevadars().get(0)));

        webTestClient.post().uri("/api/repos")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromMultipartData(builder.build()))
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.name").isNotEmpty();*/
    }

    @Test
    public void saveSevadar() throws Exception {
        var sevadar  = new Sevadar(null,"Dr. Jagdeep Oberoi", "Mr. Oberoi", "M", "Joberoi.gmail.com", "0899443001",
                "Madhu Hotel", "Haryana", "YamunaNagar", "135001", "Doctor", "M.D", "2007",
                "Hindi", "Oberoi", "19-12-1965","04:00AM", "YamunaNagar", "India");
        String requestData = mapper.writeValueAsString(sevadar);
        LinkedMultiValueMap map = new LinkedMultiValueMap();
        map.add("sevadar", requestData);
        System.out.println(map);

        /*mockMvc.perform(post("/sevadar")
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .param("sevadar", requestData))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.uuid").exists());*/

        mockMvc.perform(MockMvcRequestBuilders.multipart("/sevadar")
                        //.file(firstFile)
                        .param("sevadar", "requestData")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.uuid").exists());
    }
}