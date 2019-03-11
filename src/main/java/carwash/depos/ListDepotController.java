package carwash.depos;

import carwash.entities.Depot;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/depots-list")
public class ListDepotController {

  private DepotRepository depotRepository;

  public ListDepotController(DepotRepository depotRepository) {
    this.depotRepository = depotRepository;
  }

  @GetMapping
  public ResponseEntity<List<Depot>> listDepots() {
    Iterable<Depot> iterator = depotRepository.findAll();
    List<Depot> depots = new ArrayList<>();
    CollectionUtils.addAll(depots, iterator);

    return ResponseEntity.ok(depots);
  }

}
