package carwash.depos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepotDto {

  private Long id;
  private String name;
  private String address;
  private Integer numberOfWorkers;
}
