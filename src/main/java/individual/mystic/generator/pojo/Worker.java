package individual.mystic.generator.pojo;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @Column(nullable = false)
    private UUID id;
    private String mac;
    private int cpuCores;
    private float cpuAvg;
    private float memTotal;
    private float memUsed;
    private float harkDiskTotal;
    private float harkDiskUsed;
    private Instant createdTime;
    private Instant updatedTime;
    private Instant deletedTime;

    @OneToMany(mappedBy = "worker")
    private List<Gpu> gpuList;

    @ManyToMany
    @JoinTable(name = "worker_task_type",
        joinColumns = @JoinColumn(name = "worker_id"),
        inverseJoinColumns = @JoinColumn(name = "task_type_id")
    )
    private List<TaskType> taskTypeList;

    @OneToMany(mappedBy = "worker")
    private List<Task> runningTaskList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public float getCpuAvg() {
        return cpuAvg;
    }

    public void setCpuAvg(float cpuAvg) {
        this.cpuAvg = cpuAvg;
    }

    public float getMemTotal() {
        return memTotal;
    }

    public void setMemTotal(float memTotal) {
        this.memTotal = memTotal;
    }

    public float getMemUsed() {
        return memUsed;
    }

    public void setMemUsed(float memUsed) {
        this.memUsed = memUsed;
    }

    public float getHarkDiskTotal() {
        return harkDiskTotal;
    }

    public void setHarkDiskTotal(float harkDiskTotal) {
        this.harkDiskTotal = harkDiskTotal;
    }

    public float getHarkDiskUsed() {
        return harkDiskUsed;
    }

    public void setHarkDiskUsed(float harkDiskUsed) {
        this.harkDiskUsed = harkDiskUsed;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public Instant getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Instant updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Instant getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Instant deletedTime) {
        this.deletedTime = deletedTime;
    }

    public List<Gpu> getGpuList() {
        return gpuList;
    }

    public void setGpuList(List<Gpu> gpuList) {
        this.gpuList = gpuList;
    }

    public List<TaskType> getTaskTypeList() {
        return taskTypeList;
    }

    public void setTaskTypeList(List<TaskType> taskTypeList) {
        this.taskTypeList = taskTypeList;
    }

    public List<Task> getRunningTaskList() {
        return runningTaskList;
    }

    public void setRunningTaskList(List<Task> runningTaskList) {
        this.runningTaskList = runningTaskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Worker worker = (Worker) o;
        return id != null && Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ", " +
            "mac = " + mac + ", " +
            "cpuCores = " + cpuCores + ", " +
            "cpuAvg = " + cpuAvg + ", " +
            "memTotal = " + memTotal + ", " +
            "memUsed = " + memUsed + ", " +
            "harkDiskTotal = " + harkDiskTotal + ", " +
            "harkDiskUsed = " + harkDiskUsed + ", " +
            "createdTime = " + createdTime + ", " +
            "updatedTime = " + updatedTime + ", " +
            "deletedTime = " + deletedTime + ")";
    }
}
