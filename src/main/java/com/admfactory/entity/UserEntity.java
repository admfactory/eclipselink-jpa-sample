package com.admfactory.entity;

import javax.persistence.*;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String email;

    private String name;

    private String password;

    // uni-directional one-to-one association to UserDetailEntity
    @OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private UserDetailEntity userDetail;

    public UserEntity() {
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

    public UserDetailEntity getUserDetail() {
	return this.userDetail;
    }

    public void setUserDetail(UserDetailEntity userDetail) {
	this.userDetail = userDetail;
    }

}