package carwash.depos.adddepot

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class AddDepotDto(
  @field:NotBlank
  var name: String,
  @field:NotBlank
  var address: String,
  @field:Positive
  var numberOfWorkers: Int)


