package pl.firmy90.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.firmy90.model.domain.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
