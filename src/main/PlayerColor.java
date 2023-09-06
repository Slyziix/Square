package main;

import java.awt.Color;

public enum PlayerColor {

    WHITE(Color.WHITE, null),
    TRANSPARENT(new Color(0, 0, 0, 100), null),
    RED(Color.RED, new Position(0, 0)),
    BLUE(Color.BLUE, new Position(0, 19)),
    GREEN(Color.GREEN, new Position(19, 0)),
    MAGENTA(Color.MAGENTA, new Position(19, 19));

    private final Color color;
    private Position position;

    private PlayerColor(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String toString() {
        String positionString = (position != null) ? ", Position: " + position.toString() : ", No Position Set";
        return "Color: " + color.toString() + positionString;
    }

}
