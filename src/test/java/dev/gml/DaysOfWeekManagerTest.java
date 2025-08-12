/**
 * @file This is the 'test class' where I will verify my logic.
 * @author gml <kickAssDeveloper@hugsForMyBugs.mock>
 */

package dev.gml;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    @DisplayName("2️⃣ It should check the correct length of the list.")
    void getListLengthShouldReturnCorrectSize() {
        // --- Given ---
        // The DaysOfWeekManager that is initialized before each test,

        // --- When ---
        // I call the 'createDaysOfWeekList' method,
        daysOfWeekManager.createDaysOfWeekList();

        // --- Then ---
        // I assert that the length of the list of days of the week is correct, it
        // should be 7.
        assertEquals(7, daysOfWeekManager.getListLength());
    }

    @Test
    @DisplayName("3️⃣ It should confirm that 'a specific day' can be deleted from the list.")
    void deleteDayShouldRemoveTheDayFromTheList() {
        // --- Given ---
        // The DaysOfWeekManager that is initialized before each test,

        // --- When ---
        // I call the 'createDaysOfWeekList' method & delete a day by name with 'deleteDay()' method.
        daysOfWeekManager.createDaysOfWeekList(); // TODO: Once all test are created, this line must be refactored (@BeforeEach)
        daysOfWeekManager.deleteDay("Monday");

        // --- Then ---
        // I assert that the length of the list of days of the week has decreased by one day.
        assertEquals(6, daysOfWeekManager.getListLength());

        // And I also assert that the list of days of the week doesn't contain the deleted day.
        assertThat(daysOfWeekManager.getDaysOfWeek(), not(hasItem("Monday")));
    }

    @Test
    @DisplayName("4️⃣ It should return the correct day based on its index in the list.")
    void getDayShouldReturnCorrectDayForGivenIndex(){
        // --- Given ---
        // The instance of DaysOfWeekManager that is initialized before each test,
        // The index of the day I want to retrieve.
        // The String name that corresponds to that day's index in the list.
        int indexOfTheDay = 0;
        String expectedDay = "Monday";

        // --- When ---
        // I create the list of days of the week.
        // I retrieve a specific day.
        daysOfWeekManager.createDaysOfWeekList();
        String actualDay = daysOfWeekManager.getDay(indexOfTheDay);

        // --- Then ---
        // I can compare both names of the day of the week and say that they match.
        assertThat(actualDay, is(equalTo(expectedDay)));
    }
}
