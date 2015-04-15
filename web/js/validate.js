/**
 * Created by swift-seeker-89717 on 15.04.2015.
 */
var classForm = "form-field";
function validName() {
    var name = document.getElementById("name");
    var label = document.getElementById("nameError");
    var pattern = /^[a-z?-?]{3,15}/;
    if (!pattern.test(name.value)) {
        label.innerHTML = "Некорректное имя пользователя";
        name.className = "error";
        return false;
    } else {
        label.innerHTML = null;
        name.className = classForm;
        return true;
    }
}
function validSurname() {
    var surname = document.getElementById("surname");
    var label = document.getElementById("surnameError");
    var pattern = /^[a-z?-?]{3,15}/;
    if (!pattern.test(surname.value)) {
        label.innerHTML = "Некорректная фамилия пользователя";
        surname.className = "error";
        return false;
    } else {
        label.innerHTML = null;
        surname.className = classForm;
        return true;
    }
}
function validAge() {
    var age = document.getElementById("age");
    var label = document.getElementById("ageError");
    var pattern = /^\d{1,3}$/
    if (!pattern.test(age.value) || age.value < 14 || age.value > 80) {
        label.innerHTML = "Введите корректный возраст (от 14 до 80 лет)";
        age.className = "error";
        return false;
    } else {
        label.innerHTML = null;
        age.className = classForm;
        return true;
    }
}
function validEmail() {
    var email = document.getElementById("email");
    var label = document.getElementById("emailError");
    var pattern = /^.+@.+[.].{2,}$/i;
    if (!(pattern.test(email.value))) {
        label.innerHTML = "Вы ввели некорректный email";
        email.className = "error";
        return false;
    } else {
        label.innerHTML = null;
        email.className = classForm;
        return true;
    }
}
function validLogin() {
    var login = document.getElementById("login");
    var label = document.getElementById("loginError");
    var pattern = /^[a-z0-9_-]{3,15}$/;
    if (!pattern.test(login.value)) {
        label.innerHTML = "Некорректный логин (должен содержать буквы и цифры)";
        login.className = "error";
        return false;
    } else {
        label.innerHTML = null;
        login.className = classForm;
        return true;
    }
}
function validPassword() {
    var password = document.getElementById("password");
    var label = document.getElementById("passwordError");
    var pattern = /((?=.*\d)(?=.*[a-z]).{4,20})/
    if (!pattern.test(password.value)) {
        label.innerHTML = "Некорректный пароль (должен содержать буквы и цифры)"
        password.className = "error";
        return false;
    } else {
        label.innerHTML = null;
        password.className = classForm;
        return true;
    }
}
function confirmPassword() {
    var password = document.getElementById("password");
    var passwordConfirm = document.getElementById("passwordConfirm");
    var label = document.getElementById("passwordConfError");
    if ((!(password.value == passwordConfirm.value) || passwordConfirm.value.length < 4)) {
        label.innerHTML = "Вы неверно подтвердили пароль";
        passwordConfirm.className = "error";
        return false;
    } else {
        label.innerHTML = null;
        passwordConfirm.className = classForm;
        return true;
    }
}
function isValid() {
    return validName() && validEmail() && validLogin() && validPassword() && validSurname() && confirmPassword() && validAge();
}