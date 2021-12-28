package individual.mystic.generator.pojo;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(nullable = false)
    private UUID id;
    private float priority;
    private float progress;
    private int status;
    private int error;
    private Instant beginTime;
    private Instant endTime;
    private boolean isAsync;
    private String results; // split with comma

    @ManyToOne
    private TaskType taskType;
    @ManyToOne
    private Worker worker;

    @ManyToOne
    private Task parentTask;

    @OneToMany(mappedBy = "parentTask")
    private List<Task> subTaskList;

    @ManyToMany
    @JoinTable(name = "pre_post_task",
            joinColumns = @JoinColumn(name = "pre_task_id"),
            inverseJoinColumns = @JoinColumn(name = "post_task_id")
    )
    private List<Task> preTaskList;

    @ManyToMany(mappedBy = "preTaskList")
    private List<Task> postTaskList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getPriority() {
        return priority;
    }

    public void setPriority(float priority) {
        this.priority = priority;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Instant getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Instant beginTime) {
        this.beginTime = beginTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public boolean isAsync() {
        return isAsync;
    }

    public void setAsync(boolean async) {
        isAsync = async;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public List<Task> getSubTaskList() {
        return subTaskList;
    }

    public void setSubTaskList(List<Task> subTaskList) {
        this.subTaskList = subTaskList;
    }

    public List<Task> getPreTaskList() {
        return preTaskList;
    }

    public void setPreTaskList(List<Task> preTaskList) {
        this.preTaskList = preTaskList;
    }

    public List<Task> getPostTaskList() {
        return postTaskList;
    }

    public void setPostTaskList(List<Task> postTaskList) {
        this.postTaskList = postTaskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Task task = (Task) o;
        return id != null && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "priority = " + priority + ", " +
                "progress = " + progress + ", " +
                "status = " + status + ", " +
                "error = " + error + ", " +
                "beginTime = " + beginTime + ", " +
                "endTime = " + endTime + ", " +
                "isAsync = " + isAsync + ", " +
                "results = " + results + ", " +
                "taskType = " + taskType.getName() + ", " +
                "workerId = " + worker.getId() + ", " +
                "parentTaskId = " + parentTask.getId() + ")";
    }
}
