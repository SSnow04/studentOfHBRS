package org.hbrs.se1.ws23.uebung1.test;
import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {
    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(1);
        assertEquals(value, "eins");
        value = translator.translateNumber(10);
        assertEquals(value, "zehn");
    }
    @Test
    void aNegativeTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(-5);
        assertEquals(value, "Übersetzung der Zahl "+ -5 +" nicht " + "möglich " +
                "Translator version: "+ translator.version);
        value = translator.translateNumber(-1);
        assertEquals(value, "Übersetzung der Zahl "+ -1 +" nicht " + "möglich " +
                "Translator version: "+ translator.version);
        value = translator.translateNumber(11);
        assertEquals(value, "Übersetzung der Zahl "+ 11 +" nicht " + "möglich " +
                "Translator version: "+ translator.version);
        value = translator.translateNumber(20);
        assertEquals(value, "Übersetzung der Zahl "+ 20 +" nicht " + "möglich " +
                "Translator version: "+ translator.version);
    }
    @Test
    void grenzwert() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(0);
        assertEquals(value, "Übersetzung der Zahl "+ 0 +" nicht " + "möglich " +
                    "Translator version: "+ translator.version);
    }
}