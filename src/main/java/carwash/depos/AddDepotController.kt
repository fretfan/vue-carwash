package carwash.depos

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/add-depot")
class AddDepotController(private val addDepotService: AddDepotService) {

  //TODO try Kotlin-lint


  @PostMapping
  fun addDepot(@RequestBody newDepot: DepotDto): ResponseEntity<DepotDto> {
    val addedDepot = addDepotService.addNewDepot(newDepot)
    return ResponseEntity.ok(addedDepot)
  }

}
