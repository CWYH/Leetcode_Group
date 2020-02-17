import java.util.HashMap;
import java.util.HashSet;

class ValidWordAbbr {

    private HashSet<String> dictSet = new HashSet<>();
    private HashMap<String, Integer> abbrMap = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            dictSet.add(dictionary[i]);
            String abbr = getAbbr(dictionary[i]);
            abbrMap.put(abbr, abbrMap.getOrDefault(abbr, 0) + 1);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (dictSet.contains(word)) {
            if (word.length() <= 2) return true;
            else return abbrMap.get(abbr) == 1;
        }
        return !abbrMap.containsKey(abbr);
    }

    private String getAbbr(String str) {
        if (str.length() <= 2) return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        sb.append(str.length() - 2);
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] dictionary = {"hello"};
        ValidWordAbbr v = new ValidWordAbbr(dictionary);
        System.out.println(v.isUnique("hello"));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */