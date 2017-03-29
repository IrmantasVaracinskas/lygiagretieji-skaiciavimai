/**
 * Created by Irmis on 2017-03-22.
 */
public class Main {
    public static void main(String[] args) {
        final int READERS = 10;
        final int WRITERS = 5;
		if(args.length < 1){
			System.out.println("argument is max number of readers at once");
		}
        Database database = new Database(Integer.parseInt(args[0]));
        for (int i = 0; i < READERS; i++) {
            new Reader(database).start();
        }

        for (int i = 0; i < WRITERS; i++) {
            new Writer(database).start();
        }
    }
}
