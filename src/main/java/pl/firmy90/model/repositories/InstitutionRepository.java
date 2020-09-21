package pl.firmy90.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.firmy90.model.domain.entity.Institution;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    List<Institution> findVisibleInstitutionsByVisibleEquals(boolean b);

    @Modifying
    @Query("update Institution inst set inst.visible=false where inst.id=:id")
    void archiveInstitutionById(Long id);

}
