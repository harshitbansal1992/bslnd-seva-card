package com.bslnd.seva.card.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@ConfigurationProperties("bslnd.seva.card.uploads")
@ConstructorBinding
public class UploadProperties {

    /**
     * Directory location to store files.
     */
    @NotBlank
    final String directoryPath;

    public UploadProperties(final String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }
}
