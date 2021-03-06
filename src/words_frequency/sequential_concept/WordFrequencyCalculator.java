package words_frequency.sequential_concept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyCalculator {

    private final List<String> lines;

    WordFrequencyCalculator(List<String> lines) {
        this.lines = lines;
    }

    public Map<String, Integer> wordVsCount() {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for (String eachLine : lines) {
            String[] words = eachLine.split("[,.;?()\\s]+");
            for (String word : words) {
                if (wordFrequencies.containsKey(word)) {
                    wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                } else {
                    wordFrequencies.put(word, 1);
                }
            }
        }
        return wordFrequencies;
    }
}
