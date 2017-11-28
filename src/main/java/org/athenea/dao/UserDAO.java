package org.athenea.dao;

import java.util.List;

/**
 * UserDAO
 */
public interface UserDAO {

  /**
   * Get a single User by his/her email (primary key)
   * @param email primary  key of the user
   * @return a single User
   */
  UserVO findUserById(String email);

  /**
   * Get a single User by his/her username
   * @param username username of the User
   * @return a single User
   */
  UserVO findUserByUsername(String username);

  List<UserVO> findUserByName(String name);

  UserVO findUserByPhoneNumber(int phone_number);

  UserVO findUserByUsernamePass(String username, String password);
  

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
