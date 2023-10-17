package Request;

import chess.ChessGame;

/**
 * Request to join an existing game
 */
public class JoinGameRequest {

  /**
   * White pieces
   */
ChessGame.TeamColor white = ChessGame.TeamColor.WHITE;

  /**
   * Black pieces
   */
  ChessGame.TeamColor black = ChessGame.TeamColor.BLACK;

  /**
   * ID of the current game
   */
  private int gameID;

  /**
   * Constructor for the request to join the game
   * @param gameID ID for the game to join
   */
  public JoinGameRequest(int gameID) {
    this.gameID=gameID;
  }


  public int getGameID() {
    return gameID;
  }


  public void setGameID(int gameID) {
    this.gameID=gameID;
  }


  public ChessGame.TeamColor getWhite() {
    return white;
  }


  public void setWhite(ChessGame.TeamColor white) {
    this.white=white;
  }


  public ChessGame.TeamColor getBlack() {
    return black;
  }



  public void setBlack(ChessGame.TeamColor black) {
    this.black=black;
  }
}
