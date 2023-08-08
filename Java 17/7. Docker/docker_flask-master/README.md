Mạng Bridge Mặc Định:
bridge mặc định được tạo ra ngay khi bạn cài đặt Docker.
Mỗi container mới sẽ được gắn kết với mạng bridge mặc định một cách tự động, trừ khi người dùng định rõ không sử dụng mạng này.
Các container gắn kết với mạng bridge mặc định có thể giao tiếp với nhau thông qua địa chỉ IP được gán bởi Docker.
Mạng bridge mặc định thường được sử dụng cho các ứng dụng mà người dùng muốn chạy và giao tiếp với nhau trong cùng một môi trường Docker.

Mạng Bridge Do Người Dùng Tự Tạo:
Docker cho phép người dùng tự tạo các mạng bridge tùy chỉnh, mỗi mạng sẽ hoạt động như một môi trường mạng độc lập.
Người dùng có thể tự tạo các mạng bridge để tạo ra các phân đoạn riêng biệt trong môi trường Docker, giúp kiểm soát giao tiếp giữa các container và tạo ra các cơ chế cách ly bổ sung.
Các mạng bridge tùy chỉnh giúp người dùng quản lý chính xác cách mà các container trong các mạng khác nhau giao tiếp với nhau và với môi trường bên ngoài.
Khi người dùng tạo mạng bridge tùy chỉnh, Docker cung cấp cách để người dùng cấu hình chúng, chẳng hạn như chỉ định một phạm vi địa chỉ IP riêng cho mạng hoặc đặt tên cho mạng để dễ dàng quản lý.



ENTRYPOINT và CMD là hai hướng dẫn trong Dockerfile để xác định lệnh mặc định sẽ được thực thi khi người dùng chạy một container từ image. Dưới đây là sự khác biệt giữa hai hướng dẫn này:

CMD được sử dụng để chỉ định lệnh mặc định sẽ được thực thi khi chạy container. Tuy nhiên, nếu chỉ định lệnh thực thi khi chạy container (dưới dạng một tham số khi chạy lệnh docker run), lệnh đó sẽ ghi đè lệnh được định nghĩa trong CMD.
CMD có thể được sử dụng để định nghĩa các tham số và tùy chọn mặc định cho lệnh chính của ứng dụng khi container khởi chạy. Điều này thường hữu ích khi muốn cung cấp các tham số mặc định cho ứng dụng mà người dùng có thể ghi đè bằng cách cung cấp các tham số riêng khi chạy container.

ENTRYPOINT cũng được sử dụng để chỉ định lệnh mặc định, nhưng nó thường được sử dụng để xác định một lệnh cố định (executable) để chạy ứng dụng hoặc dịch vụ.
Bất kỳ tham số được cung cấp khi chạy container sẽ được thêm vào sau ENTRYPOINT. Điều này cho phép bạn sử dụng container như một thực thể thực hiện một lệnh cố định với các tham số cụ thể.
Khi sử dụng ENTRYPOINT, có thể kết hợp với CMD để cung cấp các tham số mặc định hoặc một lệnh thay thế nếu không cung cấp tham số.