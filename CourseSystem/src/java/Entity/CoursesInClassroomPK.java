/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ASUS
 */
@Embeddable
public class CoursesInClassroomPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "courses_CNO")
    private String coursesCNO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "classroom_ID")
    private String classroomID;

    public CoursesInClassroomPK() {
    }

    public CoursesInClassroomPK(String coursesCNO, String classroomID) {
        this.coursesCNO = coursesCNO;
        this.classroomID = classroomID;
    }

    public String getCoursesCNO() {
        return coursesCNO;
    }

    public void setCoursesCNO(String coursesCNO) {
        this.coursesCNO = coursesCNO;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursesCNO != null ? coursesCNO.hashCode() : 0);
        hash += (classroomID != null ? classroomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoursesInClassroomPK)) {
            return false;
        }
        CoursesInClassroomPK other = (CoursesInClassroomPK) object;
        if ((this.coursesCNO == null && other.coursesCNO != null) || (this.coursesCNO != null && !this.coursesCNO.equals(other.coursesCNO))) {
            return false;
        }
        if ((this.classroomID == null && other.classroomID != null) || (this.classroomID != null && !this.classroomID.equals(other.classroomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CoursesInClassroomPK[ coursesCNO=" + coursesCNO + ", classroomID=" + classroomID + " ]";
    }
    
}
