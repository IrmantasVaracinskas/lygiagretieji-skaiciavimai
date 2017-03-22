/**
 * Created by Irmis on 2017-03-22.
 */

public class Database {
    private volatile int readers; // number of active readers
    private volatile boolean wantToWrite;


    public Database() {
        this.readers = 0;
        wantToWrite = false;
    }


    public void read(int number) {
        synchronized (this) {
            try {
                while (true) {
                    while (wantToWrite) {// someone wants to write, so we have to wait
                        wait();
                    }
                    if (readers < 4) {
                        readers++;
                        System.out.println("Reader " + number + " starts reading.");
                        System.out.println("    Current readers: " + readers);
                        break;
                    } else {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep((int) (Math.random() * Delays.READING_TIME));// doing the reading
        } catch (InterruptedException e) {
        }

        synchronized (this) {
            readers--;
            System.out.println("Reader " + number + " stops reading.");
            System.out.println("    Current reader: " + readers);
            if(readers == 0)
                notifyAll();
            else
                notify();
        }
    }

    public void write(int number) {
        synchronized (this) {
            try {
                while (wantToWrite)// someone else is trying to write already
                    wait();
                wantToWrite = true;
                while (readers != 0) {// now wait until every reader stopped reading
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Writer " + number + " starts writing.");

        try {
            Thread.sleep((int) (Math.random() * Delays.WRITING_TIME));// doing the writing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Writer " + number + " stops writing.");
        wantToWrite = false;
        synchronized (this) {
            this.notifyAll();
        }
    }
}
