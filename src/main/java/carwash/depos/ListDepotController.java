package carwash.depos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/depots-list")
public class ListDepotController {

  private ListDepotService listDepotService;

  public ListDepotController(ListDepotService listDepotService) {
    this.listDepotService = listDepotService;
  }


  @GetMapping
  public ResponseEntity<List<DepotDto>> listDepots() {
    List<DepotDto> depots = listDepotService.getAllDepots();
    return ResponseEntity.ok(depots);
  }

}
