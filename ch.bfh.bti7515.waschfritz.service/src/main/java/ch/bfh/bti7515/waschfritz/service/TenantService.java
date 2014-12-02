package ch.bfh.bti7515.waschfritz.service;

import ch.bfh.bti7515.waschfritz.service.dto.TenantDTO;

import javax.inject.Named;
import java.util.Collection;

/**
 * Created by adrian on 02.12.14.
 */

public interface TenantService {

    public TenantDTO create(TenantDTO reservation);

    public  TenantDTO read(Long id);

    public Collection<TenantDTO> list();

    public  TenantDTO update(TenantDTO reservation);

    public  void delete(TenantDTO reservation);

}
