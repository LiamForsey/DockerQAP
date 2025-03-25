package tournaments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    List<Tournament> findByLocation(String location);

    List<Tournament> findByStartDateBetween(Date startDate, Date endDate);
}
