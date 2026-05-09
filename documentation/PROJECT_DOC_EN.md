# 📱 Android App Documentation: FeedbackWithFragments

________________________________________
## 🧾 General Information
*   **Project Name:** FeedbackWithFragments
*   **Author:** Zeev Fraiman
*   **Date:** May 2024
*   **Language:** Java
*   **IDE:** Android Studio
*   **Android Version:** minSdk 28 / targetSdk 36
________________________________________
## 🎯 Project Goal
•   **Task:** Provide a user-friendly interface for sending feedback via various channels (SMS, E-mail, Phone).
•   **Importance:** Centralizing communication methods simplifies user interaction with support or developers.
•   **Target Audience:** Mobile users who need quick access to contact options.
________________________________________
## 📌 Requirements
### Functional Requirements
•   Switch between input screens without reloading the entire Activity.
•   Automatic network availability check and disabling of unavailable features.
•   Input text and phone numbers for SMS.
### Non-functional Requirements
•   **Performance:** Instant Fragment switching.
•   **Usability:** Intuitive control buttons at the bottom.
•   **Reliability:** Preventing data submission attempts when there is no connection.
________________________________________
## 🧠 General Architecture
•   **Approach:** MVC (Model-View-Controller).
•   **Why:** For a small project, it allows clear separation between control logic (Activity) and UI (Fragments).
•   **Components:**
    *   `MainActivity` — Controller.
    *   `Fragments` — Views.
    *   `BroadcastReceivers` — System event listeners.
________________________________________
## 🧩 UML Diagram
`[MainActivity]` <--> `[SMSFragment | MailFragment | PhoneFragment]`
`[MainActivity]` <-- `[ConnectivityManager]`
________________________________________
## 🧩 Class Details
### 📌 Class: MainActivity
*   **Role:** Main hub and coordinator.
*   **Responsibility:** Fragment lifecycle management, network receiver registration.
*   **Methods:**
    *   `onCreate()` — Initialize elements and set listeners.
    *   `updateButtonsState()` — Logic for mobile network availability.
    *   `onResume()` / `onPause()` — System subscription management.

### 📌 Class: SMSFragment / MailFragment / PhoneFragment
*   **Role:** Interface modules.
*   **Responsibility:** Collect user input.
________________________________________
## 🎨 UI/UX Analysis
•   **Principles:**
    *   **Simplicity:** One button, one action.
    *   **Logic:** Content area is located above the navigation buttons.
    *   **Accessibility:** Visual feedback (disabled state) if a function is unavailable.
________________________________________
## ⚙️ Threading
•   **Method:** UI Thread (Main).
•   **ANR Prevention:** Using lightweight operations inside BroadcastReceivers.
________________________________________
## 💾 Data Handling
•   **Type:** Temporary storage in UI components (EditText).
•   **Security:** Data is not stored on disk, preventing leaks after the app is closed.
________________________________________
## 📊 Project Self-Assessment
| Criterion | Rating (1–10) |
| :--- | :--- |
| Architecture | 7 |
| Code | 6 |
| UI/UX | 8 |
| Reliability | 9 |
| **Total Level** | **7.5** |
________________________________________
## 🏁 Conclusion
The project successfully demonstrates working with Fragments and Android system events. Skills in managing UI states based on external conditions (network) were acquired.
