package hillel.entry_test.first_task;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;


public class DistinctWordsService {

    private String path;
    private File file;
    private List<String> uniqueWordsContainer = new ArrayList<>();

    public DistinctWordsService(String path) {
        Objects.requireNonNull(path);
        this.path = path;
        file = new File(path);
    }

    public String readFile() {
        String line;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String collectDistinctWords() {
        String text = readFile();
        Pattern pattern = Pattern.compile("[\\W]+");
        String[] splitted = pattern.split(text);
        getUniqueWords(splitted);
        String finalString = uniqueWordsContainer.stream().collect(joining(", "));
        return finalString;
    }

    private List<String> getUniqueWords(String[] source) {
        for (int i = 0; i < source.length; i++) {
            if (!uniqueWordsContainer.contains(source[i].toLowerCase())) {
                uniqueWordsContainer.add(source[i]);
            }
        }
        return uniqueWordsContainer;
    }

}
