package org.SmartWaste;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.time.Instant;

//@Document(collectionName = "reports")
public class Reports {

    @DocumentId
    private String report_id;

    private String name;
    private String phone_num;
    private String description;
    private String source;
    //private Timestamp timestamp;

    public Reports() {}

    public Reports(String report_id, String name, String phone_num, String description, String source/*, Timestamp timestamp*/) {
        this.report_id = report_id;
        this.name = name;
        this.phone_num = phone_num;
        this.description = description;
        this.source = source;
       // this.timestamp = timestamp;
    }

    public String getReport_id() { return report_id; }
    public void setReport_id(String report_id) { this.report_id = report_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone_num() { return phone_num; }
    public void setPhone_num(String phone_num) { this.phone_num = phone_num; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

}
