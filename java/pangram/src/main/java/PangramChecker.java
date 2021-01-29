public class PangramChecker {

	public boolean isPangram(String input) {
		if (input == null || input.trim().isEmpty()) return false;
		String lowerCase = input.toLowerCase();
		for (int i = (int) 'a'; i <= (int)'z'; i++) {
			if (lowerCase.indexOf(i) < 0)
				return false;
		}
		return true;
	}
}