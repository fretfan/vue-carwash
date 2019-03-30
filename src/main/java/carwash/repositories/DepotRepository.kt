package carwash.repositories

import carwash.entities.Depot
import org.springframework.data.repository.CrudRepository

interface DepotRepository : CrudRepository<Depot, Long>
