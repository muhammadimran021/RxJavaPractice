package com.example.muhammad.practiceapp;

import java.util.ArrayList;

/**
 * Created by Muhammad on 1/20/2017.
 */

public class Users {
    public static ArrayList<model> userdata() {
        ArrayList<model> userList = new ArrayList<>();
        userList.add(new model(model.Adimn, "imran"));
        userList.add(new model(model.Adimn, "kamran"));
        userList.add(new model(model.Moderator, "faiz"));
        userList.add(new model(model.Moderator, "moosa"));
        userList.add(new model(model.Moderator, "qasim"));
        userList.add(new model(model.Moderator, "samad"));
        userList.add(new model(model.Guest, "bilal"));
        userList.add(new model(model.Guest, "faisal"));
        userList.add(new model(model.Guest, "arsalan"));
        userList.add(new model(model.Guest, "zeeshan"));
        return userList;
    }
}
