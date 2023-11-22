package org.hbrs.se1.ws23.uebung4.prototype.Model;

import org.hbrs.se1.ws23.uebung4.prototype.Controller.InputDialog;
import org.hbrs.se1.ws23.uebung4.prototype.Model.Container;

import java.util.List;

public class Main {
    /**
     * Start-Methoden zum Starten des Programms
     * (hier koennen ggf. weitere Initialisierungsarbeiten gemacht werden spaeter)
     */
    public static void main (String[] args) throws Exception {
        Container con = Container.getInstance();
        InputDialog input = new InputDialog();
        input.startEingabe();

    }

}
