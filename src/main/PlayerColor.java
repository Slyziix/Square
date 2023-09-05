package main;
import java.awt.Color; 

public enum PlayerColor {
    
    WHITE(Color.WHITE,null),
    TRANSPARENT(new Color(0,0,0,100),null),
    RED(Color.RED,new Position(0,0)),
    BLUE(Color.BLUE,new Position(0,20)),
    GREEN(Color.GREEN,new Position(20,0)),
    YELLOW(Color.YELLOW,new Position(20,20)); 

    private final Color color;
    private Position position;

    private PlayerColor(Color color, Position position ) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return this.name();
    }
}
