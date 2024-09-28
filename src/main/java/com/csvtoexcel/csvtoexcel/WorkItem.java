
package com.csvtoexcel.csvtoexcel;

import java.time.LocalDate;
import java.time.LocalDateTime;



    
    
 public class WorkItem {
    private String assignedTo;
    private Long id;
    private String workItemType;
    private String title;
    private String state;
    private LocalDateTime startDate;
    private LocalDateTime targetDate;
    private int effort;
    private String tshirtSize;

    public WorkItem(String assignedTo, Long id, String workItemType, String title, String state, LocalDateTime startDate, LocalDateTime targetDate, int effort, String tshirtSize) {
        this.assignedTo = assignedTo;
        this.id = id;
        this.workItemType = workItemType;
        this.title = title;
        this.state = state;
        this.startDate = startDate;
        this.targetDate = targetDate;
        this.effort = effort;
        this.tshirtSize = tshirtSize;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public Long getId() {
        return id;
    }

    public String getWorkItemType() {
        return workItemType;
    }

    public String getTitle() {
        return title;
    }

    public String getState() {
        return state;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getTargetDate() {
        return targetDate;
    }

    public int getEffort() {
        return effort;
    }

    public String getTshirtSize() {
        return tshirtSize;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWorkItemType(String workItemType) {
        this.workItemType = workItemType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public void setTshirtSize(String tshirtSize) {
        this.tshirtSize = tshirtSize;
    }
    
    

   
  }   
