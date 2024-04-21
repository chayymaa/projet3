import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TractorService {
    @Autowired
    private TractorRepository tractorRepository;

    public List<Tractor> getAllTractors() {
        return tractorRepository.findAll();
    }

    public Optional<Tractor> getTractorById(Long id) {
        return tractorRepository.findById(id);
    }

    public Tractor saveOrUpdateTractor(Tractor tractor) {
        return tractorRepository.save(tractor);
    }

    public void deleteTractorById(Long id) {
        tractorRepository.deleteById(id);
    }
}
