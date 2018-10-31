package utils;

public interface Message {

	static final String SQL_EXCEPTION_MESSAGE = "At the moment is impossible satisfy the request. Please contact database administrator.";
	static final String SIGNUP_ERROR_MESSAGE = "Already registered user.";
	static final String PASSWORD_ERROR_MESSAGE = "Wrong password";
	static final String USERNAME_ERROR_MESSAGE = "Username already in use";
	static final String SIGNUP_CONFIRM_MESSAGE = "Thank you for registering";
	static final String LOGIN_ERROR_MESSAGE = "Unregistered user or wrong credentials";
	static final String INJECTION_ATTEMPT_MESSAGE = "At the moment is impossible satisfy the request. Please contact database administrator.";
	static final String LOGIN_CONFIRM_MESSAGE = "Welcome";
	static final String BRUTEFORCE_ATTEMPT_MESSAGE = "Numbers of login attempts exceeded";
	static final String LOGOUT_MESSAGE = "Bye Bye";
}
