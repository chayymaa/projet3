import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tractors")
public class TractorController {
    @Autowired
    private TractorService tractorService;

    @GetMapping
    public List<Tractor> getAllTractors() {
        return tractorService.getAllTractors();
    }

    @GetMapping("/{id}")
    public Tractor getTractorById(@PathVariable Long id) {
        return tractorService.getTractorById(id)
                .orElseThrow(() -> new RuntimeException("Tractor not found with id " + id));
    }

    @PostMapping
    public Tractor createTractor(@RequestBody Tractor tractor) {
        return tractorService.saveOrUpdateTractor(tractor);
    }

    @PutMapping("/{id}")
    public Tractor updateTractor(@PathVariable Long id, @RequestBody Tractor tractorDetails) {
        Tractor tractor = tractorService.getTractorById(id)
                .orElseThrow(() -> new RuntimeException("Tractor not found with id " + id));

        tractor.setBrand(tractorDetails.getBrand());
        tractor.setModel(tractorDetails.getModel());

        return tractorService.saveOrUpdateTractor(tractor);
    }

    @DeleteMapping("/{id}")
    public void deleteTractor(@PathVariable Long id) {
        tractorService.deleteTractorById(id);
    }
}
