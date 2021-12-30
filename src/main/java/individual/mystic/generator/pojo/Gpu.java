package individual.mystic.generator.pojo;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "gpu")
public class Gpu {
    @Id
    @Column(nullable = false)
    private UUID id;
    private float memCap;
    private float memUsed;
    private float pwrCap;
    private float pwrUsed;
    private float temperature;
    private float gpuUtilization;

    @ManyToOne
    private Worker worker;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getMemCap() {
        return memCap;
    }

    public void setMemCap(float memCap) {
        this.memCap = memCap;
    }

    public float getMemUsed() {
        return memUsed;
    }

    public void setMemUsed(float memUsed) {
        this.memUsed = memUsed;
    }

    public float getPwrCap() {
        return pwrCap;
    }

    public void setPwrCap(float pwrCap) {
        this.pwrCap = pwrCap;
    }

    public float getPwrUsed() {
        return pwrUsed;
    }

    public void setPwrUsed(float pwrUsed) {
        this.pwrUsed = pwrUsed;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getGpuUtilization() {
        return gpuUtilization;
    }

    public void setGpuUtilization(float gpuUtilization) {
        this.gpuUtilization = gpuUtilization;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Gpu gpu = (Gpu) o;
        return id != null && Objects.equals(id, gpu.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ", " +
            "memCap = " + memCap + ", " +
            "memUsed = " + memUsed + ", " +
            "pwrCap = " + pwrCap + ", " +
            "pwrUsed = " + pwrUsed + ", " +
            "temperature = " + temperature + ", " +
            "gpuUtilization = " + gpuUtilization + ")";
    }
}
