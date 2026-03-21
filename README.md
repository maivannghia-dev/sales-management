# 🛒 Sales Management API

Hệ thống quản lý bán hàng REST API được xây dựng bằng Spring Boot và MySQL.

## 🚀 Công nghệ sử dụng
- ☕ Java 21
- 🍃 Spring Boot 3.5.11
- 🗄️ Spring Data JPA / Hibernate
- 🐬 MySQL 8.0
- 📦 Maven

## 📁 Cấu trúc thư mục
* `config/`: Cấu hình CORS
* `controller/`: Nhận request và trả response
* `entity/`: Định nghĩa các Entity mapping với database
* `repository/`: Giao tiếp với database
* `service/`: Xử lý logic nghiệp vụ
* `exception/`: Xử lý exception toàn cục

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

## ⚙️ Cài đặt

### Yêu cầu
- JDK 21
- MySQL 8.0
- Maven

### Các bước chạy
1. Clone project về máy
```
git clone https://github.com/maivannghia-dev/sales-management.git
```
2. Tạo database MySQL
```
CREATE DATABASE sales_management;
```
3. Cấu hình kết nối database trong `src/main/resources/application.properties`
```
spring.datasource.url=jdbc:mysql://localhost:3306/sales_management
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```
4. Chạy project bằng IntelliJ hoặc lệnh
```
mvn spring-boot:run
```
5. API chạy tại `http://localhost:8080`

## 📡 API Endpoints

### 📂 Category
| Method | URL | Mô tả |
|--------|-----|--------|
| GET | /categories | Lấy danh sách danh mục |
| GET | /categories/{id} | Lấy danh mục theo id |
| POST | /categories | Tạo danh mục mới |
| PUT | /categories/{id} | Cập nhật danh mục |
| DELETE | /categories/{id} | Xóa danh mục |

### 🛍️ Product
| Method | URL | Mô tả |
|--------|-----|--------|
| GET | /products | Lấy danh sách sản phẩm |
| GET | /products/{id} | Lấy sản phẩm theo id |
| GET | /products/search?name= | Tìm kiếm theo tên |
| GET | /products/filter?maxPrice= | Lọc theo giá |
| POST | /products | Tạo sản phẩm mới |
| PUT | /products/{id} | Cập nhật sản phẩm |
| DELETE | /products/{id} | Xóa sản phẩm |

### 👤 Customer
| Method | URL | Mô tả |
|--------|-----|--------|
| GET | /customers | Lấy danh sách khách hàng |
| GET | /customers/{id} | Lấy khách hàng theo id |
| POST | /customers | Tạo khách hàng mới |
| PUT | /customers/{id} | Cập nhật khách hàng |
| DELETE | /customers/{id} | Xóa khách hàng |

### 🧾 Order
| Method | URL | Mô tả |
|--------|-----|--------|
| GET | /orders | Lấy danh sách đơn hàng |
| GET | /orders/{id} | Lấy đơn hàng theo id |
| POST | /orders | Tạo đơn hàng mới |
| PUT | /orders/{id} | Cập nhật đơn hàng |
| DELETE | /orders/{id} | Xóa đơn hàng |

### 📋 OrderDetail
| Method | URL | Mô tả |
|--------|-----|--------|
| GET | /order-details | Lấy danh sách chi tiết đơn hàng |
| GET | /order-details/{id} | Lấy chi tiết đơn hàng theo id |
| POST | /order-details | Tạo chi tiết đơn hàng mới |
| PUT | /order-details/{id} | Cập nhật chi tiết đơn hàng |
| DELETE | /order-details/{id} | Xóa chi tiết đơn hàng |

## 👨‍💻 Tác giả
Mai Văn Nghĩa