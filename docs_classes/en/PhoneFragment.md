# Class Description: PhoneFragment

## 1. General Information
*   **Class Name:** PhoneFragment
*   **Type:** Fragment (UI Module)
*   **Purpose:** A screen used to input a phone number.
*   **Interaction:** Collects the phone number and passes it to the `MainActivity` using the `receiveData` method.

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where used |
| :--- | :--- | :--- | :--- |
| `etPhone` | EditText | Input field for phone number | `onCreateView` |
| `bCallNumber` | Button | Confirmation button | `onCreateView` |
| `st1` | String | Holds the input text | `onClick` |

## 3. Class Methods
### Method: onCreateView()
*   **What it does:** Builds the input interface. When the button is clicked, it gets a reference to the `MainActivity` and sends the typed number there.
*   **Key Detail:** It uses `(MainActivity) getActivity()`. This allows the fragment to talk to its parent activity.

## 4. Lifecycle
*   **onCreateView():** Called when the fragment is being created to show on the screen.

## 6. Interaction with other components
This fragment sends data "upwards":
1. Reads input text.
2. Finds the parent `MainActivity`.
3. Calls `activity.receiveData(st1)`.

## 8. Simplified Explanation
**PhoneFragment** is like an intercom keypad. You type the apartment number (the phone number), press the "Call" button, and the signal travels to the main control box (**MainActivity**), which then decides what to do with that signal.
