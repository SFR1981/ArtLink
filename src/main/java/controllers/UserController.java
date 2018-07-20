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
        get("/engineers/:id/edit", (req, res) -> {
            int engineerId = Integer.parseInt(req.params(":id"));

            Engineer engineer = DBHelper.find(engineerId, Engineer.class);

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/engineers/update.vtl");

            List<Department> departments = DBHelper.getAll(Department.class);
            model.put("departments", departments);
            model.put("engineer", engineer);

            return new ModelAndView(model, "templates/layout.vtl");

        },new VelocityTemplateEngine());

        //update
        post("/engineers/:id", (req, res) -> {
            Engineer engineer = new Engineer();

            engineer.setId(Integer.parseInt(req.params(":id")));
            engineer.setFirstName(req.queryParams("first-name"));
            engineer.setLastName(req.queryParams("last-name"));
            engineer.setSalary(Integer.parseInt(req.queryParams("salary")));

            int departmentId = Integer.parseInt(req.queryParams("department"));
            Department department = DBHelper.find(departmentId, Department.class);
            engineer.setDepartment(department);

            DBHelper.save(engineer);
            res.redirect("/engineers");
            return null;
        }, new VelocityTemplateEngine());

        //delete
        post ("/engineers/:id/delete", (req, res) -> {

            int engineerId = Integer.parseInt(req.params(":id"));

            Engineer engineer = DBHelper.find(engineerId, Engineer.class);

            DBHelper.delete(engineer);

            res.redirect("/engineers");
            return null;
        }, new VelocityTemplateEngine());

    }
}
