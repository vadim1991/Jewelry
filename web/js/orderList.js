/**
 * Created by swift-seeker-89717 on 15.04.2015.
 */
function Product(img, title, desc, price) { // id: product-stub
    this.title = title; // class: product-big-img
    this.imgSource = img;
    this.desc = desc;
    this.price = price
}

Product.prototype.getStub = function () {
    var clone = $("#cartItem").clone();
    clone.removeClass("stub");
    clone.removeAttr("id");
    return clone;
};

Product.prototype.build = function () {
    var stub = this.getStub();

    stub.find(".title").text(this.title);
    stub.find(".cart-item-price").text(this.price);
    stub.find(".cart-item-desc").text(this.desc);
    stub.find(".image").attr("src", this.imgSource);

    return stub;
};
/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
