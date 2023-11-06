package Service;

import Request.RegisterRequest;
import Response.RegisterReponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.UserDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterServiceTest {
  private RegisterService service;
  private RegisterReponse response;
  AuthDAO authDAO;
  UserDAO userDAO;

  @BeforeEach
  void setup() throws DataAccessException {
    service = new RegisterService();
    authDAO = new AuthDAO();
    userDAO = new UserDAO();

    authDAO.ClearTokens();
    userDAO.ClearUsers();
  }

  @AfterEach
  void cleanUp() throws DataAccessException {
    authDAO.ClearTokens();
    userDAO.ClearUsers();
  }

  @Test
  @DisplayName("Successful Register Service")
  void SuccessfulRegister() {

    RegisterRequest request = new RegisterRequest("mr. Popo","Kami", "@squareCircles");

    RegisterReponse response = service.register(request);

    assertEquals(response.getUsername(),"mr. Popo");
    assertNotNull(response.getAuthToken());
  }

  @Test
  @DisplayName("Unsuccessful Register Service")
  void UnsuccessfulRegisterService(){
    RegisterRequest request1 = new RegisterRequest("Little Green","Big Green", "@Hey");
    RegisterRequest request2 = new RegisterRequest("Little Green","Big Green", "@Hey");

    RegisterReponse response1= service.register(request1);
    RegisterReponse response2 = service.register(request2);

    assertEquals("already taken error", response2.getMessage());

  }
}