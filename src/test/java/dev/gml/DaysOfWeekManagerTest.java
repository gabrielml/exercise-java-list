/**
 * @file This is the 'test class' where I will verify my logic.
 * @author gml <kickAssDeveloper@hugsForMyBugs.mock>
 */

package dev.gml;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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
        // I call the 'createDaysOfWeekList' method & delete a day by name with
        // 'deleteDay()' method.
        daysOfWeekManager.createDaysOfWeekList(); // TODO: Once all test are created, this line must be refactored
                                                  // (@BeforeEach)
        daysOfWeekManager.deleteDay("Monday");

        // --- Then ---
        // I assert that the length of the list of days of the week has decreased by one
        // day.
        assertEquals(6, daysOfWeekManager.getListLength());

        // And I also assert that the list of days of the week doesn't contain the
        // deleted day.
        assertThat(daysOfWeekManager.getDaysOfWeek(), not(hasItem("Monday")));
    }

    @Test
    @DisplayName("4️⃣ It should return the correct day based on its index in the list.")
    void getDayShouldReturnCorrectDayForGivenIndex() {
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

    @Test
    @DisplayName("5️⃣🅰️ It should return 'True' if day exists in the list.")
    void dayExistsShouldReturnTrueForExistingDay() {
        // --- Given ---
        // The instance of DaysOfWeekManager that is initialized before each test,
        // The list of days of the week,
        // A existing day.
        daysOfWeekManager.createDaysOfWeekList();
        String existingDay = "Wednesday";

        // --- When ---
        // I have verified that the day is on the list.
        boolean dayExists = daysOfWeekManager.dayExists(existingDay);

        // --- Then ---
        // I can confirm that the day does exist on the list.
        assertThat(dayExists, is(true));
    }

    @Test
    @DisplayName("5️⃣🅱️ It should return 'False' if day doesn't exists in the list.")
    void dayExistsShouldReturnFalseForNonExistingDay() {
        // --- Given ---
        // The instance of DayOfWeekManager that is initialized before each test,
        // The list of days of the week,
        // An invented day name.
        daysOfWeekManager.createDaysOfWeekList();
        String nonExistingDay = "FUNday";

        // --- When ---
        // I have verified that the 'funny day' is not on the list :(
        boolean dayExists = daysOfWeekManager.dayExists(nonExistingDay);

        // --- Then ---
        // I can sadly confirm that the day does not exist on this list.
        assertThat(dayExists, is(false));
    }

    @Test
    @DisplayName("6️⃣ It should sort the days of the list alphabetically.")
    void sortDaysAlphabeticallyShouldSortTheListInAscendingOrder() {
        // --- Given ---
        // The instance of DayOfWeekManager that is initialized before each test,
        // The list of days of the week,
        // an alphabetically ordered list of the days of the week.
        daysOfWeekManager.createDaysOfWeekList();
        List<String> expectedAlphabeticallySortedList = Arrays.asList(
                "Friday", "Monday", "Saturday", "Sunday", "Thursday", "Tuesday", "Wednesday");

        // --- When ---
        // I call the corresponding method, it sorts the list of days alphabetically.
        daysOfWeekManager.sortDaysAlphabetically();

        // --- Then ---
        // I confirm that the list is sorted alphabetically.
        assertThat(daysOfWeekManager.getDaysOfWeek(), is(equalTo(expectedAlphabeticallySortedList)));
    }

    @Test
    @DisplayName("7️⃣ It should successfully clears the list of days.")
    void emptyListShouldClearTheListOfDays() {
        // --- Given ---
        // The instance of DayOfWeekManager that is initialized before each test,
        // the list of days of the week,
        // I check that the list has been initialized with the days.
        daysOfWeekManager.createDaysOfWeekList();
        assertThat(daysOfWeekManager.getDaysOfWeek(), is(not(empty())));

        // --- When ----
        // The "emptyList" method is called.
        daysOfWeekManager.emptyList();

        // --- Then ----
        // The list should be empty.
        assertThat(daysOfWeekManager.getDaysOfWeek(), is(empty()));
    }

}
