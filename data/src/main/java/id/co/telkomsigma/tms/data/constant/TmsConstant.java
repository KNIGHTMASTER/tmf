package id.co.telkomsigma.tms.data.constant;

/**
 * Created on 8/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface TmsConstant {

    interface Common {
        String AUTHORIZATION = "Authorization";
        String BEARER_PREFIX = "Bearer ";
        String BASIC_PREFIX = "Basic ";
        String REALM_PREFIX = "realm=";
        String REALM_BASIC = BASIC_PREFIX.concat(REALM_PREFIX).concat("\"Authorization/client\"");
        String REALM_BEARER = BEARER_PREFIX.concat(REALM_PREFIX).concat("\"oauth\"");
        String WWW_AUTHANTICATE = "WWW-Authenticate";
        String METHOD_POST = "POST";
        String CLIENT_IDENTIFIER = "client_id";
        String CLIENT_SECRET = "client_secret";
        String HTTP_REQUEST = "HTTP.REQUEST";
        String ACCESS_TOKEN = "access_token";

        String DATE_FORMAT = "dd-MM-yyyy";
        String DATE_TIME_FORMAT = "dd-MM-yyyy";
        String PUBLIC_USER = "Public User";

        interface GeneralValue{
            int ONE = 1;
            int ZERO = 0;
            int MIN_ONE = -1;
        }

        interface Punctuation {
            String SPACE = " ";
            String COLON = ":";
            String SEMI_COLON = ";";
            String COMMA = ",";
            String QUESTION = "?";
            String UNDERSCORE = "_";
            String HYPHEN = "-";
            String SLASH = "/";
            String AT_MARK = "@";
            String EMPTY = "";
            String PERCENTAGE = "%";
        }
    }

    interface Table {
        interface Security {
            String SEC_USER_DETAILS = "sec_user_details";
            String SEC_USER_PROFILE = "sec_user_profile";
            String SEC_ROLE = "sec_role";
            String SEC_LOCALE = "sec_locale";
            String SEC_GROUP = "sec_group";
            String SEC_BRANCH = "sec_branch";
            String SEC_COMPANY = "sec_company";
            String SEC_FUNCTION = "sec_function";
            String SEC_FUNCTION_ASSIGNMENT = "sec_function_assignment";
            String SEC_USER_ADDRESS = "sec_user_address";
            String SEC_USER_CONTACT = "sec_contact";
            String SEC_OAUTH_CLIENT_DETAILS = "sec_oauth_client_details";
            String SEC_USER_VERIFICATION = "sec_user_verification";

        }

        interface Master {
            String MST_COMPANY = "mst_company";
            String MST_BRANCH = "mst_branch";
            String MST_API_TYPE = "mst_api_type";
            String MST_PRODUCT_TYPE = "mst_product_type";
            String MST_PRODUCT_BRAND = "mst_product_brand";
            String MST_BANK = "mst_bank";
            String MST_COUNTRY = "mst_country";
            String MST_PROVINCE = "mst_province";
            String MST_CITY = "mst_city";
            String MST_DISTRICT = "mst_district";
            String MST_VILLAGE = "mst_village";
        }

        interface System {
            String SYS_PARAMETER = "sys_parameter";
            String SYS_PARAMETER_GROUP = "sys_parameter_group";
        }

    }

    interface Encryption {
        String HMACMD5 = "HmacMD5";
        String HMACSHA256 = "HmacSHA256";
    }

    interface InfoMarkerConstant {
        String ERR_SIGNATURE_UNDEFINED = "Error Header";
        String ERR_SIGNATURE = "Error Header : {}";
        String ERR_SIGNATURE_PARAM = "X-Sigma Header not null";
        String ERR_USER_DETAILS_SERVICE = "Error User Details Service";
        String ERR_SYSTEM_PARAMETER_CONFIGURE = "System Parameter Initialized";
        String ERR_I18NLOCALE_CONFIGURE = "I18N Locale Initialized";
        String DEB_INITIALIZING_SERVLET = "Initializing context...";
        String ERR_INITIALIZING_SERVLET = "Error Initialized Web Service Integration";
        String DEB_LOCALE_RESOLVER = "Using LocaleResolver [{}]";
        String DEB_LOCALE_RESOLVER_BEAN = "Unable to locate LocaleResolver with name '{}' using default [{}]";
        String INF_BAD_CREDENTIAL_EXCEPTION = "No client credentials presented";
        String ERR_ENDPOINT = "Error Endpoint";
        String ERR_PROFILE_ENDPOINT = "Error Profile Endpoint : {}";
        String ERR_SCAFFOLDING_ENDPOINT = "Error Scaffolding Endpoint : {}";
        String ERR_AUTHENTICATION_ENDPOINT = "Error Authentication Endpoint : {}";
        String ERR_PASSWORD_NOT_VALID = "Error Password Not Valid";
        String ERR_LOCALE_CODE_NULL = "Error Locale Code Not Null";
        String ERR_LOCALE_NOT_FOUND = "Error Locale Not Found";
        String ERR_LOGOUT = "Error on logout";

        String INFO_DATA_NOT_FOUND = "Info Data not Found";
    }

    interface PathName {
        String PATH_OAUTH_TOKEN = "/oauth/token";
        String PATH_PROFILE = "/profile";
        String PATH_CHANGE = "/100005";
        String PATH_LOGOUT = "/100002";
        String PATH_LOCALE = "/locale";
        String PARAM_API_TYPE_CODE = "apiTypeCode";
        String PATH_API_TYPE_CODE = "{" + PARAM_API_TYPE_CODE + "}";
        String PATH_AUTH = "/100001";
        String PATH_REFRESH = "/100004";
        String PATH_ADMIN_MENU_GENERATOR = "/100003";

        interface PathScaffolding {
            String PATH_FIND_ALL = "/100004";
            String PATH_FIND_ALL_PAGINATION = "/100005";

            String PATH_FIND_BY_ID = "/100006";

            String PATH_FIND_BY_CODE = "/100007";
            String PATH_FIND_BY_CODE_ORDER_BY_ID_ASC = "/100008";
            String PATH_FIND_BY_CODE_ORDER_BY_CODE_ASC = "/100009";
            String PATH_FIND_BY_CODE_ORDER_BY_CODE_DESC = "/100010";
            String PATH_FIND_PAGINATION_BY_CODE = "/100011";

            String PATH_FIND_BY_NAME = "/100012";
            String PATH_FIND_BY_NAME_ORDER_BY_ID_ASC = "/100013";
            String PATH_FIND_BY_CODE_ORDER_BY_NAME_ASC = "/100014";
            String PATH_FIND_BY_CODE_ORDER_BY_NAME_DESC = "/100015";
            String PATH_FIND_PAGINATION_BY_NAME = "/100016";
            String PATH_SELECT_LOV = "/100017";

            String PATH_APPROVE_ALL = "/100018";
            String PATH_APPROVE_SINGLE_DATA = "/100019";
            String PATH_CANCEL_ALL = "/100020";
            String PATH_CANCEL_SINGLE_DATA = "/100021";
            String PATH_UPDATE = "100022";
            String PATH_INSERT = "100023";
            String PATH_INSERT_AND_FLUSH = "100024";
            String PATH_INSERT_COLLECTION = "100025";

            String PATH_DELETE = "100026";
            String PATH_DELETE_BY_ENTITY = "100027";
            String PATH_DELETE_COLLECTION = "100028";
            String PATH_DELETE_COLLECTION_BY_ID = "100029";

            String PATH_ADVANCED_PAGINATION = "100030";
        }
    }

    interface Role {
        String ROLE_SUPERADMIN = "ROLE_SUPERADMIN";
        String ROLE_ADMIN = "ROLE_ADMIN";
        String ROLE_USER = "ROLE_USER";
        String ROLE_MEMBER = "ROLE_MEMBER";
        String ROLE_THIRD_PARTY = "ROLE_THIRD_PARTY";
    }
}
