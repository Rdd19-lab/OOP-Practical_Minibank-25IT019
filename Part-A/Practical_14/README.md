# Practical 14

1. **Assemble and test:** `Task1_LayeredAppTesting` contains the task model, service, console driver and JUnit 5 tests. From that folder, compile and run the menu with `javac Task.java TaskService.java Driver.java` and `java Driver`. Run its tests with `mvn test`, or use the standalone JUnit runner commands below.
2. **Advanced learner — modular packaging:** `Task2_ModularPackaging` is a Maven package project with Java packages, object save/load and a JUnit 5 persistence test. Run `mvn test`, then `mvn package`; execute the runnable JAR in `target/`.

The included runner is `MINI-BANK/lib/junit-platform-console-standalone.jar`. From the repository root, compile and run Task 1 tests:

```powershell
$junit = 'MINI-BANK/lib/junit-platform-console-standalone.jar'
$task = 'Part-A/Practical_14/Task1_LayeredAppTesting'
javac -encoding UTF-8 -cp $junit -d "$task/build" "$task/Task.java" "$task/TaskService.java" "$task/Driver.java" "$task/TaskServiceTest.java"
java -jar $junit execute --class-path "$task/build" --scan-class-path
```

To compile and run Task 2 tests without Maven:

```powershell
$task = 'Part-A/Practical_14/Task2_ModularPackaging'
$sources = Get-ChildItem "$task/src" -Recurse -Filter *.java
javac -encoding UTF-8 -cp $junit -d "$task/build" $sources.FullName
java -jar $junit execute --class-path "$task/build" --scan-class-path
```
