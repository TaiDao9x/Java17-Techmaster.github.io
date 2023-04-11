// Danh sách các sản phẩm có trong giỏ hàng
let products = [
  {
    name: "Iphone 13 Pro Max", // Tên sản phẩm
    price: 3000000, // Giá mỗi sản phẩm
    brand: "Apple", // Thương hiệu
    count: 2, // Số lượng sản phẩm trong giỏ hàng
  },
  {
    name: "Samsung Galaxy Z Fold3",
    price: 41000000,
    brand: "Samsung",
    count: 1,
  },
  {
    name: "IPhone 11",
    price: 15500000,
    brand: "Apple",
    count: 1,
  },
  {
    name: "OPPO Find X3 Pro",
    price: 19500000,
    brand: "OPPO",
    count: 3,
  },
];

console.log(products);
// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
// Ví dụ : OPPO Find X3 Pro - 19500000 - OPPO - 3
for (const x of products) {
  console.log(x.name + " - " + x.price + " - " + x.brand + " - " + x.count);
}
products.map((x) =>
  console.log(x.name + " - " + x.price + " - " + x.brand + " - " + x.count)
);

// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
// Tổng tiền mỗi sản phẩm = price * count

// 3. Tìm các sản phẩm của thuơng hiệu "Apple"
function find_bran_apple(products) {
  return products.filter((x) => (x.brand === "Apple"));
}
console.log(find_bran_apple(products))
// 4. Tìm các sản phẩm có giá > 20000000

// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)

// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product

// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng

// 8. Sắp xếp giỏ hàng theo price tăng dần

// 9. Sắp xếp giỏ hàng theo count giảm dần

// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
