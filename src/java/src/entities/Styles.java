/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darren
 */
@Entity
@Table(name = "styles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Styles.findAll", query = "SELECT s FROM Styles s"),
    @NamedQuery(name = "Styles.findByStyleId", query = "SELECT s FROM Styles s WHERE s.styleId = :styleId"),
    @NamedQuery(name = "Styles.findStyleTypeByTypeId", query = "SELECT s.propStyle FROM Styles s WHERE s.styleId = :styleId"),
    @NamedQuery(name = "Styles.findByPropStyle", query = "SELECT s FROM Styles s WHERE s.propStyle = :propStyle")})
public class Styles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "styleId")
    private Integer styleId;
    @Column(name = "propStyle")
    private String propStyle;

    public Styles() {
    }

    public Styles(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getPropStyle() {
        return propStyle;
    }

    public void setPropStyle(String propStyle) {
        this.propStyle = propStyle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (styleId != null ? styleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Styles)) {
            return false;
        }
        Styles other = (Styles) object;
        if ((this.styleId == null && other.styleId != null) || (this.styleId != null && !this.styleId.equals(other.styleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Styles[ styleId=" + styleId + " ]";
    }
    
}
