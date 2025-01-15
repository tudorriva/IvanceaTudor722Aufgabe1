package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fallakten {

    int id;
    String name;
    String symptom;
    String diagnose;
    SimpleDateFormat date;
    String krankenhaus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public String getKrankenhaus() {
        return krankenhaus;
    }

    public void setKrankenhaus(String krankenhaus) {
        this.krankenhaus = krankenhaus;
    }

    public Fallakten(int id, String name, String symptom, String diagnose, SimpleDateFormat date, String krankenhaus) {
        this.id = id;
        this.name = name;
        this.symptom = symptom;
        this.diagnose = diagnose;
        this.date = date;
        this.krankenhaus = krankenhaus;
    }

    public Fallakten() {}
}
