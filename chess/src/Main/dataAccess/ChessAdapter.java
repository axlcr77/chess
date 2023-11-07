package dataAccess;

import chess.*;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ChessAdapter implements JsonDeserializer<ChessBoard> {


  @Override
  public ChessBoard deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    return new Gson().fromJson(jsonElement, ChessBoardImp.class);
  }
}
