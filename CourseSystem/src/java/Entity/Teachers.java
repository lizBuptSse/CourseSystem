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
@Table(name = "teachers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teachers.findAll", query = "SELECT t FROM Teachers t")
    , @NamedQuery(name = "Teachers.findByTno", query = "SELECT t FROM Teachers t WHERE t.tno = :tno")
    , @NamedQuery(name = "Teachers.findByTname", query = "SELECT t FROM Teachers t WHERE t.tname = :tname")
    , @NamedQuery(name = "Teachers.findByTpassword", query = "SELECT t FROM Teachers t WHERE t.tpassword = :tpassword")})
public class Teachers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "TNO")
    private String tno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TNAME")
    private String tname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TPASSWORD")
    private String tpassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teachersTNO")
    private Collection<Courses> coursesCollection;

    public Teachers() {
    }

    public Teachers(String tno) {
        this.tno = tno;
    }

    public Teachers(String tno, String tname, String tpassword) {
        this.tno = tno;
        this.tname = tname;
        this.tpassword = tpassword;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    @XmlTransient
    public Collection<Courses> getCoursesCollection() {
        return coursesCollection;
    }

    public void setCoursesCollection(Collection<Courses> coursesCollection) {
        this.coursesCollection = coursesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tno != null ? tno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teachers)) {
            return false;
        }
        Teachers other = (Teachers) object;
        if ((this.tno == null && other.tno != null) || (this.tno != null && !this.tno.equals(other.tno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Teachers[ tno=" + tno + " ]";
    }
    
}
