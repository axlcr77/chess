package dataAccess;

import Models.AuthTokenModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLIntegrityConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

class AuthDAOTest {

  private AuthDAO authDAO;

  @BeforeEach
  void setup() throws DataAccessException{
    authDAO = new AuthDAO();
    authDAO.ClearTokens();
  }

  @AfterEach
  void cleanUp()throws DataAccessException{
    authDAO.ClearTokens();

  }


  @Test
  @DisplayName("Valid token creation")
  void createToken() throws DataAccessException{
    authDAO.CreateToken("lala","land");
    AuthTokenModel proof = authDAO.GetToken("lala");

    assertEquals(proof.getUsername(),"land");
  }
  @Test
  @DisplayName("Invalid token creation")
  void invalid_createToken() throws DataAccessException{
    //The token cannot be null
    assertThrows(RuntimeException.class, ()-> authDAO.CreateToken(null,"land"));
  }

  @Test
  @DisplayName("Valid get token")
  void getToken() throws DataAccessException{
    authDAO.CreateToken("among","us");
    AuthTokenModel proof =authDAO.GetToken("among");

    assertEquals("among",proof.getAuthToken());
  }
  @Test
  @DisplayName("Invalid get token")
  void invalid_getToken() throws DataAccessException{
    authDAO.CreateToken("among","us");
    AuthTokenModel proof =authDAO.GetToken("amog");

    assertNull(proof);
  }

  @Test
  @DisplayName("Correctly delete a token")
  void deleteToken() throws DataAccessException{
    authDAO.CreateToken("this","that");

    authDAO.DeleteToken("this");
    assertNull(authDAO.GetToken("this"));
  }
  @Test
  @DisplayName("incorrectly delete a token")
  void incorrectly_deleteToken() throws DataAccessException{
    authDAO.CreateToken("this","that");

    authDAO.DeleteToken("that");
    assertNotNull(authDAO.GetToken("this"));
  }

  @Test
  void clearTokens()throws DataAccessException {
    authDAO.CreateToken("this","that");
    authDAO.CreateToken("among","us");
    authDAO.CreateToken("lala","land");

    authDAO.ClearTokens();
    assertNull(authDAO.GetToken("this"));
    assertNull(authDAO.GetToken("among"));
    assertNull(authDAO.GetToken("lala"));

  }
}