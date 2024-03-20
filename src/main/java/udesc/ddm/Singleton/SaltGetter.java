package udesc.ddm.Singleton;

public class SaltGetter {
    private static String salt;
    private static boolean isNull = true;

    private SaltGetter(){}

    public static void setSalt(String salt){
        if(isNull){
            SaltGetter.salt = salt;
            isNull = false;
        }
    }

    public static String getSalt() {
        return salt;
    }
}
