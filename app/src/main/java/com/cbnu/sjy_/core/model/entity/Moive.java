package com.cbnu.sjy_.core.model.entity;

import com.cbnu.sjy_.base.model.BaseEntity;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오전 12:31
 * @homepage : https://github.com/sangji11
 */
public class Moive extends BaseEntity {
    private String name;
    private String directors;
    private String companys;
    private String stroy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getCompanys() {
        return companys;
    }

    public void setCompanys(String companys) {
        this.companys = companys;
    }

    public String getStroy() {
        return stroy;
    }

    public void setStroy(String stroy) {
        this.stroy = stroy;
    }
}
