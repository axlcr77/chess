package Service;

import Models.AuthTokenModel;
import Request.LoginRequest;
import Response.LoginResponse;

/**
 * Service call to log in
 */

public class LoginService {
  /**
   * Call to login
   * @param request request to login
   * @param token token to verify the user
   * @return response to the request
   */
    public LoginResponse login(LoginRequest request , AuthTokenModel token) {
      return null;
    }

}
