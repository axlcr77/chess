package chess;

import java.util.Objects;

public class ChessPositionImp implements ChessPosition{
  //Do the rows and columns have to be between 1-8?
  private final int Row;
  private final int Column;


  //Need a constructor for testing so that I can access a certain position
  public ChessPositionImp(int row, int column) {
    Row=row;
    Column=column;
  }

  @Override
  public int getRow() {
    return Row;
  }

  @Override
  public int getColumn() {
    return Column;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChessPositionImp that=(ChessPositionImp) o;
    return Row == that.Row && Column == that.Column;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Row, Column);
  }
}
