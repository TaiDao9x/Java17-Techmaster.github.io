function Student(student_name,student_grade,student_sex){
  this.name=student_name
  this.grade=student_grade
  this.sex=student_sex
}
const student1 = new Student('John',8,'M')
const student2 = new Student('Sarah',12,'F')
const student3 = new Student('Bob',16,'M')
const student4 = new Student('Johnny',2,'M')
const student5 = new Student('Ethan',4,'M')
const student6 = new Student('Paula',18,'F')
const student7 = new Student('Donal',5,'M')
const student8 = new Student('Jenifer',13,'F')
const student9 = new Student('Courtney',15,'F')
const student10 = new Student('Jane',9,'F')
let students=[student1,student2,student3,student4,student5,student6,student7,student8,student9,student10]

function print_student_list(student_list){
  for(const std of student_list){
    console.log(`    ${std.name} - ${std.grade} - ${std.sex}`)
  }
}
function get_average_rank(student_list){
  return student_list.reduce((total_grade,student)=>total_grade+student.grade,0)/student_list.length
}
function filter_student_by_sex(student_list,sex){
  return student_list.filter(student=>student.sex.toLowerCase()===sex.toLowerCase())
}
function get_average_rank_by_sex(student_list,sex){
  let filter_by_sex=filter_student_by_sex(student_list,sex)
  return filter_by_sex.reduce((total_grade,student)=>total_grade+student.grade,0)/filter_by_sex.length
}
function sort_filter_student_by_sex_and_grade(student_list,sex){
  return filter_student_by_sex(student_list,sex).sort((student1,student2)=>student2.grade-student1.grade)
}
function sort_student_by_grade(student_list){
  return student_list.sort((student1,student2)=>student2.grade-student1.grade)
}
function sort_student_by_name(student_list){
  return student_list.sort((student1,student2)=>(student1.name>student2.name)?1:-1)
}
function filter_by_subtr(student_list,sex,subtr){
  return filter_student_by_sex(student_list,sex).filter(student=>student.name.substr(0,1).toLowerCase()===subtr.toLowerCase())
}

print_student_list(students)
console.log('1. Thứ hạng trung bình của cả lớp: '+get_average_rank(students))
console.log('2. Thứ hạng TB của Nam trong lớp: '+get_average_rank_by_sex(students,'m'))
console.log('3. Thứ hạng TB của Nữ trong lớp: '+get_average_rank_by_sex(students,'f'))
console.log('4. Học viên Nam có thứ hạng cao nhất: ')
print_student_list(sort_filter_student_by_sex_and_grade(students,'m').slice(0,1))
console.log('5. Học viên Nữ có thứ hạng cao nhất: ')
print_student_list(sort_filter_student_by_sex_and_grade(students,'f').slice(0,1))
console.log('6. Học viên Nam có thứ hạng thấp nhất:')
print_student_list(sort_filter_student_by_sex_and_grade(students,'m').reverse().slice(0,1))
console.log('7. Học viên Nữ có thứ hạng thấp nhất: ')
print_student_list(sort_filter_student_by_sex_and_grade(students,'f').reverse().slice(0,1))
console.log('8. Thứ hạng cao nhất của cả lớp: ')
print_student_list(sort_student_by_grade(students).slice(0,1))
console.log('9. Thứ hạng thấp nhất của cả lớp: ')
print_student_list(sort_student_by_grade(students).reverse().slice(0,1))
console.log('10. Danh sách học viên nữ trong lớp: ')
print_student_list(filter_student_by_sex(students,'f'))
console.log('11. Danh sách HV sắp xếp theo bảng chữ cái tăng dần:')
print_student_list(sort_student_by_name(students))
console.log('12. Danh sách HV sắp xếp theo bảng chữ cái giảm dần:')
print_student_list(sort_student_by_name(students).reverse())
console.log('13.Học viên có tên bắt đầu bằng "J": ')
print_student_list(filter_by_subtr(students,'f','j'))
console.log('14. Top 5 người có thứ hạng cao nhất trong lớp:')
print_student_list(sort_student_by_grade(students).slice(0,5))
