/**
 * @file This is the 'test class' where I will verify my logic.
 * @author gml <kickAssDeveloper@hugsForMyBugs.mock>
 */

package dev.gml;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DaysOfWeekManagerTest {
    // Attributes (aka fields)
    private DaysOfWeekManager daysOfWeekManager;

    // Methods
    @BeforeEach
    void setUp() {
        daysOfWeekManager = new DaysOfWeekManager();
    }

    @Test
    @DisplayName("1️⃣ It should check if the 'createDaysOfWeekList' method correctly initializes the list!")
    void createDaysOfWeekListShouldInitializeList() {
        // --- Given ---
        // The DaysOfWeekManager class

        // --- When ---
        // I call the 'createDaysOfWeekList' method
        daysOfWeekManager.createDaysOfWeekList();

        // --- Then ---
        // I assert that the list of days of the week is not 'null'
        assertNotNull(daysOfWeekManager.getDaysOfWeek());
    }

}
