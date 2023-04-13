function Product(product_name, product_price, product_brand, product_count) {
    (this.name = product_name),
      (this.price = product_price),
      (this.brand = product_brand),
      (this.count = product_count);
  }
  
  const product1 = new Product("Iphone 13 Pro Max", 30000000, "Apple", 2);
  const product2 = new Product("Samsung Galaxy Z Fold3", 41000000, "Samsung", 4);
  const product3 = new Product("IPhone 11", 15500000, "Apple", 1);
  const product4 = new Product("OPPO Find X3 Pro", 19500000, "OPPO", 3);
  let products = [product1, product2, product3, product4];
  
  function print_product_list(product_arr) {
    for (product of product_arr)
      console.log(
        `     ${product.name} - ${product.price} - ${product.brand} - ${product.count}`
      );
  }
  function total_price(product_list) {
    return product_list.reduce(
      (total_price, product) => total_price + product.price * product.count,
      0
    );
  }
  function filter_by_brand(product_list, brand) {
    return product_list.filter(
      (product) => product.brand.toLowerCase() === brand.toLowerCase()
    );
  }
  function filter_by_price(product_list, price) {
    return product_list.filter((product) => product.price > price);
  }
  function filter_by_name(product_list, subStr) {
    return product_list.filter((product) =>
      product.name.toLowerCase().includes(subStr.toLowerCase())
    );
  }
  function add_element(product_list, product_item) {
    product_list.push(product_item);
    return product_list;
  }
  let new_product = new Product("Macbook pro", 35000000, "Apple", 5);
  function remove_by_brand(product_list, brand) {
    return product_list.filter(
      (product) => product.brand.toLowerCase() !== brand.toLowerCase()
    );
  }
  function sort_by_price(product_list) {
    return product_list.sort((p1, p2) => p1.price - p2.price);
  }
  function sort_by_count(product_list) {
    return product_list.sort((p1, p2) => p2.count - p1.count);
  }
  function get_random_product(product_list, num) {
    let shuffle_array = product_list.sort((p1, p2) => 0.5 - Math.random());
    return shuffle_array.splice(0, num);
  }
  
  console.log("1. Thông tin các sản phẩm trong giỏ hàng: ");
  print_product_list(products);
  console.log(
    "2. Tổng tiền tất cả sản phẩm trong giở hàng: " + total_price(products)
  );
  console.log("3. Các sản phẩm của thương hiệu Apple: ");
  print_product_list(filter_by_brand(products, "APPLE"));
  console.log("4. Các sản phẩm giá trên 20000000");
  print_product_list(filter_by_price(products, 20000000));
  console.log("5. Các sản phẩm có chữ Pro trong sản phẩm: ");
  print_product_list(filter_by_name(products, "pro"));
  console.log("6. Thêm 1 sản phẩm vào vào mảng:");
  print_product_list(add_element(products, new_product));
  console.log('7. Xóa tất cả sản phẩm thương hiệu "Samsung" trong giở hàng: ');
  print_product_list(remove_by_brand(products, "Samsung"));
  console.log("8. Sắp xếp giỏ hàng theo price tăng dần: ");
  print_product_list(sort_by_price(products));
  console.log("9. Sắp xếp giở hàng theo count giảm dần: ");
  print_product_list(sort_by_count(products));
  console.log("10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng: ");
  print_product_list(get_random_product(products, 2));