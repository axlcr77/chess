package Service;

import Request.RegisterRequest;
import Response.RegisterReponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterServiceTest {

  @Test
  @DisplayName("Successful Register Service")
  void SuccessfulRegister() {
    RegisterService service = new RegisterService();
    RegisterRequest request = new RegisterRequest("mr. Popo","Kami", "@squareCircles");

    RegisterReponse response = service.register(request);

    assertEquals(response.getUsername(),"mr. Popo");
    assertNotNull(response.getAuthToken());
  }

  @Test
  @DisplayName("Unsuccessful Register Service")
  void UnsuccessfulRegisterService(){
    RegisterService service = new RegisterService();
    RegisterRequest request1 = new RegisterRequest("Little Green","Big Green", "@Hey");
    RegisterRequest request2 = new RegisterRequest("Little Green","Big Green", "@Hey");

    RegisterReponse response1= service.register(request1);
    RegisterReponse response2 = service.register(request2);

    assertEquals("already taken error", response2.getMessage());

  }
}