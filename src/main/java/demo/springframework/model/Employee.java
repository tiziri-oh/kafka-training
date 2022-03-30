package demo.springframework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data @NoArgsConstructor @AllArgsConstructor
@ToString
public class Employee {
    private String name;
    private String department;
    private String salary;

    public String md5sum() {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Unable to compute md5sum for string", ex);
        }
        assert (digest != null);
        String input = name + department + salary;
        digest.update(input.getBytes());
        BigInteger hash = new BigInteger(1, digest.digest());
        return (hash.toString(16));
    }
}
