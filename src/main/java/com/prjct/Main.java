package com.prjct;
import java.util.ArrayList;
public class Main {
    public static void main(String... args){
        final String dbUri = "bolt://localhost:7687";
        final String dbUser = "neo4j";
        final String dbPassword = "12345678";
        Controller controller = new Controller(dbUri, dbUser, dbPassword);
        InicioDeSesionUI UI = new InicioDeSesionUI(controller);
    }
}