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
    log.info("Start database inserts");
    var depot1 = Depot.builder()
      .name("Sam's carwash")
      .address("Mon Str 5")
      .numberOfWorkers(5)
      .build();

    depotRepository.save(depot1);

    var depot2 = Depot.builder()
      .name("Anna's carwash")
      .address("Tue Str 12")
      .numberOfWorkers(2)
      .build();
    depotRepository.save(depot2);

    log.info("Finish database inserts");
  }
}
