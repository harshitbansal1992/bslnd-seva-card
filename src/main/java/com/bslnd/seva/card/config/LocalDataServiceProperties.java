package com.bslnd.seva.card.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@ConfigurationProperties("bslnd.seva.card.localdata")
@ConstructorBinding
public class LocalDataServiceProperties {

    /**
     * Directory location to store files.
     */
    @NotBlank
    final String directoryPath;

    /**
     * File name to store data.
     */
    @NotBlank
    final String fileName;

    /**
     * Csv field names that would be written to local data.
     */
    final ArrayList<String> columnNames;

    /**
     * Number of records to be saved in one file.
     */
    @NotBlank
    final int recordsPerFile;

    public LocalDataServiceProperties(final String directoryPath, final String fileName, final ArrayList<String> columnNames, final int recordsPerFile) {
        this.directoryPath = directoryPath;
        this.fileName = fileName;
        this.columnNames = columnNames;
        this.recordsPerFile = recordsPerFile;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList<String> getColumnNames() {
        return columnNames;
    }

    public int getRecordsPerFile() {
        return recordsPerFile;
    }
}
