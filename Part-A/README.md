# Part A — Java OOP Practice Programs

Contains the 14 CEUE203 practicals, including the third “For Advanced Learners” task where provided.

## Folder conventions
- `Practical_XX/Practical_XX.pdf` — completed journal pages for that practical.
- `Task.../` — independent Java source files for a single exercise.
- Each task is compiled and run independently because some exercises use the same class names (for example, `Driver`).

## Practical index

| Practical | Part A exercises |
|---|---|
| 01 | Vending machine; toll booth; Rock-Paper-Scissors-Lizard-Spock |
| 02 | Smart thermostat; cinema show; parking lot |
| 03 | Distinct points; duplicate card check; fractions |
| 04 | Password strength; chat-log filter; template filler |
| 05 | Shape areas; payroll; media late fees |
| 06 | Remote control; notification senders; discount engine |
| 07 | Form validator; mini test runner; column mapper |
| 08 | Guarded calculator; stock issue; AutoCloseable session |
| 09 | Counter race; seat-booking race; parallel array sum |
| 10 | Thread-pool runner; producer-consumer; deadlock prevention |
| 11 | Serialization; log analyzer; NIO directory report |
| 12 | Word frequency; unique visitors; leaderboard |
| 13 | Generic containers; bounded statistics; generic stack |
| 14 | Layered app testing; modular packaging |

## Compile and run
Open the required task directory in the terminal, then run:

```powershell
javac *.java
java Driver
```

For single-file tasks, run the class name shown by the file, such as `java VendingMachine` or `java TollBooth`.

## Practical 14
The basic layered task includes a JUnit 5 test source. The advanced modular task is a Maven project; from `Practical_14/Task2_ModularPackaging`, run:

```powershell
mvn test
mvn package
java -jar target/task-organizer-1.0.0.jar
```

The `tasks.dat` file is created by the program when run.
