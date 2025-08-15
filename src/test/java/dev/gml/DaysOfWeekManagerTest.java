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
        daysOfWeekManager.createDaysOfWeekList();
    }

    @Test
    @DisplayName("1️⃣ It should check if the 'createDaysOfWeekList' method correctly initializes the list!")
    void createDaysOfWeekListShouldInitializeList() {
        assertNotNull(daysOfWeekManager.getDaysOfWeek());
    }

    @Test
    @DisplayName("2️⃣ It should check the correct length of the list.")
    void getListLengthShouldReturnCorrectSize() {
        assertEquals(7, daysOfWeekManager.getListLength());
    }

    @Test
    @DisplayName("3️⃣ It should confirm that 'a specific day' can be deleted from the list.")
    void deleteDayShouldRemoveTheDayFromTheList() {
        daysOfWeekManager.deleteDay("Monday");

        assertEquals(6, daysOfWeekManager.getListLength());

        assertThat(daysOfWeekManager.getDaysOfWeek(), not(hasItem("Monday")));
    }

    @Test
    @DisplayName("4️⃣ It should return the correct day based on its index in the list.")
    void getDayShouldReturnCorrectDayForGivenIndex() {
        int indexOfTheDay = 0;
        String expectedDay = "Monday";

        String actualDay = daysOfWeekManager.getDay(indexOfTheDay);

        assertThat(actualDay, is(equalTo(expectedDay)));
    }

    @Test
    @DisplayName("5️⃣🅰️ It should return 'True' if day exists in the list.")
    void dayExistsShouldReturnTrueForExistingDay() {
        String existingDay = "Wednesday";

        boolean dayExists = daysOfWeekManager.dayExists(existingDay);

        assertThat(dayExists, is(true));
    }

    @Test
    @DisplayName("5️⃣🅱️ It should return 'False' if day doesn't exists in the list.")
    void dayExistsShouldReturnFalseForNonExistingDay() {
        String nonExistingDay = "FUNday";

        boolean dayExists = daysOfWeekManager.dayExists(nonExistingDay);

        assertThat(dayExists, is(false));
    }

    @Test
    @DisplayName("6️⃣ It should sort the days of the list alphabetically.")
    void sortDaysAlphabeticallyShouldSortTheListInAscendingOrder() {
        List<String> expectedAlphabeticallySortedList = Arrays.asList(
                "Friday", "Monday", "Saturday", "Sunday", "Thursday", "Tuesday", "Wednesday");

        daysOfWeekManager.sortDaysAlphabetically();

        assertThat(daysOfWeekManager.getDaysOfWeek(), is(equalTo(expectedAlphabeticallySortedList)));
    }

    @Test
    @DisplayName("7️⃣ It should successfully clears the list of days.")
    void emptyListShouldClearTheListOfDays() {
        assertThat(daysOfWeekManager.getDaysOfWeek(), is(not(empty())));

        daysOfWeekManager.emptyList();

        assertThat(daysOfWeekManager.getDaysOfWeek(), is(empty()));
    }

}
