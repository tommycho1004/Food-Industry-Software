package sample;

public enum Size {
    Small, Medium, Large;

    public String pizzaSizeString(){
        if (this == Small){
            return "Small";
        }
        else if (this == Medium){
            return "Medium";
        }
        else{
            return "Large";
        }
    }
}
