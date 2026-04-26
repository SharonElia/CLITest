---
name: TestLsCommand - Directory Listing Testing
description: Test prompts for the LS (list) command
keywords: test, ls, listing, directory, files
---

# TestLsCommand - Directory Listing Testing

## Purpose

Test the `ls` command which displays the contents of the current directory. This test suite validates:
- Correct listing of all files and directories
- Accurate file/directory distinction
- Handling of empty directories
- Proper display format and order
- Special case handling

## Test File Location

`src/Test/TestLs.java`

## Command Under Test

```bash
ls                  # List all contents in current directory
```

## Key Test Scenarios

### Positive Tests
1. **List directory with files and subdirectories**
   - Create mixed content (files and directories)
   - Execute `ls` command
   - Verify all items are listed
   - Verify correct item count

2. **List empty directory**
   - Create an empty directory
   - Navigate to it
   - Execute `ls`
   - Verify appropriate empty message or empty list

3. **List with multiple items**
   - Create many files and directories
   - Verify all appear in listing
   - Verify listing is complete and accurate

4. **List with various file types**
   - Files with different extensions (.txt, .xml, .png, etc.)
   - Directories with different naming patterns
   - Verify all are properly displayed

### Negative Tests
1. **List non-existent directory** (if applicable)
   - Verify error handling

2. **List with special characters in names**
   - Files/dirs with spaces, hyphens, underscores
   - Verify proper display

## Test Assertions

Examples of assertions to include:

```java
// Verify item count
assertEquals(listSize, expectedCount);

// Verify specific item exists
assertTrue(items.contains("fileName"));

// Verify all items listed
assertTrue(items.containsAll(expectedItems));

// Verify correct format
assertTrue(output.matches(expectedPattern));
```

## Content to Verify

- File names
- Directory names
- Number of items
- Item order (if sorted)
- Duplicates (should not exist)
- Hidden items handling (if applicable)

## Test Execution

```bash
# Run LS tests only
mvn test -Dtest=TestLsCommand

# Run with output verification
mvn test -Dtest=TestLs -e
```

## Expected Results

- All visible files and directories are listed
- Listing is complete and accurate
- Output format is consistent
- Empty directories are handled correctly
- Item names are displayed as created
