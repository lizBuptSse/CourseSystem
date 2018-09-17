/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "courses_in_classroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoursesInClassroom.findAll", query = "SELECT c FROM CoursesInClassroom c")
    , @NamedQuery(name = "CoursesInClassroom.findByCoursesCNO", query = "SELECT c FROM CoursesInClassroom c WHERE c.coursesInClassroomPK.coursesCNO = :coursesCNO")
    , @NamedQuery(name = "CoursesInClassroom.findByClassroomID", query = "SELECT c FROM CoursesInClassroom c WHERE c.coursesInClassroomPK.classroomID = :classroomID")
    , @NamedQuery(name = "CoursesInClassroom.findByTimeno", query = "SELECT c FROM CoursesInClassroom c WHERE c.timeno = :timeno")
    , @NamedQuery(name = "CoursesInClassroom.findByWeekno", query = "SELECT c FROM CoursesInClassroom c WHERE c.weekno = :weekno")})
public class CoursesInClassroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoursesInClassroomPK coursesInClassroomPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIMENO")
    private int timeno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEEKNO")
    private int weekno;
    @JoinColumn(name = "classroom_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Classroom classroom;
    @JoinColumn(name = "courses_CNO", referencedColumnName = "CNO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Courses courses;

    public CoursesInClassroom() {
    }

    public CoursesInClassroom(CoursesInClassroomPK coursesInClassroomPK) {
        this.coursesInClassroomPK = coursesInClassroomPK;
    }

    public CoursesInClassroom(CoursesInClassroomPK coursesInClassroomPK, int timeno, int weekno) {
        this.coursesInClassroomPK = coursesInClassroomPK;
        this.timeno = timeno;
        this.weekno = weekno;
    }

    public CoursesInClassroom(String coursesCNO, String classroomID) {
        this.coursesInClassroomPK = new CoursesInClassroomPK(coursesCNO, classroomID);
    }

    public CoursesInClassroomPK getCoursesInClassroomPK() {
        return coursesInClassroomPK;
    }

    public void setCoursesInClassroomPK(CoursesInClassroomPK coursesInClassroomPK) {
        this.coursesInClassroomPK = coursesInClassroomPK;
    }

    public int getTimeno() {
        return timeno;
    }

    public void setTimeno(int timeno) {
        this.timeno = timeno;
    }

    public int getWeekno() {
        return weekno;
    }

    public void setWeekno(int weekno) {
        this.weekno = weekno;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursesInClassroomPK != null ? coursesInClassroomPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoursesInClassroom)) {
            return false;
        }
        CoursesInClassroom other = (CoursesInClassroom) object;
        if ((this.coursesInClassroomPK == null && other.coursesInClassroomPK != null) || (this.coursesInClassroomPK != null && !this.coursesInClassroomPK.equals(other.coursesInClassroomPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CoursesInClassroom[ coursesInClassroomPK=" + coursesInClassroomPK + " ]";
    }
    
}
