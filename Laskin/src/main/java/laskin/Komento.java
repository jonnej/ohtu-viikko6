/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author jonnej
 */
public abstract class Komento implements KomentoInterface {
        
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    private int edellinenArvo;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    @Override
    public void suorita() {
        edellinenArvo = sovellus.tulos();
        int tulos = laske();
        tuloskentta.setText("" + tulos);
        disableNollaaButton(tulos);
        undo.disableProperty().set(false);
    }
    
    @Override
    public void peru() {
        tuloskentta.setText("" + edellinenArvo);
        sovellus.setTulos(edellinenArvo);
        disableNollaaButton(edellinenArvo);
    }
    
    private void disableNollaaButton(int tulos) {
        nollaa.disableProperty().set(tulos == 0);
    }
    
    protected abstract int laske();
}
