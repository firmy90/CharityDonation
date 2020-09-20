package pl.firmy90.services.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.firmy90.model.domain.entity.Donation;
import pl.firmy90.model.repositories.DonationRepository;
import pl.firmy90.services.interfaces.DonationService;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultDonationService implements DonationService {
    DonationRepository donationRepository;

    @Override
    public Long countDonations() {
        return donationRepository.count();
    }

    @Override
    public Integer countQuantity() {
        return donationRepository.countAllQuantity();
    }

    @Override
    public void saveFormDonation(Donation donation) {
        donationRepository.save(donation);
    }


}
