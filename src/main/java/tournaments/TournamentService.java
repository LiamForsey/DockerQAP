package tournaments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;


    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }


    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }


    public List<Tournament> searchByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }


    public List<Tournament> searchByDateRange(String startDate, String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);
            return tournamentRepository.findByStartDateBetween(start, end);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}

