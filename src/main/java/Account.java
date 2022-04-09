public class Account {

    private final String name;
    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        return (name.length() >= 3 && name.length() < 20) &&
                (name.length() - name.replaceAll(" ", "").length() == 1) &&
                (!name.startsWith(" ") && (!name.endsWith(" ")));
    }
}