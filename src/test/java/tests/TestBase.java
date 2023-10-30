package tests;

import config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.Base64;

public class TestBase {

    protected static final ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public static String getBase64Credentials(String login, String password) {
        String credentials = login + ":" + password;
        byte[] credentialsBytes = credentials.getBytes();
        byte[] base64Bytes = Base64.getEncoder().encode(credentialsBytes);
        return new String(base64Bytes);
    }
}
