package com.bslnd.seva.card.controller;

import com.bslnd.seva.card.config.UploadProperties;
import com.bslnd.seva.card.model.LocalDataModel;
import com.bslnd.seva.card.model.Sevadar;
import com.bslnd.seva.card.repository.Repository;
import com.bslnd.seva.card.service.DataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;

@RestController
@EnableConfigurationProperties(UploadProperties.class)
public class CardController {

    Logger LOGGER = LoggerFactory.getLogger(CardController.class);
    final private ObjectMapper mapper;

    final private Validator validator;

    final Repository<Sevadar, String> repository;

    final DataService dataService;

    final UploadProperties uploadProperties;

    private final Path root;

    public CardController(@Qualifier("objectMapper") final ObjectMapper mapper, final Validator validator,
                          final Repository<Sevadar, String> repository, final DataService dataService,
                          final UploadProperties uploadProperties) {
        this.mapper = mapper;
        this.validator = validator;
        this.repository = repository;
        this.dataService = dataService;
        this.uploadProperties = uploadProperties;
        //"/Users/hban0002/Documents/Backup/uploads/"
        root = Paths.get(uploadProperties.getDirectoryPath());
    }

    @PostMapping(value = "/sevadar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sevadar> saveSevadarWithImage(@RequestPart(name = "sevadar") String body,
                                                        @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        Sevadar sevadar = mapper.readValue(body, Sevadar.class);
        Set<ConstraintViolation<Sevadar>> errors = validator.validate(sevadar);
        if(errors != null && !errors.isEmpty()) {
            throw new ConstraintViolationException(errors);
        }

        if(image != null && !image.isEmpty()) {
            final String savedFileName = UUID.randomUUID() + image.getOriginalFilename();
            Files.copy(image.getInputStream(), this.root.resolve(savedFileName));
            sevadar.setUserPhoto(this.root.resolve(savedFileName).toString());
        }
        dataService.save(sevadar);
        return new ResponseEntity<>(sevadar, HttpStatus.OK);
    }

    @GetMapping(value = "/sevadarByName/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sevadar> saveSevadarWithImage(@PathVariable(name = "name") String name) throws IOException {
        Sevadar sevadar = repository.findByName(name);
        return new ResponseEntity<>(sevadar, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return new ResponseEntity<>("true", HttpStatus.OK);
    }

}
