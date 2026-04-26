---
name: TestTouchCommand - File Creation Testing
description: Test prompts for the TOUCH (create file) command
keywords: test, touch, file creation, file operations
---

# TestTouchCommand - File Creation Testing

## Purpose

Test the `touch` command which creates new files. This test suite validates:
- Successful file creation
- File with correct names and extensions
- Duplicate file prevention
- Error handling for invalid names
- File access and properties verification

## Test File Location

`src/Test/TestTouch.java`

## Command Under Test

```bash
touch fileName         # Create a new file
touch fileName.ext     # Create file with extension
```

## Key Test Scenarios

### Positive Tests
1. **Create single file**
   - Execute `touch fileName`
   - Verify file exists
   - Verify file appears in directory

2. **Create file with extension**
   - Create files with various extensions: `.txt`, `.xml`, `.png`, `.log`
   - Verify file is created with correct extension
   - Verify extension is preserved

3. **Create multiple files**
   - Create several files with different names
   - Verify each file exists
   - Verify all appear in directory listing

4. **Create files with various naming patterns**
   - Simple names: `file`, `test`, `data`
   - With numbers: `file1`, `test_2024`
   - With underscores/hyphens: `my_file`, `test-file`
   - With multiple extensions: `archive.tar.gz`
   - Verify all variations work correctly

### Negative Tests
1. **Create duplicate file**
   - Create file with same name
   - Verify appropriate error/exception
   - Verify original file is not modified

2. **Invalid file names**
   - Reserved names (if applicable)
   - Illegal characters
   - Very long names
   - Empty names
   - Verify proper error messages

3. **Invalid operations**
   - Create in non-existent directory
   - Create without permissions
   - Verify graceful error handling

## Test Assertions

Examples of assertions to include:

```java
// Verify file exists
assertTrue(fileExists("fileName"));

// Verify file is a regular file (not directory)
assertTrue(isFile("fileName"));

// Verify file extension
assertTrue(fileName.endsWith(".ext"));

// Verify file in directory listing
assertTrue(directoryListing.contains("fileName"));

// Verify creation fails appropriately
assertThrows(Exception.class, () -> touch(duplicateName));
```

## File Verification

For each created file, verify:
- It exists in the file system
- It's a file (not a directory)
- It's readable and writable
- It appears in directory listing
- Size is correct (usually 0 for newly created files)
- Extension is preserved
- Complete path is valid

## Test Execution

```bash
# Run TOUCH tests only
mvn test -Dtest=TestTouchCommand

# Run with file creation verification
mvn test -Dtest=TestTouch -verbose

# Run all file operation tests
mvn test -Dtest=TestTouch,TestMkdir
```

## Expected Results

- File is created successfully
- File is immediately accessible
- File appears in directory listings
- File has correct name and extension
- Duplicate attempts are rejected
- Invalid names are handled gracefully
- File properties are correct
- Error messages are clear and descriptive
