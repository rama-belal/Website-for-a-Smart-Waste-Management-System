# Website for a Smart Waste Management System

A part of an IoT-based smart waste management system that monitors bin status in real time and helps streamline waste collection and issue reporting.

## Objective

Waste collection is often inefficient — bins get collected when only partially full, or overflow before being noticed. This project builds a system to monitor bin status via sensors, let the public and field workers report issues, and give an admin a central dashboard to manage it all.

## Features

- **Real-Time Bin Monitoring** — Sensors (ultrasonic distance, tilt, smoke) report bin fill level, orientation, and air quality to a live dashboard.
- **Admin Dashboard** — View live sensor readings, reports, and tasks in one place.
- **Public Issue Reporting** — A QR code on each bin links to a public web form for reporting problems (e.g. a damaged or overflowing bin).
- **Worker Reports** — Field workers submit reports through a companion mobile app.
- **Task Management** — Admin creates tasks for workers; unassigned tasks are tracked until a worker picks them up via the mobile app.
- **Authentication** — Firebase Authentication for admin login.

## Tech Stack

- **Backend:** Java, Spring Boot
- **Databases:**
  - Cloud Firestore — reports, tasks, admin data
  - Firebase Realtime Database — live sensor readings
- **Frontend:** HTML, CSS, JavaScript
- **Hosting:** Firebase Hosting
- **Auth:** Firebase Authentication



## Project Structure

```
SmartWaste/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── SmartWaste/
│       │           ├── controller/
│       │           ├── service/
│       │           ├── repository/
│       │           └── *.java          (model classes: Reports, Tasks, SensorData)
│       │
│       └── resources/
│           └── firebase/          (excluded — see .gitignore)
│
├── public/
│   ├── Auth.html
│   ├── Homepage.html
│   ├── data.html
│   ├── index.html
│   ├── reportsSection.html
│   └── tasks.html
│
├── .gitignore
└── README.md
```

## Setup

This project connects to a specific Firebase project (Firestore + Realtime Database) and requires your own Firebase setup to run:

1. Clone the repo.
2. Create a Firebase project with Firestore and Realtime Database enabled.
3. Update the Firebase web config in the HTML files to match your own project.
4. Serve the `public/` folder via Firebase Hosting, or open the HTML files directly for local testing.
