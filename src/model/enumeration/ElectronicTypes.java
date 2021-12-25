package model.enumeration;


public enum ElectronicTypes {
    RADIO("radio"),
    TELEVISION("television"),
    NOT_SET("not set");


    private String type;

    ElectronicTypes(String type) {
        this.type = type;
    }

    public ElectronicTypes getVal(String type){
        switch (type.trim()){
            case "radio":
                return RADIO;
            case "television":
                return TELEVISION;
            default:
                return NOT_SET;
        }
    }

    public String getType() {
        return type;
    }
}
