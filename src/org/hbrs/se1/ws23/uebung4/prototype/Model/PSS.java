package org.hbrs.se1.ws23.uebung4.prototype.Model;

import org.hbrs.se1.ws23.solutions.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.solutions.uebung3.persistence.PersistenceStrategyStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class PSS {
    private PersistenceStrategyStream<UserStory> pss = new PersistenceStrategyStream<>();
    public void save(List<UserStory> list) throws PersistenceException {
        pss.setLOCATION("Users.ser");
        pss.openConnection();
        pss.save(list);
        pss.closeConnection();
    }

    public List<UserStory> load() throws PersistenceException, IOException {
        // Load the objects from stream
        List <UserStory> lesen = null;
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("Users.ser"));
            // Create Streams here instead using "this.openConnection();"
            // Workaround!
            // fis = new FileInputStream( LOCATION );
            // ois = new ObjectInputStream( fis );

            // Auslesen der Liste
            Object obj = os.readObject();
            if (obj instanceof List<?>) {
                lesen = (List) obj;
            }

            System.out.println("LOG: Es wurden " + lesen.size() + " User Stories erfolgreich reingeladen!");
            return lesen;
        }
        catch (IOException e) {
            // Sup-Optimal, da Exeception in Form eines unlesbaren Stake-Traces ausgegeben wird
            e.printStackTrace();
            System.out.println(e.getMessage());

            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Laden der Datei!");
        }
        catch (ClassNotFoundException e) {
            // Chain of Responsbility erfuellt, durch Throw der Exceotion kann UI
            // benachrichtigt werden!
            System.out.println(e.getMessage());
            throw new PersistenceException( PersistenceException.ExceptionType.LoadFailure , "Fehler beim Laden der Datei! Class not found!");
        }
    }

    public void closeConnection() throws PersistenceException {
        pss.closeConnection();
    }
}
