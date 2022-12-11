package com.bslnd.seva.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {

        /*File file = new File("/Users/hban0002/Documents/uploads.csv");
        file.createNewFile();

        System.out.println(System.getProperty("user.dir"));

        File file1 = new File(System.getProperty("user.dir") + "/uploadsWithinProj.csv");
        file.createNewFile();*/
        SpringApplication.run(Application.class, args);
    }
}
