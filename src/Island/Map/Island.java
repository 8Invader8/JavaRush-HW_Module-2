package Island.Map;

import java.sql.Array;

public class Island {
//    private Map<Type, Set<IslandFormOfLife>> islandMap;
    public Array[][] islandMap = new Array[100][20];
    private int x;
    private int y;
    private final int maxX = 100;
    private final int maxY = 20;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
