package com.arad.care4pets;

public class HealthRecord {
    private String recordType;
    private String description;

    public HealthRecord(String type, String description){
        this.recordType = type;
        this.description = description;
    }

    public String getRecordType(){
        return recordType;
    }
    public String getDescription(){
        return description;
    }

    public void setRecordType(String recordType){
        this.recordType = recordType;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
