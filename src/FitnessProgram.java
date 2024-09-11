class FitnessProgram {
    int id;
    String name;
    int age;
    double bmi;
    String fitnessGoals;

    public FitnessProgram(int id, String name, int age, double bmi, String fitnessGoals) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bmi = bmi;
        this.fitnessGoals = fitnessGoals;
    }

    public String checkEligibility() {
        if (age < 18 || age > 65) {
            return "Not Eligible (Age out of range)";
        }
        if (bmi < 18.5 || bmi > 30.0) {
            return "Not Eligible (BMI out of range)";
        }
        if (!fitnessGoals.equalsIgnoreCase("Weight Loss") &&
            !fitnessGoals.equalsIgnoreCase("Muscle Gain") &&
            !fitnessGoals.equalsIgnoreCase("General Fitness")) {
            return "Not Eligible (Invalid Fitness Goal)";
        }
        return "Eligible";
    }
}
