import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        List<JobOffer> list = new ArrayList();
        list.add(new JobOffer("Warszawa", 1000, 12, List.of("Java", "Spring")));
        list.add(new JobOffer("Poznań", 1234, 10, List.of("Java", "HTML")));
        list.add(new JobOffer("Kraków", 7895, 1, List.of("CSS", "HTML")));
        list.add(new JobOffer("Warszawa", 9514, 9, List.of("Java", "Spring")));
        list.add(new JobOffer("Olsztyn", 9872, 5, List.of("C#", "SQL")));
        list.add(new JobOffer("Radom", 3674, 17, List.of("Java", "SQL")));
        list.add(new JobOffer("Gdańsk", 95275, 9, List.of("PHP", "Rubby")));
        list.add(new JobOffer("Berlin", 152374, 17, List.of("Java", " PASCAL")));
        list.add(new JobOffer("Mogilno", 9514, 12, List.of("Java", "Spring")));
        list.add(new JobOffer("Poznań", 9514, 12, List.of("PASCAL", "Spring")));
        list.add(new JobOffer("Katowice", 9514, 12, List.of("CSS", "HTML")));
        list.add(new JobOffer("Lublin", 9514, 12, List.of(".NET", "Spring")));
        list.add(new JobOffer("Lublin", 9514, 12, List.of(".NET", "Spring")));

        JobOfferService jobOfferService = new JobOfferService();
        JobApplicationService jobApplicationService = new JobApplicationService();
        System.out.println(jobOfferService.getBiggestSalary(list));
        System.out.println(jobOfferService.countInCity(list, "Berlin"));
        System.out.println(jobOfferService.getMostPopularSkill(list));
        System.out.println(jobOfferService.getCitiesSet(list));
        System.out.println(jobOfferService.getAverageMinExp(list));
        List<JobApplication> list2 = new ArrayList();
        list2.add(new JobApplication("Emil Gajęcki", 900, "Mogilno", 789337218, true, "emil.gajecki@gmail.com", 15, List.of("Java", "SQL", "Spring")));
        list2.add(new JobApplication("Snorkeldink Banglesnatch", 90000, "Warszawa", 1234567, false, "ad", 1, List.of("Java", "HTML")));
        list2.add(new JobApplication("Bendydick Chuckecheese", 6547, "Warszawa", 2345678, true, "res", 1, List.of("C#", "Spring")));
        list2.add(new JobApplication("Barbituate Oxfordshire", 1500, "Berlin", 3573734, false, "wer", 1, List.of("C#", "SQL")));
        list2.add(new JobApplication("Boilerdang Concubine", 200, "Lublin", 89217856, true, "les", 1, List.of(".NET", "Spring")));
        System.out.println(jobOfferService.getBestApplication((JobOffer)list.get(0), list2));
    }
}
