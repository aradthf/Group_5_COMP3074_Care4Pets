package com.arad.care4pets;

public class HealthRecord {

    private int id;
    private String recordType;
    private String description;

    public HealthRecord(int id, String type, String description){
        this.id = id;
        this.recordType = type;
        this.description = description;
    }

    public int getId(){
        return id;
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
