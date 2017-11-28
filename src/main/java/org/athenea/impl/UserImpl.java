package org.athenea.impl;

import java.util.List;
import org.athenea.dao.UserDAO;
import org.athenea.dao.UserVO;
import org.athenea.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Implementation for User class to get Users from DB
 */
public class UserImpl implements UserDAO {

  /**
   * Automap user mapper
   */
  @Autowired
  private UserMapper userMapper;  // Autowired mapper from Spring

  /**
   * Get an user from an email
   *
   * @param email of the User (primary key)
   * @return a UserVO
   */
  @Override
  public UserVO findUserById(String email) {
    return userMapper.getUserByEmail(email);
  }

    /**
   * Get an user from an email
   *
   * @param email of the User (primary key)
   * @return a UserVO
   */
  @Override
  public UserVO findUserByUsername(String username) {
    return userMapper.getUserByUsername(username);
  }

    /**
   * Get an user from an email
   *
   * @param email of the User (primary key)
   * @return a UserVO
   */
  @Override
  public UserVO findUserByPhoneNumber(int number) {
    return userMapper.getUserByPhoneNumber(number);
  }

    /**
   * Get an user from an email
   *
   * @param email of the User (primary key)
   * @return a UserVO
   */
  @Override
  public List<UserVO> findUserByName(String name) {
    return userMapper.getUserByName(name);
  }

  /**
   * Get all Users from DB
   *
   * @return a List of UserVO
   */
  @Override
  public List<UserVO> findAllUsers() {
    return userMapper.getUsers();
  }

  /**
   * Inserr user into DB
   */
  @Override
  public void insertUser(String email, String name, String username, String password,
      int phone_number) {
      userMapper.insertUser(email, name, username, password, phone_number);
  }

  @Override
  public UserVO findUserByUsernamePass(String username, String password) {
	  return userMapper.getUserByUsernamePass(username, password);
  }
}
