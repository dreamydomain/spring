package com.horace.spring.model;

import com.horace.spring.common.utils.StringUtil;

import javax.persistence.Id;
import java.util.Date;

public class BaseModel {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
