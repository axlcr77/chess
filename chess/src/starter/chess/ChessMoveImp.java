package chess;

import java.util.Objects;

public class ChessMoveImp implements ChessMove{
  private final ChessPosition Startposition;
  private final ChessPosition EndPosition;
  private final ChessPiece.PieceType PromotionPiece;

  public ChessMoveImp(ChessPosition startposition, ChessPosition endPosition,  ChessPiece.PieceType promotionPiece) {
    Startposition=startposition;
    EndPosition=endPosition;
    PromotionPiece = promotionPiece;
  }

  @Override
  public ChessPosition getStartPosition() {
    return Startposition;
  }

  @Override
  public ChessPosition getEndPosition() {
    return EndPosition;
  }

  @Override
  public ChessPiece.PieceType getPromotionPiece() {
    return PromotionPiece;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChessMoveImp that=(ChessMoveImp) o;
    return Objects.equals(Startposition, that.Startposition) && Objects.equals(EndPosition, that.EndPosition) && PromotionPiece == that.PromotionPiece;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Startposition, EndPosition, PromotionPiece);
  }
}
