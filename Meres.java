
package vernyomasgui;

import javafx.scene.control.TextField;

/**
 *
 * @author Czégel Vanessza
 */
public class Meres {
    private String datum;
    private int szisztole, diasztole;

    public Meres(String sor) {
        String[] s = sor.split(";");
        datum = s[0];
        szisztole = Integer.parseInt(s[1]);
        diasztole = Integer.parseInt(s[2]);
    }

    public Meres(String datum, int szisztole, int diasztole) {
        this.datum = datum;
        this.szisztole = szisztole;
        this.diasztole = diasztole;
    }

    public String getDatum() {
        return datum;
    }

    public int getSzisztole() {
        return szisztole;
    }

    public int getDiasztole() {
        return diasztole;
    }
    
    public boolean Magas(){
        if(szisztole > 130 || diasztole > 80 ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return datum+";"+szisztole+";"+diasztole+";";
    }
}
