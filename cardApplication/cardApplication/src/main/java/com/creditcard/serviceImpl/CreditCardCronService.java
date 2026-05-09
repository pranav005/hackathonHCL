// package com.creditcard.serviceImpl;

// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Service;

// import com.creditcard.DTO.CreditCardApplicationRequest;

// import java.util.List;
// import java.util.concurrent.CopyOnWriteArrayList;
// import java.util.Random;

// @Service
// public class CreditCardCronService {

//     // Thread-safe list to store pending applications
//     private final List<CreditCardApplication> pendingApplications = new CopyOnWriteArrayList<>();

//     // Add new application
//     public void addApplication(CreditCardApplicationRequest request) {
//         pendingApplications.add(request);
//     }

//     // Cron job: runs every 30 seconds for demo purposes
//     @Scheduled(fixedRate = 30000)
//     public void processApplications() {
//         if (pendingApplications.isEmpty()) return;

//         System.out.println("Cron job triggered. Processing pending credit card applications...");

//         for (CreditCardApplicationRequest request : pendingApplications) {
//             int score = generateCreditScore(request);
//             System.out.println("Processed credit score for " + request.getName() + ": " + score);
//             // TODO: Save to DB or send notification
//             pendingApplications.remove(request);
//         }
//     }

//     private int generateCreditScore(CreditCardApplicationRequest request) {
//         // Simulate credit score computation
//         return 300 + new Random().nextInt(551);
//     }
// }
