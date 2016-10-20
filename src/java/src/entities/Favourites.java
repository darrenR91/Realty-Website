/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darre
 */
@Entity
@Table(name = "favourites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favourites.findAll", query = "SELECT f FROM Favourites f"),
    @NamedQuery(name = "Favourites.findById", query = "SELECT f FROM Favourites f WHERE f.id = :id"),
    
    @NamedQuery(name = "Favourites.cleanDB", query = "Delete from Favourites where dateCreated < (NOW() - INTERVAL 168 DAY_HOUR)"),
    
    @NamedQuery(name = "Favourites.findByDateCreated", query = "SELECT f FROM Favourites f WHERE f.dateCreated = :dateCreated")})

    
public class Favourites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "favouritesList")
    private String favouritesList;
    @Basic(optional = false)
    @Column(name = "dateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    public Favourites() {
    }

    public Favourites(Integer id) {
        this.id = id;
    }

    public Favourites(Integer id, String name, String favouritesList, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.favouritesList = favouritesList;
        this.dateCreated = dateCreated;
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

    public String getFavouritesList() {
        return favouritesList;
    }

    public void setFavouritesList(String favouritesList) {
        this.favouritesList = favouritesList;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
        if (!(object instanceof Favourites)) {
            return false;
        }
        Favourites other = (Favourites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Favourites[ id=" + id + " ]";
    }
    
}
