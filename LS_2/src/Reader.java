/**
 * Created by Irmis on 2017-03-22.
 */
public class Reader extends Thread{
    private static int readers = 0; // number of readers

    private int number;
    private Database database;

    public Reader(Database database) {
        this.database = database;
        this.number = Reader.readers++;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * Delays.READING_FREQUENCY));
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.database.read(this.number);
        }
    }
}
