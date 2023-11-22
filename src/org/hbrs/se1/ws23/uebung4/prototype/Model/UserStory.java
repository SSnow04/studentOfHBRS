package org.hbrs.se1.ws23.uebung4.prototype.Model;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class UserStory implements Serializable, Comparable<UserStory> {
        // ToDo: Sind die Attribute der Klasse UserStory vollständig? (F4)

        String titel;
        int aufwand = 0;
        int id = 0;
        int mehrwert = 0;
        int risk = 0;
        int strafe = 0;
        double prio = 0.0;
        String project;

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public UserStory(int id, String titel, String akzeptanzkriterium, String projekt, int mehrwert, int strafe,
                         int aufwand, int risk) {
            if (mehrwert < 1 || strafe < 1 || aufwand < 1 || risk < 1){
                throw new NoSuchElementException("Bitte geben Sie einen gültigen Zahl (also >=1 )");
            }

            this.id = id;
            this.titel = titel;
            this.mehrwert = mehrwert;
            this.strafe = strafe;
            this.aufwand = aufwand;
            this.risk = risk;
            this.project = projekt;

            int zaehler = getMehrwert()+getStrafe();
            int nenner = getAufwand()+getRisk();
            this.prio = (double) zaehler /nenner;

        }

        public UserStory() {
        }

        // Berechnung der Prio. Nach der Formel von Gloger:

        public double getPrio() {
            return prio;
        }
        public void setPrio(double prio) {
            this.prio = prio;
        }
        public String getTitel() {
            return titel;
        }
        public void setTitel(String titel) {
            this.titel = titel;
        }
        public int getAufwand() {
            return aufwand;
        }
        public void setAufwand(int aufwand) {
            this.aufwand = aufwand;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getMehrwert() {
            return mehrwert;
        }
        public void setMehrwert(int mehrwert) {
            this.mehrwert = mehrwert;
        }
        public int getRisk() {
            return risk;
        }
        public void setRisk(int risk) {
            this.risk = risk;
        }
        public int getStrafe() {
            return strafe;
        }
        public void setStrafe(int strafe) {
            this.strafe = strafe;
        }

    @Override
    public int compareTo(UserStory o) {
        return (int) ( 100*o.getPrio() - 100*this.getPrio());
    }

}

