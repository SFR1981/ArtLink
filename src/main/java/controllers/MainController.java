package controllers;

import db.Seeds;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class MainController {

    public static void main(String[] args) {

        Seeds.seedData();

        ArtistController artistController = new ArtistController();
        ItemController itemController = new ItemController();
        UserController userController = new UserController();

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/", (req,res)-> {
            Map<String,Object> model = new HashMap<>();
            model.put("template", "templates/landing.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
