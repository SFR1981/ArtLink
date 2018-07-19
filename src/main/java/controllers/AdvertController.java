package controllers;

import db.DBHelper;
import db.Seeds;
import models.Advert;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class AdvertController {

    public class EmployeesController {
        public EmployeesController(){
            this.setupEndPoints();


        }

        public void setupEndPoints(){





            get("/adverts", (req,res) ->{
                Map<String, Object> model = new HashMap();


                List<Advert> adverts = DBHelper.getAll(Advert.class);
                model.put("adverts", adverts);
                model.put("template", "templates/adverts/index.vtl");

                return new ModelAndView(model, "templates/layout.vtl");

            }, new VelocityTemplateEngine());

        }
    }
}
