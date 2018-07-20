package controllers;

import db.DBHelper;
import models.Category;
import models.Item;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ItemController {

    public ItemController(){
        this.setupEndpoints();
    }


    private void setupEndpoints() {
        // index
        get("/items", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBHelper.getAll(Item.class);
            model.put("items", items);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // new
        get("/items/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/items/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // create
        post("/items", (req, res) -> {

            String title = req.queryParams("title");

            String description = req.queryParams("description");

            int userId = Integer.parseInt(req.queryParams("user"));
            User user = DBHelper.find(userId, User.class);

//            int categoryId = Integer.parseInt(req.queryParams("category"));
//            Category category = DBHelper.find(categoryId, Category.class);

            String price = req.queryParams("price");

//            DBHelper.save(item);


            res.redirect("/items");
            return null;
        }, new VelocityTemplateEngine());

        // show
        get("/items/:id", (req, res) -> {

            Map<String, Object> model = new HashMap();

            int itemId = Integer.parseInt(req.params(":id"));
            Item item = DBHelper.find(itemId, Item.class);
            model.put("template", "templates/items/show.vtl");
            model.put("item", item);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        // edit
        get("/items/:id/edit", (req, res) -> {
            int engineerId = Integer.parseInt(req.params(":id"));

            Item item = DBHelper.find(engineerId, Item.class);

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/update.vtl");

            model.put("item", item);

            return new ModelAndView(model, "templates/layout.vtl");

        },new VelocityTemplateEngine());

        //update
        post("/items/:id", (req, res) -> {
            Item item = new Item();

            item.setId(Integer.parseInt(req.params(":id")));
            item.setTitle(req.queryParams("title"));
            item.setDescription(req.queryParams("description"));

            item.setPrice(req.queryParams("price"));


            DBHelper.save(item);
            res.redirect("/items");
            return null;
        }, new VelocityTemplateEngine());

        //delete
        post ("/items/:id/delete", (req, res) -> {

            int engineerId = Integer.parseInt(req.params(":id"));

            Item item = DBHelper.find(engineerId, Item.class);

            DBHelper.delete(item);

            res.redirect("/items");
            return null;
        }, new VelocityTemplateEngine());

    }


}
