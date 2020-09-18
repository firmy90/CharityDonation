package pl.firmy90.model.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Column(nullable = false, length = 100)
    private String name;

//    //TODO
//    @ManyToMany(mappedBy = "categories")
//    private List<Donation> donations;
}
