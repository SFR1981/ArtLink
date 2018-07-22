package controllers;

import db.DBHelper;
import db.Seeds;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

        staticFileLocation("/public");

        Seeds.seedData();

        AdvertController advertController = new AdvertController();
        ArtistController artistController = new ArtistController();
        ItemController itemController = new ItemController();
        UserController userController = new UserController();


        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/", (req,res)-> {
            Map<String,Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            model.put("template", "templates/landing.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/:id", (req,res)-> {
            Map<String,Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
