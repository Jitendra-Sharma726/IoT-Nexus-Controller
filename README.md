# IoT-Nexus-Controller

IoT Nexus Controller Project
Hey Innovators! Welcome to the IoT Nexus Controller Project! 🏠🔌

In this project, you will build the Spring Boot Backend for a next-generation Smart Home Hub. This system acts as the central "brain" that organizes and controls smart devices across different locations in a house.

Connectivity is everything! A modern smart home needs to know which devices (like Smart Bulbs, Thermostats, or Cameras) belong to which specific room (like the Living Room or Kitchen). Your system will use Spring Data JPA Relationships to link these items together automatically.

Your task is to complete the missing backend logic to make this API fully functional.

Project Structure
You are given 6 Java files representing a Layered Architecture:

Entities (The Data Model):
Room.java → The Parent entity. Represents a physical location (e.g., "Kitchen").
Device.java → The Child entity. Represents a gadget (e.g., "Smart Bulb") that belongs to a Room.
Repositories (The Data Access Layer):
RoomRepository.java & DeviceRepository.java → Interfaces that handle saving and retrieving data for their respective entities.
Service (The Business Logic):
IoTService.java → Contains the logic to link devices to rooms and handle cascading deletions.
Controller (The API Layer):
IoTController.java → Handles web requests to create rooms, add devices, and manage the system.
Project Dependencies
To build this backend, your project is pre-configured with the following tools:

Spring Web: For building RESTful API endpoints and handling HTTP requests.
Spring Data JPA: For interacting with the database using Java objects instead of SQL.
H2 Database: An in-memory database that stores your data while the app is running.
Lombok: A library that automatically generates boilerplate code like Getters, Setters, and Constructors.
Important Rules

Do NOT change class names
Do NOT change method names
Complete the sections marked with TODO
The testing system relies on the existing structure
The Logic: ORM Relationships
This project focuses on Object-Relational Mapping (ORM). We are not just storing simple lists; we are storing Relationships.

One-to-Many: One Room can have Many Devices.
Many-to-One: Many Devices belong to One Room.
Cascading: If you delete a Room, the system should automatically delete all Devices inside it (because a wall switch cannot exist without a wall!).
Database Access (H2 Console)
If you want to visually check your tables and run SQL queries manually:

Run the file named consoleViewer.js and paste the CodeChef browser URL. For more details, refer to the project demonstration video.
Command to run the file:
node consoleViewer.js
Copy the URL printed in the output.
Paste it into your browser to access the H2 Console.
Write this JDBC URL "jdbc:h2:mem:iotdb" and click Connect to see your live data tables (for more details, check application.properties file).
Your Task:

Complete the Entities
File: entity/Room.java (The Parent)
Annotations: Mark this class so that JPA recognizes it as a database table.
Primary Key: Configure the id field to be the Primary Key and set it to Auto-Increment using the IDENTITY strategy.
Relationship: Define a list of devices using One To Many Mapping.
Challenge 1: Configure this relationship so that Hibernate knows the Device class is the "owner" of the link (Hint: Explore the mappedby attribute).
Challenge 2: Configure the cascading behaviour so that if a Room is Deleted or Saved, that action automatically applies to all its Devices as well.
Getters & Setters: Generate these for all fields (manually or using Lombok annotations) so other classes can access the data.
File: entity/Device.java (The Child)
Annotations: Mark this class so that JPA recognizes it as a database table.
Primary Key: Configure the id field as the Primary Key with Auto-Increment.
The Relationship (Link to Room):
Define a relationship where many Devices can belong to one Room.
Foreign Key Challenge: Configure the joining column name in the database table to be "room_id".
JSON Challenge: Add a specific annotation to this field to prevent an "Infinite Recursion" loop (Room → Device → Room...) when the data is converted to JSON.
Getters & Setters: Generate these for all fields.
Docs: Guide to JPA Entities | Lombok @Getter & @Setter | @Id and @GeneratedValue | Guide to @OneToMany and @ManyToOne | Understanding the mappedBy Attribute | JPA Cascade Types | Using @JoinColumn for Foreign Keys | Handling Infinite Recursion with @JsonIgnore
Configure the Repositories
File: repository/RoomRepository.java & repository/DeviceRepository.java These interfaces are your direct line to the database.
Interface: Define these as Interfaces (not classes).
Inheritance: Extend the standard JpaRepository interface.
Generics: You must specify two things for each repository:
The Entity Type it manages (Room or Device).
The Data Type of that Entity's Primary Key.
Docs: @Repository Annotation | Introduction to Spring Data JPA Repositories | JpaRepository Interface | Java Generics (The <T, ID> syntax)
Build the Service
File: service/IoTService.java
Annotation: Add the correct Spring annotation to mark this class as a Service.
Dependency Injection: Define the repositories as private final fields and initialize them using a Constructor.
Logic - Add Device:
Try to find the Room using its ID.
If the Room exists, LINK the device to the room (set the relationship).
Save the device to the database.
If the Room does not exist, throw an exception (code provided).
Logic - Delete Room:
Delete the Room by its ID. Because of the Cascading you configured in step 1, this should automatically remove all associated devices.
Logic - Delete Device:
Check if the device exists, then delete it.
Docs: @Service Annotation | Constructor Dependency Injection | Spring Data CrudRepository Methods (save, findById)
Define the API Endpoints
File: controller/IoTController.java
Class Configuration: Annotate the class to make it a REST Controller and define the base URL path as "/api".
Dependency Injection: Inject the IoTService using the constructor.
Map the Endpoints:
Create a Room (/rooms)
Goal: Save a new room to the database.
Action: Map this method to handle POST requests.
Input: The room data is coming as JSON. Use the correct annotation to convert that JSON body into a Room Java object.
Get All Rooms (/rooms)
Goal: Retrieve the list of all rooms (and their devices).
Action: Map this method to handle GET requests.
Output: Return a List<Room>.
Add Device (/rooms/{roomId}/devices)
Goal: Add a new device to a specific room.
Action: Map this method to handle POST requests.
Inputs: You need to capture two pieces of data from different places:
Extract Room ID from the URL Path (the {roomId} part).
Extract Device Data from the Request Body (the JSON sent by the user).
Delete Room (/rooms/{id})
Goal: Remove a room (and automatically remove its devices).
Action: Map this method to handle DELETE requests.
Input: Extract the id from the URL Path so the service knows which room to delete.
Delete Device (/devices/{id})
Goal: Remove a single device.
Action: Map this method to handle DELETE requests.
Input: Extract the id from the URL Path.
Docs: @RestController Annotation | Building a RESTful Web Service | Overview of @GetMapping, @PostMapping, @DeleteMapping | Spring @PathVariable | @RequestBody Annotation
Expected Behaviour:
Before submitting the project, ensure the backend server is running. If you make any changes to the code, you must restart the server for those changes to take effect.


