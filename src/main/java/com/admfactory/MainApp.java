package com.admfactory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.admfactory.entity.UserDetailEntity;
import com.admfactory.entity.UserEntity;

public class MainApp {

    public static final String PERSISTENCE_UNIT = "db";
    private static EntityManager em;

    /**
     * 
     * List to console all the users using NamedQuery
     *
     */
    public static void listAll() {
	Query queryAll = em.createNamedQuery("UserEntity.findAll");
	List<UserEntity> users = queryAll.getResultList();
	for (int i = 0; i < users.size(); i++) {
	    System.out.println("===========================");
	    UserEntity user = users.get(i);
	    System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail() + " " + user.getPassword());

	    UserDetailEntity details = user.getUserDetail();
	    System.out.println(details.getId() + " " + details.getAddress() + " " + details.getCity() + " "
		    + details.getPhoneNumber() + " " + details.getPostalCode());

	    System.out.println("===========================");
	}
    }

    /**
     * 
     * insert a new user
     * 
     * @param name
     * @param email
     * @param password
     * @param address
     * @param city
     * @param phone
     * @param code
     */
    public static void insertUser(String name, String email, String password, String address, String city, String phone,
	    String code) {

	EntityTransaction tx = em.getTransaction();
	tx.begin();

	UserEntity user = new UserEntity();
	user.setEmail(email);
	user.setName(name);
	user.setPassword(password);

	UserDetailEntity details = new UserDetailEntity();
	details.setAddress(address);
	details.setCity(city);
	details.setPhoneNumber(phone);
	details.setPostalCode(code);
	user.setUserDetail(details);
	em.persist(user);
	tx.commit();
    }

    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	em = emf.createEntityManager();

	/** insert some data */
	insertUser("User 1", "user1@admfactory.com", "aaa", "address 1", "city 1", "12345", "WS3 2SD");
	insertUser("User 2", "user2@admfactory.com", "bbb", "address 2", "city 2", "6789", "TY6 7PA");

	/** list some data */
	listAll();

	em.close();
    }

}
