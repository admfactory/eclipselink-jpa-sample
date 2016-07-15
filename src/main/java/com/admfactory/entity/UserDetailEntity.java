package com.admfactory.entity;

import javax.persistence.*;

/**
 * The persistent class for the user_detail database table.
 * 
 */
@Entity
@Table(name = "user_detail")
@NamedQuery(name = "UserDetailEntity.findAll", query = "SELECT u FROM UserDetailEntity u")
public class UserDetailEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String address;

    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "postal_code")
    private String postalCode;


    public UserDetailEntity() {
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

}
