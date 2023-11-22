package org.hbrs.se1.ws23.uebung4.prototype.Controller;
import org.hbrs.se1.ws23.solutions.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.prototype.Model.Container;
import org.hbrs.se1.ws23.uebung4.prototype.Model.ContainerException;
import org.hbrs.se1.ws23.uebung4.prototype.Model.PSS;
import org.hbrs.se1.ws23.uebung4.prototype.Model.UserStory;
import org.hbrs.se1.ws23.uebung4.prototype.Util.Util;
import org.hbrs.se1.ws23.uebung4.prototype.View.UserStoryView;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputDialog {
    Container container = Container.getInstance();
    PSS PSS = new PSS();
    UserStoryView storyView = new UserStoryView();

    /*
     * Diese Methode realisiert eine Eingabe ueber einen Scanner
     * Alle Exceptions werden an den aufrufenden Context (hier: main) weitergegeben (throws)
     * Das entlastet den Entwickler zur Entwicklungszeit und den Endanwender zur Laufzeit
	*/

    public void startEingabe() throws ContainerException, Exception {
        String strInput = null;

        // Ausgabe eines Texts zur Begruessung
        System.out.println("UserStory-Tool V1.0 by Julius P. (dedicated to all my friends)");

        while ( true ) {
            // Initialisierung des Eingabe-View
            Scanner scanner = new Scanner( System.in );
            System.out.print( "> "  );
            strInput = scanner.nextLine();
            // Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");
            scanLine(strings,scanner);

        } // Ende der Schleife
    }

    private void scanLine(String[] text, Scanner scanner) throws PersistenceException, IOException {

        // 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
        if ( text[0].equals("help") ) {
            System.out.println("Folgende Befehle stehen zur Verfuegung: help, load, store, search, exit, enter");
        }

        if ( text[0].equals("load") ) {

            List<UserStory> list = PSS.load();
            container.setListe(list);
            PSS.closeConnection();
            storyView.dump(list);
        }

        if (text[0].equals("dump") && text[1].equals("Projekt")) {
            Util.getProjekt(container,text,storyView);
        }

        if ( text[0].equals("search") ) {
            System.out.println("Füge eine Projekt zu suchen");
            String gesucht = scanner.next();
            storyView.dump(Util.search(container.getCurrentList(), gesucht));
        }

        // Auswahl der bisher implementierten Befehle:
        if ( text[0].equals("enter") ) {
            System.out.println("Füge eine ID ein");
            int mehrwert = 0, strafe = 0, risk = 0;
            int id = scanner.nextInt();

            System.out.println("Füge eine Titel ein");
            String titel = scanner.next();

            System.out.println("Füge eine Akzeptanzkriterium ein");
            String akzeptanzkriterium = scanner.next();

            System.out.println("Füge ein Projekt ein");
            String projekt = scanner.next();

            System.out.println("Füge eine Mehrwert ein");
            mehrwert = scanner.nextInt();
            while (mehrwert > 5 || mehrwert < 1 ){
                System.out.println("Falsche Eingabe");
                mehrwert = scanner.nextInt();
            }

            System.out.println("Füge eine Strafe ein");
            strafe = scanner.nextInt();
            while (strafe > 5 || strafe < 1 ) {
                System.out.println("Falsche Eingabe");
                strafe = scanner.nextInt();
            }

            System.out.println("Füge eine Risk ein");
            risk = scanner.nextInt();
            while (risk > 5 || risk < 1 ){
                System.out.println("Falsche Eingabe");
                risk = scanner.nextInt();
            }

            System.out.println("Füge eine Aufwand ein");
            int aufwand = scanner.nextInt();
            while (aufwand > 13 || aufwand < 1 ) {
                System.out.println("Falsche Eingabe");
                aufwand = scanner.nextInt();
            }

            try {
                container.addUserStory(new UserStory(id, titel, akzeptanzkriterium,projekt, mehrwert, strafe, aufwand, risk)); //um das Objekt in die Liste einzufügen.
            } catch (ContainerException exception) {
                System.out.println("ID bereits vorhanden!");
            }
        }

        if (text[0].equals("store")  ) {
            PSS.save(Util.sort(container.getCurrentList()));
        }

        if (text[0].equals("exit")  ) {
            System.out.println("Tschooooo");
            System.exit(0);
        }
    }

}
