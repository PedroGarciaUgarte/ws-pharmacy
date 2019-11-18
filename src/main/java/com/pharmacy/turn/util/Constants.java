package com.pharmacy.turn.util;

public class Constants {

    public static final String SCHEME_CONFIG = "scheme: {}";
    public static final String ENDPOINT_CONFIG = "endpoint: {}";
    public static final String PROCESS_CONFIG = "process: {}";
    public static final String ERROR = "Error: ";

    public static final String TYPE_JSON = "application/json";
    public static final String API_REQUEST = "API request: {}";
    public static final String API_RESPONSE = "API response: {}";

    public static final String URI = "URI: {}";
    public static final String EMPTY_LINE = "";

    public static final String SUFFIX = "?id_region=";
    public static final String REG_ID = "reg_id";

    public static final String ERROR_UNAUTHORIZED_CODE = "401 UNAUTHORIZED";
    public static final String ERROR_MESSAGE_UNAUTHORIZED = "HTTP Header (X_AUTH_TOKEN | X_RESOURCE_NAME) not defined.";

    private Constants() {
    }
}
