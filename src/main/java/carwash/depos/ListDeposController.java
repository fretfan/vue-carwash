package carwash.depos;

import carwash.entities.Depot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ListDeposController {

  private DepotRepository depotRepository;

  public ListDeposController(DepotRepository depotRepository) {
    this.depotRepository = depotRepository;
  }

  @GetMapping("/hello")
  public ResponseEntity<Depot> sayHello() {
    Optional<Depot> byId = depotRepository.findById(1L);
    var depot = byId.get();
    return ResponseEntity.ok(depot);
  }

}
