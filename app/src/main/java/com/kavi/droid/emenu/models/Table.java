package com.kavi.droid.emenu.models;

/**
 * Created by kavi707 on 9/24/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */

public class Table {

    private String tableUUID;
    private String id;
    private String number;
    private int status;

    public String getTableUUID() {
        return tableUUID;
    }

    public void setTableUUID(String tableUUID) {
        this.tableUUID = tableUUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
