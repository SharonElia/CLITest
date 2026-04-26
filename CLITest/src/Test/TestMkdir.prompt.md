---
name: TestMkdirCommand - Directory Creation Testing
description: Test prompts for the MKDIR (make directory) command
keywords: test, mkdir, directory creation, fs operations
---

# TestMkdirCommand - Directory Creation Testing

## Purpose

Test the `mkdir` command which creates new directories. This test suite validates:
- Successful directory creation
- Correct directory structure
- Duplicate directory prevention
- Error handling for invalid names
- Permission and access verification

## Test File Location

`src/Test/TestMkdir.java`

## Command Under Test

```bash
mkdir directoryName    # Create a new directory
```

## Key Test Scenarios

### Positive Tests
1. **Create single directory**
   - Execute `mkdir directoryName`
   - Verify directory exists
   - Verify it appears in file system

2. **Create multiple directories**
   - Create several directories with different names
   - Verify each one is created
   - Verify all are accessible

3. **Create nested directories**
   - Create parent directory
   - Create subdirectories within it
   - Verify structure is correct

4. **Create directory with various names**
   - Simple names: `folder`, `test`, `data`
   - With numbers: `folder1`, `test_2024`
   - With underscores/hyphens: `my_folder`, `test-dir`
   - Verify all variations work

### Negative Tests
1. **Create duplicate directory**
   - Create directory with same name
   - Verify appropriate error/exception
   - Verify original directory is not modified

2. **Invalid directory names**
   - Reserved names or special characters (if applicable)
   - Very long names
   - Empty names
   - Verify proper error messages

3. **Invalid operations**
   - Create without proper permissions
   - Create in non-existent parent
   - Verify graceful error handling

## Test Assertions

Examples of assertions to include:

```java
// Verify directory exists
assertTrue(directoryExists("directoryName"));

// Verify directory is accessible
assertTrue(directory.canRead() && directory.canWrite());

// Verify in directory tree
assertTrue(fileSystem.contains(directory));

// Verify creation fails appropriately
assertThrows(Exception.class, () -> mkdir(duplicateName));
```

## Creation Verification

For each created directory, verify:
- It exists in the file system
- It's readable and writable
- It appears in parent directory listing
- It can contain files and subdirectories
- Its properties are correct (type is directory, not file)

## Test Execution

```bash
# Run MKDIR tests only
mvn test -Dtest=TestMkdirCommand

# Run with file system verification
mvn test -Dtest=TestMkdir -verbose
```

## Expected Results

- Directory is created successfully
- Directory is immediately accessible
- Directory appears in file listings
- Directory structure is maintained correctly
- Duplicate attempts are rejected
- Invalid names are handled gracefully
- Error messages are clear and descriptive
