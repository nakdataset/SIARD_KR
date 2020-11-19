package ch.admin.bar.siard2.cmd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public enum HashAction
{
    MD5("MD5"), SHA1("SHA1"), SHA256("SHA-256"), SHA512("SHA-512");

    private String mode;

    HashAction(String mode)
    {
        this.mode = mode;
    }

    public String getMode()
    {
        return mode;
    }

    public byte[] checkSum(String buffer)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance(getMode());

            digest.update(buffer.getBytes());

            return digest.digest();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    public byte[] checkSum(File input)
    {
        try (InputStream in = new FileInputStream(input)) {
            MessageDigest digest = MessageDigest.getInstance(getMode());

            int length;
            byte[] block = new byte[4096];
            while ((length = in.read(block)) > 0) {
                digest.update(block, 0, length);
            }

            return digest.digest();
        } catch (IOException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}
