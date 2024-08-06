package ru.pstl.noiramv.service;

import org.springframework.http.ResponseEntity;
import ru.pstl.noiramv.model.Tournament;

public interface TournamentServiceable {
    ResponseEntity<Tournament> getTournamentById(long tournamentId);
    ResponseEntity<Tournament> createTournament(Tournament tournament);
    ResponseEntity<Tournament> deleteTournament(long tournamentId);
}
