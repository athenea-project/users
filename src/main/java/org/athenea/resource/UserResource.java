package org.athenea.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.athenea.dao.UserDAO;
import org.athenea.dao.UserVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class to obtain User objects.
 */
@Path("/user")
@Api(value = "user", description = "Retrieve users.")
public class UserResource {

  private static final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");   // Application context to load Spring

  private static final UserDAO userDAO = (UserDAO) context.getBean("userDAO");    // User bean to work with

  /**
   * Get all users from DB.
   *
   * @return a List containing all users.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/all")
  @ApiResponses(value = {@ApiResponse(code = 500, message = "Error when connecting to server."),
      @ApiResponse(code = 404, message = "No user found")})
  @ApiOperation(value = "Returns all users.",
      response = UserVO.class)
  public List<UserVO> getAll() {

    return userDAO.findAllUsers();
  }

  /**
   * Get user from an email
   *
   * @param email primary key in DB
   * @return a User object
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/email")
  @ApiResponses(value = {@ApiResponse(code = 500, message = "Error when connecting to server."),
      @ApiResponse(code = 404, message = "No user found")})
  @ApiOperation(value = "Returns all users.",
      response = UserVO.class)
  public UserVO getUserByEmail(@HeaderParam("email") String email) {

    return userDAO.findUserById(email);
  }


}
