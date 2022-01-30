import java.util.List;

public class JobOffer {
    private String city;
    private int offerSalary;
    private double requiredYearsExperience;
    private List<String> requiredSkill;

    public JobOffer(String city, int offerSalary, int requiredYearsExperience, List<String> requiredSkill) {
        this.city = city;
        this.offerSalary = offerSalary;
        this.requiredYearsExperience = (double)requiredYearsExperience;
        this.requiredSkill = requiredSkill;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOfferSalary() {
        return this.offerSalary;
    }

    public void setOfferSalary(int offerSalary) {
        this.offerSalary = offerSalary;
    }

    public double getRequiredYearsExperience() {
        return this.requiredYearsExperience;
    }

    public void setRequiredYearsExperience(double requiredYearsExperience) {
        this.requiredYearsExperience = requiredYearsExperience;
    }

    public List<String> getRequiredSkill() {
        return this.requiredSkill;
    }

    public void setRequiredSkill(List<String> requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public String toString() {
        return "JobOffer{city='" + this.city + "', offerSalary=" + this.offerSalary + ", requiredYearsExperience=" + this.requiredYearsExperience + ", requiredSkill=" + this.requiredSkill + "}";
    }
}
