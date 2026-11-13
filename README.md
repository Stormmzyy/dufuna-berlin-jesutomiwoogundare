# Dufuna Java Programme: Address

This repository contains my work for the Dufuna Java Programme (Berlin cohort). It is a single Maven project that grows sprint by sprint, with each sprint adding new packages and applications on top of the existing structure.

So far the project contains two runnable console applications:

- **AddressApp**: an introductory program that prints a greeting.
- **MockLekkiPropertyApp**: a small property application that models a Lekki property, saves it through a service interface and reads it back using a mock implementation.

## Sprint Progress

| Sprint | Topic | What was built | Branch |
| --- | --- | --- | --- |
| 1 | Development environment setup | Installed and configured JDK 17, Maven, Git and IntelliJ IDEA. No code. | n/a |
| 2 | Maven project and HelloWorld | Created the `address` Maven project and the `AddressApp` class, which prints `Hello, World!`. | `main` |
| 3 | Lekki Property application | Added the `LekkiProperty` model, the `LekkiPropertyService` interface, the `MockLekkiPropertyService` implementation and the `MockLekkiPropertyApp` entry point. | `feature/jcc_Sprint3` |

## Tech Stack

| Tool | Version |
| --- | --- |
| Java (Amazon Corretto) | 17 |
| Apache Maven | 3.9.x |
| Git | Any recent version |
| IDE (recommended) | IntelliJ IDEA |

The project uses only the Java standard library. There are no external dependencies.

## Prerequisites

Make sure the following are installed and available on your `PATH`:

- **JDK 17** (Amazon Corretto 17 recommended)
- **Apache Maven 3.9 or later**
- **Git**

Verify your setup:

```bash
java -version
mvn -version
git --version
```

`java -version` should report version 17, and the `Java version` line in the `mvn -version` output should also show 17. If Maven reports a different Java version, check that `JAVA_HOME` points to your JDK 17 installation.

## Getting Started

Clone the repository:

```bash
git clone https://github.com/Stormmzyy/dufuna-berlin-jesutomiwoogundare.git
cd dufuna-berlin-jesutomiwoogundare
```

Build the project:

```bash
mvn clean install
```

A successful build ends with `BUILD SUCCESS`, compiles the classes into `target/classes` and produces `target/address-1.0-SNAPSHOT.jar`.

## Running the Applications

Build the project first, then run each application from the project root.

### AddressApp (Sprint 2)

```bash
java -cp target/classes com.dufuna.berlin.jesutomiwoogundare.address.AddressApp
```

Expected output:

```
Hello, World!
```

### MockLekkiPropertyApp (Sprint 3)

The app creates a `LekkiProperty`, saves it through `MockLekkiPropertyService`, retrieves it by its ID and prints it.

```bash
java -cp target/classes com.dufuna.berlin.jesutomiwoogundare.lekki.MockLekkiPropertyApp
```

Expected output:

```
MockLekkiPropertyService.saveProperty called
MockLekkiPropertyService.getProperty called
LekkiProperty{propertyId=1, address='12 Admiralty Way, Lekki Phase 1, Lagos', type='Duplex', noOfBedrooms=4, noOfSittingRooms=2, noOfKitchens=1, noOfBathrooms=4, noOfToilets=5, owner='Jesutomiwo Ogundare', description='Fully detached duplex with a boys' quarters', validFrom=2026-01-01, validTo=2027-12-31}
```

The mock service holds a single property in memory. `getProperty` returns the last saved property regardless of the ID passed in, and nothing is persisted between runs.

### From IntelliJ IDEA

1. Open the project folder in IntelliJ IDEA (**File > Open**). It will be detected as a Maven project.
2. Set the project SDK to Java 17 under **File > Project Structure > Project**.
3. Open `AddressApp.java` or `MockLekkiPropertyApp.java` and click the run icon next to the `main` method.

## Project Structure

```
.
├── pom.xml
├── README.md
├── .gitignore
└── src
    └── main
        └── java
            └── com
                └── dufuna
                    └── berlin
                        └── jesutomiwoogundare
                            ├── address
                            │   └── AddressApp.java
                            ├── lekki
                            │   └── MockLekkiPropertyApp.java
                            ├── model
                            │   └── LekkiProperty.java
                            └── service
                                ├── LekkiPropertyService.java
                                └── MockLekkiPropertyService.java
```

All packages sit under the base package `com.dufuna.berlin.jesutomiwoogundare`.

| Package | Sprint | Contents |
| --- | --- | --- |
| `address` | 2 | `AddressApp`, the HelloWorld entry point. |
| `lekki` | 3 | `MockLekkiPropertyApp`, the entry point that builds a sample property and uses the service to save and retrieve it. |
| `model` | 3 | `LekkiProperty`, a plain Java class describing a property: ID, address, type, room counts (bedrooms, sitting rooms, kitchens, bathrooms, toilets), owner, description and a validity period (`validFrom` and `validTo` as `LocalDate`). It provides getters and setters and overrides `toString`, `equals` and `hashCode`. |
| `service` | 3 | `LekkiPropertyService`, an interface with `saveProperty(LekkiProperty)` and `getProperty(long)`, and `MockLekkiPropertyService`, an in-memory implementation that logs each call to the console. |

Build output goes to `target/`, which is not tracked in Git.

## Configuration

Project settings are defined in `pom.xml`:

| Property | Value |
| --- | --- |
| `groupId` | `com.dufuna.berlin.jesutomiwoogundare` |
| `artifactId` | `address` |
| `version` | `1.0-SNAPSHOT` |
| `maven.compiler.source` / `maven.compiler.target` | `17` |
| `project.build.sourceEncoding` | `UTF-8` |

No environment variables or external services are required to run the applications.

## Development Workflow

Each sprint is developed on its own branch and merged into `main` through a pull request.

1. Start from an up-to-date `main` and create the sprint branch:

   ```bash
   git checkout main
   git pull
   git checkout -b feature/jcc_SprintN
   ```

2. Add or change code in `src/main/java`, keeping each class in the package that matches its directory.
3. Build and confirm the build passes:

   ```bash
   mvn clean install
   ```

4. Run the new application and check its output.
5. Update this README:
   - add a row to the **Sprint Progress** table
   - add the run command and expected output under **Running the Applications**
   - add any new packages to the **Project Structure** tree and package table
6. Commit and push the branch:

   ```bash
   git add .
   git commit -m "Sprint N: short description of the change"
   git push -u origin feature/jcc_SprintN
   ```

7. Open a pull request from `feature/jcc_SprintN` into `main` on GitHub, review it and merge it.

Build output (`target/`) and IDE-specific files (`.idea/`, `*.iml`) are excluded through `.gitignore`.

## Conventions

- Branches are named `feature/jcc_SprintN`, where `N` is the sprint number.
- Class names match their file names (for example, `LekkiProperty` lives in `LekkiProperty.java`).
- Package names mirror the directory structure under `src/main/java`.
- Packages are grouped by role: `model` for data classes, `service` for service interfaces and their implementations, and one package per application entry point.
- Services are written against an interface (`LekkiPropertyService`) so the mock implementation can later be replaced without changing the calling code.
- `pom.xml` stays at the root of the project.

## Author

**Jesutomiwo Ogundare**
GitHub: [@Stormmzyy](https://github.com/Stormmzyy)
