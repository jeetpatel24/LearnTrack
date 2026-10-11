# LearnTrack

A console-based **Student & Course Management System** built with Core Java, as part of the Airtribe Java cohort.

It lets an admin manage:

- **Students:** add, view, search by ID, deactivate
- **Courses:** add, view, activate/deactivate
- **Enrollments:** enroll a student in a course, view a student's enrollments, mark an enrollment completed or cancelled

All data is kept in memory using `ArrayList` (no database).

> **Status: work in progress.** The entities, repositories, services, utilities and exceptions are in place. The menu-driven console UI, the remaining docs and the class diagram are coming next. See [docs/Development_Log.md](docs/Development_Log.md) for every change made so far and the reason behind it.

---

## Tech

- Java 17 (no external libraries)
- Maven project layout (`pom.xml`)

## Project structure

```
src/main/java/com/airtribe/learntrack/
├── Main.java          # Entry point (console menu, in progress)
├── entity/            # Person (abstract), Student, Course, Enrollment
├── enums/             # CourseEnrollmentStatus: ACTIVE, COMPLETED, CANCELLED
├── exception/         # EntityNotFoundException, InvalidInputException
├── repository/        # In-memory storage (ArrayList) for each entity
├── service/           # Business logic: StudentService, CourseService, EnrollmentService
└── util/              # IdGenerator (static ID counters), InputValidator
docs/
└── Development_Log.md # Step-by-step change log with reasons
```

## How to compile and run

**Prerequisite:** JDK 17 or newer (`java -version` to check).

### Option 1: IntelliJ IDEA

1. Open the `LearnTrack` folder as a project (IntelliJ detects `pom.xml`).
2. Open `src/main/java/com/airtribe/learntrack/Main.java`.
3. Click the green ▶ next to `main` and choose **Run 'Main.main()'**.

### Option 2: Terminal

From the project root:

**Windows (PowerShell)**

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src/main/java).FullName
java -cp out com.airtribe.learntrack.Main
```

**macOS / Linux / Git Bash**

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.airtribe.learntrack.Main
```

`javac` compiles the `.java` source files into `.class` bytecode in the `out/` folder; `java` starts the JVM and runs `Main` from there.

## Class diagram

_Coming in a later update._
