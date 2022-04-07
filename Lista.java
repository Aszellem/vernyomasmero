
package vernyomasgui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Czégel Vanessza
 */
public class Lista {
    //Az osztály egy Meres típusú elemekből álló listát fog kezelni.
    ArrayList <Meres> lista = new ArrayList<>(); 
    
    /**Adattagokat vett fel a "lista".
    Lenullázzuk az adattagokat és az eredményeket itt fogom tárolni.*/
    private int maxSzisztole = 0;
    private int maxDiasztole = 0;
    private int dbMagas = 0;
    
    /**Készítek egy konstruktort a Lista osztályhoz, ami beolvassa a méréseket a vernyomas.txt fájlból.
    és közben hozzá is adom őket a "lista"-hoz a Hozzaad metódussal.*/
    public Lista() throws IOException{
        Scanner sc = new Scanner(new File("src/vernyomasgui/vernyomas.txt"));
        sc.nextLine();
        while(sc.hasNextLine()){
            Hozzaad(new Meres(sc.nextLine()));
        }
        sc.close();
    }
    
    //Lekérdezéshez getter metódusokat készítek.
    public int getMaxSzisztole() {
        return maxSzisztole;
    }

    public int getMaxDiasztole() {
        return maxDiasztole;
    }

    public int getDbMagas() {
        return dbMagas;
    }
    
    //A lista hosszának lekérdezéséhez is készítek egy getter metódust.
    public int getHossz(){
        return lista.size();
    }
    
    /**Ez a metódus egy paraméterként kapott mérést hozzáad a listához,
    majd szükség esetén frissíti a legnagyobb szisztolé és diasztolé értékeket
    valamint a magas eredmények számát!*/
    public void Hozzaad(Meres m){ //itt kapja meg a paramétert.
        lista.add(m); //itt adja hozzá.
        
        //itt pedig frissíti.
        if(m.getSzisztole() > maxSzisztole){
            maxSzisztole = m.getSzisztole();
        }
        if(m.getDiasztole() > maxDiasztole){
            maxDiasztole = m.getDiasztole();
        }
        if (m.Magas()) { //hozzáad 1-et
            dbMagas++;
        }
    }
    
    /**Ez a metódus azt adja vissza, hogy a szöveges paraméterként kapott dátum
    szerepel-e a "lista" valamelyik mérésében!*/
    public boolean volt(String datum) {//itt kapja meg a paramétert.
        for (Meres m : lista) { //végigmegy a listán, hogy szerepel-e valamelyik mérésben
            if (m.getDatum().equals(datum)) { //ha a szerepel a kapott parameter, azaz datum
                return true; // akkor boolean miatt true érték jön vissza
            }
        }
        return false; //amúgy false
    }

    //Kiegészítés 8-as feladat.
    /*A Lista osztályt kiegészítem egy hozzafuz metódussal, amely
        objektumként kapja meg a beírt adatokat és hozzáfűzi a vernyomas.txt-hez.
        Ha nem sikerül, akkor a keletkező kivételt továbbítsa az őt meghívó metódusnak!*/
    public void hozzafuz(Meres m) throws IOException {
        PrintWriter ki = new PrintWriter(new FileWriter("src/vernyomasgui/vernyomas.txt",true));
        ki.println(m);
        ki.close();
    }
}

