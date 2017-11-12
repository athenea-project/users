package org.athenea.mapper;

import java.util.List;
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
  @Select("SELECT * FROM USERS")
  List<UserVO> getUsers();

  /**
   * Get user by email
   * @param email email of the User (primary key)
   * @return a single User
   */
  @Select("SELECT * FROM USERS WHERE EMAIL = #{email}")
  UserVO getUserByEmail(@Param("email") String email);
}
