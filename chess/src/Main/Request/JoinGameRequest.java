package Request;

import chess.ChessGame;

/**
 * Request to join an existing game
 */
public class JoinGameRequest {

  private ChessGame.TeamColor playerColor;
  /**
   * ID of the current game
   */
  private int gameID;

  /**
   * Constructor for the request to join the game
   * @param gameID ID for the game to join
   */
  public JoinGameRequest(int gameID, ChessGame.TeamColor playerColor)
  {
    this.gameID=gameID;
    this.playerColor = playerColor;
  }


  public int getGameID() {
    return gameID;
  }


  public void setGameID(int gameID) {
    this.gameID=gameID;
  }

  public ChessGame.TeamColor getTeamColor() {
    return playerColor;
  }

  public void setTeamColor(ChessGame.TeamColor teamColor) {
    this.playerColor=teamColor;
  }
}
