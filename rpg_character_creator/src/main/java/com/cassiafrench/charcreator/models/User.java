package com.cassiafrench.charcreator.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="mm-dd-yyyy")
    private Date createdAt;
	@DateTimeFormat(pattern="mm-dd-yyyy")
    private Date updatedAt;
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private List<Chara> characters;
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
    
    @NotEmpty(message="Must input a username!")
	@Size(min=3, max=255, message="Username must be at least 2 characters and less than 255 characters!")
	private String username;
	
	@NotEmpty(message="Must input an email!")
	@Email(message="Email is not in a proper format!")
	private String email;
	
	@NotEmpty(message="Must input a password!")
	@Size(min=8, max=255, message="Password must be between 8 and 255 characters!")
	private String password;
	
	@Transient
	@NotEmpty(message="Must input password twice to confirm!")
	@Size(min=8, max=255, message="Password must be between 8 and 255 characters!")
	private String confirmPassword;
    
	public User() {}
	
	
	public User(List<Chara> characters, Role role,
			@NotEmpty(message = "Must input a username!") @Size(min = 3, max = 255, message = "Username must be at least 2 characters and less than 255 characters!") String username,
			@NotEmpty(message = "Must input an email!") @Email(message = "Email is not in a proper format!") String email,
			@NotEmpty(message = "Must input a password!") @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters!") String password,
			@NotEmpty(message = "Must input password twice to confirm!") @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters!") String confirmPassword) {
		super();
		this.characters = characters;
		this.role = role;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Chara> getCharacters() {
		return characters;
	}
	public void setCharacters(List<Chara> characters) {
		this.characters = characters;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}