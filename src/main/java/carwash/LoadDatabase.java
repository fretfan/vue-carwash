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

    var depot1 = new Depot();
    depot1.setName("Sam's carwash");
    depot1.setAddress("Mon Str 5");
    depot1.setNumberOfWorkers(5);
    depotRepository.save(depot1);

    var depot2 = new Depot();
    depot2.setName("Anna's carwash");
    depot2.setAddress("Tue Str 12");
    depot2.setNumberOfWorkers(2);
    depotRepository.save(depot2);

    var depot3 = new Depot();
    depot3.setName("Franks's carwash");
    depot3.setAddress("Middle of nowhere 321");
    depot3.setNumberOfWorkers(10);
    depotRepository.save(depot3);

    var depot4 = new Depot();
    depot4.setName("Smith's carwash");
    depot4.setAddress("Very close str 67");
    depot4.setNumberOfWorkers(8);
    depotRepository.save(depot4);

    log.info("Finish database inserts");
  }
}
