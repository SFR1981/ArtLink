package models;

public enum Category {


    PAINTING("prints & paintings"),
    PHOTOGRAPHY("photography"),
    JEWELlERY("jewellery"),
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
