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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author ASUS
 */
@Entity
@Table(name = "courses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courses.findAll", query = "SELECT c FROM Courses c")
    , @NamedQuery(name = "Courses.findByCno", query = "SELECT c FROM Courses c WHERE c.cno = :cno")
    , @NamedQuery(name = "Courses.findByCname", query = "SELECT c FROM Courses c WHERE c.cname = :cname")
    , @NamedQuery(name = "Courses.findByLeftnum", query = "SELECT c FROM Courses c WHERE c.leftnum = :leftnum")
    , @NamedQuery(name = "Courses.findByCkind", query = "SELECT c FROM Courses c WHERE c.ckind = :ckind")})
public class Courses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CNO")
    private String cno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CNAME")
    private String cname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEFTNUM")
    private int leftnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CKIND")
    private int ckind;
    @JoinTable(name = "students_study_courses", joinColumns = {
        @JoinColumn(name = "courses_CNO", referencedColumnName = "CNO")}, inverseJoinColumns = {
        @JoinColumn(name = "students_SNO", referencedColumnName = "SNO")})
    @ManyToMany
    private Collection<Students> studentsCollection;
    @JoinColumn(name = "teachers_TNO", referencedColumnName = "TNO")
    @ManyToOne(optional = false)
    private Teachers teachersTNO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private Collection<CoursesInClassroom> coursesInClassroomCollection;

    public Courses() {
    }

    public Courses(String cno) {
        this.cno = cno;
    }

    public Courses(String cno, String cname, int leftnum, int ckind) {
        this.cno = cno;
        this.cname = cname;
        this.leftnum = leftnum;
        this.ckind = ckind;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getLeftnum() {
        return leftnum;
    }

    public void setLeftnum(int leftnum) {
        this.leftnum = leftnum;
    }

    public int getCkind() {
        return ckind;
    }

    public void setCkind(int ckind) {
        this.ckind = ckind;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    public Teachers getTeachersTNO() {
        return teachersTNO;
    }

    public void setTeachersTNO(Teachers teachersTNO) {
        this.teachersTNO = teachersTNO;
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
        hash += (cno != null ? cno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.cno == null && other.cno != null) || (this.cno != null && !this.cno.equals(other.cno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Courses[ cno=" + cno + " ]";
    }
    
}
