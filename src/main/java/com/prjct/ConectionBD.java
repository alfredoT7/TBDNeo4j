package com.prjct;

import org.neo4j.driver.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class ConectionBD {
    private final Driver driver;
    public ConectionBD(String uri, String user, String password) {
        this.driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }
    public boolean autenticarCredencualesLogin(String username, String password) {
        try (Session session = driver.session(SessionConfig.forDatabase("neo4j"))) {
            var result = session.run(
                    "MATCH (u:Usuario {username: $username, contraseña: $password}) " +
                            "RETURN u.username AS LoginResponse",
                    Map.of("username", username, "password", password)
            );
            if (result.hasNext()) {
                var record = result.next();
                if (!record.get("LoginResponse").isNull()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public ArrayList<String> getUiPorNombreDeUser(String userName) {
        try (Session session = driver.session(SessionConfig.forDatabase("neo4j"))) {
            var result = session.run(
                    "MATCH (u:Usuario {username: $userName})-[:ROL_USER]->(r:Rol)-[:ROL_FUNCION]->(f:Funcion)-[:FUNCION_UI]->(ui:UI) " +
                            "RETURN ui.nombre_UI AS nombreUI",
                    Map.of("userName", userName)
            );
            ArrayList<String> uiObtenidas = new ArrayList<>();
            result.stream().forEach(record -> uiObtenidas.add(record.get("nombreUI").asString()));
            return uiObtenidas;
        }
    }
}
