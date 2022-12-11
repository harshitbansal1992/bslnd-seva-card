package com.bslnd.seva.card.service;

import com.bslnd.seva.card.config.LocalDataServiceProperties;
import com.bslnd.seva.card.exception.SevaCardException;
import com.bslnd.seva.card.model.Sevadar;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.bslnd.seva.card.exception.SevaCardErrorCode.COULD_NOT_SAVE_SEVADAR_LOCALLY;

public class LocalDataService implements DataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalDataService.class);

    private final LocalDataServiceProperties properties;

    private final CsvSchema sevadarCsvSchema;

    private File currentFilePath;

    private int currentFileRecordsCount;

    private final List<File> files = new ArrayList<>();

    private final CsvMapper csvMapper;
    private final ObjectWriter writer;

    public LocalDataService(final LocalDataServiceProperties properties, final CsvMapper csvMapper) throws IOException {
        this.properties = properties;
        this.csvMapper = csvMapper;

        ArrayList<CsvSchema.Column> columns = new ArrayList<>();
        for (int i = 0; i < properties.getColumnNames().size(); i++) {
            columns.add(new CsvSchema.Column(i, properties.getColumnNames().get(i)));
        }
        this.sevadarCsvSchema = CsvSchema.builder().setUseHeader(true)
                .addColumns(columns)
                .build();

        currentFilePath = createFile();
        writeHeaderRow();
        files.add(currentFilePath);
        writer = csvMapper.writerFor(Sevadar.class).with(sevadarCsvSchema.withoutHeader());
        csvMapper.writer(sevadarCsvSchema.withHeader()).writeValueAsString(null);
    }

    /**
     * Saves sevadar details to a local file.
     * @param sevadar the sevadar to be saved
     * @return true or false
     */
    @Override
    public boolean save(final Sevadar sevadar) {
        try {
            if(checkNewFileRequired()) {
                currentFilePath = createFile();
                files.add(currentFilePath);
                writeHeaderRow();
            }
            OutputStream outstream = new FileOutputStream(currentFilePath , true);
            writer.writeValue(outstream,sevadar);

            //writer.writeValues(currentFilePath).write(sevadar);
            currentFileRecordsCount++;
            return true;
        } catch (Exception ex) {
            throw new SevaCardException(ex, COULD_NOT_SAVE_SEVADAR_LOCALLY.getErrorCode(), COULD_NOT_SAVE_SEVADAR_LOCALLY.getDescription());
        }
    }

    private File createFile() throws IOException {
        currentFileRecordsCount = 0;
        File dir = new File(properties.getDirectoryPath());
        if(!dir.mkdirs()){
            LOGGER.info("Did not create directory : {}",properties.getDirectoryPath());
        };
        File file = new File(properties.getDirectoryPath() + properties.getFileName() + UUID.randomUUID() + ".csv");
        var createFileFlag = file.createNewFile();
        if(!createFileFlag) {
            throw new SevaCardException(null, COULD_NOT_SAVE_SEVADAR_LOCALLY.getErrorCode(), COULD_NOT_SAVE_SEVADAR_LOCALLY.getDescription());
        }

        //csvMapper.writer(sevadarCsvSchema.withHeader()).writeValues(currentFilePath).write(null);
        return file;
    }

    private void writeHeaderRow() throws IOException {
        final var headerWriter = csvMapper.writerFor(Sevadar.class).with(sevadarCsvSchema.withHeader());
        OutputStream outstream = new FileOutputStream(currentFilePath , true);
        headerWriter.writeValue(outstream,null);
    }

    private boolean checkNewFileRequired() {
        return currentFileRecordsCount >= properties.getRecordsPerFile();
    }
}