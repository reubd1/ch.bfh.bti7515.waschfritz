package ch.bfh.bti7515.waschfritz.service.dto;

public class TenantDTO {

    private Long id;
    private String name;
    private String address;
    //private List<ReservationDTO> reservationDTOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*public List<ReservationDTO> getReservationDTOs() {
        return reservationDTOs;
    }

    public void setReservationDTOs(List<ReservationDTO> reservationDTOs) {
        this.reservationDTOs = reservationDTOs;
    }
    */
}
