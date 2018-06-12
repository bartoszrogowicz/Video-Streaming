package pl.polsl.rtc.security;

public class SecurityConstatns {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final long TIME_TOKEN_NO_REMEBER = 3_600_000; //1 hour

    public static final long TIME_TOKEN_IS_REMEBER = 14_400_000; //4 hour

    public static final String SECRET_KEY = "MySecurityKeyForApplication";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String AUTHORITIES_KEY = "auth";
}
