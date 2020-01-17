package org.papaja.adminfly.module.psy.database.entity.results;

import org.papaja.adminfly.commons.dao.entity.api.AbstractEntity;
import org.papaja.adminfly.module.psy.database.entity.Patient;
import org.papaja.adminfly.module.psy.tests.Test;

import javax.persistence.*;

import java.util.Objects;

import static java.lang.String.format;

@Entity
@Table(name = "PSY_RESULTS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TEST")
public abstract class Result extends AbstractEntity {

    @Column(name = "TEST", columnDefinition = "VARCHAR(16)", nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Test test;

    @Column(name = "UNIQUE_ID")
    private String uniqueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Test getTest() {
        return test;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Boolean isNew() {
        return Objects.isNull(getId());
    }

    public Boolean isOld() {
        return !isNew();
    }

    @Override
    public String toString() {
        return format("Results{test=%s, patient=%s}", test, patient);
    }
}