package me.fit.models;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class IPLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iplog_seq")
    private Long id;

    private String ipString;
    private String ipType;
    private Date createdDate;

    @ManyToOne
    private AppUser user;

    public IPLog() {
        super();
    }

    public IPLog(String ipString, String ipType, Date createdDate, AppUser user) {
        super();
        this.ipString = ipString;
        this.ipType = ipType;
        this.createdDate = createdDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpString() {
        return ipString;
    }

    public void setIpString(String ipString) {
        this.ipString = ipString;
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ipString == null) ? 0 : ipString.hashCode());
        result = prime * result + ((ipType == null) ? 0 : ipType.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IPLog other = (IPLog) obj;
        if (createdDate == null) {
            if (other.createdDate != null)
                return false;
        } else if (!createdDate.equals(other.createdDate))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ipString == null) {
            if (other.ipString != null)
                return false;
        } else if (!ipString.equals(other.ipString))
            return false;
        if (ipType == null) {
            if (other.ipType != null)
                return false;
        } else if (!ipType.equals(other.ipType))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IPLog [id=" + id + ", ipString=" + ipString + ", ipType=" + ipType + ", createdDate=" + createdDate
                + ", user=" + user + "]";
    }
}
