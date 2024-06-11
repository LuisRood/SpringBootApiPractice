@Service
public class EncryptionService {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String KEY = "1234567890123456"; // Llave de ejemplo, usa una más segura en producción
    private static final String INIT_VECTOR = "RandomInitVector"; // Vector de inicialización

    public String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
