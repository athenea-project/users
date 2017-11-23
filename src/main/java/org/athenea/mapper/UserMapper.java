package org.athenea.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.athenea.dao.UserVO;

/**
 * User mapper class for Spring and MyBatis
 */
public interface UserMapper {

  /**
   * Get all Users
   * @return every user in a List
   */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USER")
  List<UserVO> getUsers();

  /**
   * Get user by email
   * @param email email of the User (primary key)
   * @return a single User
   */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USER WHERE EMAIL = #{email}")
  UserVO getUserByEmail(@Param("email") String email);
  
  /**
   * Get user by email
   * @param email email of the User (primary key)
   * @return a single User
   */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USER WHERE USERNAME = #{username}")
  UserVO getUserByUsername(@Param("username") String username);

  /**
   * Get user by name
   * @param name name of the User 
   * @return a single User
   */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USER WHERE NAME = #{name}")
  List<UserVO> getUserByName(@Param("name") String name);

  /** 
  * Get user by phone number
  * @param phoneNumber phone number of the User
  * @return a single User
  */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USER WHERE PHONE_NUMBER = #{phone_number}")
  UserVO getUserByPhoneNumber(@Param("phone_number") int phoneNumber);

  /**
   * Insert user into DB
   * @param email
   * @param name
   * @param username
   * @param password
   * @param phone_number
   */
  @Insert("INSERT INTO USER (EMAIL, NAME, USERNAME, PASSWORD, PHONE_NUMBER) VALUES (#{email}, #{name}, #{username}, #{password}, #{phone_number})")
  void insertUser(@Param("email") String email, @Param("name") String name, @Param("username") String username,
      @Param("password") String password, @Param("phone_number") int phone_number);
}
