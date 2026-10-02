# Restaurant Management System - System Analysis & Design

## Project overview

The project addresses restaurant operations that can become error-prone when handled manually, including food ordering, table management, payment, employee administration, inventory, and financial reporting. The target system is intended to improve operational efficiency and service quality through centralized digital workflows.


## Core business areas

| Area | Main capabilities |
|---|---|
| Authentication | Register, login, logout, password/account handling |
| Table Management | Search tables, assign tables, update table status |
| Employee Management | Maintain employees, shifts/hours, salary-related management |
| Menu / Food Management | Maintain menu items, prices, descriptions, images, categories, promotions |
| Inventory | Manage ingredients, inbound/outbound stock records |
| Food Ordering | Select table, add food and quantity, create order/invoice detail |
| Billing & Payment | Create/search/update/print invoices, manage payment state |
| Financial Statistics | Revenue/profit reporting by selected periods |

## BA / System Analysis artifacts

This repository contains:

- Business problem, objectives, scope, and stakeholders
- Business Requirements (normalized from the report)
- Functional Requirements and documented Non-Functional Requirements
- Business Rules derived from explicit process/use-case conditions
- Actor catalog and use-case catalog
- Nine detailed use-case specifications
- Extracted Use Case, Activity, Sequence, Class, State, and ER diagrams
- Relational data model and data dictionary
- UI screen catalog and extracted application screenshots
- Acceptance Criteria, UAT cases, and Requirement Traceability Matrix (RTM)
- Known gaps/inconsistencies and source-grounding policy
- Group contribution matrix from the original report

## Primary review path

**Business Problem -> Scope -> Requirements -> Use Cases -> UML -> Data Model -> UI -> UAT -> Traceability -> Known Gaps**

Start with [`docs/00-guide/how-to-read-this-repo.md`](docs/00-guide/how-to-read-this-repo.md).

## Repository structure

```text
restaurant-management-system-analysis-design/
├── .gitignore
├── README.md
├── REPOSITORY_MANIFEST.txt
├── docs/
│   ├── README.md
│   ├── 00-guide/
│   │   └── how-to-read-this-repo.md
│   ├── 01-business-overview/
│   │   ├── business-context.md
│   │   ├── business-problem.md
│   │   ├── project-objectives.md
│   │   ├── project-scope.md
│   │   └── stakeholders.md
│   ├── 02-requirements/
│   │   ├── business-requirements.md
│   │   ├── business-rules.md
│   │   ├── functional-requirements.md
│   │   └── non-functional-requirements.md
│   ├── 03-use-cases/
│   │   ├── actors.md
│   │   ├── use-case-list.md
│   │   └── specifications/
│   │       ├── UC01-login.md
│   │       ├── UC02-register.md
│   │       ├── UC03-table-management.md
│   │       ├── UC04-employee-management.md
│   │       ├── UC05-food-management.md
│   │       ├── UC06-inventory-management.md
│   │       ├── UC07-food-ordering.md
│   │       ├── UC08-invoice-management.md
│   │       └── UC09-financial-statistics.md
│   ├── 04-diagrams/
│   │   ├── activity/
│   │   ├── class/
│   │   ├── erd/
│   │   ├── sequence/
│   │   ├── state/
│   │   └── use-case/
│   ├── 05-database/
│   │   ├── data-dictionary.md
│   │   └── DatabaseRestaurant.sql
│   ├── 06-ui/
│   │   ├── screen-list.md
│   │   └── screenshots/
│   └── 07-testing/
│       ├── acceptance-criteria.md
│       ├── requirement-traceability-matrix.md
│       └── uat-test-cases.md
└── src/
```

## Technology documented in the source

- Java
- Oracle Database
- NetBeans IDE
- JDBC / OJDBC
- JCommon / JFreeChart
- javax.mail / activation
- Draw.io for system diagrams

