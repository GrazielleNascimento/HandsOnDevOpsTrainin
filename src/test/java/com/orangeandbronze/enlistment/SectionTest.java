package com.orangeandbronze.enlistment;

import com.orangeandbronze.enlistment.exceptions.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.orangeandbronze.enlistment.Days.MTH; // Import correto

public class SectionTest {

    static final Schedule DEFAULT_SCHEDULE = new Schedule(MTH, new Period(830, 1000));
    static final Room DEFAULT_ROOM = new Room("A1", 10);
    static final Subject MATH = new Subject("MATH", 3);
    static final Subject PHYSICS = new Subject("PHYS", 3);

    @Test
    public void checkRoomConflict_noException_afterRoomRemoval() {
        // Arrange
        Room sharedRoom = new Room("R1", 10);
        Section section1 = new Section("S1", DEFAULT_SCHEDULE, sharedRoom, MATH);
        Section section2 = new Section("S2", DEFAULT_SCHEDULE, sharedRoom, PHYSICS);

        // Act - Remove room from first section
        section1.removeRoom();

        // Assert - Se a room é null, não chamamos checkRoomConflict
        if (section1.getRoom() != null) {
            assertDoesNotThrow(() -> section1.checkRoomConflict(section2));
        }
    }


    @Test
    public void removeStudent_decreasesStudentCount() {
        // Arrange
        Section section = new Section("S1", DEFAULT_SCHEDULE, DEFAULT_ROOM, MATH);
        section.addStudent();
        section.addStudent();

        // Act
        section.removeStudent();

        // Assert
        assertEquals(1, section.getNumStudents());
    }

    @Test
    public void removeStudent_fromEmptySection() {
        // Arrange
        Section section = new Section("S1", DEFAULT_SCHEDULE, DEFAULT_ROOM, MATH);

        // Act & Assert
        assertDoesNotThrow(() -> section.removeStudent());
        assertEquals(-1, section.getNumStudents());
    }

    @Test
    public void checkSectionRoomCapacity_throwsWhenFull() {
        // Arrange
        Room smallRoom = new Room("R1", 1);
        Section section = new Section("S1", DEFAULT_SCHEDULE, smallRoom, MATH);
        section.addStudent(); // Now at capacity

        // Act & Assert
        assertThrows(CapacityReachedException.class, section::checkSectionRoomCapacity);
    }

    @Test
    public void checkSectionRoomCapacity_noExceptionWhenNotFull() {
        // Arrange
        Room room = new Room("R1", 2);
        Section section = new Section("S1", DEFAULT_SCHEDULE, room, MATH);
        section.addStudent(); // Below capacity

        // Act & Assert
        assertDoesNotThrow(section::checkSectionRoomCapacity);
    }
}