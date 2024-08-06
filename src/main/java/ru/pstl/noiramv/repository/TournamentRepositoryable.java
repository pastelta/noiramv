package ru.pstl.noiramv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pstl.noiramv.model.Tournament;

public interface TournamentRepositoryable extends JpaRepository<Tournament, Long> {
}
