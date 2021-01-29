public class Twofer {
    public String twofer(String name) {
        String actualName = (name == null || name.trim().isEmpty()) ? "you" : name.trim();
        return String.format("One for %s, one for me.",  actualName);
    }
}