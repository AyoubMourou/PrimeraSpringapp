package com.example.PrimeraAppSpring.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6396066457369908309L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long Id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String username;
	
	@Column
	private String password;
	
	@Transient
	private String confirmPassword;
	
	/* utilizamos SET y no LIST para controlar que no se repita ningun valor */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	public User() {
		
	}	
	
	public User(Long id) {
		super();
		Id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, email, firstName, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	
}
