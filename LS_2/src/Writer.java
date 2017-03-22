/**
 * Created by Irmis on 2017-03-22.
 */
public class Writer extends Thread {
    private static int writers = 0; // number of writers

    private int number;
    private Database database;

    public Writer(Database database) {
        this.database = database;
        this.number = Writer.writers++;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * Delays.WRITING_FREQUENCY));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.database.write(this.number);
        }
    }
}
