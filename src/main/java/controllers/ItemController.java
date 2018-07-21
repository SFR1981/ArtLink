package controllers;

import db.DBHelper;
import db.DBItem;
import models.Category;
import models.Item;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
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

        User terry = new User("terry");
        DBHelper.save(terry);
        // index
        get("/items", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBHelper.getAll(Item.class);
            model.put("items", items);
            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/0", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBItem.getItemsForCategory(Category.PAINTING);
            model.put("items", items);
            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/1", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBItem.getItemsForCategory(Category.PHOTOGRAPHY);
            model.put("items", items);
            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/items/2", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBItem.getItemsForCategory(Category.JEWELlERY);
            model.put("items", items);
            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/3", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBItem.getItemsForCategory(Category.CLOTHES);
            model.put("items", items);
            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/4", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBItem.getItemsForCategory(Category.VINTAGE);
            model.put("items", items);
            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/5", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBItem.getItemsForCategory(Category.CRAFT);
            model.put("items", items);
            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/6", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/items/index.vtl");

            List<Item> items = DBItem.getItemsForCategory(Category.MISCELLANEOUS);
            model.put("items", items);
            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());










        // new
        get("/items/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Category> categories = Arrays.asList(Category.values());
            model.put("user", terry);
            model.put("categories", categories);
            model.put("template", "templates/items/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // create
        post("/items", (req, res) -> {

            String title = req.queryParams("title");

            String description = req.queryParams("description");

            String image = req.queryParams("image");

            int userId = Integer.parseInt(req.queryParams("user"));
            //get ordinal from input
            int categoryValue = Integer.parseInt(req.queryParams("category"));

           Category category = Category.values()[categoryValue];


           User user = DBHelper.find(userId, User.class);


            String price = req.queryParams("price");
            Item item = new Item(title, description, user, category, price);
            item.setImage(image);

            DBHelper.save(item);


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

            int itemId = Integer.parseInt(req.params(":id"));

            Map<String, Object> model = new HashMap();
            int id = Integer.parseInt((req.params(":id")));
            Item item = DBHelper.find(id, Item.class);

            List<Category> categories = Arrays.asList(Category.values());
            model.put("categories", categories);
            model.put("user", terry);

            model.put("template", "templates/items/edit.vtl");

            model.put("item", item);

            return new ModelAndView(model, "templates/layout.vtl");

        },new VelocityTemplateEngine());

        //update
        post("/items/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Item item = DBHelper.find(id, Item.class);


            item.setTitle(req.queryParams("title"));
            item.setImage(req.queryParams("image"));
            item.setDescription(req.queryParams("description"));
            int userId = Integer.parseInt(req.queryParams("user"));
            User user = DBHelper.find(userId, User.class);
            item.setUser(user);
            System.out.println(req.queryParams("category"));
            int categoryValue = Integer.parseInt(req.queryParams("category"));

            Category category = Category.values()[categoryValue];
            item.setCategory(category);

            item.setPrice(req.queryParams("price"));


            DBHelper.save(item);
            res.redirect("/items");
            return null;
        }, new VelocityTemplateEngine());

        //delete
        post ("/items/:id/delete", (req, res) -> {

            int itemId = Integer.parseInt(req.params(":id"));

            Item item = DBHelper.find(itemId, Item.class);

            DBHelper.delete(item);

            res.redirect("/items");
            return null;
        }, new VelocityTemplateEngine());

    }


}
