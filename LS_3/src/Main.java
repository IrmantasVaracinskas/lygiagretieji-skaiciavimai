import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Irmis on 2017-04-24.
 */
public class Main {
    static boolean cont = true;
    public static void main(String[] args) {
        int threadCount;
        int size;
        int aliveCells;
        int cyclesCount;
        if(args.length < 4) {
            System.out.println("not enough arguments");
            return;
        }
        threadCount = Integer.parseInt(args[0]);
        size = Integer.parseInt(args[1]);
        aliveCells = Integer.parseInt(args[2]);
        cyclesCount = Integer.parseInt(args[3]);
        ArrayList<Point> points = generatePoints(size, aliveCells);
        int listSize = size * size;
        CyclicBarrier barrier = new CyclicBarrier(threadCount + 1);
        for(int i = 0; i < threadCount; i++){
            new Thread(new NextTurnCalculator(listSize / threadCount * i, listSize / threadCount * (i + 1), points, barrier, size)).start();
        }
        long start = System.currentTimeMillis();
        for(int i = 0; i < cyclesCount; i++){
            try{
                barrier.await();// wait until every thread stopped calculating
                barrier.await();// wait until every thread updated point alive
            } catch (Exception e){
                System.out.println("EXCEPTION!!!!");
                e.printStackTrace();
            }
            //System.out.println("i is " + i);
        }
        //cont = false;
        try {
            barrier.await();
            cont = false;
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("FINISHED");
        long finish = System.currentTimeMillis();
        System.out.println("Finished in " + (finish - start) + " millis");
    }

    private static ArrayList<Point> generatePoints(int size, int aliveCells){
        ArrayList<Point> points = new ArrayList<>();
        Random randomGenerator = new Random();
        for(int i = 0; i < size * size; i++){
            Point point = new Point(i % size, i / size, false);
            points.add(point);
        }

        for(int i = 0; i < aliveCells; i++){
            points.get(randomGenerator.nextInt(size * size)).alive = true;
        }
        return points;
    }
}
