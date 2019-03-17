package carwash.depos

import carwash.entities.Depot
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.util.Optional

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
