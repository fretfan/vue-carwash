package carwash.depos.adddepot

import carwash.depos.DepotDto
import carwash.entities.Depot
import carwash.repositories.DepotRepository
import org.dozer.Mapper
import org.springframework.stereotype.Service

@Service
class AddDepotService(private val depotRepository: DepotRepository, private val mapper: Mapper) {

  fun addNewDepot(newDepot: AddDepotDto): DepotDto {
    val depotEntity = mapper.map(newDepot, Depot::class.java)
    val savedDepot = depotRepository.save(depotEntity)
    return mapper.map(savedDepot, DepotDto::class.java)
  }

}
