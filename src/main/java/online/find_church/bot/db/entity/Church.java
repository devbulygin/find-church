package online.find_church.bot.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import online.find_church.bot.db.entity.activity.Activity;
import online.find_church.bot.db.entity.address.Address;
import online.find_church.bot.db.entity.denomination.Denomination;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "churches")
public class Church {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String churchName;

    @ManyToOne
    @JoinColumn(name = "denomination_id", nullable = false)
    private Denomination denomination;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "pastor_id")
    private Pastor pastor;

    @OneToMany(mappedBy = "church", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activity> activities;

    private LocalDateTime lastUpdated;
    private String photoUrl;
}
