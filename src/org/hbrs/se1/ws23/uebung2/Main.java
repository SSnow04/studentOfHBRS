package org.hbrs.se1.ws23.uebung2;
import org.hbrs.se1.ws23.uebung3.persistence.*;

public class Main {
    public static void main(String[] args) {
        Container container = Container.getInstance();
        PersistenceStrategy pSStream = new PersistenceStrategyStream();
        container.setPersistenceStrategy(pSStream);

    }
}
