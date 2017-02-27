package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private CheckBox cbAfrica;
    @FXML
    private CheckBox cbAsia;
    @FXML
    private CheckBox cbEurope;
    @FXML
    private CheckBox cbNorthAmerica;
    @FXML
    private CheckBox cbOceania;
    @FXML
    private CheckBox cbSouthAmerica;
    @FXML
    private CheckBox cbSynced;

    public void onPrintClicked() throws IOException {
        Printer printer = new Printer();
        ArrayList<Thread> threads = new ArrayList<Thread>();
        if(cbAfrica.isSelected()) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeCountries(Region.AFRICA, cbSynced.isSelected());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        if(cbAsia.isSelected()) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeCountries(Region.ASIA, cbSynced.isSelected());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        if(cbEurope.isSelected()) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeCountries(Region.EUROPE, cbSynced.isSelected());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        if(cbNorthAmerica.isSelected()) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeCountries(Region.NORTH_AMERICA, cbSynced.isSelected());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        if(cbOceania.isSelected()) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeCountries(Region.OCEANIA, cbSynced.isSelected());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        if(cbSouthAmerica.isSelected()) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeCountries(Region.SOUTH_AMERICA, cbSynced.isSelected());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        for(Thread t : threads){
            t.start();
        }
        for(Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printer.close();
    }
}
