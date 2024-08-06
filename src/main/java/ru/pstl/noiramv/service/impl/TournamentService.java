package ru.pstl.noiramv.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.pstl.noiramv.exception.ResourceNotFoundException;
import ru.pstl.noiramv.model.Tournament;
import ru.pstl.noiramv.repository.TournamentRepositoryable;
import ru.pstl.noiramv.service.TournamentServiceable;
@Service
@AllArgsConstructor
public class TournamentService implements TournamentServiceable {
    private final TournamentRepositoryable TOURNAMENT_REPO;
    @Override
    public ResponseEntity<Tournament> getTournamentById(long tournamentId) {
        Tournament tournament = TOURNAMENT_REPO.findById(tournamentId)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Tournament with id = " + tournamentId));
        return new ResponseEntity<>(tournament, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tournament> createTournament(Tournament tournament) {
        return new ResponseEntity<>(TOURNAMENT_REPO.save(tournament), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tournament> deleteTournament(long tournamentId) {
        TOURNAMENT_REPO.findById(tournamentId)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Tournament with id = " + tournamentId));
        TOURNAMENT_REPO.deleteById(tournamentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
