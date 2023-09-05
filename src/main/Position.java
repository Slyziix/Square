package main;
public class Position{
    
    private final int x;
    private final int y;

    /**
     * constructor of position 
     * @param x horizontal position
     * @param y vertical position
     */
    public Position(int x, int y) {
        
        this.x = x;
        this.y = y;
    }

    /**
     * getter of horizontal position
     * @return horizontal position
     */
    public int getX() {
        
        return x;
    }

    /**
     * getter of vertcial position
     * @return vertical position
     */
    public int getY() {
        
        return y;
    }

    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    public String toString() {
        
        return "("+ x + "," + y + ")";
    }

}