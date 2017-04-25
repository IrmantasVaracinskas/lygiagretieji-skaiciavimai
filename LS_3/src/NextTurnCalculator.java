import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Irmis on 2017-04-24.
 */
public class NextTurnCalculator implements Runnable{
    int first;
    int last;
    int row;
    ArrayList<Point> points;
    CyclicBarrier barrier = null;
    //static Object o = new Object();
    public NextTurnCalculator(int first, int last, ArrayList<Point> points, CyclicBarrier barrier, int row){
        this.first = first;
        this.last = last;
        this.points = points;
        this.barrier = barrier;
        this.row = row;
    }
    public void run(){
        while(Main.cont){
            for(int i = first; i < last; i++){
                Point p = points.get(i);
                int neighbours = countNeighbours(p);
                if(p.alive && neighbours <= 1){// if has one or less friends then dies of loneliness
                    p.nextTurnAlive = false;
                }
                if(p.alive && neighbours >= 4){// if has more or equal than 4 friends then dies if overpopulation
                    p.nextTurnAlive = false;
                }

                if(p.alive && (neighbours == 2 || neighbours == 3)){// if has 2 or 3 friends then it lives
                    p.nextTurnAlive = true;
                }
                if(!p.alive && neighbours == 3){// if 3 friends has space then new friend is born
                    p.nextTurnAlive = true;
                }
            }
            try{
                barrier.await();
            } catch (Exception e){
                e.printStackTrace();
            }
            for(int i = first; i < last; i++){
                Point p = points.get(i);
                p.alive = p.nextTurnAlive;
            }
            try{
                barrier.await();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public int countNeighbours(Point point){
        int count = 0; //<>//

        if(point.x > 0){
            if(points.get((point.x - 1)+ point.y * row).alive){// check left
                count++;
                //println("left");
            }

            if(point.y > 0){
                if(points.get((point.x - 1)+ (point.y - 1) * row).alive){// check top left
                    count++;
                    //println("top left");
                }
            }

            if(point.y < row - 1){
                if(points.get((point.x - 1) + (point.y + 1) * row).alive){// check bottom left
                    count++;
                    //println("bottom left");
                }
            }

        }
        if(point.x < row - 1){
            if(points.get((point.x + 1) + point.y * row).alive){// check in the right
                count++;
                //println("right");
            }

            if(point.y > 0){
                if(points.get((point.x + 1) + (point.y - 1) * row).alive){// check top right
                    count++;
                    //println("top right");
                }
            }

            if(point.y < row - 1){
                if(points.get((point.x + 1) + (point.y + 1) * row).alive){// check bottom right
                    count++;
                    //println("bottom right");
                }
            }
        }

        if(point.y > 0){
            if(points.get((point.x) + (point.y - 1) * row).alive){// check top
                count++;
                //println("top");
            }
        }

        if(point.y < row - 1){
            if(points.get((point.x) + (point.y + 1) * row).alive){// check bottom
                count++;
                //println("bottom");
            }
        }

        return count;
    }
}