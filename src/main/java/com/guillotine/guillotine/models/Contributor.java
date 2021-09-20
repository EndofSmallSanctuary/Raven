package com.guillotine.guillotine.models;

public class Contributor {

    User user;

    Label[] labels;

    Integer totalprs;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Label[] getLabels() {
        return labels;
    }

    public void setLabels(Label[] labels) {
        this.labels = labels;
    }

    public Integer getTotalprs() {
        return totalprs;
    }

    public void setTotalprs(Integer totalprs) {
        this.totalprs = totalprs;
    }
}
