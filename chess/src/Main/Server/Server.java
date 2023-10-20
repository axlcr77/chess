package Server;

import Handlers.*;
import spark.Spark;

public class Server {

  public static void main(String[] args){
    new Server().run();
  }

  private void run(){
    //Port to listen on
    Spark.port(8080);


    Spark.externalStaticFileLocation("C:/Users/shiny/OneDrive - Brigham Young University/Desktop/School/Fall 2023/CS 240/chess/chess/web");

    //Registering handlers
    //Clear Application
    Spark.delete("/db", (req,res) -> (new ClearApplicationHandler()).ClearApplication(req,res));

    //Register User
    Spark.post("/user", (req,res) -> (new RegisterHandler()).service(req,res));

    //Login
    Spark.post("/session", (req,res) ->(new LoginHandler()).service(req,res));

    //Logout
    Spark.delete("/session", (req,res) -> (new LogoutHandler()).service(req,res));

    //List games
    Spark.get("/game", (req, res) -> (new ListGamesHandler()).service(req,res));

    //Create Game
    Spark.post("/game",(req,res)-> (new CreateGameHandler()).service(req,res));

    //Join Game
    Spark.put("/game", (req,res) -> (new JoinGameHandler()).service(req,res));
  }
}
