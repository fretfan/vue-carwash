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

    var depot3 = Depot.builder()
      .name("Franks's carwash")
      .address("Middle of nowhere 321")
      .numberOfWorkers(10)
      .build();
    depotRepository.save(depot3);

    var depot4 = Depot.builder()
      .name("Smith's carwash")
      .address("Very close str 67")
      .numberOfWorkers(8)
      .build();
    depotRepository.save(depot4);

    log.info("Finish database inserts");
  }
}
