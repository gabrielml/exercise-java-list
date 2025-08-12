/**
 * @file This is the main class for the 'DaysOfWeekManager' app.
 * 
 * This class servers as 'the entry point' to observe the 
 * functionality of the 'DaysOfWeekManager'.
 * 
 * @author gml <kickAssDeveloper@hugsForMyBugs.mock>
 */
package dev.gml;

/**
 * 'Entry point' for the 'DaysOfWeekManager' application.
 */
public final class App {
    private App() {
    }

    /**
     * 'Main method' to demostrate the 'DaysOfWeekManager' functionality.
     * 
     * @param args The comand-lines arguments of the program (if necessary).
     */
    public static void main(String[] args) {

        DaysOfWeekManager daysOfWeekManager = new DaysOfWeekManager();

        daysOfWeekManager.createDaysOfWeekList();

        System.out.println(daysOfWeekManager.getDaysOfWeek());
    }
}
