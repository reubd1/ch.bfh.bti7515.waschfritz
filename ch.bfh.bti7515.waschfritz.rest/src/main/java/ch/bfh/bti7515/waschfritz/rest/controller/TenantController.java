package ch.bfh.bti7515.waschfritz.rest.controller;


import ch.bfh.bti7515.waschfritz.service.TenantService;
import ch.bfh.bti7515.waschfritz.service.dto.TenantDTO;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by adrian on 07.12.14.
 */

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Inject
    private TenantService tenantService;

    @RequestMapping(method = RequestMethod.POST)
    public TenantDTO createTenant(@RequestBody TenantDTO tenantDTO) {
        TenantDTO createdTenant = tenantService.create(tenantDTO);
        System.out.println("Created Tenant with ID: " + createdTenant.getId());
        return createdTenant;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TenantDTO> getTenants() {
        Collection<TenantDTO> allTenants = tenantService.list();
        System.out.println(String.format("Returning %d tenants", allTenants.size()));
        return allTenants;

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public TenantDTO getTenantById(@PathVariable long id) {
        System.out.println("Getting Tenant with id " + id);
        return tenantService.read(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public TenantDTO updateTenant(@RequestBody TenantDTO tenantDTO) {
        System.out.println("Update Tenant with id " + tenantDTO.getId());
        return tenantService.update(tenantDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteTenant(@PathVariable long id) {
        System.out.println("Delete Tenant with id " + id);
        TenantDTO tenantDTO = tenantService.read(id);
        tenantService.delete(tenantDTO);
    }
}
