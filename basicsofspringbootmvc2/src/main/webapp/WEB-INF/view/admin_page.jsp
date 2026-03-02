<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800;900&display=swap"
            rel="stylesheet">
        <style>
            /* ===== RESET & BASE ===== */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: 'Inter', sans-serif;
                min-height: 100vh;
                overflow-x: hidden;
                background: #0a0a1a;
                color: #e0e0e0;
            }

            /* ===== ANIMATED GRADIENT BACKGROUND ===== */
            .bg-animated {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                z-index: -2;
                background: linear-gradient(135deg, #0a0a1a 0%, #1a0a2e 25%, #0a1628 50%, #16082a 75%, #0a0a1a 100%);
                background-size: 400% 400%;
                animation: gradientShift 15s ease infinite;
            }

            @keyframes gradientShift {
                0% {
                    background-position: 0% 50%;
                }

                50% {
                    background-position: 100% 50%;
                }

                100% {
                    background-position: 0% 50%;
                }
            }

            /* ===== FLOATING ORB LIGHTS ===== */
            .orb {
                position: fixed;
                border-radius: 50%;
                filter: blur(80px);
                z-index: -1;
                animation: orbFloat 8s ease-in-out infinite;
            }

            .orb-1 {
                width: 400px;
                height: 400px;
                background: radial-gradient(circle, rgba(99, 102, 241, 0.3), transparent);
                top: -100px;
                left: -100px;
                animation-duration: 10s;
            }

            .orb-2 {
                width: 350px;
                height: 350px;
                background: radial-gradient(circle, rgba(236, 72, 153, 0.25), transparent);
                bottom: -80px;
                right: -80px;
                animation-duration: 12s;
                animation-delay: -3s;
            }

            .orb-3 {
                width: 300px;
                height: 300px;
                background: radial-gradient(circle, rgba(16, 185, 129, 0.2), transparent);
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                animation-duration: 14s;
                animation-delay: -6s;
            }

            @keyframes orbFloat {

                0%,
                100% {
                    transform: translate(0, 0) scale(1);
                }

                25% {
                    transform: translate(30px, -40px) scale(1.1);
                }

                50% {
                    transform: translate(-20px, 20px) scale(0.95);
                }

                75% {
                    transform: translate(40px, 30px) scale(1.05);
                }
            }

            /* ===== FLOATING PARTICLES ===== */
            .particles {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                z-index: -1;
                overflow: hidden;
            }

            .particle {
                position: absolute;
                width: 3px;
                height: 3px;
                background: rgba(255, 255, 255, 0.15);
                border-radius: 50%;
                animation: particleRise linear infinite;
            }

            .particle:nth-child(1) {
                left: 10%;
                animation-duration: 12s;
                animation-delay: 0s;
                width: 2px;
                height: 2px;
            }

            .particle:nth-child(2) {
                left: 20%;
                animation-duration: 15s;
                animation-delay: -2s;
                width: 4px;
                height: 4px;
            }

            .particle:nth-child(3) {
                left: 35%;
                animation-duration: 10s;
                animation-delay: -5s;
            }

            .particle:nth-child(4) {
                left: 50%;
                animation-duration: 18s;
                animation-delay: -3s;
                width: 2px;
                height: 2px;
            }

            .particle:nth-child(5) {
                left: 65%;
                animation-duration: 13s;
                animation-delay: -7s;
                width: 4px;
                height: 4px;
            }

            .particle:nth-child(6) {
                left: 75%;
                animation-duration: 16s;
                animation-delay: -1s;
            }

            .particle:nth-child(7) {
                left: 85%;
                animation-duration: 11s;
                animation-delay: -4s;
                width: 2px;
                height: 2px;
            }

            .particle:nth-child(8) {
                left: 92%;
                animation-duration: 14s;
                animation-delay: -6s;
                width: 5px;
                height: 5px;
            }

            @keyframes particleRise {
                0% {
                    transform: translateY(100vh) rotate(0deg);
                    opacity: 0;
                }

                10% {
                    opacity: 1;
                }

                90% {
                    opacity: 1;
                }

                100% {
                    transform: translateY(-10vh) rotate(720deg);
                    opacity: 0;
                }
            }

            /* ===== MAIN CONTAINER ===== */
            .container {
                max-width: 1100px;
                margin: 0 auto;
                padding: 40px 24px;
                perspective: 1200px;
            }

            /* ===== HEADER WITH 3D FLIP ===== */
            .header {
                text-align: center;
                margin-bottom: 50px;
                animation: headerDrop 1s cubic-bezier(0.34, 1.56, 0.64, 1) forwards;
                opacity: 0;
                transform: translateY(-60px) rotateX(15deg);
            }

            @keyframes headerDrop {
                to {
                    opacity: 1;
                    transform: translateY(0) rotateX(0deg);
                }
            }

            .header .badge {
                display: inline-block;
                padding: 6px 18px;
                border-radius: 50px;
                background: linear-gradient(135deg, rgba(99, 102, 241, 0.2), rgba(236, 72, 153, 0.2));
                border: 1px solid rgba(99, 102, 241, 0.3);
                font-size: 0.75rem;
                font-weight: 600;
                letter-spacing: 2px;
                text-transform: uppercase;
                color: #a5b4fc;
                margin-bottom: 16px;
                animation: badgePulse 3s ease-in-out infinite;
            }

            @keyframes badgePulse {

                0%,
                100% {
                    box-shadow: 0 0 15px rgba(99, 102, 241, 0.15);
                }

                50% {
                    box-shadow: 0 0 30px rgba(99, 102, 241, 0.35);
                }
            }

            .header h1 {
                font-size: 3rem;
                font-weight: 900;
                background: linear-gradient(135deg, #ffffff 0%, #a5b4fc 40%, #ec4899 70%, #10b981 100%);
                background-size: 200% auto;
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                background-clip: text;
                animation: textShimmer 4s ease-in-out infinite;
                letter-spacing: -1px;
            }

            @keyframes textShimmer {

                0%,
                100% {
                    background-position: 0% center;
                }

                50% {
                    background-position: 200% center;
                }
            }

            .header p {
                color: #8892b0;
                font-size: 1rem;
                margin-top: 8px;
                font-weight: 300;
            }

            /* ===== STATS ROW ===== */
            .stats-row {
                display: flex;
                gap: 20px;
                margin-bottom: 40px;
                justify-content: center;
                flex-wrap: wrap;
            }

            .stat-card {
                flex: 1;
                min-width: 200px;
                max-width: 260px;
                padding: 24px;
                border-radius: 20px;
                background: rgba(255, 255, 255, 0.04);
                border: 1px solid rgba(255, 255, 255, 0.08);
                backdrop-filter: blur(20px);
                text-align: center;
                position: relative;
                overflow: hidden;
                animation: statSlideUp 0.8s cubic-bezier(0.34, 1.56, 0.64, 1) forwards;
                opacity: 0;
                transform: translateY(40px) rotateX(10deg);
                transition: transform 0.4s ease, box-shadow 0.4s ease;
            }

            .stat-card:nth-child(1) {
                animation-delay: 0.2s;
            }

            .stat-card:nth-child(2) {
                animation-delay: 0.4s;
            }

            .stat-card:nth-child(3) {
                animation-delay: 0.6s;
            }

            .stat-card:hover {
                transform: translateY(-8px) rotateX(0deg) scale(1.03);
                box-shadow: 0 20px 60px rgba(99, 102, 241, 0.15);
                border-color: rgba(99, 102, 241, 0.3);
            }

            .stat-card::before {
                content: '';
                position: absolute;
                top: 0;
                left: -100%;
                width: 100%;
                height: 100%;
                background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.05), transparent);
                transition: left 0.6s ease;
            }

            .stat-card:hover::before {
                left: 100%;
            }

            @keyframes statSlideUp {
                to {
                    opacity: 1;
                    transform: translateY(0) rotateX(0deg);
                }
            }

            .stat-icon {
                font-size: 2rem;
                margin-bottom: 8px;
            }

            .stat-value {
                font-size: 2rem;
                font-weight: 800;
                background: linear-gradient(135deg, #fff, #a5b4fc);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                background-clip: text;
            }

            .stat-label {
                font-size: 0.8rem;
                color: #8892b0;
                text-transform: uppercase;
                letter-spacing: 1.5px;
                margin-top: 4px;
                font-weight: 500;
            }

            /* ===== TABLE GLASS CARD ===== */
            .table-card {
                border-radius: 24px;
                background: rgba(255, 255, 255, 0.03);
                border: 1px solid rgba(255, 255, 255, 0.07);
                backdrop-filter: blur(30px);
                overflow: hidden;
                animation: tableFlipIn 1s cubic-bezier(0.34, 1.56, 0.64, 1) 0.5s forwards;
                opacity: 0;
                transform: perspective(800px) rotateY(-8deg) translateX(-30px);
                box-shadow: 0 25px 80px rgba(0, 0, 0, 0.3);
                position: relative;
            }

            .table-card::before {
                content: '';
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                height: 1px;
                background: linear-gradient(90deg, transparent, rgba(99, 102, 241, 0.5), rgba(236, 72, 153, 0.5), transparent);
            }

            @keyframes tableFlipIn {
                to {
                    opacity: 1;
                    transform: perspective(800px) rotateY(0deg) translateX(0);
                }
            }

            .table-header {
                padding: 24px 32px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                border-bottom: 1px solid rgba(255, 255, 255, 0.06);
            }

            .table-header h2 {
                font-size: 1.3rem;
                font-weight: 700;
                color: #fff;
            }

            .table-header .live-dot {
                display: flex;
                align-items: center;
                gap: 8px;
                font-size: 0.8rem;
                color: #10b981;
                font-weight: 500;
            }

            .live-dot::before {
                content: '';
                width: 8px;
                height: 8px;
                background: #10b981;
                border-radius: 50%;
                animation: livePulse 2s ease-in-out infinite;
            }

            @keyframes livePulse {

                0%,
                100% {
                    box-shadow: 0 0 0 0 rgba(16, 185, 129, 0.4);
                }

                50% {
                    box-shadow: 0 0 0 8px rgba(16, 185, 129, 0);
                }
            }

            /* ===== TABLE ===== */
            table {
                width: 100%;
                border-collapse: collapse;
            }

            thead th {
                padding: 16px 24px;
                text-align: left;
                font-size: 0.7rem;
                font-weight: 700;
                text-transform: uppercase;
                letter-spacing: 2px;
                color: #8892b0;
                background: rgba(255, 255, 255, 0.02);
                border-bottom: 1px solid rgba(255, 255, 255, 0.06);
                position: relative;
            }

            tbody tr {
                border-bottom: 1px solid rgba(255, 255, 255, 0.04);
                transition: all 0.3s ease;
                animation: rowSlideIn 0.6s ease forwards;
                opacity: 0;
                transform: translateX(-20px);
            }

            tbody tr:nth-child(1) {
                animation-delay: 0.8s;
            }

            tbody tr:nth-child(2) {
                animation-delay: 0.9s;
            }

            tbody tr:nth-child(3) {
                animation-delay: 1.0s;
            }

            tbody tr:nth-child(4) {
                animation-delay: 1.1s;
            }

            tbody tr:nth-child(5) {
                animation-delay: 1.2s;
            }

            tbody tr:nth-child(6) {
                animation-delay: 1.3s;
            }

            tbody tr:nth-child(7) {
                animation-delay: 1.4s;
            }

            tbody tr:nth-child(8) {
                animation-delay: 1.5s;
            }

            tbody tr:nth-child(9) {
                animation-delay: 1.6s;
            }

            tbody tr:nth-child(10) {
                animation-delay: 1.7s;
            }

            @keyframes rowSlideIn {
                to {
                    opacity: 1;
                    transform: translateX(0);
                }
            }

            tbody tr:hover {
                background: rgba(99, 102, 241, 0.08);
                transform: scale(1.01) translateX(4px);
                box-shadow: inset 3px 0 0 #6366f1;
            }

            tbody td {
                padding: 18px 24px;
                font-size: 0.9rem;
                color: #c8d0e0;
                font-weight: 400;
                transition: color 0.3s ease;
            }

            tbody tr:hover td {
                color: #fff;
            }

            /* Name column - avatar style */
            td:first-child {
                font-weight: 600;
                color: #fff;
                display: flex;
                align-items: center;
                gap: 12px;
            }

            td:first-child::before {
                content: '';
                width: 36px;
                height: 36px;
                border-radius: 12px;
                background: linear-gradient(135deg, #6366f1, #ec4899);
                display: inline-flex;
                align-items: center;
                justify-content: center;
                flex-shrink: 0;
                animation: avatarSpin 6s linear infinite;
            }

            @keyframes avatarSpin {
                0% {
                    border-radius: 12px;
                }

                25% {
                    border-radius: 50% 12px 50% 12px;
                }

                50% {
                    border-radius: 50%;
                }

                75% {
                    border-radius: 12px 50% 12px 50%;
                }

                100% {
                    border-radius: 12px;
                }
            }

            /* Role badge styling */
            .role-badge {
                display: inline-block;
                padding: 4px 14px;
                border-radius: 50px;
                font-size: 0.75rem;
                font-weight: 600;
                letter-spacing: 0.5px;
            }

            .role-admin {
                background: linear-gradient(135deg, rgba(236, 72, 153, 0.15), rgba(236, 72, 153, 0.05));
                color: #f472b6;
                border: 1px solid rgba(236, 72, 153, 0.3);
            }

            .role-user {
                background: linear-gradient(135deg, rgba(16, 185, 129, 0.15), rgba(16, 185, 129, 0.05));
                color: #34d399;
                border: 1px solid rgba(16, 185, 129, 0.3);
            }

            /* ===== DELETE BUTTON ===== */
            .btn-delete {
                display: inline-flex;
                align-items: center;
                gap: 6px;
                padding: 6px 16px;
                border-radius: 10px;
                background: rgba(239, 68, 68, 0.1);
                border: 1px solid rgba(239, 68, 68, 0.25);
                color: #fca5a5;
                font-size: 0.78rem;
                font-weight: 600;
                font-family: 'Inter', sans-serif;
                cursor: pointer;
                text-decoration: none;
                transition: all 0.3s ease;
            }

            .btn-delete:hover {
                background: rgba(239, 68, 68, 0.2);
                border-color: rgba(239, 68, 68, 0.5);
                color: #ef4444;
                transform: translateY(-2px);
                box-shadow: 0 6px 20px rgba(239, 68, 68, 0.15);
            }

            .btn-delete svg {
                width: 14px;
                height: 14px;
            }

            .btn-edit {
                display: inline-flex;
                align-items: center;
                gap: 6px;
                padding: 6px 16px;
                border-radius: 10px;
                background: rgba(251, 191, 36, 0.1);
                border: 1px solid rgba(251, 191, 36, 0.25);
                color: #fcd34d;
                font-size: 0.78rem;
                font-weight: 600;
                font-family: 'Inter', sans-serif;
                cursor: pointer;
                text-decoration: none;
                transition: all 0.3s ease;
            }

            .btn-edit:hover {
                background: rgba(251, 191, 36, 0.2);
                border-color: rgba(251, 191, 36, 0.5);
                color: #f59e0b;
                transform: translateY(-2px);
                box-shadow: 0 6px 20px rgba(251, 191, 36, 0.15);
            }

            .btn-edit svg {
                width: 14px;
                height: 14px;
            }

            .action-btns {
                display: flex;
                gap: 8px;
                align-items: center;
            }

            .icon-inline {
                width: 16px;
                height: 16px;
                vertical-align: middle;
                margin-right: 4px;
            }

            /* ===== FOOTER ===== */
            .footer {
                text-align: center;
                padding: 40px 0 20px;
                color: #4a5568;
                font-size: 0.8rem;
                animation: fadeIn 1s ease 1.5s forwards;
                opacity: 0;
            }

            @keyframes fadeIn {
                to {
                    opacity: 1;
                }
            }

            /* ===== 3D TILT ON MOUSE (via JS) ===== */
            .tilt-3d {
                transition: transform 0.1s ease;
            }

            /* ===== SCROLLBAR ===== */
            ::-webkit-scrollbar {
                width: 6px;
            }

            ::-webkit-scrollbar-track {
                background: transparent;
            }

            ::-webkit-scrollbar-thumb {
                background: rgba(99, 102, 241, 0.3);
                border-radius: 3px;
            }

            ::-webkit-scrollbar-thumb:hover {
                background: rgba(99, 102, 241, 0.5);
            }

            /* ===== NAV LINKS ===== */
            .nav-links {
                display: flex;
                gap: 12px;
                justify-content: center;
                margin-bottom: 30px;
                animation: fadeIn 0.8s ease 0.3s forwards;
                opacity: 0;
            }

            .nav-links a {
                padding: 10px 24px;
                border-radius: 12px;
                background: rgba(255, 255, 255, 0.05);
                border: 1px solid rgba(255, 255, 255, 0.1);
                color: #a5b4fc;
                text-decoration: none;
                font-weight: 500;
                font-size: 0.85rem;
                transition: all 0.3s ease;
                position: relative;
                overflow: hidden;
            }

            .nav-links a:hover {
                background: rgba(99, 102, 241, 0.15);
                border-color: rgba(99, 102, 241, 0.4);
                transform: translateY(-2px);
                box-shadow: 0 8px 30px rgba(99, 102, 241, 0.2);
                color: #fff;
            }

            .nav-links a::after {
                content: '';
                position: absolute;
                bottom: 0;
                left: 0;
                right: 0;
                height: 2px;
                background: linear-gradient(90deg, #6366f1, #ec4899);
                transform: scaleX(0);
                transition: transform 0.3s ease;
            }

            .nav-links a:hover::after {
                transform: scaleX(1);
            }
        </style>
    </head>

    <body>
        <!-- Background Effects -->
        <div class="bg-animated"></div>
        <div class="orb orb-1"></div>
        <div class="orb orb-2"></div>
        <div class="orb orb-3"></div>
        <div class="particles">
            <div class="particle"></div>
            <div class="particle"></div>
            <div class="particle"></div>
            <div class="particle"></div>
            <div class="particle"></div>
            <div class="particle"></div>
            <div class="particle"></div>
            <div class="particle"></div>
        </div>

        <div class="container">
            <!-- Header -->
            <div class="header">
                <div class="badge"><svg class="icon-inline" viewBox="0 0 24 24">
                        <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5" />
                    </svg> Admin Portal</div>
                <h1>Employee Dashboard</h1>
                <p>Manage your team with style</p>
            </div>

            <!-- Navigation -->
            <div class="nav-links">
                <a href="/register"><svg class="icon-inline" viewBox="0 0 24 24">
                        <path d="M12 5v14M5 12h14" stroke="currentColor" stroke-width="2" fill="none"
                            stroke-linecap="round" />
                    </svg> Add Employee</a>
                <a href="/login"><svg class="icon-inline" viewBox="0 0 24 24">
                        <path d="M9 21H5a2 2 0 01-2-2V5a2 2 0 012-2h4M16 17l5-5-5-5M21 12H9" stroke="currentColor"
                            stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" />
                    </svg> Logout</a>
            </div>

            <!-- Stats Row -->
            <div class="stats-row">
                <div class="stat-card">
                    <div class="stat-icon"><svg width="28" height="28" viewBox="0 0 24 24" fill="none" stroke="#a5b4fc"
                            stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">
                            <path d="M17 21v-2a4 4 0 00-4-4H5a4 4 0 00-4 4v2" />
                            <circle cx="9" cy="7" r="4" />
                            <path d="M23 21v-2a4 4 0 00-3-3.87M16 3.13a4 4 0 010 7.75" />
                        </svg></div>
                    <div class="stat-value" id="emp-count">0</div>
                    <div class="stat-label">Total Employees</div>
                </div>
                <div class="stat-card">
                    <div class="stat-icon"><svg width="28" height="28" viewBox="0 0 24 24" fill="none" stroke="#f472b6"
                            stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">
                            <path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10z" />
                        </svg></div>
                    <div class="stat-value" id="admin-count">0</div>
                    <div class="stat-label">Admins</div>
                </div>
                <div class="stat-card">
                    <div class="stat-icon"><svg width="28" height="28" viewBox="0 0 24 24" fill="none" stroke="#34d399"
                            stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">
                            <path d="M20 21v-2a4 4 0 00-4-4H8a4 4 0 00-4 4v2" />
                            <circle cx="12" cy="7" r="4" />
                        </svg></div>
                    <div class="stat-value" id="user-count">0</div>
                    <div class="stat-label">Users</div>
                </div>
            </div>

            <!-- Table Card -->
            <div class="table-card tilt-3d">
                <div class="table-header">
                    <h2><svg class="icon-inline" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                            stroke-linecap="round" stroke-linejoin="round">
                            <path d="M14 2H6a2 2 0 00-2 2v16a2 2 0 002 2h12a2 2 0 002-2V8z" />
                            <polyline points="14 2 14 8 20 8" />
                            <line x1="16" y1="13" x2="8" y2="13" />
                            <line x1="16" y1="17" x2="8" y2="17" />
                            <polyline points="10 9 9 9 8 9" />
                        </svg> Employee List</h2>
                    <span class="live-dot">Live Data</span>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Salary</th>
                            <th>Role</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list_of_employees}" var="emp">
                            <tr>
                                <td>${emp.name}</td>
                                <td>${emp.email}</td>
                                <td>${emp.salary}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${emp.role == 'Admin'}">
                                            <span class="role-badge role-admin">${emp.role}</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="role-badge role-user">${emp.role}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <div class="action-btns">
                                        <a href="/update?email=${emp.email}" class="btn-edit">
                                            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                                stroke-linecap="round" stroke-linejoin="round">
                                                <path d="M11 4H4a2 2 0 00-2 2v14a2 2 0 002 2h14a2 2 0 002-2v-7" />
                                                <path d="M18.5 2.5a2.121 2.121 0 013 3L12 15l-4 1 1-4 9.5-9.5z" />
                                            </svg>
                                            Edit
                                        </a>
                                        <a href="/delete-emp?email=${emp.email}" class="btn-delete"
                                            onclick="return confirm('Delete ${emp.name}?');">
                                            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                                stroke-linecap="round" stroke-linejoin="round">
                                                <path
                                                    d="M3 6h18M19 6v14a2 2 0 01-2 2H7a2 2 0 01-2-2V6m3 0V4a2 2 0 012-2h4a2 2 0 012 2v2M10 11v6M14 11v6" />
                                            </svg>
                                            Delete
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="footer">
                &copy; 2026 Admin Dashboard &bull; Built with Spring Boot
            </div>
        </div>

        <!-- 3D Tilt Effect + Counter Animation -->
        <script>
            // 3D Mouse Tilt on table card
            const card = document.querySelector('.tilt-3d');
            card.addEventListener('mousemove', (e) => {
                const rect = card.getBoundingClientRect();
                const x = e.clientX - rect.left;
                const y = e.clientY - rect.top;
                const centerX = rect.width / 2;
                const centerY = rect.height / 2;
                const rotateX = (y - centerY) / 30;
                const rotateY = (centerX - x) / 30;
                card.style.transform = 'perspective(800px) rotateX(' + rotateX + 'deg) rotateY(' + rotateY + 'deg)';
            });
            card.addEventListener('mouseleave', () => {
                card.style.transform = 'perspective(800px) rotateX(0deg) rotateY(0deg)';
            });

            // Animated counter
            function animateCount(el, target) {
                let current = 0;
                const step = Math.max(1, Math.floor(target / 30));
                const timer = setInterval(() => {
                    current += step;
                    if (current >= target) {
                        current = target;
                        clearInterval(timer);
                    }
                    el.textContent = current;
                }, 40);
            }

            // Count employees by role from table rows
            window.addEventListener('DOMContentLoaded', () => {
                const rows = document.querySelectorAll('tbody tr');
                let admins = 0, users = 0;
                rows.forEach(row => {
                    const badge = row.querySelector('.role-badge');
                    if (badge && badge.classList.contains('role-admin')) admins++;
                    else users++;
                });
                setTimeout(() => {
                    animateCount(document.getElementById('emp-count'), rows.length);
                    animateCount(document.getElementById('admin-count'), admins);
                    animateCount(document.getElementById('user-count'), users);
                }, 800);
            });
        </script>
    </body>

    </html>