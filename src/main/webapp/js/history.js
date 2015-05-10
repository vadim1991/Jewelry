/**
 * Created by Вадим on 10.05.2015.
 */
$(document).ready(function () {
    // prepare the data
    $.ajax({
        url: "ordersHistory",
        method: "post",
        dataType: "json",
        async: false,
        success: function (data) {
            var dataMap = init(data);
            var source =
            {
                localData: dataMap,
                dataType: "array"
            };
            // initialize the row details.
            var initRowDetails = function (id, row, element, rowinfo) {
                var tabsdiv = null;
                var information = null;
                var notes = null;
                // update the details height.
                rowinfo.detailsHeight = 200;
                element.append($("<div style='margin: 10px;'><ul style='margin-left: 30px;'><li class='title'>Title</li></ul><div class='information'></div></div>"));
                tabsdiv = $(element.children()[0]);

                if (tabsdiv != null) {
                    for (var i = 0; i < row.products.length; i++) {
                        var product = row.products[i];
                        information = tabsdiv.find('.information');
                        var title = tabsdiv.find('.title');
                        title.text("Заказ № " + row.id);
                        var container = $('<div style="margin: 5px;"></div>')
                        container.appendTo($(information));
                        var photocolumn = $('<div style="float: left; width: 15%;"></div>');
                        var leftcolumn = $('<div style="float: left; width: 45%;"></div>');
                        var rightcolumn = $('<div style="float: left; width: 40%;"></div>');
                        container.append(photocolumn);
                        container.append(leftcolumn);
                        container.append(rightcolumn);
                        var photo = $("<div class='jqx-rc-all text-center' style='margin: 10px;'><b>Фото</b></div>");
                        var image = $("<div style='margin-top: 10px;'></div>");
                        var imgurl = product.imageUrl;
                        var img = $('<img height="60" src="' + imgurl + '"/>');
                        image.append(img);
                        image.appendTo(photo);
                        photocolumn.append(photo);
                        var productTitle = "<div style='margin: 10px;'><b>Изделие: </b> " + product.title + "</div>";
                        var material = "<div style='margin: 10px;'><b>Материал: </b> " + product.material + "</div>";
                        var weight = "<div style='margin: 10px;'><b>Вес:</b> " + product.weight + "</div>";
                        var amount = "<div style='margin: 10px;'><b>Количество:</b> " + product.amount + "</div>";
                        $(leftcolumn).append(productTitle);
                        $(leftcolumn).append(material);
                        $(leftcolumn).append(weight);
                        $(leftcolumn).append(amount);
                        var insert = "<div style='margin: 10px;'><b>Вставка:</b>" + product.insert + "</div>";
                        var size = "<div style='margin: 10px;'><b>Размер:</b>" + product.size + "</div>";
                        var phone = "<div style='margin: 10px;'><b>Категория:</b>" + product.category + "</div>";
                        var price = "<div style='margin: 10px;'><b>Цена:</b> " + product.price + "</div>";
                        $(rightcolumn).append(phone);
                        $(rightcolumn).append(insert);
                        $(rightcolumn).append(size);
                        $(rightcolumn).append(price);
                        var hr = $("<hr>");
                        container.append(hr);
                        $(tabsdiv).jqxTabs({width: "98%", height: 170, theme: "bootstrap"});
                    }
                }
            };
            var dataAdapter = new $.jqx.dataAdapter(source);
            $("#dataTable").jqxDataTable(
                {
                    width: "80%",
                    source: dataAdapter,
                    pageable: true,
                    pageSize: 3,
                    rowDetails: true,
                    theme: "metrodark",
                    sortable: true,
                    ready: function () {
                        // expand the first details.
                        $("#dataTable").jqxDataTable('showDetails', 0);
                    },
                    initRowDetails: initRowDetails,
                    columns: [
                        {text: 'Номер заказа', dataField: 'id', width: 200},
                        {text: 'Статус заказа', dataField: 'status', width: 100},
                        {text: 'Информация', dataField: 'info', width: 200},
                        {text: 'Дата оформления', dataField: 'date', width: 200},
                        {text: 'Общая сумма', dataField: 'price'}
                    ]
                });
        }

    });

    function init(data) {
        var dataMap = new Array();
        var id = new Array();
        var status = new Array();
        var info = new Array();
        var date = new Array();
        var price = new Array();
        var products = new Array();
        for (var i = 0; i < data.orders.length; i++) {
            id[i] = data.orders[i].id;
            status[i] = data.orders[i].orderStatus;
            info[i] = data.orders[i].orderInfo;
            date[i] = data.orders[i].date;
            price[i] = data.orders[i].totalPrice;
            products[i] = data.orders[i].products;
        }
        for (var i = 0; i < id.length; i++) {
            var row = {};
            row["id"] = id[i];
            row["status"] = status[i];
            row["info"] = info[i];
            row["date"] = date[i];
            row["price"] = price[i];
            row["products"] = products[i];
            dataMap[i] = row;
        }
        return dataMap;
    }
});