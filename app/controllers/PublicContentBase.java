package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;
import play.i18n.Messages;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
        if (User.loadUser(username) == null){
            User u = new User(username, HashUtils.getMd5(password), type, -1);
            u.save();
            registerComplete();
        }else{
            flash.put("repeated", Messages.get("Public.login.userRepeated"));
            register();
        }
    }

    public static void registerComplete(){
        render();
    }
}
