# Class Description: SMSFragment

## 1. General Information
*   **Class Name:** SMSFragment
*   **Type:** Fragment (UI Module)
*   **Purpose:** Provides a sub-screen where the user can enter an SMS message and a phone number.
*   **Interaction:** Lives inside the MainActivity. It gathers user input and displays it using a pop-up message (Toast).

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where used |
| :--- | :--- | :--- | :--- |
| `etPhoneNumber` | EditText | Input field for the phone number | `onCreateView` |
| `etSMStext` | EditText | Input field for the message text | `onCreateView` |
| `bSendSMS` | Button | The "Send" button | `onCreateView` |
| `st1`, `st2` | String | Temporary storage for input text | `onClick` |

## 3. Class Methods
### Method: onCreateView()
*   **Type:** public
*   **Return value:** View (The fragment's UI)
*   **What it does:** Inflates the layout (turns XML into code), connects the variables to the UI elements, and sets up the click listener for the button. When clicked, it reads the input from the text boxes and shows a Toast.
*   **When called:** When the MainActivity attaches this fragment to the screen.

## 4. Lifecycle (Fragment)
*   **onCreateView():** The most important method for a fragment. This is where the interface is built and prepared for the user.

## 5. UI Interaction
*   **EditText:** Allows the user to type information.
*   **Toast:** A small temporary notification that appears at the bottom of the screen.

## 7. General Logic
This class acts like a digital form. It waits for the user to fill in the blanks. Once the button is pressed, it "grabs" the text from the screen and shows it back to you.

## 8. Simplified Explanation
**SMSFragment** is like a paper form you fill out at a post office. It has specific lines for a phone number and a message. The "Send" button is like handing that form to the clerk: the clerk looks at it and reads the details back to you to confirm they got it right.
