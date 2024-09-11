import java.util.Scanner;

public class FitnessProgramExecution {
    public void manageFitnessPrograms() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of Applications: ");
        int numberOfApplications = scanner.nextInt();
        scanner.nextLine(); 

        FitnessProgram[] programs = new FitnessProgram[numberOfApplications];
        double totalEligible = 0.0;
        double totalNotEligible = 0.0;

        for (int i = 0; i < numberOfApplications; i++) {
            System.out.println("Enter details of application " + (i + 1) + ":");
            
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("BMI: ");
            double bmi = scanner.nextDouble();
            scanner.nextLine(); 

            System.out.print("Fitness Goals: ");
            String fitnessGoals = scanner.nextLine();

            FitnessProgram program = new FitnessProgram(id, name, age, bmi, fitnessGoals);
            programs[i] = program;

            String eligibility = program.checkEligibility();
            if (eligibility.equals("Eligible")) {
                totalEligible++;
            } else {
                totalNotEligible++;
            }
        }

        displayProgramDetails(programs, totalEligible, totalNotEligible);
    }

    private void displayProgramDetails(FitnessProgram[] programs, double totalEligible, double totalNotEligible) {
        System.out.printf("\n%-10s %-10s %-10s %-10s %-20s %-20s\n",
                "ID", "Name", "Age", "BMI", "Fitness Goals", "Eligibility Status");

        for (FitnessProgram p : programs) {
            System.out.printf("%-10d %-10s %-10d %-10.1f %-20s %-20s\n",
                    p.id, p.name, p.age, p.bmi, p.fitnessGoals, p.checkEligibility());
        }

        System.out.printf("\n%-10s %-10s %-10s %-10s %-20s %-20.0f\n",
                " ", "Total Eligible:", "", "", "", totalEligible);

        System.out.printf("\n%-10s %-10s %-10s %-10s %-20s %-20.0f\n",
                " ", "Total Not Eligible:", "", "", "", totalNotEligible);
    }
}