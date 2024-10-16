package com.example.churchbot.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.find_church.bot.db.entity.activity.Activity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class WorshipActivity extends Activity {
    private static final long serialVersionUID = 1L;

}
