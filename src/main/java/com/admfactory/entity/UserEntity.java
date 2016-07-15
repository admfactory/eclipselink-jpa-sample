package com.admfactory.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private String email;

    private String name;

    private String password;

    private long updated;

    // uni-directional one-to-one association to UserDetailEntity
    @OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private UserDetailEntity userDetail;

    public UserEntity() {
    }

    public long getId() {
	return this.id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Date getCreated() {
	return this.created;
    }

    public void setCreated(Date created) {
	this.created = created;
    }

    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public long getUpdated() {
	return this.updated;
    }

    public void setUpdated(long updated) {
	this.updated = updated;
    }

    public UserDetailEntity getUserDetail() {
	return this.userDetail;
    }

    public void setUserDetail(UserDetailEntity userDetail) {
	this.userDetail = userDetail;
    }

}