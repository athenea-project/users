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

}
