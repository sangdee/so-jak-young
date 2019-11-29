package com.cbnu.sjy_.core.model.entity;

import com.cbnu.sjy_.base.model.BaseEntity;

/**
 * @author : Sangji Lee
 * @when : 2019-11-28 오후 5:01
 * @homepage : https://github.com/sangji11
 */
public class TimeTableItem extends BaseEntity {
    private String time, seat;

    public TimeTableItem(String time, String seat) {
        this.time = time;
        this.seat = seat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
