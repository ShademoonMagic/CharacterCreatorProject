package com.cassiafrench.charcreator.models;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="characters")
public class Chara {
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
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @NotBlank(message="Please give your character a name!")
    @Size(min=2, max=255, message="Name must be between 2 and 255 characters!")
    private String name;
    
    @NotNull(message="Must provide age of your character!")
    @PositiveOrZero(message="Age cannot be a negative number!")
    private Integer age;
    
    @NotBlank(message="Please select a class!")
    private String charaClass;
    
    @NotBlank(message="Please provide a brief description of your character!")
    @Size(min=2, max=255, message="Description must be between 2 and 255 characters!")
    private String description;
    
    @NotBlank(message="Please provide a brief backstory for your character!")
    @Size(min=2, max=255, message="Backstory must be between 2 and 255 characters!")
    private String backstory;
    
    private Integer level;

	public Chara() {}
	
	
	public Chara(User user,
			@NotBlank(message = "Please give your character a name!") @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters!") String name,
			@NotNull(message = "Must provide age of your character!") @PositiveOrZero(message = "Age cannot be a negative number!") Integer age,
			@NotBlank(message = "Please select a class!") String charaClass,
			@NotBlank(message = "Please provide a brief description of your character!") @Size(min = 2, max = 255, message = "Description must be between 2 and 255 characters!") String description,
			@NotBlank(message = "Please provide a brief backstory for your character!") @Size(min = 2, max = 255, message = "Backstory must be between 2 and 255 characters!") String backstory,
			Integer level) {
		super();
		this.user = user;
		this.name = name;
		this.age = age;
		this.charaClass = charaClass;
		this.description = description;
		this.backstory = backstory;
		this.level = level;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCharaClass() {
		return charaClass;
	}
	public void setCharaClass(String charaClass) {
		this.charaClass = charaClass;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBackstory() {
		return backstory;
	}
	public void setBackstory(String backstory) {
		this.backstory = backstory;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
}
