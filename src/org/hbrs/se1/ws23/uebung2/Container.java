package org.hbrs.se1.ws23.uebung2;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;

import java.util.*;

public class Container {
    private static Container container;
    private ArrayList<Member> memList = new ArrayList<>();

    //private Container wegen Singelton Patten
    private Container(){}

    public static Container getInstance(){
        if(container == null)
            container = new Container();

        return container;
    }

    public void addMember( Member member ) throws ContainerException{
        for (Member mem:memList) {
            if (mem.getID().equals(member.getID())) {
                throw new ContainerException(
                                "Das Member-Objekt mit der ID " + mem.getID() +
                                " ist bereits vorhanden!");
            }
        }
        memList.add(member);
    }

    public String deleteMember( Integer id ) {

        for (Member mem: memList
             ) {
            if (mem.getID().equals(id)){
                memList.remove(mem);
                return "Der Member mit dem ID = " + id + "wurde entfernt.";
            }
        }

        return "Es gibt keinen Member mit diesem ID, ID = " + id;
    }

    public  void dump(){
        for (Member mem: memList) {
            System.out.println(mem);
        }

    }

    public int size(){
        return memList.size();
    }

    public void store() throws PersistenceException {

    }

    public void load() throws PersistenceException {

    }


}
