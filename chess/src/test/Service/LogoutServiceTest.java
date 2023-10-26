package Service;

import Response.LogoutResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogoutServiceTest {

  @Test
  @DisplayName("Successful Logout")
  void SuccessfulLogout() throws DataAccessException {
    LogoutService service = new LogoutService();
    AuthDAO authDAO = new AuthDAO();
    String token = authDAO.CreateToken("thisAtoken","gru");
    LogoutResponse response = service.logout(token);

    assertNull(response);
  }

  @Test
  @DisplayName("Unsuccessful Logout")
  void UnsuccessfulLogout (){
    LogoutService service = new LogoutService();
    LogoutResponse response = service.logout("thisAtoken");
    assertEquals("unauthorized error",response.getMessage());
  }
}