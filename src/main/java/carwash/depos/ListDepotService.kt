package carwash.depos

import org.dozer.Mapper
import org.springframework.stereotype.Service
import java.util.*

@Service
class ListDepotService(private val depotRepository: DepotRepository, private val mapper: Mapper) {

  fun getAllDepots(): List<DepotDto> {
    val iterator = depotRepository.findAll()
    val depots = ArrayList<DepotDto>()
    iterator.forEach { depot ->
      val dto = mapper.map(depot, DepotDto::class.java)
      depots.add(dto)
    }
    return depots
  }

}
