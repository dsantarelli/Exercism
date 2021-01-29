import java.util.ArrayList;
import java.util.List;

public class Flattener {

  Iterable flatten(Iterable input) {
    List<Object> output = new ArrayList<Object>();
    recursiveFill(input, output);    
    return output;
  }

  private static void recursiveFill(Iterable input, List<Object> output) {
    for (Object obj : input) {
      if (obj != null) {
        if (Iterable.class.isAssignableFrom(obj.getClass())) 
          recursiveFill((Iterable)obj, output);
        else 
          output.add(obj);
      }
    }
  }
}