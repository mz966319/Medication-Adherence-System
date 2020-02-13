package com.example.mas;

import org.junit.Test;
import static org.junit.Assert.*;

public class Med_InfoTest {
    @Test
    public void gettesTest() {
        Med_Info medinfo1 = new Med_Info("medicineA","Test Medicine Info1");

        assertEquals("medicineA",medinfo1.getMedName());
        assertEquals("Test Medicine Info1", medinfo1.getMedInfo());
    }

    @Test
    public void settesTest() {
        Med_Info medinfo1 = new Med_Info("medicineA","Test Medicine Info1");
        medinfo1.setMedName("medicineB");
        medinfo1.setMedInfo("FooBar");
        assertEquals("medicineB",medinfo1.getMedName());
        assertEquals("FooBar", medinfo1.getMedInfo());
    }
}