package org.example.core.auth;

public final class UserContextHeaders {
    public static final String USER_ID = "X-User-Id";
    public static final String EMAIL = "X-User-Email";
    public static final String ROLES = "X-User-Roles";
    public static final String TENANT = "X-User-Tenant";
    public static final String IP = "X-User-Ip";

    private UserContextHeaders() {
    }
}
