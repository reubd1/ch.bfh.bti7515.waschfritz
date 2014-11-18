package ch.bfh.bti7515.waschfritz.repository;

/**
 * Created by reubid on 18.11.14.
 */


import ch.bfh.bti7515.waschfritz.model.Tenant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class TenantRepositoryIT {


    @Inject
    private TenantRepository tenantRepository;

    @Test
    public void test(){

        // Create
        Tenant newTenant = new Tenant();
        newTenant.setName("Hans Muster");
        newTenant.setAddress("6b");
        tenantRepository.save(newTenant);

        // Read
        Tenant readTenant = tenantRepository.findOne(newTenant.getId());
        org.junit.Assert.assertTrue(newTenant.getName().equals(readTenant.getName()));

        // Update
        readTenant.setName("Fritz Muster");
        readTenant = tenantRepository.save(readTenant);
        Tenant updatedTenant = tenantRepository.findOne(readTenant.getId());
        org.junit.Assert.assertTrue(readTenant.getName().equals(updatedTenant.getName()));


        // Delete
        tenantRepository.delete(updatedTenant);
        Tenant deletedTenant = tenantRepository.findOne(readTenant.getId());
        org.junit.Assert.assertNull(deletedTenant);
    }


}
