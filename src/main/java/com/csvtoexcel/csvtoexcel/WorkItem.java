
package com.csvtoexcel.csvtoexcel;

import java.time.LocalDate;
import java.util.Date;



    
    
 public class WorkItem {
    private String assignedTo;
    private Long id;
    private String workItemType;
    private String title;
    private String state;
    private LocalDate startDate;
    private LocalDate targetDate;
    private int effort;
    private String tshirtSize;

    public WorkItem(String assignedTo, Long id, String workItemType, String title, String state, LocalDate startDate, LocalDate targetDate, int effort, String tshirtSize) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getTargetDate() {
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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public void setTshirtSize(String tshirtSize) {
        this.tshirtSize = tshirtSize;
    }
    
    

   
  }   
