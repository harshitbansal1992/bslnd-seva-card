package com.bslnd.seva.card;

import com.bslnd.seva.card.model.LocalDataModel;
import com.bslnd.seva.card.model.Sevadar;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class TestUtil {

    public static List<Sevadar> getSevadars() {
        return List.of(
                new Sevadar(null,"Dr. Jagdeep Oberoi", "Mr. Oberoi", "M", "Joberoi.gmail.com", "0899443001",
                        "Madhu Hotel", "Haryana", "YamunaNagar", "135001", "Doctor", "M.D", "2007",
                        "Hindi", "Oberoi", "19-12-1965","04:00AM", "YamunaNagar", "India"),

                new Sevadar(null,"Mrs. Jagdeep Oberoi", "Mr. Oberoi", "M", "Joberoi.gmail.com", "0899443002",
                        "Madhu Hotel", "Haryana", "YamunaNagar", "135001", "Doctor", "M.D", "2007",
                        "Hindi", "Oberoi", "19-12-1965","04:00AM", "YamunaNagar", "India")
        );
    }

    public static List<LocalDataModel> getLocalDataModels() {
        return List.of(
                new LocalDataModel(null,"Dr. Jagdeep Oberoi", "Mr. Oberoi", "M", "Joberoi.gmail.com", "0899443001",
                        "Madhu Hotel", "Haryana", "YamunaNagar", "135001", "Doctor", "M.D", "2007",
                        "Hindi", "Oberoi", "19-12-1965","04:00AM", "YamunaNagar", "India", "/dir/file1.png"),

                new LocalDataModel(null,"Mrs. Jagdeep Oberoi", "Mr. Oberoi", "M", "Joberoi.gmail.com", "0899443002",
                        "Madhu Hotel", "Haryana", "YamunaNagar", "135001", "Doctor", "M.D", "2007",
                        "Hindi", "Oberoi", "19-12-1965","04:00AM", "YamunaNagar", "India", "/dir/file2.jpg")
        );
    }

    public static void deleteDirectory(final String path) {
        var dir = new File(path);
        var files = dir.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(file -> file.delete());
        }
        dir.delete();
    }
}
