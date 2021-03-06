package com.example.mas;

import org.junit.Test;
import static org.junit.Assert.*;


public class MedValidatorTest {

    @Test
    public void validDrugName() {
        DrugNameValidator v1 = new DrugNameValidator("");
        DrugNameValidator v2 = new DrugNameValidator(" ");
        DrugNameValidator v3 = new DrugNameValidator("1234@");
        DrugNameValidator v4 = new DrugNameValidator("Erythromycin");

        assertFalse(v1.valideDrug());
        assertFalse(v2.valideDrug());
        assertFalse(v3.valideDrug());
        assertTrue(v4.valideDrug());
    }

    @Test
    public void validDosage() {
        DrugNameValidator v1 = new DrugNameValidator("");
        DrugNameValidator v2 = new DrugNameValidator(" ");
        DrugNameValidator v3 = new DrugNameValidator("Erythromycin");

        assertFalse(v1.valideDrug());
        assertFalse(v2.valideDrug());
        assertTrue(v3.valideDrug());
        //assertTrue(v4.valideDrug());
    }

    @Test
    public void validDoctorName() {
        DoctorNameValidator v1 = new DoctorNameValidator("");
        DoctorNameValidator v2 = new DoctorNameValidator(" ");
        DoctorNameValidator v3 = new DoctorNameValidator("123");
        DoctorNameValidator v4 = new DoctorNameValidator("David");
        assertFalse(v1.valideDoctor());
        assertFalse(v2.valideDoctor());
        assertFalse(v3.valideDoctor());
        assertTrue(v4.valideDoctor());
    }


}
