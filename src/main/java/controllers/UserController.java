package controllers;

import db.DBHelper;
import db.DBUser;
import models.Advert;
import models.Artist;
import models.Item;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class UserController {

    public UserController(){
        this.setupEndpoints();
    }


    private void setupEndpoints() {

        get("/users/$thisUser.getId()", (req,res)-> {
            Map<String,Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            model.put("template", "templates/landing.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // index
        get("/users/:id", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/users/index.vtl");
            int id = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(id, User.class);
            model.put("thisUser", user);

            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // new
        get("/users/:x/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            model.put("template", "templates/users/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // create
        post("/users", (req, res) -> {

            String username = req.queryParams("username");
            String image = req.queryParams("image");
            User user = new User(username);
            user.setImage(image);
            DBHelper.save(user);
            int userId = user.getId();


            res.redirect("/"+userId);
            return null;
        }, new VelocityTemplateEngine());

        // show
        get("/users/:x/:id", (req, res) -> {

            Map<String, Object> model = new HashMap();

            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);
            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            List<Item> adverts = DBUser.getItemsForUser(user);
            String url = "items";
            model.put("url", url);
            model.put("adverts", adverts);
            model.put("template", "templates/users/show.vtl");
            model.put("user", user);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());



        get("/users/:x/:id/items", (req, res) -> {

            Map<String, Object> model = new HashMap();

            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);
            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            List<Item> adverts = DBUser.getItemsForUser(user);
            String url = "items";
            model.put("url", url);
            model.put("adverts", adverts);
            model.put("template", "templates/users/show.vtl");
            model.put("user", user);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        get("/users/:x/:id/artists", (req, res) -> {

            Map<String, Object> model = new HashMap();
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);
            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            List<Artist> adverts = DBUser.getArtistsForUser(user);
            String url = "artists";
            model.put("url", url);
            model.put("adverts", adverts);
            model.put("template", "templates/users/show.vtl");
            model.put("user", user);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        // edit
        get("/users/:x/:id/edit", (req, res) -> {

            int userId = Integer.parseInt(req.params(":id"));

            User user = DBHelper.find(userId, User.class);

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/users/edit.vtl");

            model.put("user", user);
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);

            return new ModelAndView(model, "templates/layout.vtl");

        },new VelocityTemplateEngine());

        //update
        post("/users/:x/:id", (req, res) -> {
            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);

            user.setUsername(req.queryParams("username"));
            user.setImage(req.queryParams("image"));

            DBHelper.save(user);
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);

            res.redirect("/users/"+id);
            return null;
        }, new VelocityTemplateEngine());

        //delete
        post ("/users/:x/:id/delete", (req, res) -> {

            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            DBHelper.delete(user);
            String id = req.params(":x");

            res.redirect("/users/"+ id );
            return null;
        }, new VelocityTemplateEngine());

    }
}
