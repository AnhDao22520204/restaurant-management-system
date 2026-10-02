# User Acceptance Test (UAT) Cases

These are business-level UAT cases derived from documented use-case behavior.

| Test ID | Scenario | Preconditions | Steps | Expected Result | Related UC |
|---|---|---|---|---|---|
| UAT-AUTH-01 | Successful login | Registered account exists | Enter valid login information and submit | Login succeeds and home screen is shown | UC01 |
| UAT-AUTH-02 | Invalid login | Account/login screen available | Enter incorrect login information and submit | Validation fails and user returns to data entry | UC01 |
| UAT-AUTH-03 | Successful registration | Registration screen available | Enter documented fields with valid format and submit | User information is saved to database | UC02 |
| UAT-AUTH-04 | Invalid registration format | Registration screen available | Enter invalid-format information and submit | Error is shown; correction is required | UC02 |
| UAT-TBL-01 | Assign an available table | User logged in; empty table exists | Search empty tables, select one, update table status | Table is assigned and status updated | UC03 |
| UAT-EMP-01 | Add/update employee | Manager logged in | Open employee screen, enter complete employee information, save/update | Employee information is updated | UC04 |
| UAT-EMP-02 | Incomplete employee input | Manager logged in | Enter incomplete employee information | System requires information re-entry | UC04 |
| UAT-MENU-01 | Maintain food information | Manager logged in | Add/update/delete/search a food record | Selected menu operation is completed | UC05 |
| UAT-INV-01 | Valid inventory update | User logged in | Select ingredient/inbound/outbound operation, enter valid data, confirm | Data is validated and saved | UC06 |
| UAT-INV-02 | Invalid inventory update | User logged in | Enter invalid inventory information | Error is displayed and user returns to operation screen | UC06 |
| UAT-ORD-01 | Order for available table | Employee logged in; empty table; food available | Select table, create order/invoice context, add food and quantity | Food is stored in invoice detail | UC07 |
| UAT-ORD-02 | Selected table already occupied | Employee logged in; selected table in use | Attempt to use occupied table | System requires another table selection | UC07 |
| UAT-ORD-03 | Selected food unavailable | Employee logged in; food item unavailable | Attempt to add unavailable food | System shows out-of-stock message and requires another selection | UC07 |
| UAT-BILL-01 | Successful invoice/payment flow | Customer order exists | Create invoice, perform payment, update status | Invoice/payment details are stored; invoice can be provided | UC08 |
| UAT-BILL-02 | Unsupported payment method | Customer order exists | Select unsupported/invalid payment method | Another valid method is required | UC08 |
| UAT-STAT-01 | View financial statistics | Admin logged in | Open statistics, select day/month/year period | System returns statistics for selected period | UC09 |
