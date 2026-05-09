# Class Description: MainActivity

## 1. General Information
*   **Class Name:** MainActivity
*   **Type:** Activity (Main Screen)
*   **Purpose:** The central hub of the app. It acts as a "command center" that switches between fragments (sub-screens) and monitors network/phone connectivity.
*   **Interaction:** Manages `SMSFragment`, `MailFragment`, and `PhoneFragment`. It receives data from these fragments to display messages on the screen.

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where used |
| :--- | :--- | :--- | :--- |
| `bSms`, `bMail`, `bPhone` | Button | Navigation buttons | `initElements`, `onCreate` |
| `flFragments` | FrameLayout | Container where fragments are shown | `onCreate` (transactions) |
| `context` | Context | Reference to the app's environment | `initElements`, `Toast` |
| `networkReceiver` | BroadcastReceiver | Listener for internet changes | `onResume`, `onPause` |
| `phoneStateReceiver` | BroadcastReceiver | Listener for mobile signal changes | `onResume`, `onPause` |

## 3. Class Methods
### Method: onCreate()
*   **Type:** protected
*   **Return value:** void
*   **Parameters:** `Bundle savedInstanceState` (Saved app state)
*   **What it does:** Runs when the app starts. It finds UI elements, sets up button click listeners, and handles fragment transactions (switching views).
*   **When called:** Once, when the screen is first created.

### Method: updateButtonsState()
*   **Type:** private
*   **Return value:** void
*   **What it does:** Checks if the mobile network is available. If there's no signal, it disables the SMS and Phone buttons (makes them grey).
*   **When called:** On startup and whenever the signal status changes.

## 4. Lifecycle (Activity)
*   **onCreate():** Initialization: sets up the UI and buttons.
*   **onResume():** Activation: registers "listeners" so the app can hear system updates about the internet.
*   **onPause():** Sleeping: unregisters listeners to save battery power.

## 5. UI Interaction
*   Uses `findViewById` to connect Java code with XML layouts.
*   Handles click events (`setOnClickListener`) for the three main buttons.

## 6. General Logic
The class works like a dispatcher. When you click the "SMS" button, it tells the system: "Remove what is currently in the middle of the screen and put SMSFragment there instead." Meanwhile, it constantly "listens" (via Receivers) to turn off features if the connection is lost.

## 8. Simplified Explanation
Think of **MainActivity** as a TV remote. The TV screen is the phone's display. Clicking the "SMS" button switches the TV to the "Messages" channel. If the antenna cable (network) is unplugged, the remote simply won't let you switch to that channel.
