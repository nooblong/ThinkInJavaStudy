package generics.mixins;

interface Color {
    String getColor();
}

class ColorImp implements Color{
    public String getColor(){
        return "color";
    }
}
