package org.hbrs.se1.ws23.uebung2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    Container c;
    Member mem1,mem2,mem3,mem4,mem5;

    @BeforeEach
    void setUp() {
        c = new Container(); // Initialize the class-level field
        mem1 = new ConcreteMember(1); // Initialize the class-level field
        mem2 = new ConcreteMember(2); // Initialize the class-level field
        mem3 = new ConcreteMember(3); // Initialize the class-level field
        mem4 = new ConcreteMember(4); // Initialize the class-level field
        mem5 = new ConcreteMember(4); // same ID as mem4
    }

    @Test
    void addMember() throws ContainerException {
        c.addMember(mem1);
        c.addMember(mem2);
        c.addMember(mem3);
        c.addMember(mem4);
        assertThrows(ContainerException.class, () -> c.addMember(mem5));
    }

    @Test
    void deleteMember() throws ContainerException{
        System.out.println("Deletion:");
        c.addMember(mem1);
        c.addMember(mem2);
        c.addMember(mem3);
        c.addMember(mem4);
        assertEquals(c.size(),4);
        c.deleteMember(mem1.getID());
        assertEquals(c.size(),3);
        c.dump();
        c.deleteMember(mem3.getID());
        assertEquals(c.size(),2);
        c.dump();
        System.out.println();
    }

    @Test
    void dump() throws ContainerException{
        System.out.println("Dump: ");
        c.addMember(mem1);
        c.addMember(mem2);
        c.addMember(mem3);
        c.addMember(mem4);
        c.dump();
        System.out.println();
    }

    @Test
    void size() throws ContainerException{
        c.addMember(mem1);
        c.addMember(mem2);
        c.addMember(mem3);
        c.addMember(mem4);
        assertEquals(c.size(),4);
    }
}