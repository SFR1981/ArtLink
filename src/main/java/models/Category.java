package models;

import java.util.ArrayList;

public enum Category {


    PAINTING("prints & paintings"),
    PHOTOGRAPHY("photography"),
    JEWELLERY("jewellery"),
    CLOTHES("clothes"),
    VINTAGE("vintage"),
    CRAFT("craft & supplies"),
    MISCELLANEOUS("miscellaneous");

    private final String value;

    Category(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }




    }



