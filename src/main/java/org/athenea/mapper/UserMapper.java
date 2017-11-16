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
  @Select("SELECT * FROM USER")
  List<UserVO> getUsers();

  /**
   * Get user by email
   * @param email email of the User (primary key)
   * @return a single User
   */
  @Select("SELECT * FROM USER WHERE EMAIL = #{email}")
  UserVO getUserByEmail(@Param("email") String email);

  @Insert("INSERT INTO USER (`EMAIL`, `NAME`, `USERNAME`, `PASSWORD`, `PHONE_NUMBER`) VALUES (#{email}, #{name}, #{username}, #{password}, #{phone_number}); ")
  void insertUser(@Param("email") String email,
        @Param("name") String name,
        @Param("username") String username,
        @Param("password") String password,
        @Param("phone_number") int phone_number
      );
}
