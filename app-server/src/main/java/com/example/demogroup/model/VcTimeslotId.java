package com.example.demogroup.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VcTimeslotId implements Serializable {

    private static final long serialVersionUID = -7832727072690695797L;
    @Column(name = "vc_code", nullable = false)
    private Integer vcCode;

    @Column(name = "ts_code", nullable = false)
    private Integer tsCode;

    public Integer getVcCode() {
        return vcCode;
    }

    public void setVcCode(Integer vcCode) {
        this.vcCode = vcCode;
    }

    public Integer getTsCode() {
        return tsCode;
    }

    public void setTsCode(Integer tsCode) {
        this.tsCode = tsCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VcTimeslotId entity = (VcTimeslotId) o;
        return Objects.equals(this.vcCode, entity.vcCode) &&
                Objects.equals(this.tsCode, entity.tsCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vcCode, tsCode);
    }

}