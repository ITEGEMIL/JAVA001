import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class JobOfferService {
    public JobOfferService() {
    }

    public JobOffer getBiggestSalary(List<JobOffer> jobOffers) {
        JobOffer maxSalaryJoboffer = null;
        for (JobOffer jobOffer : jobOffers) {
            if (maxSalaryJoboffer == null || maxSalaryJoboffer.getOfferSalary() < jobOffer.getOfferSalary())
                maxSalaryJoboffer = jobOffer;
        }
        return maxSalaryJoboffer;
    }

    public long countInCity(List<JobOffer> jobOffers, String city) {
       long sumCounter = 0;
        for (JobOffer jobOffer : jobOffers) {
            if(jobOffer.getCity().equals(city){
                sumCounter++;
            }
        }
        return sumCounter;
    }

    public Set<String> getCitiesSet(List<JobOffer> jobOffers) {
        return null;
    }

    public double getAverageMinExp(List<JobOffer> jobOffers) {
        return 0;
    }

    public String getMostPopularSkill(List<JobOffer> jobOffers) {
        return null;

    }

    public JobApplication getBestApplication(JobOffer jobOffer, List<JobApplication> jobApplications) {
        return null;
    }
}
