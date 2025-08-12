/**
 * @file This is the class I will written my logic in.
 * @author gml <kickAssDeveloper@hugsForMyBugs.mock>
 */
package dev.gml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Manages a list of the days of the week.
 * It provides methods to 'create', 'retrieve', and 'manipulate' the list.
 */
public class DaysOfWeekManager {
    // --- Attributes --- (aka fields)
    private List<String> daysOfWeek;

    // --- Methods ---
    /**
     * Initializes the list fo days of the week.
     * The list is populated with the names of the seven days.
     */
    public void createDaysOfWeekList() {
        // Create the list with all the days of the week.
        daysOfWeek = new ArrayList<>(
                Arrays.asList(
                        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
    }

    /**
     * Returns the list of days of the week.
     * 
     * <p>
     * This method now returns a '(!) Defensive Copy' of the internal list.
     * The returned list can be modified freely by the caller without affecting
     * the internal list of our object.
     * </p>
     * 
     * @return An unmodifiable {@List List} of Strings containing the days of the
     *         week.
     */
    public List<String> getDaysOfWeek() {
        return new ArrayList<>(daysOfWeek); // Return a copy to prevent external modification.
    }

    /**
     * Return the number of days in the list.
     * 
     * @return the length of the list of days of the week.
     */
    public int getListLength() {
        return daysOfWeek.size();
    }

}
