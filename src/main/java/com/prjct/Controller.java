package com.prjct;

public class Controller{
    String dbUri;
    String dbUser;
    String dbPassword;
    ConectionBD conectionBD;
    public Controller(String dbUri, String dbUser, String dbPassword){
        this.dbUri = dbUri;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.conectionBD = new ConectionBD(dbUri,dbUser,dbPassword);
        System.out.println("Conectados");
    }
    public boolean getUILoginData(String username, String password){
        return conectionBD.autenticarCredencualesLogin(username,password);
    }
//    public getInterfacesHabilidatas(){
//
//    }
}
