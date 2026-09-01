class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> chains = new HashMap<>();  
        String[] sortedWords = Arrays.copyOf(words, words.length);
        Arrays.sort(sortedWords, (a, b) -> a.length() - b.length());  
        for (String word : sortedWords) {
            chains.put(word, 1);  

            for (int i = 0; i < word.length(); i++) {
                String pred = word.substring(0, i) + word.substring(i + 1);  
                if (chains.containsKey(pred)) {
                    chains.put(word, Math.max(chains.getOrDefault(word, 0), chains.get(pred) + 1));
                }
            }
        }

        int maxChainLength = chains.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        return maxChainLength;        
    }
}