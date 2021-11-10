package sample;

public enum Topping {
    Pepperoni, Pineapple, Ham, Sausage, Peppers, Onions, Mushrooms, Chicken, Invalid;

    @Override
    public String toString(){
        if (this == Pepperoni){
            return "Pepperoni";
        }
        else if (this == Ham){
            return "Ham";
        }
        else if (this == Sausage){
            return "Sausage";
        }
        else if (this == Peppers){
            return "Peppers";
        }
        else if (this == Onions){
            return "Onions";
        }
        else if (this == Pineapple){
            return "Pineapple";
        }
        else if (this == Mushrooms){
            return "Mushrooms";
        }
        else if (this == Chicken){
            return "Chicken";
        }
        else{
            return "Invalid";
        }
    }
}
