import java.util.HashMap;
import java.util.Map;

public class RnaTranscription {

    private static final Map<Character, Character> rnaMap = createRnaMap();
    private static Map<Character, Character> createRnaMap() {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('C', 'G');
        map.put('G', 'C');
        map.put('T', 'A');
        map.put('A', 'U');
        return map;
    }

    public String transcribe(String dnaStrand) {
        if (dnaStrand == null || dnaStrand.trim().isEmpty()) return "";
        char[] dnaChars = dnaStrand.toCharArray();
        StringBuilder rnaBuilder = new StringBuilder();
        for (Character dnaChar : dnaChars) {
            if (rnaMap.containsKey(dnaChar))
                rnaBuilder.append(rnaMap.get(dnaChar));
        }
        return rnaBuilder.toString();
    }
}