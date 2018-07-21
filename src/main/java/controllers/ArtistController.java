package controllers;

import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

public class ArtistController {




    public ArtistController(){
        this.setupEndpoints();
    }


    private void setupEndpoints() {

        User terry = new User("terry");
        DBHelper.save(terry);
        // index
        get("/artists", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/artists/index.vtl");

            List<Artist> artists = DBHelper.getAll(Artist.class);
            model.put("artists", artists);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // new
        get("/artists/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("user", terry);
            model.put("skills", skills);
            model.put("template", "templates/artists/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // create
        post("/artists", (req, res) -> {

            String title = req.queryParams("title");

            String description = req.queryParams("description");

            String image = req.queryParams("image");

            int userId = Integer.parseInt(req.queryParams("user"));
            User user = DBHelper.find(userId, User.class);
            //get ordinal from input
            int skillValue = Integer.parseInt(req.queryParams("skill"));

            Skill skill = Skill.values()[skillValue];

            String name = req.queryParams("name");

            String location = req.queryParams("location");

            //TODO: email


            Artist artist = new Artist(title, description, user, name, skill, location);
            artist.setImage(image);

            DBHelper.save(artist);


            res.redirect("/artists");
            return null;
        }, new VelocityTemplateEngine());

        // show
        get("/artists/:id", (req, res) -> {

            Map<String, Object> model = new HashMap();

            int artistId = Integer.parseInt(req.params(":id"));
            Artist artist = DBHelper.find(artistId, Artist.class);
            model.put("template", "templates/artists/show.vtl");
            model.put("artist", artist);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        // edit
        get("/artists/:id/edit", (req, res) -> {

            int itemId = Integer.parseInt(req.params(":id"));

            Map<String, Object> model = new HashMap();
            int id = Integer.parseInt((req.params(":id")));
            Artist artist = DBHelper.find(id, Artist.class);

            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);
            model.put("user", terry);

            model.put("template", "templates/artists/edit.vtl");

            model.put("artist", artist);

            return new ModelAndView(model, "templates/layout.vtl");

        },new VelocityTemplateEngine());

        //update
        post("/artists/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Artist artist = DBHelper.find(id, Artist.class);


            artist.setTitle(req.queryParams("title"));
            artist.setImage(req.queryParams("image"));
            artist.setDescription(req.queryParams("description"));
            int userId = Integer.parseInt(req.queryParams("user"));
            User user = DBHelper.find(userId, User.class);
            artist.setUser(user);

            int skillValue = Integer.parseInt(req.queryParams("skill"));

            Skill skill = Skill.values()[skillValue];
            artist.setSkill(skill);

            artist.setName(req.queryParams("name"));
            artist.setLocation(req.queryParams("location"));


            DBHelper.save(artist);
            res.redirect("/artists");
            return null;
        }, new VelocityTemplateEngine());

        //delete
        post ("/artists/:id/delete", (req, res) -> {

            int artistId = Integer.parseInt(req.params(":id"));

            Artist artist = DBHelper.find(artistId, Artist.class);

            DBHelper.delete(artist);

            res.redirect("/artists");
            return null;
        }, new VelocityTemplateEngine());

    }


}


