/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author ASUS
 */
@Entity
@Table(name = "classroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classroom.findAll", query = "SELECT c FROM Classroom c")
    , @NamedQuery(name = "Classroom.findById", query = "SELECT c FROM Classroom c WHERE c.id = :id")
    , @NamedQuery(name = "Classroom.findByClno", query = "SELECT c FROM Classroom c WHERE c.clno = :clno")})
public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CLNO")
    private String clno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classroom")
    private Collection<CoursesInClassroom> coursesInClassroomCollection;

    public Classroom() {
    }

    public Classroom(String id) {
        this.id = id;
    }

    public Classroom(String id, String clno) {
        this.id = id;
        this.clno = clno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClno() {
        return clno;
    }

    public void setClno(String clno) {
        this.clno = clno;
    }

    @XmlTransient
    public Collection<CoursesInClassroom> getCoursesInClassroomCollection() {
        return coursesInClassroomCollection;
    }

    public void setCoursesInClassroomCollection(Collection<CoursesInClassroom> coursesInClassroomCollection) {
        this.coursesInClassroomCollection = coursesInClassroomCollection;
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
        if (!(object instanceof Classroom)) {
            return false;
        }
        Classroom other = (Classroom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Classroom[ id=" + id + " ]";
    }
    
}
