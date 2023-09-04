public enum Color {
    
    WHITE("\u001B[0m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m");

    private final String color;
    
    private Color(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    } 

    public String toString() {
        return this.name();
    }

}
