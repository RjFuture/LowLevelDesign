package model;

import java.util.Date;

public class BaseEntity {

    private int id;
    private Date createdAt;
    private Date updatedAt;

    public int getId() {
        return id;
    }
}
