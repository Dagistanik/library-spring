package com.library.project.products;

import com.library.project.random.MothsOfYear;

import java.util.Objects;

public class Periodical extends Publication{
    public String month;

    private SubscriptionType subscriptionType=SubscriptionType.UNKNOWN;


    public Periodical(int id, String title, MothsOfYear month){
        super(id, title);
        this.month = String.valueOf(month);
    }

    public String getMonth() { return month; }

    public SubscriptionType getType() { return subscriptionType; }

    public void setType(SubscriptionType type){this.subscriptionType=type;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Periodical periodical = (Periodical) o;
        return this.month.equals(periodical.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month);
    }

    @Override
    public String toString() {
        return "Periodical{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", month='" + month + '\'' +
                '}';
    }

    public enum SubscriptionType{
        UNKNOWN,
        COMMERCIAL,
        NON_PROFIT,
    }
}
