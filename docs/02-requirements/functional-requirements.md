# Functional Requirements

| ID | Module | Requirement | Related BR |
|---|---|---|---|
| FR-AUTH-01 | Authentication | The system shall allow supported users to register an account. | BR-002 |
| FR-AUTH-02 | Authentication | The system shall allow registered users to log in. | BR-002 |
| FR-AUTH-03 | Authentication | The system shall validate login information and reject incorrect credentials by returning the user to data entry. | BR-002 |
| FR-AUTH-04 | Authentication | Registration shall capture documented user information and validate input format before saving it to the database. | BR-002 |
| FR-TBL-01 | Table | Staff shall be able to search for available tables. | BR-003 |
| FR-TBL-02 | Table | Staff shall be able to assign/select an available table for customers. | BR-003, BR-007 |
| FR-TBL-03 | Table | The system shall allow table status to be updated. | BR-003 |
| FR-EMP-01 | Employee | Management shall be able to add, update, delete, and search employee information. | BR-004 |
| FR-EMP-02 | Employee | Management shall be able to schedule employee shifts. | BR-004 |
| FR-EMP-03 | Employee | Management shall be able to track employee work hours for salary calculation. | BR-004 |
| FR-EMP-04 | Employee | Management shall be able to calculate/pay employee salary as documented. | BR-004 |
| FR-MENU-01 | Menu | Management shall be able to add, update, delete, and search menu items. | BR-005 |
| FR-MENU-02 | Menu | Menu items shall support price, description, image, and other documented attributes. | BR-005 |
| FR-MENU-03 | Menu | Management shall be able to maintain promotions for menu items. | BR-005 |
| FR-MENU-04 | Menu | The system shall support menu classification/category handling. | BR-005 |
| FR-INV-01 | Inventory | Users shall be able to add, update, delete, and search ingredient information. | BR-006 |
| FR-INV-02 | Inventory | Users shall be able to create/update inbound stock records. | BR-006 |
| FR-INV-03 | Inventory | Users shall be able to create/update outbound stock records. | BR-006 |
| FR-INV-04 | Inventory | The system shall validate inventory updates before saving them. | BR-006 |
| FR-INV-05 | Inventory | Inventory quantities/value shall be updated after inbound/outbound activities as documented in the process description. | BR-006 |
| FR-ORD-01 | Ordering | Staff shall select an available table before placing the customer's food order. | BR-003, BR-007 |
| FR-ORD-02 | Ordering | Staff shall be able to create a new invoice/order context for the selected table. | BR-007, BR-008 |
| FR-ORD-03 | Ordering | Staff shall be able to add food items and quantities to order/invoice detail. | BR-007 |
| FR-ORD-04 | Ordering | The system shall check menu-item availability/status before adding the item. | BR-007 |
| FR-ORD-05 | Ordering | If a table is already in use, the system shall require another table selection. | BR-003, BR-007 |
| FR-ORD-06 | Ordering | If a food item is unavailable, the system shall notify the user and require another selection. | BR-005, BR-007 |
| FR-BILL-01 | Billing | Cashier shall be able to create a customer invoice from the order context. | BR-008 |
| FR-BILL-02 | Billing | The invoice shall display documented order information including table, food, quantity, unit price, and total. | BR-008 |
| FR-BILL-03 | Billing | The system shall support invoice search/filter and invoice history. | BR-008 |
| FR-BILL-04 | Billing | The system shall support invoice status updates. | BR-008 |
| FR-BILL-05 | Billing | The system shall support documented online/offline payment handling. | BR-008 |
| FR-BILL-06 | Billing | After successful payment, the system shall retain invoice/payment details and provide the customer invoice in paper or electronic form. | BR-008 |
| FR-STAT-01 | Statistics | Admin shall be able to request financial statistics. | BR-009 |
| FR-STAT-02 | Statistics | Admin shall be able to choose a statistics period such as day, month, or year. | BR-009 |
| FR-STAT-03 | Statistics | The system shall return the requested statistics result, including documented revenue/profit-related information. | BR-009, BR-010 |
