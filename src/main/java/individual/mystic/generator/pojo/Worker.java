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
    private float cpu;
    private float gpu;
    private float memory;
    private float harkDisk;
    private Instant createdTime;

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

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public float getGpu() {
        return gpu;
    }

    public void setGpu(float gpu) {
        this.gpu = gpu;
    }

    public float getMemory() {
        return memory;
    }

    public void setMemory(float memory) {
        this.memory = memory;
    }

    public float getHarkDisk() {
        return harkDisk;
    }

    public void setHarkDisk(float harkDisk) {
        this.harkDisk = harkDisk;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
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
                "cpu = " + cpu + ", " +
                "gpu = " + gpu + ", " +
                "memory = " + memory + ", " +
                "harkDisk = " + harkDisk + ", " +
                "createdTime = " + createdTime + ")";
    }
}
