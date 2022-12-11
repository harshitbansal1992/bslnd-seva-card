package com.bslnd.seva.card.service;

import com.bslnd.seva.card.TestUtil;
import com.bslnd.seva.card.config.LocalDataServiceProperties;
import com.bslnd.seva.card.model.Sevadar;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocalDataServiceTest {

    private final String FILE_NAME = "sevadar";

    private LocalDataService localDataService;
    @Mock
    private LocalDataServiceProperties properties;

    private ArrayList<String> columns = getCsvColumnList();

    @BeforeEach
    public void setUp () throws IOException {
        when(properties.getDirectoryPath()).thenReturn("dir/");
        when(properties.getFileName()).thenReturn(FILE_NAME);
        when(properties.getColumnNames()).thenReturn(columns);
        when(properties.getRecordsPerFile()).thenReturn(Integer.valueOf(1));

        localDataService = new LocalDataService(properties, new CsvMapper());
    }

    @AfterEach
    public void cleanUp() {
        TestUtil.deleteDirectory("dir/");
    }

    @Test
    public void saveSuccess() {
        assertTrue(localDataService.save(TestUtil.getSevadars().get(0)));
    }

    @Test
    public void saveSuccessWithMultipleFile() {
        when(properties.getRecordsPerFile()).thenReturn(2);
        assertTrue(localDataService.save(TestUtil.getSevadars().get(0)));
        assertTrue(localDataService.save(TestUtil.getSevadars().get(1)));
        assertTrue(localDataService.save(TestUtil.getSevadars().get(0)));
        assertTrue(localDataService.save(TestUtil.getSevadars().get(1)));
        File[] files = new File("dir/").listFiles();
        assertEquals(2, files.length);
    }

    @Test
    public void saveSuccessWithMultipleRecordsOneFile() {
        when(properties.getRecordsPerFile()).thenReturn(10);
        assertTrue(localDataService.save(TestUtil.getSevadars().get(0)));
        assertTrue(localDataService.save(TestUtil.getSevadars().get(1)));
        File[] files = new File("dir/").listFiles();
        assertEquals(1, files.length);
    }

    private ArrayList<String> getCsvColumnList() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("uuid");
        columns.add("fullName");
        columns.add("fatherName");
        columns.add("gender");
        columns.add("email");
        columns.add("phone");
        columns.add("address");
        columns.add("state");
        columns.add("city");
        columns.add("pin");
        columns.add("profession");
        columns.add("qualification");
        columns.add("pathYear");
        columns.add("knownLanguage");
        columns.add("gotra");
        columns.add("dob");
        columns.add("tob");
        columns.add("pob");
        columns.add("nationality");
        columns.add("userPhoto");
        return columns;
    }

}