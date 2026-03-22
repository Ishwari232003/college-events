# 🎓  College Event Management System
## 📌 Problem Statement

In college, students miss many events like seminars, hackathons,
cultural fests, and sports meets because:

- Event info is scattered across multiple WhatsApp groups
- Notice boards are not always visible to everyone
- There is no centralized platform to track all events
- Registration links are hard to find

This project provides a single platform where all events are
listed with dates, venue, description, and direct registration
links — so no student misses an opportunity.

A full-stack web application to manage and display college events.

## 🛠️ Tech Stack
| Layer | Technology |
|---|---|
| Frontend | HTML, CSS, JavaScript |
| Backend | Java, Spring Boot |
| Database | MySQL |
| ORM | Spring Data JPA |
| Security | Spring Security |

## ✨ Features
- Browse all events by category
- Filter by Academic, Technical, Cultural, Sports, Social, Awareness
- Full event detail page with registration link
- Auto-hides past events
- Secure admin panel
- Add / Delete events from admin

## 🚀 How to Run
1. Import `sgbit_events.sql` into MySQL
2. Add your DB credentials in `application.properties`
3. Run: `mvn spring-boot:run`
4. Open: `http://localhost:8080`

## 🔐 Admin Panel
URL: `http://localhost:8080/admin.html`