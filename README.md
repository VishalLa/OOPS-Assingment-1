
---

````markdown
# 🧠 Quiz Bowl Program

A **Java-based training program** designed to help high school quiz bowl teams sharpen their skills by practicing True/False, Multiple Choice, and Short Answer questions.

---

## ⚙️ Setup Instructions

### 1️⃣ Requirements
- **Java Development Kit (JDK)** 8 or higher  
- A **text file** containing quiz questions (see format below)

---

### 2️⃣ Compilation
Compile all Java source files using:
```bash
javac *.java
````

---

### 3️⃣ Run the Program

Run the main class using:

```bash
java QuizBowl
```

---

### 4️⃣ Program Flow

1. Enter **first and last name** when prompted.
2. Enter the **filename** of the question file** (e.g., `sample.txt`).
3. Choose how many questions to attempt (validated against file total).
4. Answer or skip each question:

   * Type your answer normally (e.g., `true`, `E`, or `Athens`).
   * Type `SKIP` to skip a question (no points gained or lost).
5. View your **final score** at the end of the game.

---

## 📁 Question File Format

The **question file** must follow this structure:

### ➤ General Format

```
n                           # number of questions
<type> <points>             # question type and point value
<question text>             # full question line
...                         # type-specific data (see below)
```

---

### ➤ Supported Question Types

#### 🟢 True/False (TF)

```
TF <points>
<question text>
<answer>                    # "true" or "false"
```

#### 🟡 Multiple Choice (MC)

```
MC <points>
<question text>
<number of choices>         # k < 10
<choice 1>
<choice 2>
...
<choice k>
<correct answer letter>     # A, B, C, etc.
```

#### 🔵 Short Answer (SA)

```
SA <points>
<question text>
<answer>                    # single word (no spaces)
```

---

## 🧾 Example Question File (`sample.txt`)

```
3
TF 5
There exist birds that can not fly. (true/false)
true
MC 10
Who was the president of the USA in 1991?
6
Richard Nixon
Gerald Ford
Jimmy Carter
Ronald Reagan
George Bush Sr.
Bill Clinton
E
SA 20
What city hosted the 2004 Summer Olympics?
Athens
```

---

## 💡 Notes

* Input is **case-insensitive** for answers.
* `SKIP` is **reserved** and cannot be a correct answer in any question.
* Questions are selected **randomly** without duplicates.
* Each player starts with **0 points**.

```

---

Would you like me to add a **“📂 Project Structure”** section showing what Java files to include (like `QuizBowl.java`, `Player.java`, etc.)? It’s useful for setup clarity.
```
