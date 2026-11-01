# Practical 06

**Topics:** Remote Control, Notification Senders, Discount Engine

Tasks 1 and 2 are independent Java programs. Open a task folder, compile with `javac *.java`, and run its `Driver` class.

Task 3 is the advanced discount engine. It places the program in the `discount` package, asks the user to choose a rule at runtime, and applies the selected lambda rule to a list of prices. From `Task3_DiscountEngine`, build and run its executable JAR with Maven:

```bash
mvn package
java -jar target/discount-engine-1.0.0.jar
```

Without Maven, run these commands from the task folder:

```bash
mkdir -p build
javac -encoding UTF-8 -d build src/discount/DiscountEngine.java
jar --create --file discount-engine.jar --main-class discount.DiscountEngine -C build .
java -jar discount-engine.jar
```

The practical journal PDF is included in this folder.
