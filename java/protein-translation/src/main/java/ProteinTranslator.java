import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {
  private static final String TRYPTOPHAN = "Tryptophan";
  private static final String CYSTEINE = "Cysteine";
  private static final String TYROSINE = "Tyrosine";
  private static final String PHENYLALANINE = "Phenylalanine";
  private static final String METHIONINE = "Methionine";
  private static final String LEUCINE = "Leucine";
  private static final String SERINE = "Serine";
  private static final String STOP = "STOP";
  private final static Map<String, String> translationMap = createTranslationMap();
  private final static Map<String, String> createTranslationMap() {
    Map<String, String> map = new HashMap<>();
    map.put("AUG", METHIONINE);
    map.put("UUU", PHENYLALANINE);
    map.put("UUC", PHENYLALANINE);
    map.put("UUA", LEUCINE);
    map.put("UUG", LEUCINE);
    map.put("UCU", SERINE);
    map.put("UCC", SERINE);
    map.put("UCA", SERINE);
    map.put("UCG", SERINE);
    map.put("UAU", TYROSINE);
    map.put("UAC", TYROSINE);
    map.put("UGU", CYSTEINE);
    map.put("UGC", CYSTEINE);
    map.put("UGG", TRYPTOPHAN);
    map.put("UAA", STOP);
    map.put("UAG", STOP);
    map.put("UGA", STOP);
    return map;
  }

  List<String> translate(String rnaSequence) {    
    int rnaSequenceLength = rnaSequence.length();
    int index = 0;
    List<String> proteins = new ArrayList<>();
    while (index < rnaSequenceLength) {
      String codon = rnaSequence.substring(index, index + 3);      
      if (translationMap.containsKey(codon)) {
        String protein = translationMap.get(codon);
        if (protein.equals(STOP)) break;
        proteins.add(protein);
      }      
      index += 3;
    }
    return proteins;
  }
}