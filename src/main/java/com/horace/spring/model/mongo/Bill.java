package com.horace.spring.model.mongo;

import com.horace.spring.common.utils.DateUtil;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "tb_bill") // 集合名
public class Bill implements Serializable {
    @Id
    private String id; // MongoDB会自己生成ID
    private Date createTime;
    private Date editTime;
    private String title;
    private int total;
    private String first;
    private String last;
    private long amount;
    private float monthly;
    @Transient
    private int surplus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getSurplus() {
        String[] arr = this.first.split("-");
        int year = Integer.valueOf(arr[0]);
        int month = Integer.valueOf(arr[1]);
        Date startDate = DateUtil.newDate(year, month - 1, 1);
        this.surplus = this.total - DateUtil.howManyMonths(startDate, new Date());
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public float getMonthly() {
        return monthly;
    }

    public void setMonthly(float monthly) {
        this.monthly = monthly;
    }
}
