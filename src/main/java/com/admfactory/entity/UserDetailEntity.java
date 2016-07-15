package com.admfactory.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the user_detail database table.
 * 
 */
@Entity
@Table(name = "user_detail")
@NamedQuery(name = "UserDetailEntity.findAll", query = "SELECT u FROM UserDetailEntity u")
public class UserDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    private String city;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    public UserDetailEntity() {
    }

    public long getId() {
	return this.id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getAddress() {
	return this.address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getCity() {
	return this.city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public Date getCreated() {
	return this.created;
    }

    public void setCreated(Date created) {
	this.created = created;
    }

    public String getPhoneNumber() {
	return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
	return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }

    public Date getUpdated() {
	return this.updated;
    }

    public void setUpdated(Date updated) {
	this.updated = updated;
    }

}