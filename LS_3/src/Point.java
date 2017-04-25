/**
 * Created by Irmis on 2017-04-24.
 */
public class Point {
    int x;
    int y;
    boolean alive;
    boolean nextTurnAlive;

    public Point(int x, int y, boolean alive){
        this.x = x;
        this.y = y;
        this.alive = alive;
        nextTurnAlive = alive;
    }
}
