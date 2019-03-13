package se.alten.challenge.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Vehicle.
 */
@Entity
@Table(name = "vehicle")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "vehicle_id", nullable = false, unique = true)
    private String vehicleId;

    @NotNull
    @Column(name = "vehicle_reg_no", nullable = false, unique = true)
    private String vehicleRegNo;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("vehicles")
    private Customer owner;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public Vehicle vehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public Vehicle vehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
        return this;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public Customer getOwner() {
        return owner;
    }

    public Vehicle owner(Customer customer) {
        this.owner = customer;
        return this;
    }

    public void setOwner(Customer customer) {
        this.owner = customer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        if (vehicle.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vehicle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "id=" + getId() +
            ", vehicleId='" + getVehicleId() + "'" +
            ", vehicleRegNo='" + getVehicleRegNo() + "'" +
            "}";
    }
}
