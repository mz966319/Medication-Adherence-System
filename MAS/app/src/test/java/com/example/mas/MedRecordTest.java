package com.example.mas;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import static org.junit.Assert.*;

public class MedRecordTest {
    @Test
    public void gettersTest(){
        MedRecord medR1 = new MedRecord("user1","med1");
        medR1.setDate(LocalDate.now().minusDays(1).toString());
        medR1.setQuantity("50.0");
        medR1.setTakenStatus(true);
        assertEquals("user1",medR1.getUsername());
        assertEquals("med1", medR1.getMed_name());
        assertTrue(medR1.getQuantity().equals("50.0"));
        assertTrue(medR1.getTakenStatus());
    }

    @Test
    public void settersTest(){
        MedRecord medR1 = new MedRecord("user1","med1");
        medR1.setUsername("usertest");
        medR1.setMed_name("medtest");
        medR1.setQuantity("40.26");
        medR1.setTakenStatus(false);
        medR1.setDate(LocalDate.now().minusDays(1).toString());

        assertEquals("usertest",medR1.getUsername());
        assertEquals("medtest", medR1.getMed_name());
        assertEquals(LocalDate.now().minusDays(1).toString(),medR1.getDate());
        assertTrue(medR1.getQuantity().equals("40.26"));
        assertFalse(medR1.getTakenStatus());
    }
}
