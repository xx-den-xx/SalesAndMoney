import express from "express";
import bodyParser from "body-parser";
import cors from "cors";
import sqlite3 from "sqlite3";
import { open } from "sqlite";

const app = express();
app.use(cors());
app.use(bodyParser.json());

// Подключаем базу данных SQLite
const db = await open({
  filename: "./db/database.sqlite",
  driver: sqlite3.Database
});

// Создаем таблицы
await db.exec(`
  CREATE TABLE IF NOT EXISTS product (
    id INTEGER PRIMARY KEY,
    name TEXT,
    description TEXT,
    isChecking BOOLEAN,
    addedAt TEXT,
    unit TEXT,
    count INTEGER,
    price INTEGER,
    image TEXT,
    ownerBucketsId INTEGER
  );
`);

await db.exec(`
  CREATE TABLE IF NOT EXISTS buckets (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT,
    description TEXT,
    updateAt TEXT,
    isHidden BOOLEAN,
    totalCost INTEGER
  );
`);

// ---- РОУТЫ ----

// Все продукты
app.get("/products", async (req, res) => {
  const products = await db.all("SELECT * FROM product");
  res.json(products);
});

// Добавить продукт
app.post("/products", async (req, res) => {
  const p = req.body;
  await db.run(
    `INSERT INTO product (id, name, description, isChecking, addedAt, unit, count, price, image, ownerBucketsId)
     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)`,
    [p.id, p.name, p.description, p.isChecking, p.addedAt, p.unit, p.count, p.price, p.image, p.ownerBucketsId]
  );
  res.json({ message: "✅ Product added" });
});

// Все корзины
app.get("/buckets", async (req, res) => {
  const buckets = await db.all("SELECT * FROM buckets");
  res.json(buckets);
});

// Добавить корзину
app.post("/buckets", async (req, res) => {
  const b = req.body;
  await db.run(
    `INSERT INTO buckets (title, description, updateAt, isHidden, totalCost)
     VALUES (?, ?, ?, ?, ?)`,
    [b.title, b.description, b.updateAt, b.isHidden, b.totalCost]
  );
  res.json({ message: "✅ Bucket added" });
});

// ---- ЗАПУСК ----
app.listen(3000, () => console.log("🚀 Backend запущен на http://localhost:3000"));