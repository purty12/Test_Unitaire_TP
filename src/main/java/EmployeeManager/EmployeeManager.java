package EmployeeManager;

public class EmployeeManager {
    /**
     * Calcul le salaire d'un employee en fonction de son level
     * @param employee
     * @return BaseSalary
     */
    public double calculateSalary(Employee employee) {
        double baseSalary;
        switch (employee.getLevel()) {
            case JUNIOR:
                baseSalary = 20000;
                break;
            case INTERMEDIAIRE:
                baseSalary = 40000;
                break;
            case SENIOR:
                baseSalary = 60000;
                break;
            default:
                throw new IllegalArgumentException("Niveau d'expérience invalide : " + employee.getLevel());
        }
        return baseSalary;
    }

    /**
     * Permet de calculer le coefficent pour calculer le salaire en focntion de l'ancienneté d'un employee
     * @param anneesExperience
     * @return experienceMultiplier
     */
    public double calculateExperienceMultiplier(int anneesExperience) {
        double experienceMultiplier = 1.0;
        for (int i = 0; i < anneesExperience; i++) {
            experienceMultiplier += 0.05;
        }
        return experienceMultiplier;
    }
}
