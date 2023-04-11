/* Lab1: Viết hàm tính tổng các số lẻ và chia hết cho 3 trong mảng
arr[1, 2, 3, 4, 5, 6] */
function sum_odd_number_and_divisible_by_3(arr) {
  let result = 0;
  for (const x of arr) {
    if (x % 2 === 1 && x % 3 === 0) result += x;
  }
  return result;
}
console.log(sum_odd_number_and_divisible_by_3([1, 2, 3, 4, 5, 6]));

/* Lab2: Viết hàm tính tổng các số nguyên tố trong mảng
  arr[2, 3, 4, 5, 6, 10, 12, 17]*/
function is_prime(number) {
  if (number <= 1) return false;
  for (let i = 2; i <= number / 2; i++) if (number % i === 0) return false;
  return true;
}

function sum_prime_number(arr) {
  return arr.filter((x) => is_prime(x)).reduce((x, y) => x + y);
}
console.log(sum_prime_number("Lab2:" + [2, 3, 4, 5, 6, 10, 12, 17]));

/* Lab3: Viết function cho phép truyền vào 1 mảng các số, kết quả trả về là 1 mảng mới với các số là
số dư tương ứng khi chia mảng cũ cho 2
Ví dụ : [4,2,5,6,2,7] => [0,0,1,0,0,1] */
function convert_array(arr) {
  arr.map((x) => x % 2);
}
console.log(convert_array([4, 2, 5, 6, 2, 7]));

//Lab4: Viết function để kiểm tra 1 giá trị có nằm trong mảng hay không?
function is_in_array(value, arr) {
  return arr.indexOf(value) !== -1;
}
console.log(is_in_array(0, [4, 2, 5, 6, 2, 7]));

//Lab 5: Viết hàm trả về một mảng chỉ gồm các số chia hết cho 3 và 5 nhỏ hơn 100
function is_divisible_3_and_5() {
  let result = new Array();
  for (let i = 15; i <= 100; i++) {
    if (i % 15 === 0) {
      result.push(i);
    }
  }
  return result;
}
console.log(is_divisible_3_and_5());
/* Lab 6: Viết hàm trả về một mảng chỉ gồm các số nguyên tố từ một mảng đã cho ban đầu
[1, 2, 4, 5, 8, 9, 11] => [2, 5, 11]*/
function prime_array(arr) {
  return arr.filter((x) => is_prime(x) === true);
}
console.log("Lab6: " + prime_array([1, 2, 4, 5, 8, 9, 11]));

/* Lab 9: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần (Sử dụng array để làm)
Ví dụ: repeatString(‘a’) => Kết quả trả về là ‘aaaaaaaaaa’*/
function repeat_string(input_string) {
  let result = [];
  for (let i = 0; i < 10; i++) result.push(input_string);
  return result;
}
console.log(repeat_string(a));
/*Lab 10: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần, ngăn cách nhau bởi dấu gạch
ngang (Sử dụng array để làm)
Ví dụ: repeatString(‘a’) => Kết quả trả về là ‘a-a-a-a-a-a-a-a-a-a' */
function repeat_string2(input_string) {
  let result = [];
  for (let i = 0; i < 10; i++) result.push(input_string);
  return result.join("-");
}
console.log(repeat_string2("a"));

// 12.Lab2
/* Bài 1: Viết function để kiểm tra 1 giá trị có nằm trong mảng hay không?
checkElementExist([1,2,3,4,5], 5) => true
checkElementExist([1,2,3,4,5], 6) => false */
function check_value_exist(array_input, value) {
  return array_input.includes(value);
}
console.log(check_value_exist([1, 2, 3, 4, 5], 5));

/* Bài 2: Viết function truyền vào 1 mảng các số, và 1 giá trị bất kỳ. Trả về mảng mới với các giá trị lớn 
hơn giá trị truyền vào
getElementGreater([1,2,3,4,5], 3) => [4,5]
getElementGreater([1,2,3,4,5], 5) => []*/
function get_element_greater(array_input, value) {
  return array_input.fillter((x) => x > value);
}
console.log(get_element_greater([1, 2, 3, 4, 5], 3));
/*Bài 3: Viết function để tạo mã màu HEX ngẫu nhiên.
randomHexCode() => #728a98
randomHexCode() => #a72938*/
function convert_number(input_number) {
  switch (input_number) {
    case 10:
      return "a";
    case 11:
      return "b";
    case 12:
      return "c";
    case 13:
      return "d";
    case 14:
      return "e";
    case 15:
      return "f";
    default:
      return input_number;
  }
}
function random_hexcode() {
  let result = [];
  result.push("#");
  for (let i = 0; i < 6; i++)
    result.push(convert_number(Math.floor(Math.random() * 16)));
  return result.join("");
}
console.log(random_hexcode());

//Hàm tính tổng các số trong mảng function sum(arr)
function sum1(arr) {
  let result = 0;
  arr.forEach((element) => {
    result += element;
  });
  return result;
}
console.log(sum1());

// Hàm tính tích các số trong mảng function multiple(arr)
function multiple(arr) {
  let result = 1;
  for (const x of arr) result *= x;
  return result;
}
console.log(multiple());

// Hàm tính giá trị trung bình của các số trong mảng function average(arr)
function average(arr) {
  let result = 0;
  for (const x of arr) result += x;
  return result / arr.length;
}
console.log(average());

// Hàm trả ra mảng gồm các phần tử lớn hơn 1 số cho trước function bigger_key(arr, key)
function bigger_key(arr, key) {
  return arr.filter((x) => x > key);
}
console.log(bigger_key());

/* Lab2:
Viết hàm chèn một phần tử vào 1 vị trí cho trước:
funtion insert_element(arr, pos) chèn vào vị trí pos */
function insert_element(arr, x, pos) {
  if (pos < 0 || pos > arr.length) {
    console.log("Index out of bound!");
    return arr;
  }
  return arr.splice(pos, 0, x);
}

/* Lab3:
Viết hàm lọc ra toàn bộ các số chính phương trong mảng
function filter_square_number(arr)
vd: [1,3,4,9,12,16,21] => [1,4,9,16] */
function is_square(num) {
  return Math.sqrt(num) * Math.sqrt(num) === num;
}
function filter_square_number(arr) {
  return arr.filter((x) => is_square(x));
}
console.log(filter_square_number([1, 3, 4, 9, 12, 16, 21]));

/*Lab4:
Viết hàm tìm số nguyên tố lớn nhất trong mảng cho sẵn
function find_big_prime_num(arr)
vd: [1,2,3,4,8,17,5,11,13] => 17*/
function find_big_prime_num(arr) {
  return Math.max(...arr.filter((x) => is_prime_number(x)));
}
console.log("Lab4: " + find_big_prime_num([1, 2, 3, 4, 8, 17, 5, 11, 13]));

/*Lab5:
Viết hàm thay thế các số âm trong mảng thành số 0
function replace(arr)
vd: [1,-3,-5,-1,1,5] => [1,0,0,0,1,5] */
function replace(arr) {
  return arr.map((x) => {
    if (x < 0) return (x = 0);
    else return x;
  });
}
console.log("Lab5: " + replace([1, -3, -5, -1, 1, 5]));

/* Lab6:
Viết hàm xóa các số nguyên tố trong mảng
function delete_prime_num(arr)
vd: [1,2,3,4,56,7,8,9] => [1,4,56,8,9,] */
function delete_prime_num(arr) {
  return arr.filter((x) => is_prime_number(x) === false);
}
console.log("Lab6: " + delete_prime_num([1, 2, 3, 4, 56, 7, 8, 9]));
