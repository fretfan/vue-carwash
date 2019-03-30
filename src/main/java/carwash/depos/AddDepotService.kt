package carwash.depos

import carwash.entities.Depot
import carwash.repositories.DepotRepository
import org.dozer.Mapper
import org.springframework.stereotype.Service

@Service
class AddDepotService(private val depotRepository: DepotRepository, private val mapper: Mapper) {

  fun addNewDepot(newDepot: DepotDto): DepotDto {
    val depotEnt = mapper.map(newDepot, Depot::class.java)
    val savedEnt = depotRepository.save(depotEnt)
    return mapper.map(savedEnt, DepotDto::class.java)
  }

}
