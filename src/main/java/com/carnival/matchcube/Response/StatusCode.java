package com.carnival.matchcube.Response;

public class StatusCode {
    public static final int OK = 100;
    public static final int CREATED = 101;
    public static final int POSSIBLE_TEAM_NAME = 102;

    public static final int NO_EMAIL = 201;
    public static final int NO_CONTENT = 202;
    public static final int DUPLICATE_EMAIL = 203;
    public static final int NO_HAVE_TEAMS = 204;
    public static final int SIGN_IN_FAIL = 205;
    public static final int NOT_VALID_AREA_CODE = 206;
    public static final int DUPLICATE_TEAM_NAME = 207;
    public static final int NOT_VALID_ACCOUNT_ID = 208;
    public static final int DUPLICATED_TEAM_IMAGE = 209;
    public static final int TOO_LONG_TEAM_NAME = 210;
    public static final int CANNOT_UPDATE = 211;

    public static final int BAD_REQUEST =  400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int DB_ERROR = 600;
}
