package com.example.book.utils;

import java.util.Arrays;
import java.util.Optional;

public enum ResponseErrorCode {

    BAD_REQUEST(400, 400, "Bad request"),

    CODE_90001_LACK_OF_REQUEST_FIELDS(400, 90001, "Lack of request fields."),
    CODE_90002_USER_CREDENTIAL_ERROR(400, 90002, "Incorrect phoneNum or password."),
    CODE_90403_USER_ACCOUNT_LOCKED(400, 90403, "User is locked. (too many login failed)"),
    CODE_90003_USER_ACCOUNT_FROZEN(400, 90003, "User is frozen."),
    CODE_90004_EXCEEDS_QUOTA(400, 90004, "Exceeds today’s quota."),
    CODE_90005_INVALID_APPLICATION_DATA(400, 90005, "Invalid Store application data."),
    CODE_90006_INVALID_REGISTER_DATA(400, 90006, "Invalid register data."),
    CODE_90007_PHONENUM_REGISTERED(400, 90007, "The phoneNum is registered."),
    CODE_90008_PASSWORD_NOT_MODIFIED(400, 90008, "The new password is not allowed to be the same with the previous one."),
    CODE_90009_REALNAME_REQUIRED(400, 90009, "The user must have realname auth first."),
    CODE_90010_BANKACCOUNT_REQUIRED(400, 90010, "The user must have bank account auth first."),
    CODE_90011_USER_REQUIRED(400, 90011, "User is required."),
    CODE_90012_STORE_REQUIRED(400, 90012, "Store is required."),
    CODE_90013_STORE_SHOULD_BE_APPROVED(400, 90013, "Store should be approved"),
    CODE_90014_STORE_OPERATION_ONLY_FOR_EMPLOYEE(400, 90014, "This operation is only for the employee."),
    CODE_90015_STORE_WITHDRAW_ACCOUNT_REQUIRED(400, 90015, "The store must have withdraw account."),
    CODE_90016_CREDITCARDS_FULL(400, 90016, "Creditcards full"),
    CODE_90017_BANKACCOUNT_EXISTED(400, 90017, "The bank account is existed"),
    CODE_90018_BANKACCOUNT_NOT_EXISTED(400, 90018, "bank account not existed"),
    CODE_90019_TRADE_ERROR(400, 90019, "Trade error."),
    CODE_90020_DEVICE_REQUIRED(400, 90020, "Device not found."),
    CODE_90021_INVALID_LOGIN_DATA(400, 90021, "Invalid login data."),
    CODE_90022_INCORRECT_AUTH_CODE(400, 90022, "Incorrect AuthCode."),
    CODE_90023_INVALID_PHONE_NUM(400, 90023, "Invalid phoneNum."),
    CODE_90024_TRADE_REQUIRED(400, 90024, "Trade is required."),
    CODE_90025_TRADE_TIMED_OUT(400, 90025, "Trade timed out."),
    CODE_90026_CREDIT_REQUIRED(400, 90026, "CreditCard is required."),
    CODE_90027_TRADE_PASSWORD_REQUIRED(400, 90027, "Trade password is required."),
    CODE_90028_USER_ACCOUNT_IN_BLACK_LIST(400, 90028, "User is in black list."),
    CODE_90029_EMAIL_REQUIRED(400, 90029, "The user must have email auth first."),
    CODE_90041_INCORRECT_AUTH_CODE_3TIME(400, 90041, "Incorrect AuthCode over 3 times."),
    CODE_90042_DEFAULT_ACCOUNT_CANNOT_BE_DELETED(400, 90042, "Default withdraw account cannot be deleted."), // 預設的提領帳戶不可被刪除
    CODE_90043_REALNAME_AUTH_HAS_BEEN_APPROVED(400, 90043, "Real-name authentication has been approved, cannot be applied again."), // 實名認證已審核通過，不可再次申請
    CODE_90044_NICK_CONTAIN_BLOCK_WORD(400, 90044, "Nickname contain block word."),// 暱稱含有禁字
    CODE_90045_STRING_CONTAIN_INVALID_CHARACTER(400, 90045, "String contain invalid character"),

    CODE_90050_TRADE_PASSWORD_INCORRECT(400, 90050, "Trade password is incorrect."),
    CODE_90051_TRADE_HAS_DONE(400, 90051, "Trade has done."),
    CODE_90052_TRADE_INVALID_AMOUNT(400, 90052, "Trade amount is invalid."),
    CODE_90053_QUERY_HINTS_START_DATE_AFTER_END_DATE(400, 90053, "QueryHints got bad arguments [startDate > endDate]."),
    CODE_90054_EMPLOYEE_REQUIRED(400, 90054, "Employee required"),
    CODE_90055_ACTION_ALLOWED_BY_OWNER(400, 90055, "The action should be done by a owner."),
    CODE_90056_COMPANY_REQUIRED(400, 90056, "Company is required."),
    CODE_90057_REIMBURSE_REQUIRED(400, 90057, "Reimburse is required."),
    CODE_90058_AUTH_CODE_EXPIRED(400, 90058, "Auth code was expired."),
    CODE_90059_EMAIL_VALIDATION_CODE_NOT_EXIT(400, 90059, "email validation code is not exit."),
    CODE_90060_REACH_MAX_PERSONAL_STORE(400, 90060, " reach maxium personal store."), // max 5 personal store
    CODE_90061_STORE_ADMIN_USER_NOT_EXIT(400, 90061, "The store must have admin user."),
    CODE_90062_INVALID_STORE_OWNER(400, 90062, "Invalid store owner."),
    CODE_90063_STORE_EMPLOYEE_NOT_MATCH(400, 90063, "The store does not have this employee."),
    CODE_90064_STORE_EMPLOYEE_EXIT(400, 90064, "The store has this empoyee already."),
    CODE_90065_STORE_EMPLOYEE_IS_SAME_WITH_ADMIN(400, 90065, "Can not delete owner for this store."),
    CODE_90066_TRAN_HAS_CAPTURED(400, 90066, "transaction has captured."),

    CODE_90067_WITHDRAW_AMOUNT_TOO_LESS(400, 90067, "CODE_90067_WITHDRAW_AMOUNT_TOO_LESS"),
    CODE_90068_CREDIT_ACCOUNT_IN_BLACK_LIST(400, 90068, "credit account is in black list."),
    CODE_90069_EMPOLYEE_USER_STATUS_INVALID(400, 90069, "employee user status is invalid."),
    CODE_90070_REACH_MAX_DEVICE(400, 90070, "reach max devices"),
    CODE_90071_USER_IN_APPROVING(400, 90071, "user in approving"),
    CODE_90072_TRADE_PASSWORD_FORMAT_ERROR(400, 90072, "Trade password format error."),
    CODE_90073_BANKACCOUNT_STATUS_INVALID(400, 90073, "Bank account status is invalid."),
    CODE_90074_STORE_INVALID(400, 90074, "Store is invalid."),
    CODE_90075_EMPLOYEE_NOT_ALLOWED(400, 90075, "Empoly is not allowed."),
    CODE_90076_CREDITCARD_IS_THE_SAME(400, 90076, "creditCard is the same."),
    CODE_90077_CREDITCARD_CAN_NOT_BUNDLE(400, 90077, "creditCard can not bundle."),
    CODE_90078_CREDITCARD_CAN_NOT_FAIL(400, 90078, "creditCard can not fail."),
    CODE_90079_CREDITCARD_CAN_NOT_CANCEL(400, 90079, "creditCard can not cancel."),
    CODE_90080_CREDITCARD_INVALID(400, 90080, "creditCard invalid."),
    CODE_90081_NOT_CREDITCARD_OWNER(400, 90081, "Not creditCard owner."),
    CODE_90082_MESSAGE_NOT_FOUND(400, 90082, "Message not found."),
    CODE_90083_AMOUNT_CAN_NOT_FILL(400, 90083, "Amount can not fill."),
    CODE_90084_TRADE_TOKEN_NOT_FOUND(400, 90084, "Trade token not found."),
    CODE_90085_STORE_INACTIVE(400, 90085, "Store is inavtive."),
    CODE_90086_INVALID_COMPANY_OWNER(400, 90086, "Invalid company owner."),
    CODE_90087_INVALID_COMPANY(400, 90087, "Invalid company."),
    CODE_90088_CAN_NOT_BE_EMPLOYEE(400, 90088, "Can not be employee."),
    CODE_90089_INVALID_EMPLOYEE_STATUS(400, 90089, "Invalid employee status."),
    CODE_90090_EXCEED_COMPANY_MONTHLY_QUOTA(400, 90090, "exceed company monthly quota."),
    CODE_90091_EXCEED_STORE_MONTHLY_QUOTA(400, 90091, "exceed store monthly quota."),
    CODE_90092_EXCEED_STORE_TRADEING_QUOTA(400, 90092, "exceed store trading quota."),
    CODE_90093_EXCEED_EMPLOYEE_MONTHLY_QUOTA(400, 90093, "exceed employee monthly quota."),
    CODE_90094_MERCHANT_NAME_DUPLICATE(400, 90094, "merchant name duplicate"),
    CODE_90095_USER_WAS_DISTRIBUTOR(400, 90095, "user was a distributor."),
    CODE_90096_INVALID_WITHDRAW_AMOUNT(400, 90096, "Invalid withdraw amount."),
    CODE_90097_USER_NOT_DISTRIBUTOR(400, 90097, "The user is not a distributor."),

    CODE_90098_FILE_GET_FAIL(400, 90098, "file get failed"),
    CODE_90099_FILE_UPLOADF_FAIL(400, 90099, "file upload failed"),
    CODE_90100_TAX_ID_EXISTS(400, 90100, "Company tax ID exists, cannot be apply by another company user."),

    CODE_90109_USER_AUTH_APPLICATION_DUPLICATE(400, 90109, "Application code already exists."),
    CODE_90110_CONFIG_NOT_EXIST(400, 90110, "Config data do not exist."),
    CODE_90111_CLIENT_USER_USERNAME_EXISTED(400, 90111, "The username is existed"),

    CODE_90112_OAUTH_TOKEN_FAIL(400, 90112, "binding motion fail."),
    CODE_90113_VALID_CODE_FAIL(400, 90113, "challengeCode is invalid."),
    CODE_90114_USER_ALREADY_BINDED(400, 90114, "user already binded."),
    CODE_90115_USER_OAUTH_NOT_FOUND(400, 90115, "userOauth not found."),
    CODE_90116_MTN_TRANSACTION_FAIL(400, 90116, "mtn transaction fail."),

    // Admin Codes
    CODE_90030_INVALID_CAPTCHA(400, 90030, "Invalid Captcha Code."),
    CODE_90031_INVALID_USER_ID(400, 90031, "Invalid userId."),
    CODE_90032_ADMIN_USER_REQUIRED(400, 90032, "Admin user is required."),
    CODE_90033_ADMIN_USER_INACTIVE(400, 90033, "Admin user is inactive."),
    CODE_90034_BONUS_CAMPAIGN_REQUIRED(400, 90034, "BounsCampaign is required."),
    CODE_90035_BONUS_INVALID_DATA(400, 90035, "Invalid bounsCampaign configuration."),
    CODE_90039_INVALID_FILTER(400, 90039, "Invalid filter input."),
    CODE_90040_USER_EXISTS(400, 90040, "User Exists."),
    CODE_90046_ACH_DATA_NOT_EXIST(400, 90046, "Can't find the relative ach_withdraw_ctbc data."),

    // einvoice: 財政部電子發票 API 錯誤訊息
    CODE_91001_EINV_ERROR(400, 91001, "MOF einvoice error"), //預設的錯誤代碼：財政部電子發票系統錯誤之外的其他錯誤都歸在此類
    CODE_91500_EINV_ERROR(400, 91500, "MOF einvoice system error"), //財政部電子發票系統錯誤
    CODE_91901_EINV_ERROR(400, 91901, "MOF einvoice: no record found in this period"), //無此期別資料
    CODE_91903_EINV_ERROR(400, 91903, "MOF einvoice: parameter error"), //參數錯誤
    CODE_91905_EINV_ERROR(400, 91905, "MOF einvoice: registration failed"), //註冊失敗
    CODE_91906_EINV_ERROR(400, 91906, "MOF einvoice: registration exists"), //該號碼&電子郵件已註冊
    CODE_91910_EINV_ERROR(400, 91910, "MOF einvoice: barcode not found"), //此手機號碼與驗證碼查無手機條碼
    CODE_91915_EINV_ERROR(400, 91915, "MOF einvoice: einvoice detail not found"), //查無此發票詳細資料
    CODE_91919_EINV_ERROR(400, 91919, "MOF einvoice: incorrect password"), //參數驗證碼錯誤
    CODE_91922_EINV_ERROR(400, 91922, "MOF einvoice: invalid phone number or invalid email"), //手機號碼或EMAIL錯誤
    CODE_91925_EINV_ERROR(400, 91925, "MOF einvoice: invalid password, try another"), //此密碼太多人使用，請再換一組

    // grpc
    CODE_93000_TEST_SERVICE_ERROR(400, 93000, "TEST_SERVICE"),
    CODE_93100_TOKEN_SERVICE_ERROR(400, 93100, "TOKEN_SERVICE"),
    CODE_93200_MESSAGE_SERVICE_ERROR(400, 93200, "MESSAGE_SERVICE"),
    CODE_93300_DATAENCRPTION_SERVICE_ERROR(400, 93300, "DATAENCRPTION_SERVICE"),
    CODE_93400_PAYMENT_GW_SERVICE_ERROR(400, 93400, "PAYMENT_GW"),
    CODE_93500_CUSTODIAN_SERVICE_ERROR(400, 93500, "ACH"),
    CODE_93600_EINVOICE_GW_SERVICE_ERROR(400, 93600, "EINVOICE_GW_SERVICE"),

    CODE_99403_ACCESS_DENIED(403, 99403, "Access is denied."),

    CODE_99997_NOT_IMPLEMENTED(400, 99997, "Function is not implemented yet."),
    CODE_99998_UNDEFINED_OR_INCOMPLETED_SPEC(400, 99998, "Undefined behavior or incompleted spec"),
    CODE_99999_AUTH_REQUIRED(401, 99999, "Authentication is required"),

    CODE_99501_ACCOUNT_ALREADY_EXISTS(401, 99501, " phone and countrycode mapping user already exists"),
    CODE_99502_INCORRECT_RESET_PASSWORD_AUTH_CODE(401, 99502, " reset password auth code INCORRECT"),
    CODE_90503_DATA_NOT_FOUND(404, 90503, " REQUEST DATA CANT FOUND ANY DATA"),

    CODE_90101_MERADMIN_CREDENTIAL_ERROR(400, 90101, "Incorrect login id or password."),
    CODE_90102_MERADMIN_ACCOUNT_LOCKED(400, 90102, "Sub account is locked. (too many login failed)"),
    CODE_90103_MERADMIN_INACTIVE_ACCOUNT(400, 90103, "The sub account is inactive."),
    CODE_90104_MERADMIN_REMOVED_ACCOUNT(400, 90104, "The sub account is removed."),
    CODE_90105_MERADMIN_NEED_TO_CHANGE_PWD(400, 90105, "The sub account should change password before login."),
    CODE_90106_MERADMIN_NO_TRANS_CONTROL(400, 90106, "The sub account has no transaction control."),
    CODE_90107_MERADMIN_ACCOUNT_EXISTS(400, 90107, "The sub account already exists."),
    CODE_90108_MERADMIN_NO_TRADE_PWD(400, 90108, "The sub account is no trade password."),

    CODE_90121_CARD_ISSUER_INCORRECT_BIN_CODE(400, 90121, "Incorrect bin code, cannot find any data.")
    ;

    public static Optional<ResponseErrorCode> getStatus(int code) {
        return Arrays.stream(ResponseErrorCode.values()).findFirst();
    }
    private Integer httpStatus;
    private Integer code;


    private String message;

    private ResponseErrorCode(Integer httpStatus, Integer code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;

        GlobalErrorCodes.addCodes(code);
    }

    public int getCode() {
        return this.code;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
