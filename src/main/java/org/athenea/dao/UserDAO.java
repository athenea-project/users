package org.athenea.dao;

import java.util.List;

/**
 * UserDAO
 */
public interface UserDAO {

  /**
   * Get a single User by his/her email (primary key)
   * @param email primary  key of the user
   * @return a single USer
   */
  UserVO findUserById(String email);

  /**
   * Get all Users
   * @return list with every User
   */
  List<UserVO> findAllUsers();

  /**
   * Insert a user into DB
   * @param email
   * @param name
   * @param username
   * @param password
   * @param phone_number
   */
  void insertUser(String email,
      String name,
      String username,
      String password,
      int phone_number);

}
