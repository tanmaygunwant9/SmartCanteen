<div align="center">

# 🍽️ Smart Canteen Management System

### A simple, desktop-based solution for smarter campus food ordering.

<p>
  <img src="https://img.shields.io/badge/Java-Desktop%20App-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java desktop app" />
  <img src="https://img.shields.io/badge/GUI-Java%20Swing-4479A1?style=for-the-badge" alt="Java Swing" />
  <img src="https://img.shields.io/badge/Storage-Local%20Text%20Files-6C8EBF?style=for-the-badge" alt="Local file storage" />
</p>

</div>

---

## 📌 About the Project

**Smart Canteen Management System** is a Java Swing desktop application that streamlines basic canteen operations for students and administrators. Students can create an account, sign in, explore the available food menu, add items to a cart, and place an order with a generated token number. Administrators can manage menu entries and review saved orders.

The application uses local text files for data storage, keeping the project lightweight and easy to run without configuring a database server.

## ✨ Features

### 🎓 Student Portal
- **Student registration** – create an account with a username and password.
- **Student login** – access the student dashboard.
- **Browse the menu** – view food items and their prices.
- **Shopping cart** – add selected items and review the cart.
- **Order placement** – calculate the order total and confirm the purchase.
- **Order token** – receive a unique time-based token when an order is placed.
- **Logout** – return to the login screen.

### 🛠️ Admin Portal
- **Admin login** – access the administration dashboard.
- **Menu management** – add new food items or remove selected entries.
- **Order overview** – view order records saved by the application.

### ⚙️ Application Highlights
- Desktop graphical interface built with Java Swing.
- Separate student and administrator workflows.
- Local file-based persistence—no database installation required.
- Lightweight implementation using standard Java libraries.

## 🧰 Tech Stack

| Technology | Purpose |
|---|---|
| **Java** | Core application logic |
| **Java Swing / AWT** | Desktop user interface and components |
| **Java I/O** | Reading and writing local text files |
| **Collections Framework** | Managing cart items and menu data |

## 🗂️ Project Structure

```text
SmartCanteen_Fixed_Project/
│
├── data/                       # Runtime data files
│   ├── admin.txt               # Admin credentials (create/configure this file)
│   ├── menu.txt                # Food items and prices
│   ├── orders.txt              # Saved order records
│   └── students.txt            # Registered student accounts
│
├── src/
│   ├── Main.java               # Application entry point
│   │
│   ├── model/
│   │   ├── Cart.java           # Cart item operations
│   │   └── FileManager.java    # Student and order file operations
│   │
│   └── ui/
│       ├── AdminDashboard.java
│       ├── GradientButton.java
│       ├── LoginUI.java
│       ├── MenuManagerUI.java
│       ├── OrderViewerUI.java
│       ├── RegisterUI.java
│       └── StudentDashboard.java
│
└── README.md
```

> **Important:** Run the application from the project root so its relative `data/...` file paths resolve correctly. The supplied archive includes menu, student, and order data files. The admin login code expects `data/admin.txt`; create it before using the Admin Portal.

## 🚀 Getting Started

### 1. Prerequisites

- **JDK 8 or later** installed.
- A terminal or Java IDE such as IntelliJ IDEA, Eclipse, or VS Code with Java support.

Check that Java is available:

```bash
java -version
javac -version
```

### 2. Get the Project

Download the project ZIP and extract it, or clone the repository:

```bash
git clone <repository-url>
cd SmartCanteen_Fixed_Project
```

### 3. Configure Admin Login

Create a file named `admin.txt` inside the `data` folder. Add the administrator username and password on one line, separated by a comma:

```text
username,password
```

For example, replace the sample values with credentials of your choice. Keep this file private and do not commit real credentials to a public repository.

### 4. Compile the Application

From the **project root** directory, run:

```bash
javac -d out src/Main.java src/model/*.java src/ui/*.java
```

### 5. Launch

```bash
java -cp out Main
```

The login window should open. Keep the terminal's current working directory at the project root while running the application because the program reads and writes files under `data/`.

## 🧭 How to Use

### Student Workflow

1. Launch the application.
2. Register a new student account, or sign in with an existing account.
3. Open **Menu** and select a food item to add it to the cart.
4. Open **Cart** to review selected items and prices.
5. Select **Order** to place the order.
6. Note the generated token and order total shown in the confirmation dialog.

### Admin Workflow

1. Select **Admin** on the login screen.
2. Enter the credentials configured in `data/admin.txt`.
3. Choose **Manage Menu** to add or remove menu entries.
4. Choose **View Orders** to review saved orders.

## 📝 Data Storage Format

The application stores data in plain text files inside the `data/` directory.

| File | Purpose | Format |
|---|---|---|
| `admin.txt` | Admin login credentials | `username,password` |
| `students.txt` | Registered student accounts | `username,password` |
| `menu.txt` | Food menu and item prices | `itemName,price` |
| `orders.txt` | Placed order records | Generated token, student, items, total |

Example menu entries:

```text
Burger,50
Pizza,80
Sandwich,40
Cold Coffee,60
```

Prices are stored as numeric values and displayed with the ₹ currency symbol in the order summary.

## ⚠️ Current Scope & Notes

- This is a lightweight academic/demo project that uses local text files rather than a database.
- Passwords are currently stored as plain text. This implementation is **not suitable for production use** without password hashing and stronger authentication.
- Order tokens are generated from the current date and time; they are not backed by a centralized token service.
- The application is designed for local desktop use and does not currently provide online ordering, payment processing, or multi-device synchronization.
- Back up the `data/` directory if you need to preserve registered accounts, menu changes, and order history.

## 🔮 Possible Future Improvements

- Integrate a database such as MySQL or SQLite.
- Hash passwords and improve account validation.
- Add order status tracking (Pending, Preparing, Ready, Completed).
- Add search and category filters to the food menu.
- Improve cart quantity controls and order history for students.
- Add reports for daily sales and popular menu items.
- Introduce online payments and a web/mobile interface.

## 🤝 Contributing

Contributions and suggestions are welcome. To propose an improvement:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m "Add your feature"`).
4. Push the branch and open a pull request.

## 📄 License

No license file is currently included. Add a license (for example, MIT) if you want to define how others may use, modify, and distribute this project.

---

<div align="center">

**Built with ☕ and Java.**

</div>
