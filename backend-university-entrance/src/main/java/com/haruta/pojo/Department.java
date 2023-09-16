/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findById", query = "SELECT d FROM Department d WHERE d.id = :id"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByWebsite", query = "SELECT d FROM Department d WHERE d.website = :website"),
    @NamedQuery(name = "Department.findByVideo", query = "SELECT d FROM Department d WHERE d.video = :video"),
    @NamedQuery(name = "Department.findByAverageScore", query = "SELECT d FROM Department d WHERE d.averageScore = :averageScore")})
public class Department implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "video")
    private String video;
    @Basic(optional = false)
    @NotNull
    @Column(name = "average_score")
    private float averageScore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    
    @JsonIgnore
    private Set<Major> majorSet;
    @OneToMany(mappedBy = "deparmentId")
    @JsonIgnore
    private Set<Recruitment> recruitmentSet;
    @JoinColumn(name = "cateid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Category cateid;

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Department(Integer id, String name, String description, String website, String video, float averageScore) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.website = website;
        this.video = video;
        this.averageScore = averageScore;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    @XmlTransient
    public Set<Major> getMajorSet() {
        return majorSet;
    }

    public void setMajorSet(Set<Major> majorSet) {
        this.majorSet = majorSet;
    }

    @XmlTransient
    public Set<Recruitment> getRecruitmentSet() {
        return recruitmentSet;
    }

    public void setRecruitmentSet(Set<Recruitment> recruitmentSet) {
        this.recruitmentSet = recruitmentSet;
    }

    public Category getCateid() {
        return cateid;
    }

    public void setCateid(Category cateid) {
        this.cateid = cateid;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.haruta.pojo.Department[ id=" + id + " ]";
    }
    
}
