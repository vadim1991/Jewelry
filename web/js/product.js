function ProductObject(id, imgSource, title, price) { // id: product-stub
    this.price = price; // class: product-price
    this.title = title; // class: product-big-img
    this.imgSource = imgSource;
    this.id = id;
    this.link = "details?id=" + id;
    this.cart = "#cartInfo";
}

ProductObject.prototype.getStub = function () {
    var clone = $("#product-stub").clone();
    clone.removeClass("stub");
    clone.removeAttr("id");
    return clone;
};

ProductObject.prototype.build = function () {
    var stub = this.getStub();

    stub.find(".id").val(this.id);
    stub.find(".price").text(this.price);
    stub.find(".title").text(this.title);
    stub.find(".image").attr("src", this.imgSource);
    stub.find(".more").attr("href", this.link);
    stub.find(".cart").attr("href",this.cart);
    stub.find(".cart").click(function () {
        var id = $(this).parent().parent().find("input.id");
        $.ajax({
            url: "cart",
            method: "get",
            dataType: "text",
            data: {
                "id": id.val()
            },
            success: function (data) {
                $("#amount").html(data);
            }
        })
    })

    return stub;
};