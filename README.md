# Yunnan Enterprise Employment/Unemployment Data Collection System

## Overview
This is a Yunnan enterprise employment/unemployment data collection system designed to facilitate effective data management and reporting for employment and unemployment activities in Yunnan Province.

## Features
1. **User Authentication and Authorization**: Manage access for different user roles (admin, enterprise, etc.).
2. **Enterprise Filing**: Enterprises can file their employment data.
3. **Data Reporting**: Generate reports on employment/unemployment statistics.
4. **Notices**: Announcement section for updates and notices.
5. **Dictionaries**: Manage reason codes and district codes for structured data input.

## Technologies Used
- **Backend**: Node.js with Express framework
- **Database**: MongoDB for document storage
- **Frontend**: React.js for the user interface (if applicable)

## Database Schema
```javascript
const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
    username: { type: String, required: true, unique: true },
    password: { type: String, required: true },
    role: { type: String, enum: ['admin', 'enterprise'], default: 'enterprise' }
});

const enterpriseSchema = new mongoose.Schema({
    name: { type: String, required: true },
    employmentData: [
        { type: mongoose.Schema.Types.ObjectId, ref: 'Employment' }
    ]
});

const employmentSchema = new mongoose.Schema({
    date: { type: Date, required: true },
    unemployed: { type: Number, required: true },
    employed: { type: Number, required: true },
    reasonCode: { type: String, required: true },
    districtCode: { type: String, required: true }
});

const noticeSchema = new mongoose.Schema({
    title: { type: String, required: true },
    content: { type: String, required: true },
    date: { type: Date, default: Date.now }
});

const User = mongoose.model('User', userSchema);
const Enterprise = mongoose.model('Enterprise', enterpriseSchema);
const Employment = mongoose.model('Employment', employmentSchema);
const Notice = mongoose.model('Notice', noticeSchema);
```

## Core Entities
- **User**: Handles user data and access rights.
- **Enterprise**: Represents the enterprise submitting employment/unemployment data.
- **Employment**: Contains employment statistics with reasons and district references.
- **Notice**: Manages public communications.  

## Authentication/Authorization
Use JWT (JSON Web Tokens) for secure user authentication. Middleware will check user permissions before accessing certain API routes.

## API Layer
```javascript
const express = require('express');
const mongoose = require('mongoose');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcrypt');

const app = express();
app.use(express.json());

// Connect to database
mongoose.connect('mongodb://localhost/yunnan_system', { useNewUrlParser: true, useUnifiedTopology: true });

// Define your routes here
app.post('/register', async (req, res) => {
    // Registration logic
});

app.post('/login', async (req, res) => {
    // Login logic
});

app.get('/data', authMiddleware, async (req, res) => {
    // Fetch data logic
});

app.listen(3000, () => {
    console.log('Server running on port 3000');
});
```

## Frontend
If a frontend is required, React can be used with Axios for API calls. The main components would include a login form, data submission forms, and reporting dashboards.

## How to Run
1. Clone the repository.
2. Install dependencies with `npm install`.
3. Start the server with `node app.js`.
4. Access the application on `http://localhost:3000`.

## Conclusion
This initial implementation provides a foundational framework for the Yunnan enterprise employment/unemployment data collection system. Future enhancements can include more detailed reporting features, advanced user management, and a more sophisticated frontend.  
