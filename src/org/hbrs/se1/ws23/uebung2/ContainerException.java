package org.hbrs.se1.ws23.uebung2;

public class ContainerException extends Exception {

    // ungeprüften Exception kommt vom Entwickler und
    // geprüften Exception kommt von Anwender und wie sollen diese behandeln wie hier.
    public ContainerException(String message) {
        super(message);
    }
}
