package ch.bfh.bti7515.waschfritz.service;

import ch.bfh.bti7515.waschfritz.service.dto.TenantDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Collection;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by adrian on 02.12.14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class TenantServiceIT {

    @Inject
    private TenantService tenantService;

    @Test
    public void test() {
        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setName("Tenant1");
        tenantDTO = tenantService.create(tenantDTO);

        TenantDTO readTenant = tenantService.read(tenantDTO.getId());
        assertEquals("Tenant1", readTenant.getName());

        Collection<TenantDTO> tenantDTOs = tenantService.list();
        assertFalse(tenantDTOs.isEmpty());

        readTenant.setName("New Name");
        readTenant = tenantService.update(readTenant);
        TenantDTO updatedTenant = tenantService.read(readTenant.getId());
        assertEquals("New Name", readTenant.getName());

        tenantService.delete(updatedTenant);
        TenantDTO deletedTenant = tenantService.read(readTenant.getId());
        assertNull(deletedTenant);


    }


}
