package online.find_church.bot.db.entity.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.find_church.bot.db.entity.Church;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "activities")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Activity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name; // Название активности

    @Column(name = "start_time")
    private LocalDateTime startTime; // Время начала

    private String description; // Описание активности

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "church_id")
    private Church church;

    @Column(name = "activity_type", insertable = false, updatable = false)
    private String activityType;

    @PrePersist
    @PreUpdate
    private void setActivityType() {
        this.activityType = this.getClass().getSimpleName();
    }
}
