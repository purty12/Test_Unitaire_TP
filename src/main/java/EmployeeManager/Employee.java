package EmployeeManager;

/**
 * Class employee
 */
public class Employee extends EmployeeManager{
    /**
     * Prénom, Nom, Année d'expérience, Level
     */
    private String firstName;
    private String lastName;
    private int experienceYears;
    private Level level;

    public Employee(String firstName, String lastName, int experienceYears, Level level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceYears = experienceYears;
        this.level = level;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public Level getLevel() {
        return level;
    }

    public enum Level {
        JUNIOR,
        INTERMEDIAIRE,
        SENIOR
    }

}
