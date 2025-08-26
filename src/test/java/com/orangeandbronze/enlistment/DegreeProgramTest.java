package com.orangeandbronze.enlistment;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DegreeProgramTest {
    @Test
    public void degreeProgram_containsSubject() {
        // Arrange
        Subject math = new Subject("MATH", 3);
        Subject physics = new Subject("PHYS", 3);
        DegreeProgram program = new DegreeProgram("Engineering", Arrays.asList(math, physics));

        // Act & Assert
        assertTrue(program.containsSubject(math));
        assertTrue(program.containsSubject(physics));
        assertFalse(program.containsSubject(new Subject("CHEM", 3)));
    }

    @Test
    public void degreeProgram_constructorValidatesParameters() {
        // Null program name lança NPE (não IllegalArgumentException)
        assertThrows(NullPointerException.class,
                () -> new DegreeProgram(null, Arrays.asList(new Subject("MATH", 3))));

        // Empty program name lança IllegalArgumentException
        assertThrows(IllegalArgumentException.class,
                () -> new DegreeProgram("", Arrays.asList(new Subject("MATH", 3))));

        // Null subjects lança NPE
        assertThrows(NullPointerException.class,
                () -> new DegreeProgram("Engineering", null));
    }

    @Test
    public void degreeProgram_equalsAndHashCode() {
        Subject math = new Subject("MATH", 3);
        DegreeProgram program1 = new DegreeProgram("Eng", Arrays.asList(math));
        DegreeProgram program2 = new DegreeProgram("Eng", Arrays.asList(math));
        DegreeProgram program3 = new DegreeProgram("CS", Arrays.asList(math));

        assertEquals(program1, program2);
        assertNotEquals(program1, program3);
        assertEquals(program1.hashCode(), program2.hashCode());
    }

    @Test
    public void degreeProgram_toString() {
        DegreeProgram program = new DegreeProgram("Computer Science",
                Arrays.asList(new Subject("MATH", 3)));
        assertEquals("Computer Science", program.toString());
    }
}
