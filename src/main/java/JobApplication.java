import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JobApplication {
    private String fullName;
    private int wantedSalary;
    private String city;
    private int phoneNo;
    private boolean relocatePositive;
    private String email;
    private int experience;
    private List<String> skills;

    public JobApplication(String fullName, int wantedSalary, String city, int phoneNo, boolean relocatePositive, String email, int experience, List<String> skills) {
        this.fullName = fullName;
        this.wantedSalary = wantedSalary;
        this.city = city;
        this.phoneNo = phoneNo;
        this.relocatePositive = relocatePositive;
        this.email = email;
        this.experience = experience;
        this.skills = skills;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getWantedSalary() {
        return this.wantedSalary;
    }

    public void setWantedSalary(int wantedSalary) {
        this.wantedSalary = wantedSalary;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isRelocatePositive() {
        return this.relocatePositive;
    }

    public void setRelocatePositive(boolean relocatePositive) {
        this.relocatePositive = relocatePositive;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getSkills() {
        return this.skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public int compareOffers(JobApplication other, List<String> requiredSkills) {
        Stream var10000 = requiredSkills.stream();
        List var10001 = this.skills;
        Objects.requireNonNull(var10001);
        long sameSkillsOur = var10000.filter(var10001::contains).count();
        long sameSkillsTheir = requiredSkills.stream().filter((s) -> {
            return other.getSkills().contains(s);
        }).count();
        if (sameSkillsTheir == sameSkillsOur) {
            if (this.wantedSalary == other.getWantedSalary()) {
                if (this.experience == other.getExperience()) {
                    return Math.random() < 0.5D ? 1 : -1;
                } else {
                    return this.experience - other.getExperience();
                }
            } else {
                return other.getWantedSalary() - this.wantedSalary;
            }
        } else {
            return Long.compare(sameSkillsOur, sameSkillsTheir);
        }
    }

    public String toString() {
        return "JobApplication{fullName='" + this.fullName + "', wantedSalary=" + this.wantedSalary + ", city='" + this.city + "', phoneNo=" + this.phoneNo + ", relocatePositive=" + this.relocatePositive + ", email='" + this.email + "', experience=" + this.experience + ", skills=" + this.skills + "}";
    }
}
