package pl.firmy90.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.firmy90.model.domain.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("select sum(quantity) from Donation ")
    Integer countAllQuantity();
}
