package com.denismarigakamara.compalinmanagementsystemv2.User.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonPK implements Serializable {
    private int heightCm;
    private String sockColor;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)return true;
        if (obj == null || getClass() !=obj.getClass())return false;

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
