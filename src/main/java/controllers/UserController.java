package controllers;

import db.DBHelper;
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
        // index
        get("/users", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/users/index.vtl");

            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // new
        get("/users/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            model.put("template", "templates/users/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // create
        post("/users", (req, res) -> {

            String username = req.queryParams("username");
            User user = new User(username);
            DBHelper.save(user);

            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());

        // show
        get("/users/:id", (req, res) -> {

            Map<String, Object> model = new HashMap();

            int userId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(userId, User.class);
            model.put("template", "templates/users/show.vtl");
            model.put("user", user);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        // edit
        get("/users/:id/edit", (req, res) -> {
            int userId = Integer.parseInt(req.params(":id"));

            User user = DBHelper.find(userId, User.class);

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/users/edit.vtl");

            model.put("user", user);

            return new ModelAndView(model, "templates/layout.vtl");

        },new VelocityTemplateEngine());

        //update
        post("/users/:id", (req, res) -> {
            User user = new User();

            user.setId(Integer.parseInt(req.params(":id")));
            user.setUsername(req.queryParams("username"));

            DBHelper.save(user);
            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());

        //delete
        post ("/users/:id/delete", (req, res) -> {

            int userId = Integer.parseInt(req.params(":id"));

            User user = DBHelper.find(userId, User.class);

            DBHelper.delete(user);

            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());

    }
}
