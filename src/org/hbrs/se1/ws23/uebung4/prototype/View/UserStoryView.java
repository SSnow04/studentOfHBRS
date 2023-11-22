package org.hbrs.se1.ws23.uebung4.prototype.View;

import org.hbrs.se1.ws23.uebung4.prototype.Model.Container;
import org.hbrs.se1.ws23.uebung4.prototype.Model.UserStory;

import java.util.List;

public class UserStoryView {
    /**
     * Diese Methode realisiert die Ausgabe.
     */
    Container container = Container.getInstance();
    public void dump(List<UserStory> list) {

        // Hier möchte Herr P. die Liste mit einem eigenen Sortieralgorithmus sortieren und dann
        // ausgeben. Allerdings weiss der Student hier nicht weiter

        // [Sortierung ausgelassen]
        // Todo: Implementierung Sortierung (F4)

        System.out.println(
                "-----------------------------------------------------------------------------");
        System.out.printf("%5s %20s %20s %5s", "ID", "Titel", "Projekt", "Prio");
        System.out.println();
        System.out.println(
                "-----------------------------------------------------------------------------");
        // Klassische Ausgabe ueber eine For-Each-Schleife
        for (UserStory story : list) {

            System.out.format("%5s %20s %20s %5s", story.getId(), story.getTitel(), story.getProject(), story.getPrio());
            System.out.println();
        }
        System.out.println(
                "-----------------------------------------------------------------------------");
        // (Filterung Projekt = "ein Wert (z.B. Coll@HBRS)" und Risiko >=5
        // Todo: Implementierung Filterung mit Lambda (F5)

    }

}
