package org.SmartWaste;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;

public class Tasks
{
    @DocumentId
    private String task_id;

    private String title ;
    private String description ;
    private boolean assigned ;
    private Timestamp timestamp;

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }


    public boolean isAssigned() {
        return assigned;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_id() {
        return task_id;
    }
}
