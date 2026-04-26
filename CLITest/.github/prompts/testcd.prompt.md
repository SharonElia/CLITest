---
name: TestCd - Directory Navigation Testing
description: Test prompts for the CD (change directory) command
keywords: test, cd, navigation, directory
---

# TestCd - Directory Navigation Testing

## Purpose

Test the `cd` command which changes the current working directory. This test suite validates:
- Navigation to subdirectories
- Navigation to parent directory using `cd ..`
- Error handling for invalid directories
- Correct path tracking after navigation

## Test File Location

`src/Test/TestCd.java`

## Command Under Test

```bash
cd directoryName    # Navigate to subdirectory
cd ..               # Navigate to parent directory
```

## Key Test Scenarios

### Positive Tests
1. **Navigate to existing directory**
   - Create a directory
   - Use `cd directoryName` to navigate to it
   - Verify current path is updated

2. **Navigate to parent directory**
   - Navigate to a subdirectory
   - Use `cd ..` to go back to parent
   - Verify correct parent path is set

3. **Navigate multiple levels**
   - Create nested directories
   - Navigate through multiple levels
   - Verify each level changes correctly

### Negative Tests
1. **Navigate to non-existent directory**
   - Attempt `cd` to a directory that doesn't exist
   - Verify error message or exception

2. **Invalid directory names**
   - Try special characters or invalid names
   - Verify proper error handling

3. **Navigate from root**
   - Try `cd ..` when already at root
   - Verify behavior is defined

## Test Assertions

Examples of assertions to include:

```java
// Verify directory change
assertEquals(currentDirectory, "expectedDirName");

// Verify navigation to parent
assertEquals(currentDirectory, "parentDir");

// Verify path structure
assertTrue(directoryStack.contains(directory));
```

## Common Issues to Test

- Path separator handling (forward vs backward slashes on Windows)
- Case sensitivity in directory names
- Whitespace in directory names
- Symbolic path references (., .., ~)

## Test Execution

```bash
# Run CD tests only
mvn test -Dtest=TestCd

# Run with verbose output
mvn test -Dtest=TestCd -X
```

## Expected Results

- All directory navigation should succeed
- Path should be correctly maintained
- Invalid navigation should be gracefully handled
- Error messages should be descriptive
