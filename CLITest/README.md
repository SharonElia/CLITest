# CLITest - CLI Simulation Project

A command-line interface simulation that implements four basic Unix-like commands: `touch`, `mkdir`, `cd`, and `ls`.

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Commands](#commands)
- [Usage Examples](#usage-examples)
- [Testing](#testing)
- [Logging](#logging)
- [Architecture](#architecture)

## Overview

CLITest is a Java-based CLI simulation project that replicates core file system operations. The framework demonstrates proper software architecture with separation of concerns, abstract base classes, and comprehensive unit testing using TestNG.

## Prerequisites

- Java JDK 8 or higher
- Maven (for build and dependency management)
- TestNG (for running test suites)

## Project Structure

The project is organized into five main directories:

### 1. OsOperation
Handles the execution of user commands and test commands.

Core classes:
- **QueryRunner**: Executes the user command or test command
- **OsOperationAbstractClass**: Provides utility methods including:
  - `capitalize()`: Converts strings to uppercase
  - `extractCommand()`: Parses the command from input
  - `extractParameters()`: Extracts command parameters
- **OSCommand**: Initializes parameters and routes to the appropriate command handler

Supported commands:
- `mkdir directoryName` — Create directories
- `ls` — Display directories and files in current path
- `cd directoryName` or `cd ..` — Navigate directory structure
- `touch fileName` — Create files

### 2. OsClass
Contains individual command implementation classes:

- **Cd**: Changes to specified directory (`cd..` or `cd dirname`)
- **Ls**: Lists contents of current directory
- **Mkdir**: Creates new directory with specified name
- **Touch**: Creates a new file with specified name and extension

### 3. SystemUtilityOperation
Utility classes for file system management and tree operations:

- **AddDirectoryAndFolder**: Adds files and directories to the tree structure
- **CreateListAndTree**: Manages the directory tree and file list
- **DirectoryInit**: Initializes default directories
- **FileInitialization**: Initializes files and directories

### 4. Test
Comprehensive unit test suite using TestNG:

- **TestLs**: Tests the `ls` command functionality
- **TestMkdir**: Tests the `mkdir` command functionality
- **TestCd**: Tests the `cd` command functionality
- **TestTouch**: Tests the `touch` command functionality

All tests inherit from a common test framework using TestNG for assertion and test management.

### 5. Log
Provides logging functionality to track execution flow and system state throughout the application lifecycle.

### 6. Exceptions
Custom exception classes for handling various error conditions within the system.

## Commands

| Command | Syntax | Description |
|---------|--------|-------------|
| mkdir | `mkdir directoryName` | Create a new directory |
| ls | `ls` | List all files and directories in current path |
| cd | `cd directoryName` or `cd ..` | Navigate to a directory or parent directory |
| touch | `touch fileName` | Create a new file |

## Usage Examples

### Interactive Session

```
> mkdir Table
✓ Great! You created a directory

> mkdir Computer
✓ Great! You created a directory

> touch Computer.xml
✓ Great! You created a file

> ls
Table
Computer
Computer.xml

> cd Table
> ls
(directory is empty)

> cd ..
```

## Testing

### Running Tests

Execute the test suite using Maven:

```bash
mvn test
```

### Test Results

Sample test execution output:

```
=========================================================
Sample Test Suite
Total tests run: 9, Failures: 0, Skips: 0
=========================================================
```

**Coverage**: The test suite validates all four core commands with comprehensive scenario testing.

## Logging

The system generates detailed logs tracking:
- Process initialization and lifecycle
- Command execution flow
- Parameter extraction and validation
- File/Directory creation operations
- Command routing and execution completion

### Sample Log Output

```
2020-12-07 10:27:04,063 INFO [Log] ******* LunchCli *******
2020-12-07 10:27:04,094 INFO [Log] Launch the process
2020-12-07 10:27:04,094 INFO [Log] Return parameter
2020-12-07 10:27:04,094 INFO [Log] Send the command to relevant class
2020-12-07 10:27:04,094 INFO [Log] Start make files
2020-12-07 10:27:04,094 INFO [Log] Creating files
2020-12-07 10:27:04,095 INFO [Log] Run cd command
2020-12-07 10:27:04,095 INFO [Log] ****** Complete Test ******
```

## Architecture

The application follows a layered architecture:

1. **Command Layer (OsClass)**: Individual command implementations
2. **Operation Layer (OsOperation)**: Command parsing and routing logic
3. **Utility Layer (SystemUtilityOperation)**: File system abstraction and tree management
4. **Test Layer**: Comprehensive unit tests with TestNG
5. **Cross-cutting Concerns**: Logging and exception handling

This design ensures:
- Loose coupling between components
- Easy addition of new commands
- Comprehensive testability
- Clear separation of concerns

