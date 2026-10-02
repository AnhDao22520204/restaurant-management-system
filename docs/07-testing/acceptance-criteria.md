# Acceptance Criteria

The following acceptance criteria translate explicit use-case behavior into testable BA language without introducing unsupported rules.

## UC01 Login

- AC1: Given a registered user, when valid login information is submitted, then the system accepts the login and navigates to the main screen.
- AC2: Given incorrect login information, when validation fails, then the user is returned to login data entry.

## UC02 Register

- AC1: Given registration details in the documented format, when the user submits them and validation passes, then the user information is saved.
- AC2: Given invalid input format, when validation fails, then an error is shown and the user must correct the input.

## UC03 Table Management

- AC1: Given restaurant tables, staff can search for an available table.
- AC2: When a table is assigned, its status can be updated.

## UC04 Employee Management

- AC1: Given a logged-in manager, employee records can be added, updated, deleted, or searched.
- AC2: Given incomplete employee input, the system requests re-entry.

## UC05 Food Management

- AC1: Given a logged-in manager, food/menu records can be added, updated, deleted, or searched.
- AC2: Given incomplete food input, the system requests re-entry.

## UC06 Inventory Management

- AC1: Users can choose ingredient, inbound, or outbound operations and update the related information.
- AC2: The system validates inventory updates before saving them.
- AC3: When validation fails, an error is shown and the flow returns to the related operation.

## UC07 Food Ordering

- AC1: Staff can begin an order only after selecting an available table.
- AC2: Food and quantity can be added to the invoice/order detail.
- AC3: If the table is occupied, another table must be selected.
- AC4: If the food item is unavailable, the system shows an out-of-stock notification and another item must be selected.

## UC08 Invoice Management

- AC1: Cashier can create an invoice from a customer order and view table/food/quantity/price/total information.
- AC2: Payment status can be updated after payment handling.
- AC3: Invalid order code produces an error/re-entry path.
- AC4: Invalid/unsupported payment method requires another payment method.

## UC09 Financial Statistics

- AC1: Admin can choose day/month/year as a statistics period.
- AC2: The system returns the requested statistics result.
