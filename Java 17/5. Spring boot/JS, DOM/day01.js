// Lab2: Viết function nhập vào 1 số. Kiểm tra số đó là số chẵn hay số lẻ.
function check_number_even_or_odd(num){
    let surplus = num%2
    if(surplus === 0) {
        console.log(num+" is even number")
    }else{
        console.log(num+" is odd number")
    }
}
// Lab4: Viết function nhập vào 3 số a, b, c. Kiểm tra xem c có bằng a + b không?
function check_sum(a,b,c){
    let sum = a+b
    if(c===sum){
        return true
    }
    return false
}

/* Lab5: Viết function nhập vào biến mark có giá 
trị từ 0 -> 100. Kiểm tra giá trị của biến mark và 
in ra nội dung sau
● ”A” nếu mark >= 85
● ”B” nếu 70 <= mark < 85 
● ”C” nếu 40 <= mark < 70
● Các trường hợp còn lại in ra “D” */

function check_score(mark){
    if(mark < 0 || mark > 100){
        console.log('Invalid number!')
    }else if(mark >= 85) {
        console.log('A')
    }else if (mark >= 70){
        console.log('B')
    }else if (mark >= 40){
        console.log('C')
    }else {
        console.log('D')
    }
}

/* Lab1: Tạo biến day có giá trị từ 0 -> 6, là các ngày trong tuần Trong đó: (0 - chủ nhật, 1 - thứ 2, …, 6 - 
    Thứ 7) Sử dụng switch-case để in ra ngày tương ứng với giá trị của biến day
    Ví dụ: day = 6 --> “Hôm nay là thứ 7” */
    let day = 8

    switch(day) {
        case 0: 
        console.log('Today is Sunday!')
        break

        case 1: 
        console.log('Today is Monday!')
        break

        case 2: 
        console.log('Today is Tuesday!')
        break

        case 3: 
        console.log('Today is Wednesday!')
        break

        case 4: 
        console.log('Today is Thusday!')
        break

        case 5: 
        console.log('Today is Friday!')
        break

        case 6: 
        console.log('Today is Saturday!')
        break

        default:
        console.log('Invalid!')
        break
    }

 /*   Lab2: Tạo biến month có giá trị từ 1 -> 12, là các tháng trong năm
    Sử dụng switch-case để in ra mùa tương ứng với giá trị của biến month
    ● 1, 2, 3 : Mùa xuân
    ● 4, 5, 6 : Mùa hạ
    ● 7, 8, 9 : Mùa thu
    ● 10, 11, 12 : Mùa đông */    
    let month = 1
    switch(month) {
        case 1,2,3: console.log('Spring')
        case 4,5,6: console.log('Summer')
        case 7,8,9: console.log('Fall')
        case 10,11,12: console.log('Winter')
    }

    /*  Viết function truyền vào 1 chuỗi bất kỳ, hãy viết hàm 
có tác dụng sao chép đó chuỗi lên 10 lần, ngăn cách nhau 
bởi dấu gạch ngang */
function copy_str1(str){
    let a = ''
    for(let i = 1; i < 10 ; i++){
        a = str+a + '-' 
    }
   a+=a
   console.log(a)
}

function copy_str_by_while(str) {
    let a =''
    let i =1
    while(i<10){
        a= str + a + '-'
        i++
    }
    a += str
    console.log(a)
}

//Homework

/*Lab1: Viết function truyền vào 1 chuỗi bất kỳ và 1 số nguyên dương n > 1, hãy viết hàm có tác dụng sao 
chép đó chuỗi lên n lần, ngăn cách nhau bởi dấu gạch ngang. */
function copy_str_by_n(str, n){
    if(n<0) {
        console.log('Invalid number')
    }else{
        let a = ''
    for(let i = 1; i < n ; i++){
        a = a + str + '-'
    }

    a += str
    console.log(a)
    }     
}

//Lab2: Tính tổng các số chia hết cho 5 từ 0 -> 100
function sum_of_num_devisible_5(){
    let result = 0
    for(let i = 0;i<=100;i++){
        if(i%5===0){
            result+=i
        }
    }
return result
}
//Lab3: Viết hàm truyền vào 2 số nguyên, tính tổng tất cả các số nguyên nằm giữa chúng.
function sum_of_num(num1,num2){
    let max_num =num1
    let min_num=num2
    if(num2>num1){
        max_num=num2
        min_num=num1
    }

    let result = 0
    for(let i = min_num+1;i<max_num;i++){
        result+=i
    }
    return result
}
//Lab4: Cho 1 số, kiểm tra xem số đó có phải là số nguyên tố hay không, kết quả trả về true hoặc false.
function check_prime_number(num){
    if(num<=1) return false
    if(num===2) return true

    for(let i = 2;i<=num/2;i++){
        if(num%i===0) return false
    }
    return true
}
//Lab5: Cho 1 số nguyên dương bất kỳ. Tính tổng tất cả các số nguyên tố mà nhỏ hơn hoặc bằng tham số truyền vào.
function sum_of_prime_number(num){
    let result = 0
    if(num<=1) return result
    for(let i = 2; i<=num;i++){
        if(check_prime_number(i)) result +=i
    }
    return result
}
//Lab6: Cho 1 số nguyên dương, viết hàm tính tổng tất cả các ước số của số đó.

function sum_of_divisor(num){
    let result = num
    if(num<1) return 0
    for(let i =1;i<=num/2;i++){
        if(num%i===0) result += i
    }
    return result
    }
