package by.bsu.ta.service;

import by.bsu.ta.model.UserData;

public class UserDataCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_INVALID_EMAIL = "testdata.user.invalid_email";
    public static final String TESTDATA_USER_INCORRECT_PASSWORD = "testdata.user.incorrect_password";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static UserData withInvalidEmail() {
        return new UserData(
                TestDataReader.getTestData(TESTDATA_USER_INVALID_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD)
        );
    }

    public static UserData withIncorrectPassword() {
        return new UserData(
                TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD)
        );
    }
}
