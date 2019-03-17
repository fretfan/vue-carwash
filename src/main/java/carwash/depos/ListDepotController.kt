package carwash.depos

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/depots-list")
class ListDepotController(private val listDepotService: ListDepotService) {


  @GetMapping
  fun listDepots(): ResponseEntity<List<DepotDto>> {
    val depots = listDepotService.getAllDepots()
    return ResponseEntity.ok(depots)
  }

}
