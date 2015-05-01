/**
 * Created by swift-seeker-89717 on 15.04.2015.
 */
function Product(id, title, img) { // id: product-stub
    this.title = title; // class: product-big-img
    this.imgSource = img;
    this.id = id;
    this.link = "details?id=" + id;
    this.height = "150px"
}

Product.prototype.getStub = function () {
    var clone = $("#item").clone();
    clone.removeClass("stub");
    clone.removeAttr("id");
    return clone;
};

Product.prototype.build = function () {
    var stub = this.getStub();

    stub.find(".id").val(this.id);
    stub.find(".title").text(this.title);
    stub.find(".img").attr("src", this.imgSource);
    stub.find(".link").attr("href", this.link);

    return stub;
};