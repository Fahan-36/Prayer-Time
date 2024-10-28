<div align="center">
<img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp" alt="Prayer Tracker Icon" width=25% height=25%>
  <h1 align="center">Prayer Time</h1>
  <p align="center">A Simple Prayer Tracking App</p>
</div>

An Android application built using Kotlin for logic, XML for UI design, and SQLite for local storage. The app allows users to log prayer names and times, track their prayer routines, and receive reminders to stay consistent.

## Features

- **Prayer Logging**: Users can create prayer entries, adding specific names and times similar to a to-do list.
- **Reminders**: Notifications alert users at designated prayer times.
- **Progress Tracking**: Users can mark prayers as completed and monitor their daily and weekly progress.

## Technologies Used

- **Kotlin**: Core language for app logic
- **XML**: For UI design
- **SQLite Database**: For local data storage
- **WorkManager**: For handling prayer reminders in the background
- **ViewModel**: For managing UI-related data in a lifecycle-conscious way

## How It Works

### 1. Prayer Logging
- Users can create prayer entries, specifying the time for each. Entries are stored locally in the app’s SQLite database to allow easy access and data persistence.

### 2. Reminders
- Using WorkManager, the app schedules notifications based on the prayer times set by users. Notifications will remind users even if the app is not open.

### 3. Progress Tracking
- Users can mark each prayer as “done,” helping them keep track of their prayer routine. The app displays an overview of daily and weekly completion to encourage consistency.

## Download

Download the APK from the [release section](https://github.com/Fahan-36/Prayer-Time/releases)
## Build Manual

### Package & Software Requirements

| Component               | Version/Details                  |
|-------------------------|----------------------------------|
| **IDE**                 | Android Studio (2023 or later)   |
| **Installed Packages**  |                                  |
| `Kotlin`                | 1.8.1                            |
| `XML`                   | For UI design                    |
| `ViewModel`             | 2.6.1                            |
| `Room Database (SQLite)`| 2.6.1                            |
| `WorkManager`           | 2.9.1                            |

### Installation

- Download & Install the latest Android Studio IDE [Android Studio](https://developer.android.com/studio)
- Configure an Android Emulator in the IDE
- Clone the project repository using:
    ```bash
      git clone https://github.com/Fahan-36/Prayer-Time.git
    ```
- Ensure all dependencies are added in the build file (`build.gradle.kts:app`).
- Run the build to start the emulator and app.

## Screenshots

<div align="center">
![screenshots1](https://github.com/user-attachments/assets/8eaa6ae4-4aee-424b-8f87-745de0838223)
![screenshots2](https://github.com/user-attachments/assets/f6824782-9ff8-4db9-a3cd-a08a8b1f387b)
![screenshots3](https://github.com/user-attachments/assets/8a34c1cf-4168-4dfc-8eb0-9c12746e100b)
![screenshots4](https://github.com/user-attachments/assets/85ee1546-7200-4869-abaf-2570b79da7f1)
</div>
