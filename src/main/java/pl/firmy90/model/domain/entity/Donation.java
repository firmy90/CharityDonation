package pl.firmy90.model.domain.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donations")
public class Donation extends BaseEntity {
    private Integer quantity;
    @ManyToMany
    @JoinTable(
            name = "donation_category",
            joinColumns = @JoinColumn(name = "donation_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
    @Column(name = "institution_id", updatable = false, insertable = false)
    private Long institutionId;

    @Column(nullable = false, length = 100)
    private String street;
    @Column(nullable = false, length = 100)
    private String city;
    @Column(nullable = false, length = 10)
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate pickUpDate;
    @Column(nullable = false)
    @DateTimeFormat(pattern="HH:MM")
    private LocalTime pickUpTime;
    @Column(columnDefinition = "TEXT")
    private String pickUpComment;


}
