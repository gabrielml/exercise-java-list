/**
 * @file This is the class I will written my logic in.
 * @author gml <kickAssDeveloper@hugsForMyBugs.mock>
 */
package dev.gml;

import java.util.ArrayList;
import java.util.List;

public class DaysOfWeekManager {
    // Attributes (aka fields)
    private List<String> daysOfWeek;

    // Methods
    public void createDaysOfWeekList() {
        // Initialize list
        daysOfWeek = new ArrayList<>();

        // Add the days of the week;
        this.daysOfWeek.add("Monday");
        this.daysOfWeek.add("Tuesday");
        this.daysOfWeek.add("Wednesday");
        this.daysOfWeek.add("Thursday");
        this.daysOfWeek.add("Friday");
        this.daysOfWeek.add("Saturday");
        this.daysOfWeek.add("Sunday");
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }
}
