package ru.pstl.noiramv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name="tournaments")
@AllArgsConstructor
@NoArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="tournament_name")
    private String tournamentName;
    @Column(name="date_start")
    private Date dateStart;
    @Column(name = "time_start")
    private Time timeStart;
    @Column(name="buy_in")
    private Integer buyIn;
}
