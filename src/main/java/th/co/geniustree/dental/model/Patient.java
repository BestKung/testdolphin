/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Best
 */
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String hn;
    private String pid;
    private String name;
    
    @Column(name="BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String sex;
    private String blood;
    private String nation;
    private String race;
    private String address;
    private String tel;
    private String mobile;
    private String job;
    private String email;
    
    @ManyToMany
    private List<MedicalHistory> medicalHistory;

    @OneToOne(cascade = CascadeType.ALL)
   private PatientPictureXray patientPictureXray;
   
    @OneToOne(cascade = CascadeType.ALL)
    private PatientPictureBefore patientPictureBefore;
    
    @OneToOne(cascade = CascadeType.ALL)
    private PatientPictureCurrent patientPictureCurrent;
    
    @OneToOne(cascade = CascadeType.ALL)
    private PatientPictureAfter patientPictureAfter;

    @OneToMany(mappedBy = "patient" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DetailHeal> detailHeals;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHn() {
        return hn;
    }

    public void setHn(String hn) {
        this.hn = hn;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MedicalHistory> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<MedicalHistory> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public PatientPictureXray getPatientPictureXray() {
        return patientPictureXray;
    }

    public void setPatientPictureXray(PatientPictureXray patientPictureXray) {
        this.patientPictureXray = patientPictureXray;
    }

    public PatientPictureBefore getPatientPictureBefore() {
        return patientPictureBefore;
    }

    public void setPatientPictureBefore(PatientPictureBefore patientPictureBefore) {
        this.patientPictureBefore = patientPictureBefore;
    }

    public PatientPictureCurrent getPatientPictureCurrent() {
        return patientPictureCurrent;
    }

    public void setPatientPictureCurrent(PatientPictureCurrent patientPictureCurrent) {
        this.patientPictureCurrent = patientPictureCurrent;
    }

    public PatientPictureAfter getPatientPictureAfter() {
        return patientPictureAfter;
    }

    public void setPatientPictureAfter(PatientPictureAfter patientPictureAfter) {
        this.patientPictureAfter = patientPictureAfter;
    }

    public List<DetailHeal> getDetailHeals() {
        return detailHeals;
    }

    public void setDetailHeals(List<DetailHeal> detailHeals) {
        this.detailHeals = detailHeals;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
   
}
