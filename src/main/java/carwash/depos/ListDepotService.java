package carwash.depos;

import carwash.entities.Depot;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListDepotService {

  private DepotRepository depotRepository;
  private Mapper mapper;

  public ListDepotService(DepotRepository depotRepository, Mapper mapper) {
    this.depotRepository = depotRepository;
    this.mapper = mapper;
  }

  public List<DepotDto> getAllDepots() {
    Iterable<Depot> iterator = depotRepository.findAll();
    List<DepotDto> depots = new ArrayList<>();
    iterator.forEach(depot -> {
      DepotDto dto = mapper.map(depot, DepotDto.class);
      depots.add(dto);
    });

    return depots;
  }

}
