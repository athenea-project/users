package org.athenea.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

  private static final ApplicationContext context = new ClassPathXmlApplicationContext(
      "applicationContext.xml");   // Application context to load Spring

  private static final UserDAO userDAO = (UserDAO) context
      .getBean("userDAO");    // User bean to work with

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


  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/insert")
  @ApiOperation(value = "Given a bounding box returns all the nodes inside by a given name.",
      response = Response.class)
  @ApiResponses(value = {@ApiResponse(code = 404, message = "Could't insert data")})
  public Response insertUser(@ApiParam(required = true) UserVO userdata) {

    //TODO: Properly handle different cases of DB working or not

    // Try to create User from data body
    try {
      userDAO.insertUser(userdata.getEmail(),
          userdata.getName(),
          userdata.getUsername(),
          userdata.getPassword(),
          userdata.getPhone_number());

      return Response.status(200).entity("OK").build();

      // Catch exception (wrong data) and return error
    } catch (Exception e) {
      return Response.status(403).entity("Bad data supplied.").build();
    }

  }


}
