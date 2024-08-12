public class Display {
    public static void main(String[] args) {
        Animals camel = new Animals(4, "Brown", "Camel");
        System.out.println(camel.toString());
    }
}

class Animals {
    int legs;
    String color;
    String type;

    public Animals(){

    }

    public Animals(int legs, String color, String type) {
        this.color = color;
        this.legs = legs;
        this.type = type;
    }

    public String toString(){
        return "Type: " + type + "Color: " + color + "Legs: " + legs;
    }
}
