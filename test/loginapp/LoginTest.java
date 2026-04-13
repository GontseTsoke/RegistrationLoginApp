package loginapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    public LoginTest() {
    }

    @Test
    public void testCheckUserName_Valid() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserName_Invalid() {
        Login login = new Login();
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        Login login = new Login();
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser_Success() {
        Login login = new Login();
        String expected = "User has been registered successfully.";
        String actual = login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        Login login = new Login();
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("Kyle", "Smith", "kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        Login login = new Login();
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String actual = login.registerUser("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_InvalidCellPhone() {
        Login login = new Login();
        String expected = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        String actual = login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals(expected, actual);
    }

    @Test
    public void testLoginUser_Success() {
        Login login = new Login();
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUser_Failure() {
        Login login = new Login();
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrong", "wrong"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        Login login = new Login();
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String expected = "Welcome Kyle, Smith it is great to see you again.";
        String actual = login.returnLoginStatus(true);
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        Login login = new Login();
        String expected = "Username or password incorrect, please try again.";
        String actual = login.returnLoginStatus(false);
        assertEquals(expected, actual);
    }
}
