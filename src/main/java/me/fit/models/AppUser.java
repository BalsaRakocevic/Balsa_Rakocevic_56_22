package me.fit.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "app_user")
@NamedQueries({ @NamedQuery(name = AppUser.GET_ALL_USERS, query = "Select u from AppUser u"),
@NamedQuery(name = AppUser.GET_USERS_BY_NAME, query = "Select u from AppUser u where u.username = :name") })
public class AppUser {



	public static String getAllUsers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	public static final String GET_ALL_USERS = "getAllUsers";
	public static final String GET_USERS_BY_NAME = "getUsersByName";

    private String username;
    private String email;
    private String password;
    private String filePath;

    public AppUser() {
        super();
    }

    public AppUser(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }
    


	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private IPLog ipLog;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Product> products;

public Set<Product> getProducts() {
    return products;
}

public void setProducts(Set<Product> products) {
    this.products = products;
}
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	public IPLog getIpLog() {
		return ipLog;
	}

	public void setIpLog(IPLog ipLog) {
		this.ipLog = ipLog;
	}

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        AppUser other = (AppUser) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
    }

    

}
