import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BracketChecker {

  private boolean ok;
  private static final List<Character> OPEN_BRACKETS = Arrays.asList('(', '[', '{');
  private static final List<Character> CLOSED_BRACKETS = Arrays.asList(')', ']', '}');

  public BracketChecker(String input) {    
    Stack<Character> brackets = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      Character ch = input.charAt(i);
      if (OPEN_BRACKETS.indexOf(ch) >= 0) brackets.push(ch);
      else {
        int closedBracketIndex = CLOSED_BRACKETS.indexOf(ch);
        if (closedBracketIndex >= 0) {
          ok = !brackets.isEmpty() && OPEN_BRACKETS.indexOf(brackets.pop()) == closedBracketIndex;
          if (!ok) return;
        }
      }
    }
    ok = brackets.isEmpty();
  }

  public boolean areBracketsMatchedAndNestedCorrectly() {
    return ok;
  }
}