import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {
    public String[] ladder(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<String> breathQueue = new LinkedList<String>();
        HashMap<String, String> path = new HashMap<String, String>();
        wordDict.add(endWord);
        String ladder = "";

        breathQueue.add(beginWord);
        while (!breathQueue.isEmpty()) {
            String word = breathQueue.remove();
            if (word.equals(endWord)){
                ladder = path.get(word);
                break;
            }

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c ='a'; c <= 'z'; c++) {
                    char temp = arr[i];

                    if (arr[i] != c) {
                        arr[i] = c;
                    }
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        breathQueue.add(newWord);
                        wordDict.remove(newWord);

                        String st = "";
                        if (path.containsKey(word))
                            st = path.get(word);
                        else
                            st = word;
                        path.put(newWord, st + "," + newWord);
                    }

                    arr[i] = temp;  // reset word
                }
            }
        }

        return ladder.split(",");
    }
}
