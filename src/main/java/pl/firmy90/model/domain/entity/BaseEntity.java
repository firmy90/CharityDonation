package pl.firmy90.model.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }

}
