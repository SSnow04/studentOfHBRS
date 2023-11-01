package org.hbrs.se1.ws23.uebung2;

import java.util.List;

public class Client {
    Container container = Container.getInstance();

    public void addMember(Member m) throws ContainerException {
        container.addMember(m);
    }
    public String removeMember(Member m) {
        return container.deleteMember(m.getID());
    }

    public List<Member> getListe() {
        return container.getCurrentList();
    }

}
