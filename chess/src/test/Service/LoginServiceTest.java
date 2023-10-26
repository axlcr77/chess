package Service;

import Request.LoginRequest;
import Response.LoginResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import dataAccess.UserDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

  @Test
  @DisplayName("Valid Login Case")
  void ValidLogin() throws DataAccessException {
    LoginService service= new LoginService();
    UserDAO userDAO = new UserDAO();
    userDAO.CreateUser("Me","myPassword","@");
    LoginRequest request = new LoginRequest("Me","myPassword");
    LoginResponse response = service.login(request);

    assertEquals(response.getUsername(), "Me");
    assertNotNull(response.getAuthToken());
  }

  @Test
  @DisplayName("Invalid Login Case")
  void InvalidLogin() throws DataAccessException{
    LoginService service = new LoginService();
    UserDAO userDAO = new UserDAO();
    userDAO.CreateUser("Me","myPassword","@");
    LoginRequest request = new LoginRequest("Me","MyPassword");
    LoginResponse response = service.login(request);

    assertEquals("unauthorized error", response.getMessage());


  }
}