package com.example.mas;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import static org.junit.Assert.*;

public class MedRecordTest {
    @Test
    public void gettersTest(){
        MedRecord medR1 = new MedRecord("user1","med1", LocalDate.now());

        assertEquals("user1",medR1.getUsername());
        assertEquals("med1", medR1.getMed_name());
        assertEquals(LocalDate.now(),medR1.getDate());
    }

    @Test
    public void settersTest(){
        MedRecord medR1 = new MedRecord("user1","med1", LocalDate.now());
        medR1.setUsername("usertest");
        medR1.setMed_name("medtest");
        medR1.setDate(LocalDate.now().minusDays(1));

        assertEquals("usertest",medR1.getUsername());
        assertEquals("medtest", medR1.getMed_name());
        assertEquals(LocalDate.now().minusDays(1),medR1.getDate());
    }
}