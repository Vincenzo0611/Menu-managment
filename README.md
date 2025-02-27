# 🚀 Microservices Project with Angular and Spring Boot

## 📌 Project Description
The project consists of three microservices written in Spring Boot and a frontend application built with Angular. The entire system is managed using Docker and Docker Compose.

This system allows for managing menu categories and adding items with prices. The data is stored in a database, and the project is being developed as a freelance solution for a company.

## 📂 Directory Structure
- **🛡 API_Gateway** – API gateway handling traffic to microservices
- **📁 category-management** – microservice managing categories
- **🍽 elements-management** – microservice managing menu items with prices
- **🖥 menu_web** – Angular frontend application
- **⚙ docker-compose.yml** – Docker Compose configuration file

## 🛠 Requirements
- 🐳 Docker and Docker Compose
- ☕ Java 17+
- 🟢 Node.js 16+
- 🅰 Angular CLI

## 📥 Installation and Running

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/Vincenzo0611/Menu-managment.git
cd Menu-managment
```

### 2️⃣ Build the Frontend Application
```sh
cd menu_web
npm install
ng build --configuration=production
```

### 3️⃣ Start the Entire System with Docker Compose
```sh
cd ..
docker-compose up --build -d
```

### 4️⃣ Access the Application
- **🅰 Angular Frontend:** [http://localhost:4200](http://localhost:4200)
- **🔗 API Gateway:** [http://localhost:8080](http://localhost:8080)

## 🛑 Stopping Services
To stop the containers, use:
```sh
docker-compose down
```

## ✨ Features
- 📌 Create and manage menu categories.
- 🏷 Add items to categories with pricing information.
- 💾 Data stored in a relational database.
- 💼 Developed as a freelance solution for a business.

## 📸 Screenshots
![Categories](https://github.com/user-attachments/assets/dc5c5f56-bce0-4411-8698-402f24b67b16)
![Elements](https://github.com/user-attachments/assets/ec21c017-9167-464c-8a89-1ed11a111ad8)
![Adding_element](https://github.com/user-attachments/assets/20dc856b-0ae4-47c7-bac7-bb4b7fcd65df)




