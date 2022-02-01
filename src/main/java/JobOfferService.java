import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class JobOfferService {
    public JobOfferService() {
    }

    public JobOffer getBiggestSalary(List<JobOffer> jobOffers) {
        JobOffer maxSalary = null;
        for (JobOffer jobOffer : jobOffers) {
            if(maxSalary == null || maxSalary.getOfferSalary() < jobOffer.getOfferSalary()){
                maxSalary = jobOffer;
            }
        }
        return maxSalary;
    }

    public long countInCity(List<JobOffer> jobOffers, String city) {
        long sumCounter = 0;
        for (JobOffer jobOffer : jobOffers) {
            if (jobOffer.getCity().equals(city)) {
                sumCounter++;
            }
        }
        return sumCounter;
    }

    public Set<String> getCitiesSet(List<JobOffer> jobOffers) {
        Set<String> cities = new HashSet<>();
        for (JobOffer jobOffer : jobOffers) {
            cities.add(jobOffer.getCity());
        }
        return cities;
    }

    public double getAverageMinExp(List<JobOffer> jobOffers) {
        if (jobOffers.isEmpty()) {
            return 0;
        }

        double averageExp = 0;
        for (JobOffer jobOffer : jobOffers) {
            averageExp += jobOffer.getRequiredYearsExperience();
        }
        return averageExp / jobOffers.size();
    }

    public String getMostPopularSkill(List<JobOffer> jobOffers) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Poland", 40);
        map.put("Germany", 80);

        int germanyPopulation = map.get("Germany");

        Map<String, Integer> popularSkills = new HashMap<>();
        for (JobOffer jobOffer : jobOffers) {
            List<String> requiredSkill = jobOffer.getRequiredSkill();
            for (String skill : requiredSkill) {
                if (popularSkills.containsKey(skill)) {
                    popularSkills.put(skill, popularSkills.get(skill) + 1);
                } else {
                    popularSkills.put(skill, 1);
                }
            }
        }

        Set<Map.Entry<String, Integer>> entries = popularSkills.entrySet();
        Map.Entry<String, Integer> maxValueEntry = null;
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry == null || maxValueEntry.getValue() > entry.getValue()) {
                maxValueEntry = entry;
            }
        }
        return maxValueEntry.getKey();

    }

    public JobApplication getBestApplication(JobOffer jobOffer, List<JobApplication> jobApplications) {
        List<JobApplication> bestApplications = new ArrayList<>();
        JobApplication bestJobApplication = null;

        for (JobApplication jobApplication : jobApplications) {
            if (jobApplication.getCity().equalsIgnoreCase(jobOffer.getCity()) || jobApplication.isRelocatePositive()
                    && jobApplication.getWantedSalary() <= jobOffer.getOfferSalary() ||
                    (jobApplication.getSkills().containsAll(jobOffer.getRequiredSkill()) && jobOffer.getOfferSalary() * 1.2 <= jobOffer.getOfferSalary()) ||
                    jobApplication.getExperience() >= jobOffer.getRequiredYearsExperience()) {
                bestApplications.add(jobApplication);
            }
        }

        List<JobApplication> finalJobBestApplication = new ArrayList<>();

        for (JobApplication bestApplication : bestApplications) {
            int tempBestSkillMatches = 0;
            int thisSkillMatches = 0;

            if (bestJobApplication == null) {
                bestJobApplication = bestApplication;
                continue;
            }

            List<String> requiredSkill = jobOffer.getRequiredSkill();
            List<String> skills = bestJobApplication.getSkills();
            List<String> skills1 = bestApplication.getSkills();

            for (String skill : skills) {
                if (requiredSkill.contains(skill)) {
                    tempBestSkillMatches++;
                }
            }

            for (String skill : skills1) {
                if (requiredSkill.contains(skill)) {
                    thisSkillMatches++;
                }
            }

            bestJobApplication = tempBestSkillMatches > thisSkillMatches ? bestJobApplication : bestApplication;
            if (tempBestSkillMatches < thisSkillMatches) {
                bestJobApplication = bestApplication;
            } else if (tempBestSkillMatches > thisSkillMatches) {
                continue;
            } else {
                if (bestApplication.getWantedSalary() > bestJobApplication.getWantedSalary()) {
                    bestJobApplication = bestApplication;
                } else if (bestApplication.getWantedSalary() < bestJobApplication.getWantedSalary()) {
                    continue;
                } else {
                    if (bestApplication.getExperience() > bestJobApplication.getExperience()) {
                        bestJobApplication = bestApplication;
                    } else if (bestApplication.getExperience() < bestJobApplication.getExperience()) {
                        continue;
                    } else {
                        finalJobBestApplication.add(bestJobApplication);
                    }
                }
            }
        }

        if (!finalJobBestApplication.isEmpty()) {
            int lastIndex = finalJobBestApplication.size() - 1;
            int randomIndex = ThreadLocalRandom.current().nextInt(0, lastIndex + 1);
            return finalJobBestApplication.get(randomIndex);
        }

        return bestJobApplication;
    }
}
