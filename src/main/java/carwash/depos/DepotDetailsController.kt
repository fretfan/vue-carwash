package carwash.depos

import carwash.entities.Depot
import carwash.repositories.DepotRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/depot")
class DepotDetailsController(private val depotRepository: DepotRepository) {

  @GetMapping("/{id}")
  fun getDepot(@PathVariable("id") id: Long): ResponseEntity<Depot> {
    val depot = depotRepository.findById(id)
    return ResponseEntity.ok(depot.orElseThrow { RuntimeException("Not found") })
  }

}
