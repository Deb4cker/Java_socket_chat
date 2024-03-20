package udesc.ddm.Crypto;

public class Decryptor {

    private static final int DIVISOR = 64;
    private final Mapper mapper;
    public Decryptor(Mapper mapper) {
        this.mapper = mapper;
    }

    public String decrypt(String hashString){
        StringBuilder builder = new StringBuilder();
        String[] stringArray = splitHashString(hashString);
        var keys = mapper.getKeys();


        for (String hash : stringArray) {
            builder.append(keys.get(hash));
        }

        return builder.toString();
    }

    private String[] splitHashString(String hashString){
        int characterCount = hashString.length() / DIVISOR;
        String[] result = new String[characterCount];
        for (int i = 0; i < characterCount; i++){
            int end = Math.min(( i + 1 ) * DIVISOR, hashString.length());
            result[i] = hashString.substring(i * DIVISOR, end);
        }

        return result;
    }
}
