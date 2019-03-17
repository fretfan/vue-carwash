package carwash

import carwash.depos.DepotRepository
import carwash.entities.Depot
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
open class LoadDatabase(private val depotRepository: DepotRepository) {

  private val log = LoggerFactory.getLogger(javaClass)

  @PostConstruct
  fun initDatabase() {
    log.info("Start database inserts")

    val depot1 = Depot()
    depot1.name = "Sam's carwash"
    depot1.address = "Mon Str 5"
    depot1.numberOfWorkers = 5
    depotRepository.save(depot1)

    val depot2 = Depot()
    depot2.name = "Anna's carwash"
    depot2.address = "Tue Str 12"
    depot2.numberOfWorkers = 2
    depotRepository.save(depot2)

    val depot3 = Depot()
    depot3.name = "Franks's carwash"
    depot3.address = "Middle of nowhere 321"
    depot3.numberOfWorkers = 10
    depotRepository.save(depot3)

    val depot4 = Depot()
    depot4.name = "Smith's carwash"
    depot4.address = "Very close str 67"
    depot4.numberOfWorkers = 8
    depotRepository.save(depot4)

    log.info("Finish database inserts")
  }
}
