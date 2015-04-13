<%--
  Created by IntelliJ IDEA.
  User: swift-seeker-89717
  Date: 13.04.2015
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="keywords" content="jQuery Slider, Slider Widget, RangeSlider"/>
    <meta name="description"
          content="jqxSlider represents a flexible jQuery Slider that lets the user select from a range of values by moving a thumb along a track. The widget is completely customizable in terms of appearance and offers numerous configuration options like mouse wheel and keyboard support, smooth or step-based slider and support for range sliders."/>
    <title id='Description'>jqxSlider represents a flexible jQuery Slider that lets the user select from a range of
        values by moving a thumb along a track. The widget is completely customizable in terms of appearance and offers
        numerous configuration options like mouse wheel and keyboard support, smooth or step-based slider and support
        for range sliders.</title>
    <link rel="stylesheet" href="css/widget/jqx.base.css"/>
    <link rel="stylesheet" href="css/widget/jqx.bootstrap.css"/>
    <link rel="stylesheet" href="css/widget/jqx.summer.css"/>
    <link rel="stylesheet" href="css/widget/jqx.black.css"/>
    <link rel="stylesheet" href="css/widget/jqx.shinyblack.css"/>
    <link rel="stylesheet" href="css/design.css"/>
    <link rel="stylesheet" href="css/justified-nav.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/widgets/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/widgets/demos.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcore.js"></script>
    <script type="text/javascript" src="js/widgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcheckbox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxslider.js"></script>
    <script type="text/javascript" src="js/widgets/jqxcombobox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="js/widgets/jqxscrollbar.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var start = $("#startPrice");
            var end = $("#endPrice");
            var startWeight = $("#startWeigh");
            var endWeight = $("#endWeight");
            $('#redLevel').jqxSlider({
                theme: "black",
                min: 0,
                max: 4000,
                step: 100,
                ticksFrequency: 300,
                mode: 'fixed',
                values: [0, 4000],
                rangeSlider: true,
                width: 180
            });
            $('#greenLevel').jqxSlider({
                theme: "black",
                min: 0,
                max: 10.0,
                step: 0.4,
                ticksFrequency: 0.6,
                mode: 'fixed',
                values: [0, 10.0],
                rangeSlider: true,
                width: 180
            });
            $('#redLevel').on('change', function (event) {
                start.val($('#redLevel').jqxSlider('value').rangeStart);
                end.val($('#redLevel').jqxSlider('value').rangeEnd);
            });
            $('#greenLevel').on('change', function (event) {
                startWeight.val($('#greenLevel').jqxSlider('value').rangeStart);
                endWeight.val($('#greenLevel').jqxSlider('value').rangeEnd);
            });
            $('#blueLevel').on('change', function (event) {
                setColor();
            });

        })
        ;
    </script>
    <script>
        $(document).ready(function () {
            var source = [
                "Белое золото",
                "Красное золото",
                "Серебро"
            ];
            // Create a jqxComboBox
            $("#jqxComboBox").jqxComboBox({
                source: source,
                selectedIndex: 0,
                width: '200px',
                height: '25px',
                theme: 'black'
            });
            $('#jqxComboBox').bind('select', function (event) {
                var args = event.args;
                var item = $('#jqxComboBox').jqxComboBox('getItem', args.index);
                $("#material").val(item.label);
            });
        });
    </script>
    <style type="text/css">
        .colorBlock {
            border: 1px solid #aaa;
            width: 200px;
            height: 200px;
            float: right;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
        }

        .colorLabel {
            padding: 6px;
        }
    </style>
</head>
<body class='default'>
<form>
    <div style="width: 550px">
        <div style="height: 180px;">
            <div style="float: left">
                <span style="font-style: italic;">Цена изделия</span>

                <div id='redLevel'>
                </div>
                <div>
                    <input class="form-field" type="text" id="startPrice" value="0">
                    <input class="form-field" type="text" id="endPrice" value="4000">
                </div>
                <span style="font-style: italic;">Вес изделия</span>

                <div id='greenLevel'>
                </div>
                <div>
                    <input class="form-field" type="text" id="startWeigh" value="0">
                    <input class="form-field" type="text" id="endWeight" value="10.0">
                </div>
                <span style="font-style: italic;">Материал</span>

                <div id='jqxComboBox'>
                </div>
                <div>
                    <input class="form-field" type="hidden" id="material">
                </div>
                <div>
                    <input type="submit" class="b-home" value="Поиск">
                </div>
            </div>
        </div>
    </div>
    </div>
</form>
</body>
</html>
