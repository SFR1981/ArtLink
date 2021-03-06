package controllers;

import db.DBHelper;
import db.Seeds;
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

public class AdvertController {


        public AdvertController(){
            this.setupEndPoints();


        }

        public void setupEndPoints(){



            get("/adverts/$thisUser.getId()", (req,res)-> {
                Map<String,Object> model = new HashMap<>();
                List<User> users = DBHelper.getAll(User.class);
                model.put("users", users);
                model.put("template", "templates/landing.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());


            get("/adverts/:x", (req,res) ->{
                Map<String, Object> model = new HashMap();


                List<Advert> adverts = DBHelper.getAll(Advert.class);
                List<Item> items = DBHelper.getAll(Item.class);
                List<Artist> artists = DBHelper.getAll(Artist.class);
                int id = Integer.parseInt(req.params(":x"));
                User thisUser = DBHelper.find(id, User.class);
                model.put("thisUser", thisUser);
                model.put("items", items);
                model.put("artists", artists);
                model.put("template", "templates/adverts/index.vtl");

                return new ModelAndView(model, "templates/layout.vtl");

            }, new VelocityTemplateEngine());

        }
    }

