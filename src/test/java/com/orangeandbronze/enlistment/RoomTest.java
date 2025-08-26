package com.orangeandbronze.enlistment;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomTest {
    @Test
    public void roomIsFull_whenCapacityReached() {
        // Arrange
        Room room = new Room("R1", 2);

        assertFalse(room.isFull(1)); // Below capacity
        assertTrue(room.isFull(2)); // At capacity
        assertTrue(room.isFull(3)); // Over capacity
    }

    @Test
    public void roomConstructor_validatesParameters() {
        // Invalid room names
        assertThrows(IllegalArgumentException.class, () -> new Room("R1!", 10));
        assertThrows(IllegalArgumentException.class, () -> new Room("", 10));

        // Invalid capacity
        // assertThrows(IllegalArgumentException.class, () -> new Room("R1", -5));
    }

    @Test
    public void testEquals_sameObject() {
        Room r = new Room("R1", 5);
        assertEquals(r, r); // Same instance
    }

    @Test
    public void testEquals_equalObjects() {
        Room r1 = new Room("R1", 5);
        Room r2 = new Room("R1", 5);
        assertEquals(r1, r2); // Different instances, same data
    }

    @Test
    public void testEquals_differentName() {
        Room r1 = new Room("R1", 5);
        Room r2 = new Room("R2", 5);
        assertNotEquals(r1, r2);
    }

    @Test
    public void testEquals_differentCapacity() {
        Room r1 = new Room("R1", 5);
        Room r2 = new Room("R1", 10);
        assertNotEquals(r1, r2);
    }

    @Test
    public void testEquals_differentClass() {
        Room r = new Room("R1", 5);
        assertNotEquals(r, "alguma coisa"); // Compare with different type
    }

    @Test
    public void testHashCode_equalObjects() {
        Room r1 = new Room("R1", 5);
        Room r2 = new Room("R1", 5);
        assertEquals(r1.hashCode(), r2.hashCode());
    }
}
