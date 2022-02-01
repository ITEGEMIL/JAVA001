import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

    public class JobApplicationService {
        public Map<String, Long> getCitiesCount(List<JobApplication> jobApplications) {
            return jobApplications.stream()
                    .collect(Collectors.groupingBy(JobApplication::getCity, Collectors.counting()));

//        Map<String, Long> citesCounts = new HashMap<>();
//        for (JobApplication jobApplication : jobApplications) {
//            String city = jobApplication.getCity();
//            citesCounts.merge(city, 1L, Long::sum);
//
////            if (citesCounts.containsKey(city)) {
////                citesCounts.put(city, citesCounts.get(city + 1));
////            } else {
////                citesCounts.put(city, 1L);
////            }
//        }
//
//        return citesCounts;
        }

        public Map<String, Long> getEmailsCount(List<JobApplication> jobApplications) {

            return jobApplications.stream()
                    .collect(Collectors.groupingBy(JobApplication::getEmail, Collectors.counting()));

//        Map<String, Long> emailCount = new HashMap<>();
//        for (JobApplication jobApplication: jobApplications) {
//            String email = jobApplication.getEmail();
//            emailCount.merge(email, 1L, Long::sum);
////            if(emailCount.containsKey(email)){
////                emailCount.put(email,emailCount.get(email)+1);
////            } else {
////                emailCount.put(email, 1L);
////            }
//        }
//        return emailCount;

        }

        public Set<String> getMostFreqSkillList(List<JobApplication> jobApplications) {
            Map<String, Long> collect = jobApplications.stream()
                    .map(JobApplication::getSkills)
                    //robija kolecje na pojedyńcze wartośi - każdy skill na innym kajaku
                    .flatMap(List::stream)
                    .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

            long maxValue = collect
                    //pojedyńczy wpis na mapie (klucz, wartość )
                    .entrySet().stream()
                    .max(Comparator.comparingLong(Map.Entry::getValue))
                    .map(Map.Entry::getValue)
                    .orElse(0L);

            return collect.entrySet().stream()
                    .filter(e -> e.getValue() == maxValue)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
        }

        public String getMostFreqSkill(List<JobApplication> jobApplications) {

            return jobApplications.stream()
                    .map(JobApplication::getSkills)
                    .flatMap(List::stream)
                    .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                    .entrySet().stream()
                    .max(Comparator.comparingLong(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .orElse(null);


//        Map<String, Long> skillCount = new HashMap<>();
//        for (JobApplication jobApplication : jobApplications) {
//            List<String> skills = jobApplication.getSkills();
//            for (String skill : skills) {
//                 skillCount.merge(skill,1L, Long::sum);
//            }
//        }
//
//        Map.Entry<String, Long> maxValyeEntry = null;
//        for (Map.Entry<String, Long> entry : skillCount.entrySet()) {
//            if(maxValyeEntry == null || entry.getValue() > maxValyeEntry.getValue()){
//                maxValyeEntry = entry;
//            }
//        }
//
////        if(maxValyeEntry == null){
////            return null;
////        } else {
////            return maxValyeEntry.getKey();
////
////                                  true   false
//        return maxValyeEntry == null ? null : maxValyeEntry.getKey();

        }

        // tan sami mail - 2 aplikacje, ale różne imie
        public List<JobApplication> validate(List<JobApplication> jobApplications) {
            List<JobApplication> wrongJobApplications = new ArrayList<>();
            Map<String, String> doubleMailApllications = new HashMap<>();

            for (JobApplication jobApplication : jobApplications) {

                String email = jobApplication.getEmail();
                String name = jobApplication.getFullName();

                if (doubleMailApllications.containsKey(email)) {
                    if (doubleMailApllications.get(email).equals(name)) {
                        wrongJobApplications.add(jobApplication);
                        wrongJobApplications.add(jobApplications.stream()
                                .filter(j -> j.getEmail().equals(email) && j.getFullName().equals(name))
                                .findAny().orElse(null));
                    }
                }
                doubleMailApllications.put(email, name);
            }

            return wrongJobApplications;
        }

}