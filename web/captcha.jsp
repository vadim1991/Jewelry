<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 08.04.2015
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML><html dir="ltr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=yes">
    <title>ReCAPTCHA demo</title>
    <link rel="stylesheet" href="https://www.gstatic.com/recaptcha/api2/r20150330155956/demo__ltr.css" type="text/css">
    <script src='/recaptcha/api.js' async defer>

    </script>
</head>
<body>
<div class="sample-form">
    <form method="POST">
        <fieldset>
            <legend>Sample Form with ReCAPTCHA</legend>
            <ul>
                <li>
                    <label for="input1">First Name</label>
                    <input class="jfk-textinput" id="input1" name="input1" type="text" value="Jane" disabled
                           aria-disabled="true">
                </li>
                <li>
                    <label for="input2">Last Name</label>
                    <input class="jfk-textinput" id="input2" name="input2" type="text" value="Smith" disabled
                           aria-disabled="true"></li>
                <li><label for="input3">Email</label>
                    <input class="jfk-textinput" id="input3" name="input3" type="text" value="stopallbots@gmail.com"
                           disabled aria-disabled="true"></li>
                <li><p>Pick your favorite color:</p><label class="jfk-radiobutton-label" for="option1">
                    <input class="jfk-radiobutton-checked" type="radio" id="option1" name="radios" value="option1"
                           disabled aria-disabled="true" checked aria-checked="true">Red</label>
                    <label class="jfk-radiobutton-label" for="option2"><input class="jfk-radiobutton" type="radio"
                                                                              id="option2" name="radios" value="option2"
                                                                              disabled
                                                                              aria-disabled="true">Green</label>
                </li>
                <li>
                    <div class="recaptcha-error"><!-- BEGIN: ReCAPTCHA implementation example. -->
                        <div class="g-recaptcha" data-sitekey="6Le-wvkSAAAAAPBMRTvw0Q4Muexq9bi0DJwx_mJ-">

                        </div>
                        <!-- Optional noscript fallback. -->
                        <noscript>
                            <div style="width: 302px; height: 352px;">
                                <div style="width: 302px; height: 352px; position: relative;">
                                    <div style="width: 302px; height: 352px; position: absolute;">
                                        <iframe src="/recaptcha/api/fallback?k=6Le-wvkSAAAAAPBMRTvw0Q4Muexq9bi0DJwx_mJ-"
                                                frameborder="0" scrolling="no"
                                                style="width: 302px; height:352px; border-style: none;">

                                        </iframe>
                                    </div>
                                    <div style="width: 250px; height: 80px; position: absolute; border-style: none; bottom: 21px; left: 25px; margin: 0px; padding: 0px; right: 25px;">
                                        <textarea dir="ltr" id="g-recaptcha-response" name="g-recaptcha-response"
                                                  class="g-recaptcha-response"
                                                  style="width: 250px; height: 80px; border: 1px solid #c1c1c1; margin: 0px; padding: 0px; resize: none; "></textarea>
                                    </div>
                                </div>
                            </div>
                            <br></noscript>
                        <!-- END: ReCAPTCHA implementation example. -->
                        <div class="recaptcha-error-message">Please verify that you are not a robot.</div>
                    </div>
                </li>
                <li><input type="submit" value="Submit"/></li>
            </ul>
        </fieldset>
    </form>
</div>
</body>
</html>
