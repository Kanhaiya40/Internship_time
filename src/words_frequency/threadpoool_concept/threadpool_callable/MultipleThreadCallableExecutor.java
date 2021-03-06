package words_frequency.threadpoool_concept.threadpool_callable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class MultipleThreadCallableExecutor implements Callable<Map<String, Integer>> {

    private final List<String> buffer;

    MultipleThreadCallableExecutor(List<String> buffer) {
        this.buffer = buffer;
    }


    @Override
    public Map<String, Integer> call() {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for (String eachLine : buffer) {
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
