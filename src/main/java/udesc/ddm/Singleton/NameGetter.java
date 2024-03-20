package udesc.ddm.Singleton;

public class NameGetter {
    private static String name;

    private NameGetter(){}

    public static void setName(String name){
        NameGetter.name = name;
    }

    public static String getName() {
        return name;
    }

    public static int nameSize(){
        return name.length();
    }

}
