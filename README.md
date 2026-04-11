# 🚀 Java Todo API (Spring Boot)

A simple REST API for managing tasks, built with Spring Boot.

---

## 📌 Features

* ✅ Create tasks
* 📄 Get all tasks
* ⚡ Fast and lightweight API
* 🧠 In-memory storage (no database yet)

---

## 📁 Project Structure

```
java-todo-api/
├── src/
│   └── main/
│       └── java/com/example/todoapi/
│           ├── Task.java
│           ├── TaskController.java
│           └── TodoapiApplication.java
├── pom.xml
└── README.md
```

---

## ⚙️ Installation & Run

```bash
git clone https://github.com/YOUR_USERNAME/java-todo-api.git
cd java-todo-api
./mvnw spring-boot:run
```

> ⚠️ Replace `YOUR_USERNAME` with your GitHub username

---

## 🌐 API Endpoints

### 📄 Get all tasks

```
GET /tasks
```

---

### ➕ Create a task

```
POST /tasks
```

#### Request Body:

```json
{
  "title": "Learn Spring Boot"
}
```

---

## 🧪 Testing

You can test the API using:

* Thunder Client (VS Code)
* Postman
* Browser (for GET requests)

---

## 🔮 Future Improvements

* ❌ Delete task
* ✔️ Mark task as completed
* 💾 Add database (PostgreSQL / MySQL)

---

## 👩‍💻 Author

Created as part of backend learning journey 🚀
