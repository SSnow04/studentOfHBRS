package org.hbrs.se1.ws23.uebung3.persistence;
import java.util.List;
import java.io.*;
public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    private FileInputStream FIS;
    private FileOutputStream FOS;
    private ObjectInputStream OIS;
    private ObjectOutputStream OOS;

    File tempFile;

    {
        try {
            tempFile = File.createTempFile("objects", ".ser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // URL of file, in which the objects are stored
    private String location = tempFile.getPath();

    // Backdoor method used only for testing purposes,
    // if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
    public void openConnection() throws PersistenceException {

        try {
            // Open input stream
            FIS = new FileInputStream(location);
            OIS = new ObjectInputStream(FIS);

            // Open output stream
            FOS = new FileOutputStream(location);
            OOS = new ObjectOutputStream(FOS);

        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Error opening stream");
        }

    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {

        try {
            if (FIS != null) {
                FIS.close();
            }

            if (OIS != null) {
                OIS.close();
            }

            if (FOS != null) {
                FOS.close();
            }

            if (OOS != null) {
                OOS.close();
            }


        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Error closing stream");
        }

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException {
        try {
            openConnection();
            OOS.writeObject(member);
            closeConnection();
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Error saving streams");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException {
        List<E> newListe = null;

        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        openConnection();

        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
        // Reading and extracting the list (try - catch ommitted here)

        Object obj = null;
        try {
            int available = OIS.available();
            if(available > 0) {
                obj = OIS.readObject();
            }
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Object has no Strategy");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class is not found", e);
        }

        if (obj instanceof List<?>)
            newListe = (List) obj;

        // and finally close the streams (guess where this could be...?)
        closeConnection();
        return newListe;

    }
}