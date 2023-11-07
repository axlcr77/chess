package dataAccess;

import Models.GameModel;
import Models.UserModel;
import org.eclipse.jetty.server.Authentication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

  private UserDAO userDAO;

  @BeforeEach
  void setup()throws DataAccessException{
    userDAO = new UserDAO();
    userDAO.ClearUsers();

  }

  @AfterEach
  void clenaUP()throws DataAccessException{
    userDAO.ClearUsers();
  }

  @Test
  @DisplayName("Valid User creation")
  void valid_createUser() throws DataAccessException{
    String user = userDAO.CreateUser("Me","Myself","I");

    assertNotNull(userDAO.getUser(user));
  }

  @Test
  @DisplayName("Invalid user creation")
  void invalid_createUser()throws DataAccessException{
    userDAO.CreateUser("not me", "not her","him");

    assertNull(userDAO.getUser("me"));
  }

  @Test
  @DisplayName("valid get user")
  void getUser()throws DataAccessException {
    String user = userDAO.CreateUser("Me","Myself","I");

    UserModel proof = userDAO.getUser("Me");

    assertEquals(proof.getUsername(),user);
  }
  @Test
  @DisplayName("Invalid get user")
  void invalid_getUser()throws DataAccessException {
    String user = userDAO.CreateUser("Me","Myself","I");

    UserModel proof = userDAO.getUser("My");

    assertNull(proof);
  }




  @Test
  @DisplayName("Correctly delete User")
  void deleteUser() throws DataAccessException{
    String user = userDAO.CreateUser("Me","Myself","I");
    userDAO.DeleteUser("Me","Myself");

    assertNull(userDAO.getUser("Me"));
  }
  @Test
  @DisplayName("Incorrectly delete User")
  void Incorrectly_deleteUser() throws DataAccessException{
    String user = userDAO.CreateUser("Me","Myself","I");
    userDAO.DeleteUser("Me","Mysel");

    //Password not matching will not delete the user

    assertNotNull(userDAO.getUser("Me"));
  }



  @Test
  @DisplayName("Valid user verification")
  void verifyUser()throws DataAccessException {
    userDAO.CreateUser("hi", "bye", "@");


    assertTrue(userDAO.verifyUser("hi", "bye"));
  }
  @Test
  @DisplayName("Invalid user verification")
  void Invalid_verifyUser()throws DataAccessException {
    userDAO.CreateUser("hi", "bye", "@");
    assertFalse(userDAO.verifyUser("hi", "bie"));
  }

  @Test
  void clearUsers()throws DataAccessException {
    userDAO.CreateUser("hi", "bye", "@");
    userDAO.CreateUser("Me","Myself","I");

    userDAO.ClearUsers();

    assertNull(userDAO.getUser("hi"));
    assertNull(userDAO.getUser("Me"));
  }
}