package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

import java.io.IOException;

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
    public void onPrintClicked() throws IOException {
        Printer printer = new Printer();
        if(cbAfrica.isSelected()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeTime(Region.AFRICA);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        if(cbAsia.isSelected()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeTime(Region.ASIA);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        if(cbEurope.isSelected()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeTime(Region.EUROPE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        if(cbNorthAmerica.isSelected()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeTime(Region.NORTH_AMERICA);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        if(cbOceania.isSelected()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeTime(Region.OCEANIA);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        if(cbSouthAmerica.isSelected()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printer.writeTime(Region.SOUTH_AMERICA);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
