import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KindergartenGarden {

  private static final int CUPS_PER_ROW = 2;
  private static final String[] DEFAULT_STUDENTS = { "Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana","Joseph", "Kincaid", "Larry" };      
  private final Vector<Vector<Character>> rows = new Vector<Vector<Character>>();
  private final List<String> students;

  public KindergartenGarden(String plants) { this(plants, DEFAULT_STUDENTS); }  
  public KindergartenGarden(String plants, String[] studentArray) {           
    this.students = Arrays.asList(studentArray);    
    this.students.sort(String::compareTo);
    Arrays.stream(plants.split("\\r?\\n"))
     .forEach(row -> this.rows.addElement(new Vector<Character>(
         row.chars().mapToObj(c -> (char)c).collect(Collectors.toList()))));
  }

  public List<Plant> getPlantsOfStudent(String student) {             
    int studentIndex = students.indexOf(student);        
    return IntStream.range(0, rows.size())
      .mapToObj(i -> rows.get(i).stream().skip(studentIndex * CUPS_PER_ROW).limit(CUPS_PER_ROW))
      .flatMap(c -> c.map(Plant::getPlant))
      .collect(Collectors.toList());
  }
}