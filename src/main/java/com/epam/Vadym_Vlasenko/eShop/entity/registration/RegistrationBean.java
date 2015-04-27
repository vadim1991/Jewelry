package com.epam.Vadym_Vlasenko.eShop.entity.registration;

import com.epam.Vadym_Vlasenko.eShop.entity.Image;
import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import com.epam.Vadym_Vlasenko.eShop.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
public class RegistrationBean {

    private static final String NAME_MESSAGE_ERROR = "Неверное имя";
    private static final String SURNAME_MESSAGE_ERROR = "Некорректная фамилия";
    private static final String LOGIN_MESSAGE_ERROR = "Некорректный логин";
    private static final String PASSWORD_MESSAGE_ERROR = "Некорректный пароль";
    private static final String EMAIL__MESSAGE_ERROR = "Некорректный email";
    private static final String AGE__MESSAGE_ERROR = "Некорректное значение возраста";
    private static final String CONFIRM__MESSAGE_ERROR = "Не подтвержден пароль";
    private static final String CAPTCHA__MESSAGE_ERROR = "Не верное значение картинки";

    private static final String NAME_ERROR = "nameError";
    private static final String SURNAME_ERROR = "surnameError";
    private static final String LOGIN_ERROR = "loginError";
    private static final String PASSWORD_ERROR = "passwordError";
    private static final String EMAIL_ERROR = "emailError";
    private static final String AGE_ERROR = "ageError";
    private static final String CONFIRM_PASSWORD_ERROR = "confirmError";
    private static final String CAPTCHA_ERROR = "captchaError";

    private static final String AVATAR_TITLE = "avatar";

    private static final Role role = new Role(2, "client");

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    /**
     * Pattern for login validation
     */
    private static final String LOGIN_PATTERN = "^(\\w){4,15}$";

    /**
     * Pattern for password validation
     */
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{4,20})";

    /**
     * Pattern for firstName validation
     */
    private static final String FIRST_NAME_PATTERN = "^[a-zA-Z]{3,15}";

    /**
     * Pattern for lastName validation
     */
    private static final String LAST_NAME_PATTERN = "^[a-zA-Z]{3,15}";

    /**
     * Maximum age for user
     */
    private static final int MAX_AGE = 100;

    /**
     * Minimmum age for user
     */
    private static final int MIN_AGE = 1;


    private String name;
    private String surname;
    private String age;
    private String login;
    private String password;
    private String email;
    private String confirmPassword;
    private String captcha;
    private String currentCaptcha;
    private Map<String, String> errors;
    private String avatarPath;

    public RegistrationBean() {
    }

    public RegistrationBean(String name, String surname, String age, String login, String password, String email, String confirmPassword, String captcha, String currentCaptcha) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
        this.email = email;
        this.confirmPassword = confirmPassword;
        this.captcha = captcha;
        this.currentCaptcha = currentCaptcha;
        errors = new HashMap<>();
    }

    public Image getAvatarImage() {
        Image image = new Image();
        image.setUrl(avatarPath);
        image.setTitle(AVATAR_TITLE);
        return image;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getCurrentCaptcha() {
        return currentCaptcha;
    }

    public void setCurrentCaptcha(String currentCaptcha) {
        this.currentCaptcha = currentCaptcha;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User getUser() {
        return new User(name, surname, login, password, email, Integer.parseInt(age), role, getAvatarImage());
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public boolean isValid() {
        if (!isNameValid()) {
            errors.put(NAME_ERROR, NAME_MESSAGE_ERROR);
        }
        if (!isSurnameValid()) {
            errors.put(SURNAME_ERROR, SURNAME_MESSAGE_ERROR);
        }
        if (!isLoginValid()) {
            errors.put(LOGIN_ERROR, LOGIN_MESSAGE_ERROR);
        }
        if (!isPasswordValid()) {
            errors.put(PASSWORD_ERROR, PASSWORD_MESSAGE_ERROR);
        }
        if (!isEmailValid()) {
            errors.put(EMAIL_ERROR, EMAIL__MESSAGE_ERROR);
        }
        if (!confirmPassword()) {
            errors.put(CONFIRM_PASSWORD_ERROR, CONFIRM__MESSAGE_ERROR);
        }
        if (!isCaptchaValid()) {
            errors.put(CAPTCHA_ERROR, CAPTCHA__MESSAGE_ERROR);
        }
        if (!isAgeValid()) {
            errors.put(AGE_ERROR, AGE__MESSAGE_ERROR);
        }
        return errors.isEmpty();
    }

    private boolean isNameValid() {
        return checkParameter(name, FIRST_NAME_PATTERN);
    }

    private boolean isSurnameValid() {
        return checkParameter(surname, LAST_NAME_PATTERN);
    }

    private boolean isPasswordValid() {
        return checkParameter(password, PASSWORD_PATTERN);
    }

    private boolean isLoginValid() {
        return checkParameter(login, LOGIN_PATTERN);
    }

    private boolean isEmailValid() {
        return checkParameter(email, EMAIL_PATTERN);
    }

    private boolean isAgeValid() {
        try {
            int age = Integer.parseInt(this.age);
            return age > MIN_AGE && age < MAX_AGE;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean confirmPassword() {
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.equals(confirmPassword);
    }

    private boolean isCaptchaValid() {
        return captcha.equals(currentCaptcha);
    }

    private boolean checkParameter(String parameter, String patternParam) {
        if (parameter == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(patternParam);
        Matcher matcher = pattern.matcher(parameter);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return "RegistrationBean{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", captcha='" + captcha + '\'' +
                ", currentCaptcha='" + currentCaptcha + '\'' +
                ", errors=" + errors +
                '}';
    }
}
