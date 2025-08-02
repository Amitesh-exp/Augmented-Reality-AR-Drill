# AR Placement App

This is a minimal Android application built for an assignment. The app demonstrates core AR (Augmented Reality) functionalities using Kotlin, ARCore, and the `sceneview` library. The objective is to allow a user to select a "drill" from a UI and place a corresponding 3D marker onto a detected real-world surface.

## Features

* **Drill Selection**: A simple UI to select from a list of drills.
* **AR Scene**: Launches into a full-screen AR experience.
* **Plane Detection**: Automatically detects horizontal surfaces like floors and tables.
* **Tap to Place**: Allows the user to tap on a detected plane to place a 3D cube object in the real world.

## Screenshots
![AR Drill SS 1](https://github.com/user-attachments/assets/2acf82fb-df0b-495e-93f2-3f5a3b6a2f1f)


## Requirements

To build and run this project, you will need:

* Android Studio (Hedgehog or newer is recommended).
* A physical Android device that supports ARCore. You can check the list of supported devices [here](https://developers.google.com/ar/devices).
* "Google Play Services for AR" installed and updated on the device from the Play Store.

## How to Use the App

1.  When the app opens, you will see a simple UI with a dropdown to select a drill.
2.  Select a drill and tap the "**Start AR Drill**" button.
3.  Grant the app **camera permission** when prompted.
4.  Point your phone's camera towards a flat, textured surface (like the floor). Move it around slowly until you see visual feedback indicating a plane has been detected.
5.  **Tap on the detected plane** to place the 3D drill marker (a cube) in the scene.
