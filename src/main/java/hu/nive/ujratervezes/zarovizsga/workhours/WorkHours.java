package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkHours {

    private List<String> readLines(String path) {
        List<String> parsedLines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = reader.readLine())  != null) {
                parsedLines.add(reformatLine(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        Collections.sort(parsedLines);
        return parsedLines;
    }

    private String reformatLine(String line){
        return line.split(",")[1] +
                "," +
                line.split(",")[0] +
                ": " +
                line.split(",")[2];
    }

    public String minWork(String file){
        List<String> result = readLines(file);
        return result.get(0).substring(result.get(0).indexOf(",")+1);
    }
}
