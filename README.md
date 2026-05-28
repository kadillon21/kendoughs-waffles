# Ken-dough's Waffles

A Java Spring Boot point-of-sale application for a custom waffle shop. Customers can build fully customized waffles, choose from signature creations, grab a daily special, add drinks and sides, and receive a printed receipt — all through a styled console interface backed by a MySQL database.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup & Installation](#setup--installation)
- [How to Use](#how-to-use)
- [Application Screens](#application-screens)
- [Menu & Pricing](#menu--pricing)
- [Class Diagram](#class-diagram)
- [Known Limitations](#known-limitations)

---

## Overview

Ken-dough's Waffles is a Capstone 2 project built for Year Up United. The application simulates a real waffle shop POS system where a customer can:

- Start a new order and customize it item by item
- Build a waffle from scratch (choose type, size, filling, and toppings)
- Order from a curated menu of Signature Waffles
- Pick today's Daily Special (rotates by day of week)
- Add drinks and sides
- Check out and receive a receipt file saved to disk
- Look up a previous order by order number

All product data (toppings, drinks, sides) is persisted in a MySQL database. Stock levels are decremented on checkout via Spring Data JPA.

---

## Features

### Core Requirements
- **3 waffle sizes** — Mini, Regular, Large
- **5 waffle types** — Buttermilk, Belgian, Liege, Churro, Red Velvet
- **Regular toppings** — Whipped Cream, Powdered Sugar, Maple Syrup, Cinnamon, Butter, Caramel Drizzle
- **Premium toppings** (+$1.00 each) — Nutella, Fresh Strawberries, Bacon Crumbles, Ice Cream, Fresh Blueberries, Cookie Butter
- **Stuffed waffle special option** — choose from Nutella, Cream Cheese, Strawberry Jam, or Strawberry
- **Drinks** — Coffee, OJ, Milk, Lemonade, Apple Juice, Cranberry Juice (Small / Medium / Large)
- **Sides** — Hash Browns, Waffle Fries, Bacon, Fruit Cup
- **Checkout** — displays order summary with line-item prices and total
- **Receipt file** — saved to the `receipts/` folder with a unique order number and timestamp

### Bonus Features
- **Signature Waffles** — 4 pre-built waffles (The Classic Ken, The Nutella Dream, The Sunrise, The Red Royale)
- **Daily Special** — rotates automatically by day of the week
- **Previous Orders** — look up a past receipt by order number
- **About Us** screen
- **Full store menu** display screen
- **Spring Boot + Spring Data JPA** — toppings, drinks, and sides are stored in and loaded from MySQL
- **REST API** (`/api/menu`, `/api/orders`) via `MenuRestController` and `OrderController`
- **Stock management** — inventory decremented on each confirmed order

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 4.0.6 |
| Database | MySQL |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Maven |
| UI | Console (ANSI-styled with box-drawing characters) |

---

## Setup & Installation

### Prerequisites
- Java 17+
- Maven
- MySQL (running locally)

### Steps

1. **Clone the repository**
   ```bash
   git clone <repo-url>
   cd kendoughs-waffles
   ```

2. **Create the database**
   ```bash
   mysql -u root -p < database/kendoughs.sql
   ```

3. **Configure your database credentials** in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/kendoughs_waffles
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   ```

4. **Run the application (Recommended to run in terminal to ensure menus are built properely)**
   ```bash
   ./mvnw spring-boot:run
   ```

---

## How to Use

When the application starts you will see the main menu. Navigate using the numbered options printed on screen.

```
╔═════════════════════════════════╗
║  Welcome to Ken-dough's Waffle  ║
╠═════════════════════════════════╣
║                                 ║
║  1)  New Order                  ║
║  2)  Previous Orders            ║
║  3)  Menu Items                 ║
║  4)  About Us                   ║
║  X)  Exit                       ║
║                                 ║
╚═════════════════════════════════╝
```

### Placing an Order
1. Select **1) New Order** from the main menu
2. Enter your phone number, email, and name
3. From the Order screen, choose:
   - **1) Add Waffle** → Build Your Own, Signature Waffle, or Daily Special
   - **2) Add Drink** → select flavor then size
   - **3) Add Side** → select from available sides
   - **4) View Current Order** → review or remove items
   - **5) Remove Item** → remove a specific item
   - **6) Checkout** → confirm and generate receipt
   - **X) Cancel Order** → discard and return to main menu

---

## Application Screens

| Screen | Description |
|---|---|
| Main Menu | Entry point — new order, previous orders, menu, about |
| Order Menu | Add waffles, drinks, sides; view/edit/checkout |
| Waffle Menu | Build Your Own / Signature / Daily Special |
| Custom Waffle Builder | Step-by-step: type → size → filling → toppings |
| Signature Waffles | Pre-built waffle options |
| Daily Special | Rotating special based on day of week |
| Drink Menu | Choose flavor then size |
| Side Menu | Choose from available sides |
| Checkout | Order summary with prices and total |
| Previous Orders | Look up receipt by 4-digit order number |
| Store Menu | Full menu with all items and prices |

---

## Menu & Pricing

### Waffle Types (base price)
| Type | Price |
|---|---|
| Buttermilk | $4.99 |
| Belgian | $5.49 |
| Liege | $5.99 |
| Churro | $5.99 |
| Red Velvet | $6.49 |

### Size Upcharge
| Size | Upcharge |
|---|---|
| Mini | +$0.00 |
| Regular | +$1.50 |
| Large | +$3.00 |

### Toppings
| Category | Price |
|---|---|
| Regular Toppings (Whipped Cream, Powdered Sugar, Maple Syrup, Cinnamon, Butter, Caramel Drizzle) | +$0.50 each |
| Premium Toppings (Nutella, Fresh Strawberries, Bacon Crumbles, Ice Cream, Fresh Blueberries, Cookie Butter) | +$1.00 each |

### Special Option (Stuffed Waffle)
| Filling | Upcharge |
|---|---|
| Nutella, Cream Cheese, Strawberry Jam, Strawberry | +$1.50 |

### Drinks
| Size | Price |
|---|---|
| Small | $2.00 |
| Medium | $2.50 |
| Large | $3.00 |

### Sides
| Item | Price |
|---|---|
| Hash Browns | $2.99 |
| Waffle Fries | $3.49 |
| Bacon | $2.49 |
| Fruit Cup | $2.99 |

### Signature Waffles (example calculated prices at Regular size)
| Waffle | Base | Size | Filling | Toppings | Total |
|---|---|---|---|---|---|
| The Classic Ken | $4.99 (Buttermilk) | +$1.50 | None | Butter + Maple Syrup (included) | **$6.49** |
| The Nutella Dream | $5.49 (Belgian) | +$1.50 | +$1.50 (Nutella) | Nutella (+$1.00) + Strawberries (+$1.00) + Whipped Cream (incl.) | **$10.49** |
| The Sunrise | $5.99 (Churro) | +$1.50 | None | Bacon Crumbles (+$1.00) + Maple Syrup (incl.) + Powdered Sugar (incl.) | **$8.49** |
| The Red Royale | $6.49 (Red Velvet) | +$1.50 | +$1.50 (Cream Cheese) | Ice Cream (+$1.00) + Blueberries (+$1.00) + Cookie Butter (+$1.00) | **$12.49** |

---

## Class Diagram

> _(Add exported diagram image here — e.g., from IntelliJ or draw.io)_
>
> ![Class Diagram](diagrams/class-diagram.png)

The core class hierarchy is:

```
Product (abstract)
├── Waffle
│   └── SignatureWaffle
│       ├── ClassicKen
│       ├── NutellaDream
│       ├── Sunrise
│       └── RedRoyale
├── Drink
├── Side
└── Topping (abstract)
    ├── RegularTopping
    └── PremiumTopping

Order
└── List<Product>

Interfaces
└── Printable
```

---

## Known Limitations

- The console UI uses ANSI escape codes for color and formatting. Colors will not display correctly in some terminals (e.g., default Windows CMD). Use a terminal that supports ANSI codes (IntelliJ terminal, macOS Terminal, Windows Terminal).
- Receipt files are saved to a local `receipts/` folder relative to the working directory.
- Stock levels are managed in the database; if a topping/drink/side runs out of stock it will be marked unavailable and cannot be ordered.
- The REST API endpoints (`/api/menu`, `/api/orders`) are available when the Spring Boot server is running but are secondary to the console interface.
