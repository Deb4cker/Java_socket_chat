package udesc.ddm.Crypto;

import udesc.ddm.Singleton.SaltGetter;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
    private static Map<String, Character> keys;
    private static final String salt = SaltGetter.getSalt();
    private static boolean loaded = false;

    public Mapper(){
        generateMap();
    }

    public Map<String, Character> getKeys(){
        return keys;
    }

    public String getSalt(){
        return salt;
    }

    private void generateMap(){
        if (!loaded){
            keys = new HashMap<>();

            for (int i = 0; i < 32786; i++) {
                char character = (char) i;
                String hash = Hasher.toSHA256(String.valueOf(character), salt);
                keys.put(hash, character);
            }

            loaded = true;
        }
    }
}
