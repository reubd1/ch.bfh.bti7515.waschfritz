package ch.bfh.bti7515.waschfritz.service.dto;

import java.util.Date;

public class ReservationDTO {

    private Long id;
    private Date startDate;
    private Date endDate;

    private MachineDTO machineDTO;

    private TenantDTO tenantDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public MachineDTO getMachineDTO() {
        return machineDTO;
    }

    public void setMachineDTO(MachineDTO machineDTO) {
        this.machineDTO = machineDTO;
    }


    public TenantDTO getTenantDTO() {
        return tenantDTO;
    }

    public void setTenantDTO(TenantDTO tenantDTO) {
        this.tenantDTO = tenantDTO;
    }
}
