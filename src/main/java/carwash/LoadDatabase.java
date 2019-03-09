package carwash;

import carwash.depos.DepotRepository;
import carwash.entities.Depot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class LoadDatabase {

  private DepotRepository depotRepository;

  public LoadDatabase(DepotRepository depotRepository) {
    this.depotRepository = depotRepository;
  }

  @PostConstruct
  public void initDatabase() {
    var depot = Depot.builder()
      .name("Some name")
      .address("Some address")
      .numberOfWorkers(5)
      .build();
    log.info("Inserting stuff");
    depotRepository.save(depot);
  }
}
