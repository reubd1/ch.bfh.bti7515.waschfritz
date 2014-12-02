package ch.bfh.bti7515.waschfritz.service;

import ch.bfh.bti7515.waschfritz.service.dto.TenantDTO;

import java.util.Collection;

/**
 * Created by adrian on 02.12.14.
 */
public interface TenantService {

    public TenantDTO create(TenantDTO TenantDTO);

    public TenantDTO read(long id);

    public Collection<TenantDTO> list();

    public TenantDTO update(TenantDTO machine);

    public void delete(TenantDTO machine);
}
