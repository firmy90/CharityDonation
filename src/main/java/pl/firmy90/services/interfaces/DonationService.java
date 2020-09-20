package pl.firmy90.services.interfaces;

import pl.firmy90.model.domain.entity.Donation;

public interface DonationService {

    Long countDonations();
    Integer countQuantity();
    void saveFormDonation(Donation donation);
}
