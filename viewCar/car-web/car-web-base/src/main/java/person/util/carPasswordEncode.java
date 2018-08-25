package person.util;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.codec.Utf8;

/**
 * Created by SunChang on 2018/8/24
 */
public class carPasswordEncode implements PasswordEncoder {
    @Override
    public String encodePassword(String rawPass, Object salt) {
        return Encoder.encodeMd5(rawPass);
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String pass = Encoder.encodeMd5(rawPass);
        return equals(encPass,pass);
    }

    private boolean equals(String expected, String actual){
        byte expectedBytes[] = bytesUtf8(expected);
        byte actualBytes[] = bytesUtf8(actual);
        int expectedLength = expectedBytes != null ? expectedBytes.length : -1;
        int actualLength = actualBytes != null ? actualBytes.length : -1;
        if(expectedLength != actualLength)
            return false;
        int result = 0;
        for(int i = 0; i < expectedLength; i++)
            result |= expectedBytes[i] ^ actualBytes[i];

        return result == 0;
    }

    private byte[] bytesUtf8(String s){
        if(s == null)
            return null;
        else
            return Utf8.encode(s);
    }

    public static void main(String[] args){
        System.out.println(Encoder.encodeMd5("admin"));
    }
}
