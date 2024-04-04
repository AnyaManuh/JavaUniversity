package exam_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        PrintWriter writer = new PrintWriter("output.txt");

        scanner.useDelimiter("[\\s.,]+");

        Map<String, Integer> map = new LinkedHashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            word = word.toLowerCase();

            if(map.containsKey(word)) {
                int amount = map.get(word);
                map.put(word, amount + 1);
            } else {
                map.put(word, 1);
            }
        }

        map.keySet().stream()
                .sorted((word1, word2) -> {
                    return map.get(word2) - map.get(word1);
                })
                .forEach(word -> writer.println(word));

        scanner.close();
        writer.close();
    }

}
