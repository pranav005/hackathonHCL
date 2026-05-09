package com.creditcard.creditCardProcessor;

import com.creditcard.creditCardProcessor.entity.CreditScore;
import com.creditcard.creditCardProcessor.repository.CreditScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CreditScoreRepository creditScoreRepository;

    @Override
    public void run(String... args) {
        if (creditScoreRepository.count() > 0) {
            return;
        }

        CreditScore record1 = new CreditScore();
        record1.setDocumentType((short) 1);
        record1.setDocumentNumber(1234567890L);
        record1.setCreditScore(800);

        CreditScore record2 = new CreditScore();
        record2.setDocumentType((short) 1);
        record2.setDocumentNumber(9876543210L);
        record2.setCreditScore(720);

        CreditScore record3 = new CreditScore();
        record3.setDocumentType((short) 2);
        record3.setDocumentNumber(1111111111L);
        record3.setCreditScore(650);

        creditScoreRepository.saveAll(List.of(record1, record2, record3));
    }
}
