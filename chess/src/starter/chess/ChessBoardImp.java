package chess;

public class ChessBoardImp implements ChessBoard{

  //Make a Chess Board by creating a 2x2 array which will represent rows x columns
  private final ChessPiece[][] board = new ChessPiece[8][8];



  @Override
  public void addPiece(ChessPosition position, ChessPiece piece) {
    board[position.getRow()-1][position.getColumn()-1] = new ChessPieceImp(piece.getPieceType(),piece.getTeamColor());
  }

  @Override
  public void MakeMove(ChessPosition StartPosition, ChessPosition EndPosition, ChessPiece piece){
    addPiece(EndPosition,piece);
    //remove capabilities
    board[StartPosition.getRow()-1][StartPosition.getColumn()-1] = null;
  }
  @Override
  public void promoteAndMove (ChessPosition startPosition, ChessPosition endposition, ChessPiece.PieceType promotePiece, ChessPiece piece){
    board[endposition.getRow()-1][endposition.getColumn()-1] = new ChessPieceImp(promotePiece,piece.getTeamColor());
    board[startPosition.getRow()-1][startPosition.getColumn()-1] = null;
  }

  //The board will take care of the correct indexing
  //-1 because of the indexing. Chess cordinates go from 1-8 but an array index goes from 0-7 in a 8x8 board.
  @Override
  public ChessPiece getPiece(ChessPosition position) {
    return board[position.getRow()-1][position.getColumn()-1];
  }

  @Override
  public void resetBoard() {
    //White pieces
    board[0][0] = new ChessPieceImp(ChessPiece.PieceType.ROOK, ChessGame.TeamColor.WHITE);
    board[0][1] = new ChessPieceImp(ChessPiece.PieceType.KNIGHT, ChessGame.TeamColor.WHITE);
    board[0][2] = new ChessPieceImp(ChessPiece.PieceType.BISHOP, ChessGame.TeamColor.WHITE);
    board[0][3] = new ChessPieceImp(ChessPiece.PieceType.QUEEN, ChessGame.TeamColor.WHITE);
    board[0][4] = new ChessPieceImp(ChessPiece.PieceType.KING, ChessGame.TeamColor.WHITE);
    board[0][5] = new ChessPieceImp(ChessPiece.PieceType.BISHOP, ChessGame.TeamColor.WHITE);
    board[0][6] = new ChessPieceImp(ChessPiece.PieceType.KNIGHT, ChessGame.TeamColor.WHITE);
    board[0][7] = new ChessPieceImp(ChessPiece.PieceType.ROOK, ChessGame.TeamColor.WHITE);

    //white pawns
    for(int i = 0; i<= 7;i++){
        board[1][i] = new ChessPieceImp(ChessPiece.PieceType.PAWN,ChessGame.TeamColor.WHITE);
    }
    //black pieces
    board[7][0] = new ChessPieceImp(ChessPiece.PieceType.ROOK, ChessGame.TeamColor.BLACK);
    board[7][1] = new ChessPieceImp(ChessPiece.PieceType.KNIGHT, ChessGame.TeamColor.BLACK);
    board[7][2] = new ChessPieceImp(ChessPiece.PieceType.BISHOP, ChessGame.TeamColor.BLACK);
    board[7][3] = new ChessPieceImp(ChessPiece.PieceType.QUEEN, ChessGame.TeamColor.BLACK);
    board[7][4] = new ChessPieceImp(ChessPiece.PieceType.KING, ChessGame.TeamColor.BLACK);
    board[7][5] = new ChessPieceImp(ChessPiece.PieceType.BISHOP, ChessGame.TeamColor.BLACK);
    board[7][6] = new ChessPieceImp(ChessPiece.PieceType.KNIGHT, ChessGame.TeamColor.BLACK);
    board[7][7] = new ChessPieceImp(ChessPiece.PieceType.ROOK, ChessGame.TeamColor.BLACK);

    //black pawns
    for(int i = 0; i<= 7;i++){
      board[6][i] = new ChessPieceImp(ChessPiece.PieceType.PAWN,ChessGame.TeamColor.BLACK);
    }

    //clean up the board
    for(int i = 2; i< 6; i++){
      for(int j = 0; j<= 7; j++){
        board[i][j] = null;
      }
    }
  }
}
