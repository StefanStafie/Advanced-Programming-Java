# Advanced Programming — Java Labs

A collection of Java laboratory assignments covering algorithms, GUI programming, multithreading, databases, networking, and REST APIs.

---

## Table of Contents

- [Lab 3 — Knapsack Problem](#lab-3--knapsack-problem)
- [Lab 4 — Hospital–Resident Matching](#lab-4--hospitalresident-matching)
- [Lab 5 — Document Catalog](#lab-5--document-catalog)
- [Lab 6 — Shape Drawing GUI](#lab-6--shape-drawing-gui)
- [Lab 7 — Multithreaded Token Game](#lab-7--multithreaded-token-game)
- [Lab 8 — Musical Albums Database](#lab-8--musical-albums-database)
- [Lab 10 — Go Game (Client–Server)](#lab-10--go-game-clientserver)
- [Lab 11 — REST API with JWT](#lab-11--rest-api-with-jwt)
- [Lab 12 — Design Panel](#lab-12--design-panel)

---

## Lab 3 — Knapsack Problem

Solves the 0/1 Knapsack problem using two strategies.

**Key classes:**
- `Item` interface — implemented by `Book`, `Food`, and `Weapon`
- `Algorithm` interface — implemented by `Greedy` and `Dynamic`
- `Knapsack` — prints items sorted by name
- `ProblemGenerator` — randomly generates `Item[]` arrays

**Benchmark results** (10 000 iterations, dynamic vs. greedy):

| Capacity | Items | Avg value (D / G) | Avg time ms (D / G) |
|----------|-------|-------------------|---------------------|
| 500      | 500   | 2501.79 / 2470.37 | 6.36 / 0.23         |
| 50       | 50    | 235.71 / 208.19   | 0.07 / 0.02         |
| 1000     | 15    | 787.75 / 787.75   | 0.53 / 0.005        |
| 15       | 1000  | 488.17 / 465.91   | 0.34 / 0.39         |

Dynamic programming consistently yields higher values; greedy is significantly faster for large inputs.

---

## Lab 4 — Hospital–Resident Matching

Implements the **Stable Matching** (Gale–Shapley) algorithm for the hospital–resident problem.

**Key classes:**
- `ProblemGenerator` — generates hospitals and residents; names are produced with the [Faker](https://github.com/faker-ruby/faker) library
- `Algorithm` — produces a `Matching` from a `Problem`
- `CheckStable` — verifies the stability of a matching
- `Compulsory` — uncomment `new Compulsory()` in `Main` to run the compulsory part

---

## Lab 5 — Document Catalog

An interactive shell application for managing a catalog of documents.

**Features:**
- `save` / `load` / `view` commands
- JSON-based persistence to `.txt` files
- Command classes: `ListCommand`, `LoadCommand`, `ViewCommand`, `ReportHtmlCommand` — all implement the `Command` interface
- Interactive shell (type `help` for the command list)
- Create catalogs, add documents and tags
- `ReportHtmlCommand` generates an `index.html` in the current directory
- Distributed as an executable JAR (`JavaEXE.jar`)

---

## Lab 6 — Shape Drawing GUI

A Java Swing application for drawing and saving shapes.

**Features:**
- Shapes: `Rectangle`, `Circle`, `RegularPolygon`
- Dynamic configuration panel that adapts to the selected shape
- Colors: Red, Green, Blue
- Save / load canvas image via a file chooser dialog
- Reset and Exit buttons

> **Note:** Click on the canvas after every change to refresh the canvas and configuration panel.

---

## Lab 7 — Multithreaded Token Game

A concurrent game where multiple player threads compete to form a token progression.

**How it works:**
- Start with `new Game(playerCount, tokenCount, progressionSize)`
- A dedicated `Thread` is created for each `Player`
- Each player collects `progressionSize` tokens from the `Board` via `getToken()`, then calls `exchangeToken()` to swap tokens with the board until they hold a valid progression
- `getToken()` and `exchangeToken()` are `synchronized` to prevent race conditions; claimed tokens are removed from the board
- A player holds at most `progressionSize` tokens at once
- The main thread detects the winner, stops all other threads gracefully, and prints the result

---

## Lab 8 — Musical Albums Database

A MySQL-backed application for managing artists, albums, and chart rankings.

**Setup:**
1. **Option A** — Copy the `musicalbums/` folder to `C:\xampp\mysql\data`
2. **Option B** — Import `musicalalbums.sql` into your MySQL instance

**Core classes:**
- `Database` — Singleton holding `Connection` and `Statement`
- `ArtistController` — `create(name, country)`, `findByName(name) → ResultSet`
- `AlbumController` — `create(name, artistId, releaseYear)`, `findByArtist(artistId) → ResultSet`

**Optional extensions:**
- Tables `charts` and `chart_record` for playlist/chart management
- `Artist`, `Album`, `Chart`, `ChartController` model classes
- Fake data generation
- Artist ranking by accumulated chart points
- `Test` class generates 20 artists, 100 albums, and 10 charts (10 albums each) and prints the final ranking

---

## Lab 10 — Go Game (Client–Server)

A networked implementation of the board game **Go** with a Swing GUI.

**Architecture:**
- **Client** — Swing GUI; communicates with the server via commands (`create game`, `join game`, `submit move`, …). Distributed as `client.jar`
- **Server** — manages game rooms and mediates players; spawns one thread per room and one per connected client, enabling multiple concurrent games
- On game completion, an SGF file is uploaded to a web server via **JCraft** (SSH/SFTP)

---

## Lab 11 — REST API with JWT

A **Spring Boot** REST service layer that integrates with the Go game from Lab 10.

**Features:**
- REST endpoints for inserting and retrieving game records
- Integrated with the Lab 10 server (game history from client; game insertion from server)
- Centralised exception handling via `@RestControllerAdvice`
- Authentication secured with **JSON Web Tokens (JWT)**

**Run:**
```bash
cd Lab11
./mvnw spring-boot:run
```

---

## Lab 12 — Design Panel

A Java Swing design/drawing tool.

**Key classes:**
- `MainFrame` — application window
- `DesignPanel` — canvas for drawing
- `ControlPanel` — tool/configuration controls
- `Mouse` — mouse event handler
- `Focus` — focus management

---

## Requirements

- Java 8 or later
- Maven (for Labs 4, 5, 8, 11)
- MySQL + XAMPP or equivalent (for Lab 8)
- Network access (for Lab 10 SGF upload)