/**
 * Created by swift-seeker-89717 on 17.04.2015.
 */
$(document).ready(function(){
    valid = {
        "email": function(){
            var email = $("#email");
            var label = $("#errorEmail");
            var pattern = /^.+@.+[.].{2,}$/i;
            if (!pattern.test(email.val())){
                email.addClass("error");
                label.text("Email is not valid");
                return false;
            } else {
                email.removeClass("error");
                label.text("");
                return true;
            }
        },
        "login": function(){
            var login = $("#login");
            var label = $("#errorLogin");
            var pattern = /^[a-z0-9_-]{3,15}$/;
            if (!pattern.test(login.val())) {
                login.addClass("error");
                label.text("Login is not valid(3 < length < 20)");
                return false;
            } else {
                login.removeClass("error");
                label.text("");
                return true;
            }
        },
        "password": function(){
            var password = $("#password");
            var label = $("#errorPassword");
            if (password.val().length > 20 || password.val().length < 6){
                password.addClass("error");
                label.text("Password is not valid(6 < length < 20)");
                return false;
            } else {
                password.removeClass("error");
                label.text("");
                return true;
            }
        },
        "confirmPassword": function(){
            var confirmPassword = $("#confirmPassword");
            var label = $("#errorConfirmPassword");
            var password = $("#password");
            if (!(confirmPassword.val() === password.val())){
                confirmPassword.addClass("error");
                label.text("Passwords does not match");
                return false;
            } else {
                confirmPassword.removeClass("error");
                label.text("");
                return true;
            }
        },
        "firstName": function(){
            var firstName = $("#firstName");
            var label = $("#errorFirstName");
            var pattern = /^[a-z?-?]{3,15}/;
            if (!pattern.test(firstName.val())) {
                firstName.addClass("error");
                label.text("First name is not valid(1 < length < 25)");
                return false;
            } else {
                firstName.removeClass("error");
                label.text("");
                return true;
            }
        },
        "lastName": function(){
            var lastName = $("#lastName");
            var label = $("#errorLastName");
            var pattern = /^[a-z?-?]{3,15}/;
            if (!pattern.test(lastName.val())) {
                lastName.addClass("error");
                label.text("Last name is not valid(1 < length < 25)");
                return false;
            } else {
                lastName.removeClass("error");
                label.text("");
                return true;
            }
        },
        "age": function(){
            var age = $("#age");
            var label = $("#errorAge");
            var pattern = /^\d{1,3}$/;
            if (!pattern.test(age.val()) || age.val() < 14 || age.val() > 80) {
                age.addClass("error");
                label.text("Age is not valid(1 < age < 100)");
                return false;
            } else {
                age.removeClass("error");
                label.text("");
                return true;
            }
        }
    };

    $('#submit').click(function (){
        valid.email();
        valid.login();
        valid.password();
        valid.confirmPassword();
        valid.firstName();
        valid.lastName();
        valid.age();
        return false;
    });

});