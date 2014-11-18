package ch.bfh.bti7515.waschfritz.repository;

import ch.bfh.bti7515.waschfritz.model.Tenant;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adrian on 18.11.14.
 */
public interface TenantRepository extends CrudRepository<Tenant, Long> {
}
