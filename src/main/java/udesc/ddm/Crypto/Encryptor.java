package udesc.ddm.Crypto;

public class Encryptor {

    private final Mapper mapper;

    public Encryptor(Mapper mapper){
        this.mapper = mapper;
    }

    public String encrypt(String text){
        StringBuilder hashString = new StringBuilder();
        String salt = mapper.getSalt();

        for (char character : text.toCharArray()) {
            String hash = Hasher.toSHA256(String.valueOf(character), salt);
            hashString.append(hash);
        }

        return hashString.toString();
    }

}
