
package vernyomasgui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Czégel Vanessza
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label cimke;

    @FXML
    private DatePicker datum;

    @FXML
    private TextField szisztole;

    @FXML
    private TextField diasztole;

    /*A Hozzáad gomb megnyomásakor beolvassa a beírt adatokat egy-egy változóba.
    Ha nem sikerült őket számmá alakírtani, akkor kiírja, hogy "Hibás adat!"
    és kilép a hozzáad metódusból.*/
    @FXML
    void hozzaad() {
        //változókba tettem
        LocalDate d = datum.getValue();
        int szi, di;
        //Számmá alakítás, ha nem sikerült hibás adatok üzenet
        try {
            szi = Integer.parseInt(szisztole.getText());
            di = Integer.parseInt(diasztole.getText());
        } catch (NumberFormatException ex) {
            cimke.setText("Hibás adatok!");
            return; //ezzel kép ki
        }
        
        /*Kostruktor készítése a Meres osztályhoz.
        Paraméterként megkapja a három adatot, mjad hozzárendeli az adattagokhoz.*/
        Meres m = new Meres(d.toString(), szi, di);
        meresek.Hozzaad(m);
        try {
            meresek.hozzafuz(m);
            cimke.setText("Mérés hozzáadva.");
        } catch (IOException ex) {
            cimke.setText(ex.getMessage());
        }
    }

    /*Az Új gomb megnyomásakor beírja automatikusan a mai dátumot és
    törli a két szövegmező tartalmát.*/
    @FXML
    void uj() {
        datum.setValue(LocalDate.now()); //mai tárum
        szisztole.clear(); //törlés
        diasztole.clear(); //törlés
        
    }

    private Lista meresek; // Ide tölti be az adatokat.

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*A program indulásakor a vernyomas.txt fájlból belölti az adatokat
        egy listába ez a private Lista meresek;
        Ha sikerült, akkor a "cimke" átváltozik "Mérések betöltve"-re. 
        Ha nem sikerült, akkor hibaüzenetet ír ki.*/
        try {
            meresek = new Lista();
            cimke.setText("Mérések betöltve!");

        } catch (Exception ex) {
            cimke.setText(ex.getMessage());
        }
        uj();
        /*Az Új gomb megnyomásakor beírja autómatikusan a mai dátumot és
        törli a két szövegmező tartalmát.*/
    }

}
