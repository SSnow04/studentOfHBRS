package org.hbrs.se1.ws23.uebung2;
import java.util.*;

public class MemberView {
    Client c = new Client();
    public void dump(){
        List<Member> List = c.getListe();
        for (Member mem: List) {
                System.out.println(mem);
        }
    }
}
