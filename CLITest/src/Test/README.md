# Test Folder Overview

This folder contains automated TestNG tests for the CLI commands and prompt documents used for QA guidance.

## Java Test Files

- `ConfTest.java`: Base test configuration with shared setup (`@BeforeTest`) and teardown (`@AfterTest`).
- `Static.java`: Shared static test data and reusable objects used by the command test classes.
- `TestCdCommand.java`: Tests `cd` behavior, including navigation attempts to files and directories.
- `TestLsCommand.java`: Tests `ls` output after creating files and directories.
- `TestMkdirCommand.java`: Tests single and bulk directory creation with `mkdir`.
- `TestTouchCommand.java`: Tests single and bulk file creation with `touch`.

## Prompt/Guidance Files

- `test.prompt.md`: High-level QA automation role and execution guidance for this project.
- `TestCd.prompt.md`: Detailed scenarios and assertions for `cd` command testing.
- `TestLs.prompt.md`: Detailed scenarios and assertions for `ls` command testing.
- `TestMkdir.prompt.md`: Detailed scenarios and assertions for `mkdir` command testing.
- `TestTouch.prompt.md`: Detailed scenarios and assertions for `touch` command testing.
