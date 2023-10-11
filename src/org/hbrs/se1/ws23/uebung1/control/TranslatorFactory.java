package org.hbrs.se1.ws23.uebung1.control;

/**
 * Anwendung des Factory method Pattern (Kapital 6; (GoF))
 * Problem: Inkonsistente Objekt-Erzeugung und -Parametrisierung
 * Lösung: Service-Klasse für die zentrale und konsistente
 */
public class TranslatorFactory {

    public static Translator createGermanTranslator(){
        return new GermanTranslator();
    }
}
