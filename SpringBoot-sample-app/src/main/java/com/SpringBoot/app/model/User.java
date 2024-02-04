package com.SpringBoot.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
     
    private User(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.password = builder.password;
    }
    
    public User() {
		// TODO Auto-generated constructor stub
	}

	public static class Builder {
        private String name;
        private Long id;
        private String password;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
