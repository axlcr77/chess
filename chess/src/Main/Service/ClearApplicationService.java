package Service;

import Response.ClearApplicationResponse;

/**
 * Service call to clear the database
 */

public class ClearApplicationService {

  /**
   * Clear application call to the database
   * @return the response for the request to clear the application
   */
  public ClearApplicationResponse clearApp(){
    //Logic

    //This is success
    return new ClearApplicationResponse(null);
  }
}
