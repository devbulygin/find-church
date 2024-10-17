package online.find_church.bot.db.entity.activity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EventActivity extends Activity {
    private static final long serialVersionUID = 1L;

    @Column(name = "end_time")
    private LocalDateTime endTime;
}
