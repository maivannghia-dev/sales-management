# 🛒 Sales Management API

Hệ thống quản lý bán hàng REST API được xây dựng bằng Spring Boot và MySQL.

## 🚀 Công nghệ sử dụng
- ☕ Java 21
- 🍃 Spring Boot 3.5.11
- 🗄️ Spring Data JPA / Hibernate
- 🐬 MySQL 8.0
- 📦 Maven
- 🔐 JWT (JSON Web Token)
- 🔒 Spring Security + BCrypt

## 📁 Cấu trúc thư mục
* `config/`: Cấu hình CORS, Security
* `controller/`: Nhận request và trả response
* `entity/`: Định nghĩa các Entity mapping với database
* `repository/`: Giao tiếp với database
* `service/`: Xử lý logic nghiệp vụ
* `exception/`: Xử lý exception toàn cục
* `security/`: JWT Filter và Utility

## ✨ Tính năng
- 📂 Quản lý danh mục sản phẩm (Category)
- 🛍️ Quản lý sản phẩm (Product)
- 👤 Quản lý khách hàng (Customer)
- 🧾 Quản lý đơn hàng (Order) - tự động tính tổng tiền
- 📋 Quản lý chi tiết đơn hàng (OrderDetail)
- ✅ Validation dữ liệu đầu vào
- ⚠️ Xử lý exception toàn cục
- 📄 Phân trang (Pagination)
- 🔍 Tìm kiếm và lọc sản phẩm
- 🔐 Xác thực JWT
- 🔒 Phân quyền ADMIN/USER

## 🔐 Phân quyền
| Quyền | GET | POST | PUT | DELETE |
|-------|-----|------|-----|--------|
| USER | ✅ | ❌ | ❌ | ❌ |
| ADMIN | ✅ | ✅ | ✅ | ✅ |

## ⚙️ Cài đặt

### Yêu cầu
- JDK 21
- MySQL 8.0
- Maven

### Các bước chạy
1. Clone project về máy
   git clone https://github.com/maivannghia-dev/sales-management.git
2. Tạo database MySQL
   CREATE DATABASE sales_management;
3. Cấu hình kết nối database trong `src/main/resources/application.properties`
   spring.datasource.url=jdbc:mysql://localhost:3306/sales_management
   spring.datasource.username=root
   spring.datasource.password=YOUR_PASSWORD
4. Chạy project bằng IntelliJ hoặc lệnh
   mvn spring-boot:run
5. API chạy tại `http://localhost:8080`

## 🔑 Authentication

### Đăng ký
POST /auth/register
{
"username": "admin",
"password": "123456",
"role": "ADMIN"
}

### Đăng nhập
POST /auth/login
{
"username": "admin",
"password": "123456"
}

### Sử dụng token
Thêm vào Header của mỗi request:
Authorization: Bearer <token>

## 📡 API Endpoints

### 📂 Category
| Method | URL | Mô tả | Quyền |
|--------|-----|--------|-------|
| GET | /categories | Lấy danh sách danh mục | USER, ADMIN |
| GET | /categories/{id} | Lấy danh mục theo id | USER, ADMIN |
| POST | /categories | Tạo danh mục mới | ADMIN |
| PUT | /categories/{id} | Cập nhật danh mục | ADMIN |
| DELETE | /categories/{id} | Xóa danh mục | ADMIN |

### 🛍️ Product
| Method | URL | Mô tả | Quyền |
|--------|-----|--------|-------|
| GET | /products | Lấy danh sách sản phẩm | USER, ADMIN |
| GET | /products/{id} | Lấy sản phẩm theo id | USER, ADMIN |
| GET | /products/search?name= | Tìm kiếm theo tên | USER, ADMIN |
| GET | /products/filter?maxPrice= | Lọc theo giá | USER, ADMIN |
| POST | /products | Tạo sản phẩm mới | ADMIN |
| PUT | /products/{id} | Cập nhật sản phẩm | ADMIN |
| DELETE | /products/{id} | Xóa sản phẩm | ADMIN |

### 👤 Customer
| Method | URL | Mô tả | Quyền |
|--------|-----|--------|-------|
| GET | /customers | Lấy danh sách khách hàng | USER, ADMIN |
| GET | /customers/{id} | Lấy khách hàng theo id | USER, ADMIN |
| POST | /customers | Tạo khách hàng mới | ADMIN |
| PUT | /customers/{id} | Cập nhật khách hàng | ADMIN |
| DELETE | /customers/{id} | Xóa khách hàng | ADMIN |

### 🧾 Order
| Method | URL | Mô tả | Quyền |
|--------|-----|--------|-------|
| GET | /orders | Lấy danh sách đơn hàng | USER, ADMIN |
| GET | /orders/{id} | Lấy đơn hàng theo id | USER, ADMIN |
| POST | /orders | Tạo đơn hàng mới | ADMIN |
| PUT | /orders/{id} | Cập nhật đơn hàng | ADMIN |
| DELETE | /orders/{id} | Xóa đơn hàng | ADMIN |

### 📋 OrderDetail
| Method | URL | Mô tả | Quyền |
|--------|-----|--------|-------|
| GET | /order-details | Lấy danh sách chi tiết đơn hàng | USER, ADMIN |
| GET | /order-details/{id} | Lấy chi tiết đơn hàng theo id | USER, ADMIN |
| POST | /order-details | Tạo chi tiết đơn hàng mới | ADMIN |
| PUT | /order-details/{id} | Cập nhật chi tiết đơn hàng | ADMIN |
| DELETE | /order-details/{id} | Xóa chi tiết đơn hàng | ADMIN |

## 👨‍💻 Tác giả
Mai Văn Nghĩa