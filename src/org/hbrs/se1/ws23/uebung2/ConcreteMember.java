package org.hbrs.se1.ws23.uebung2;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {

    private Integer ID;
    public ConcreteMember(Integer id){
        this.ID = id;
    }

    public String toString() {
        return "Member (ID [" + getID() +"])";
    }
    @Override
    public Integer getID() {
        return ID;
    }
}
