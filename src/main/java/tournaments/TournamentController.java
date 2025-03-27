package tournaments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;


    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }


    @GetMapping("/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }


    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }


    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }


    @GetMapping("/search")
    public List<Tournament> searchTournament(@RequestParam(required = false) String location,
                                             @RequestParam(required = false) String startDate,
                                             @RequestParam(required = false) String endDate) {
        if (location != null) {
            return tournamentService.searchByLocation(location);
        } else if (startDate != null && endDate != null) {

            return tournamentService.searchByDateRange(startDate, endDate);
        }
        return null;
    }
}

