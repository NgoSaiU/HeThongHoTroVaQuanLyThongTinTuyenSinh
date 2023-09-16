/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "livestream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livestream.findAll", query = "SELECT l FROM Livestream l"),
    @NamedQuery(name = "Livestream.findById", query = "SELECT l FROM Livestream l WHERE l.id = :id"),
    @NamedQuery(name = "Livestream.findByName", query = "SELECT l FROM Livestream l WHERE l.name = :name"),
    @NamedQuery(name = "Livestream.findByStartDate", query = "SELECT l FROM Livestream l WHERE l.startDate = :startDate"),
    @NamedQuery(name = "Livestream.findByStartTime", query = "SELECT l FROM Livestream l WHERE l.startTime = :startTime")})


@JsonIgnoreProperties(value = {
    "questionSet",
    "recruitmentId"
})
public class Livestream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livestreamId")
    private Set<Question> questionSet;
    @JoinColumn(name = "recruitment_id", referencedColumnName = "id")
    @ManyToOne
    private Recruitment recruitmentId;

    public Livestream() {
    }

    public Livestream(Integer id) {
        this.id = id;
    }

    public Livestream(Integer id, String name, String description, Date startDate, Date startTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @XmlTransient
    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    public Recruitment getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(Recruitment recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livestream)) {
            return false;
        }
        Livestream other = (Livestream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.haruta.pojo.Livestream[ id=" + id + " ]";
    }
    
}
