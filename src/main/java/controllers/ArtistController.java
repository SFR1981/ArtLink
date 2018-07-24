package controllers;

import db.DBArtist;
import db.DBComment;
import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

public class ArtistController {

//mvp


    public ArtistController(){
        this.setupEndpoints();
    }


    private void setupEndpoints() {


        // index

        get("/artists/$thisUser.getId()", (req,res)-> {
            Map<String,Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            model.put("template", "templates/landing.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/artists/$thisUser.getId()/new", (req,res) -> {
            Map<String,Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            model.put("template", "templates/landing.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        get("/artists/:x", (req, res) -> {
            Map<String, Object> model = new HashMap();
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);
            model.put("template", "templates/artists/index.vtl");

            List<Artist> artists = DBHelper.getAll(Artist.class);
            Set<Artist> artistSet = new HashSet<Artist>(artists);
            model.put("artists", artists);
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/artists/:x/PAINTER", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/artists/index.vtl");
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);

            List<Artist> artists = DBArtist.getArtistsFor(Skill.PAINTER);
            Set<Artist> artistSet = new HashSet<Artist>(artists);
            model.put("artists", artists);
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/artists/:x/PHOTOGRAPHER", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/artists/index.vtl");
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);

            List<Artist> artists = DBArtist.getArtistsFor(Skill.PHOTOGRAPHER);
            model.put("artists", artists);
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/artists/:x/JEWELER", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/artists/index.vtl");
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);

            List<Artist> artists = DBArtist.getArtistsFor(Skill.JEWELER);
            model.put("artists", artists);
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/artists/:x/ACTOR", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/artists/index.vtl");
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);

            List<Artist> artists = DBArtist.getArtistsFor(Skill.ACTOR);
            model.put("artists", artists);
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/artists/:x/TAILOR", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/artists/index.vtl");
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);

            List<Artist> artists = DBArtist.getArtistsFor(Skill.TAILOR);
            model.put("artists", artists);
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/artists/:x/DIRECTOR", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/artists/index.vtl");
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);

            List<Artist> artists = DBArtist.getArtistsFor(Skill.DIRECTOR);
            model.put("artists", artists);
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/artists/:x/MISCELLANEOUS", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/artists/index.vtl");
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);

            List<Artist> artists = DBArtist.getArtistsFor(Skill.MISCELLANEOUS);
            model.put("artists", artists);
            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // new
        get("/artists/:x/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Skill> skills = Arrays.asList(Skill.values());
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            model.put("thisUser", thisUser);
            model.put("skills", skills);
            model.put("template", "templates/artists/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // create
        post("/artists/:x", (req, res) -> {

            String title = req.queryParams("title");
            int id = Integer.parseInt(req.params(":x"));



            String description = req.queryParams("description");

            String image = req.queryParams("image");

            int userId = Integer.parseInt(req.queryParams("user"));
            User user = DBHelper.find(userId, User.class);
            //get ordinal from input
            int skillValue = Integer.parseInt(req.queryParams("skill"));

            Skill skill = Skill.values()[skillValue];

            String name = req.queryParams("name");

            String location = req.queryParams("location");

            String contact = req.queryParams("contact");

            //TODO: email


            Artist artist = new Artist(title, description, user, name, skill, location, contact);
            artist.setImage(image);

            DBHelper.save(artist);


            res.redirect("/artists/"+id);
            return null;
        }, new VelocityTemplateEngine());

        // show
        get("/artists/:x/:id", (req, res) -> {

            Map<String, Object> model = new HashMap();

            int artistId = Integer.parseInt(req.params(":id"));
            Artist artist = DBHelper.find(artistId, Artist.class);
            int id = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(id, User.class);
            List<Comment> comments = artist.getComments();
            model.put("comments", comments);
            model.put("thisUser", thisUser);
            model.put("template", "templates/artists/show.vtl");
            model.put("artist", artist);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        // edit
        get("/artists/:x/:id/edit", (req, res) -> {

            int itemId = Integer.parseInt(req.params(":id"));

            Map<String, Object> model = new HashMap();
            int thisId = Integer.parseInt(req.params(":x"));
            User thisUser = DBHelper.find(thisId, User.class);
            model.put("thisUser", thisUser);
            int id = Integer.parseInt((req.params(":id")));
            Artist artist = DBHelper.find(id, Artist.class);

            List<Skill> skills = Arrays.asList(Skill.values());
            model.put("skills", skills);


            model.put("template", "templates/artists/edit.vtl");

            model.put("artist", artist);

            return new ModelAndView(model, "templates/layout.vtl");

        },new VelocityTemplateEngine());

        //update
        post("/artists/:x/:id", (req, res) -> {
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
            artist.setContact(req.queryParams("contact"));


            DBHelper.save(artist);
            res.redirect("/artists/"+userId);
            return null;
        }, new VelocityTemplateEngine());

        //delete
        post ("/artists/:x/:id/delete", (req, res) -> {

            int id = Integer.parseInt(req.params(":x"));
            int artistId = Integer.parseInt(req.params(":id"));

            Artist artist = DBHelper.find(artistId, Artist.class);

            DBHelper.delete(artist);

            res.redirect("/artists/"+id);
            return null;
        }, new VelocityTemplateEngine());


        post ("/artists/:x/:id/comment", (req, res) -> {

            int artistId = Integer.parseInt(req.params(":id"));

            Artist artist = DBHelper.find(artistId, Artist.class);
            int id = Integer.parseInt(req.params(":x"));
            User user = DBHelper.find(id, User.class);
            String text = req.queryParams("comment");
            Comment comment = new Comment(user, artist, text);
            DBComment.addComment(comment, user, artist);

            res.redirect("/artists/"+id+"/"+artistId);
            return null;
        }, new VelocityTemplateEngine());

    }


}


