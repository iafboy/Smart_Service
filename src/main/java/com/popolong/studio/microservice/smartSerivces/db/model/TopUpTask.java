package com.popolong.studio.microservice.smartSerivces.db.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class TopUpTask implements Serializable {
    private static final long serialVersionUID = -3649188071950755323L;
    private String TaskUUID;
    private String CardID;
    private String MAC1;
    private String MAC2;
    private String RTC;
    private int TaskStatus=0;//0:created; 1:payment success ; 2:payment fail; 3:topup APDU ready; 4:topup APDU sent; 5:topup APDU execute failed ; 6:topup APDU excute success ; 10:task success
    private Timestamp TaskCreateTime;
    private Timestamp TaskUpdateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTaskUUID() {
        return TaskUUID;
    }

    public void setTaskUUID(String taskUUID) {
        TaskUUID = taskUUID;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public String getMAC1() {
        return MAC1;
    }

    public void setMAC1(String MAC1) {
        this.MAC1 = MAC1;
    }

    public String getMAC2() {
        return MAC2;
    }

    public void setMAC2(String MAC2) {
        this.MAC2 = MAC2;
    }

    public String getRTC() {
        return RTC;
    }

    public void setRTC(String RTC) {
        this.RTC = RTC;
    }

    public int getTaskStatus() {
        return TaskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        TaskStatus = taskStatus;
    }

    public Timestamp getTaskCreateTime() {
        return TaskCreateTime;
    }

    public void setTaskCreateTime(Timestamp taskCreateTime) {
        TaskCreateTime = taskCreateTime;
    }

    public Timestamp getTaskUpdateTime() {
        return TaskUpdateTime;
    }

    public void setTaskUpdateTime(Timestamp taskUpdateTime) {
        TaskUpdateTime = taskUpdateTime;
    }
    public String toString(){
        return "Task: "+TaskUUID+" [ CardID: "+CardID+" ] "+" [ MAC1: "+MAC1+" ] "+" [ MAC2: "+MAC2+" ] "+" [ RTC: "+RTC+" ] "+" [ TaskStatus: "+TaskStatus+" ] ";
    }
}
