package ch.bfh.bti7515.waschfritz.service.impl;

import ch.bfh.bti7515.waschfritz.model.Tenant;
import ch.bfh.bti7515.waschfritz.repository.TenantRepository;
import ch.bfh.bti7515.waschfritz.service.TenantService;
import ch.bfh.bti7515.waschfritz.service.dto.TenantDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by adrian on 02.12.14.
 */

@Named
public class DefaultTenantService implements TenantService {

    private final ModelMapper mapper = new ModelMapper();
    @Inject
    private TenantRepository tenantRepository;

    @Override
    public TenantDTO create(TenantDTO TenantDTO) {
        Tenant Tenant = mapper.map(TenantDTO, Tenant.class);
        Tenant savedTenant = tenantRepository.save(Tenant);
        return mapper.map(savedTenant, TenantDTO.class);
    }

    @Override
    public TenantDTO read(long id) {
        Tenant Tenant = tenantRepository.findOne(id);
        if (Tenant == null) {
            return null;
        }
        return mapper.map(Tenant, TenantDTO.class);
    }

    @Override
    public Collection<TenantDTO> list() {
        Iterable<Tenant> Tenants = tenantRepository.findAll();
        Type listType = new TypeToken<Collection<TenantDTO>>() {
        }.getType();
        return mapper.map(Tenants, listType);
    }

    @Override
    public TenantDTO update(TenantDTO tenantDTO) {
        Tenant Tenant = mapper.map(tenantDTO, Tenant.class);
        Tenant savedTenant = tenantRepository.save(Tenant);
        return mapper.map(savedTenant, TenantDTO.class);
    }

    @Override
    public void delete(TenantDTO tenantDTO) {
        Tenant Tenant = tenantRepository.findOne(tenantDTO.getId());
        tenantRepository.delete(Tenant);

    }
}
