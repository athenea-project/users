package org.athenea.dao;

/**
 * User model class
 */
public class UserVO {

  private String email;   // primary key
  private String password;
  private String name;
  private String username;
  private int phone_number;

  public UserVO(String email, String password, String name) {
    this.email = email;
    this.password = password;
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(int phone_number) {
    this.phone_number = phone_number;
  }
}
