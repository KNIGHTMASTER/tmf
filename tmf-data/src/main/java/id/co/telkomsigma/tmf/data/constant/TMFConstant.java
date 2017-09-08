package id.co.telkomsigma.tmf.data.constant;

/**
 * Created on 8/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface TMFConstant {

    interface Common {
        String BASE_PACKAGES = "id.co.telkomsigma.tmf";
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

        String APPLICATION_JSON = "application/json";
        String APPLICATION_XML = "application/xml";

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
        String PATH_ECHO = "/echo";
        String PATH_START_JMS_MANAGER = "/jms/manager/start";
        String PATH_STOP_JMS_MANAGER = "/jms/manager/stop";

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

        interface Security{
            String PATH_COMPANY = "/api/security/190001";
            String PATH_BRANCH = "/api/security/190002";
            String PATH_ROLE = "/api/security/190003";
            String PATH_GROUP = "/api/security/190006";
            String PATH_FUNCTION = "/api/security/190004";
            String PATH_FUNCTION_ASSIGNMENT = "/api/security/190005";
            String PATH_PROFILE = "/api/security/190010";
            String PATH_PASSWORD = "/api/security/password";
            String PATH_GET_PROFILE = "/191001";
            String PATH_UPDATE_PROFILE = "/191002";
            String PATH_UPDATE_PASSWORD = "/191003";
            String PATH_FORGOT_PASSWORD = "/191004";
            String PATH_RESET_PASSWORD = "/191005";
            String PATH_REGISTRATION = "/api/security/200001";
            String PATH_REGISTRATION_MEMBER = "200002";
            String PATH_ACTIVATE_MEMBER = "200003";
        }

        interface Master{
            String PATH_COUNTRY = "/api/130006";

            String PATH_PROVINCE = "/api/130017";
            String PATH_PROVINCE_BY_COUNTRY_ID = "/api/130171";
            String PATH_PROVINCE_BY_COUNTRY_CODE = "/api/130172";
            String PATH_PROVINCE_BY_COUNTRY_NAME = "/api/130173";

            String PATH_CITY = "/api/130004";
            String PATH_CITY_BY_PROVINCE_ID = "/api/130041";
            String PATH_CITY_BY_PROVINCE_CODE = "/api/130042";
            String PATH_CITY_BY_PROVINCE_NAME = "/api/130043";

            String PATH_DISTRICT = "/api/130008";
            String PATH_DISTRICT_BY_CITY_ID = "/api/130081";
            String PATH_DISTRICT_BY_CITY_CODE = "/api/130082";
            String PATH_DISTRICT_BY_CITY_NAME = "/api/130083";

            String PATH_VILLAGE = "/api/130023";
            String PATH_VILLAGE_BY_DISTRICT_ID = "/api/130231";
            String PATH_VILLAGE_BY_DISTRICT_CODE = "/api/130232";
            String PATH_VILLAGE_BY_DISTRICT_NAME = "/api/130233";
        }
    }

    interface Role {
        String ROLE_SUPERADMIN = "ROLE_SUPERADMIN";
        String ROLE_ADMIN = "ROLE_ADMIN";
        String ROLE_USER = "ROLE_USER";
        String ROLE_MEMBER = "ROLE_MEMBER";
        String ROLE_THIRD_PARTY = "ROLE_THIRD_PARTY";
    }

    interface Query {
        String LOGIN = "SELECT "
                + "ocd.client_id, ocd.client_secret, sud.user_enabled, "
                + "sud.user_expired_date, sud.user_credentials_expired_date, sud.user_non_locked, sr.code "
                + "FROM sec_user_details sud "
                + "JOIN sec_oauth_client_details ocd ON sud.client_id = ocd.client_id "
                + "JOIN sec_role sr ON sud.role_id = sr.id "
                + "JOIN sec_user_profile mp ON mp.user_id = sud.user_id "
                + "JOIN sec_contact sc ON sc.id = mp.contact_id "
                + "WHERE ocd.client_id = ? OR sc.email = ? OR sc.phone_number_1 = ?";

        String AUTHENTICATION_CHANGE = "UPDATE oauth_client_details "
                + "SET client_secret = ?1 WHERE client_id = ?2";
        String SELECT_LOV = "SELECT id, name FROM #{#entityName}";
        String COUNT_ENTITY_SIZE = "SELECT COUNT(a) FROM #{#entityName} a";
        String COUNT_ENTITY_SIZE_BY_STATUS = "SELECT COUNT(a) FROM #{#entityName} a where a.status = ?1";
        String COUNT_ENTITY_SIZE_BY_CODE = "SELECT COUNT(a) FROM #{#entityName} a where a.code LIKE %?1%";
        String COUNT_ENTITY_SIZE_BY_CODE_AND_STATUS = "SELECT COUNT(a) FROM #{#entityName} a where a.code LIKE %?1% and a.status = ?2";
        String COUNT_ENTITY_SIZE_BY_NAME = "SELECT COUNT(a) FROM #{#entityName} a where a.name LIKE %?1%";
        String COUNT_ENTITY_SIZE_BY_NAME_AND_STATUS = "SELECT COUNT(a) FROM #{#entityName} a where a.name LIKE %?1% and a.status = ?2";
        String ADVANCED_PAGINATION = "SELECT a FROM #{#entityName} a WHERE a.?1 = ?2";
        int STATUS_APPROVED = 1;
        int STATUS_CANCELLED = 0;
        String ASCENDING = "asc";
        String DESCENDING = "desc";
    }

    interface BeanName {
        String SCAFFOLDING_SERVICE_BEAN = "scaffoldingService";
    }

    interface ResourceProperties {
        public static final String PARAM_HEADER_KEY = "${eth.api.param.key}";
        public static final String PARAM_HEADER_TIMESTAMP = "${eth.api.param.timestamp}";
        public static final String PARAM_HEADER_SIGNATURE = "${eth.api.param.signature}";
        public static final String WSCONTEXT = "${eth.wscontext}";
    }

    interface SystemParameterKey {
        public static final String EMAIL_FORGOT_PASSWORD_SUBJECT = "ETH.EMAIL.FORGOT.PASSWORD.SUBJECT";
        public static final String EMAIL_FORGOT_PASSWORD_BODY_MESSAGE = "ETH.EMAIL.FORGOT.PASSWORD.BODY.MESSAGE";
        public static final String EMAIL_FORGOT_PASSWORD_VERIFY_SUBJECT = "ETH.EMAIL.FORGOT.PASSWORD.VERIFY.SUBJECT";
        public static final String EMAIL_FORGOT_PASSWORD_VERIFY_BODY_MESSAGE = "ETH.EMAIL.FORGOT.PASSWORD.VERIFY.BODY.MESSAGE";
        public static final String EMAIL_NEW_USER_SUBJECT = "ETH.EMAIL.NEW.USER.SUBJECT";
        public static final String EMAIL_NEW_USER_BODY_MESSAGE = "ETH.EMAIL.NEW.USER.BODY.MESSAGE";
        public static final String HEADER_KEY = "ETH.HEADER.KEY";
    }

    interface ApplicationContext {
        public static final String CONTEXT_CONFIG_LOCATION_PARAMETER = "contextConfigLocation";
        public static final String CONTEXT_SYSTEM_PARAMETER = "CONTEXT_SYSTEM_PARAMETER";
        public static final String CONTEXT_I18NLOCALE = "CONTEXT_I18NLOCALE";
    }

    interface Queue {
        String QUEUE_HEADER = "tmf.queue";
    }

    interface JMS{
        String JMSConnectionFactoryName = "tmfJmsListenerConnectionFactory";
    }
}
