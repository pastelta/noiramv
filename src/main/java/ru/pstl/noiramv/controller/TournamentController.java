package ru.pstl.noiramv.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pstl.noiramv.exception.ErrorResponse;
import ru.pstl.noiramv.exception.ResourceNotFoundException;
import ru.pstl.noiramv.model.Tournament;
import ru.pstl.noiramv.service.TournamentServiceable;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TournamentController {
    private final TournamentServiceable TOURNAMENT_SERVICE;
    @GetMapping("/tournaments/{tournamentId}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable("tournamentId") long tournamentId){
        return TOURNAMENT_SERVICE.getTournamentById(tournamentId);
    }
    @PostMapping("/create-tournament")
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament){
        return TOURNAMENT_SERVICE.createTournament(tournament);
    }
    @PostMapping("/delete-tournament/{tournamentId}")
    public ResponseEntity<Tournament> createTournament(@PathVariable("tournamentId") long tournamentId){
        return TOURNAMENT_SERVICE.deleteTournament(tournamentId);
    }
    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(ResourceNotFoundException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
