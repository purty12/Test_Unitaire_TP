package EmployeeManagerTest;

import EmployeeManager.Employee;
import EmployeeManager.EmployeeManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testCalculateSalaryForJuniorEmployeeWithOneYearExperience() {
        Employee employee = new Employee("John", "test", 1, Employee.Level.JUNIOR);

        double Salary = employee.calculateSalary(employee) * employee.calculateExperienceMultiplier(employee.getExperienceYears());
        double ExpectedResult = 21000;

        Assertions.assertEquals(Salary, ExpectedResult);
    }

    @Test
    public void testCalculateSalaryForIntermediaireEmployeeWithFiveYearExperience() {
        Employee employee = new Employee("John2", "test2", 5, Employee.Level.INTERMEDIAIRE);

        double Salary = Math.round(employee.calculateSalary(employee) * employee.calculateExperienceMultiplier(employee.getExperienceYears()));
        double ExpectedResult = 50000;

        Assertions.assertEquals(Salary, ExpectedResult);
    }

    @Test
    public void testCalculateSalaryForSeniorEmployeeWithTenYearExperience() {
        Employee employee = new Employee("John3", "test3", 10, Employee.Level.SENIOR);

        double Salary = Math.round(employee.calculateSalary(employee) * employee.calculateExperienceMultiplier(employee.getExperienceYears()));
        double ExpectedResult = 90000;

        Assertions.assertEquals(Salary, ExpectedResult);
    }

    @Test
    public void testCalculateSalaryForSeniorEmployeeWithTwentyYearExperience() {
        Employee employee = new Employee("John4", "test4", 20, Employee.Level.SENIOR);

        double Salary = Math.round(employee.calculateSalary(employee) * employee.calculateExperienceMultiplier(employee.getExperienceYears()));
        double ExpectedResult = 120000;

        Assertions.assertEquals(Salary, ExpectedResult);
    }

    @Test
    public void testCalculateSalaryForJuniorEmployeeWithTwentyYearExperience() {
        Employee employee = new Employee("John4", "test4", 20, Employee.Level.JUNIOR);

        double Salary = Math.round(employee.calculateSalary(employee) * employee.calculateExperienceMultiplier(employee.getExperienceYears()));
        double ExpectedResult = 40000;

        Assertions.assertEquals(Salary, ExpectedResult);
    }
}
