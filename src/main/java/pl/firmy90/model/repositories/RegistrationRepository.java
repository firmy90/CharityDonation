package pl.firmy90.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.firmy90.model.domain.entity.Role;
import pl.firmy90.model.domain.entity.User;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<User,Long> {

    List<User> findByRoleEqualsAndVisibleEquals(Role role, boolean b);
    @Modifying
    @Query("update User u set u.visible=false where u.id=:id")
    void archiveById(Long id);

    User getByUsername(String username);
    boolean existsByUsername(String username);
}
