<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Employee</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Inter', sans-serif;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #0a0a1a;
            color: #e0e0e0;
            overflow: hidden;
        }

        .bg {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -2;
            background: linear-gradient(135deg, #0a0a1a, #1a0f0a, #1a0a2e, #0a0a1a);
            background-size: 400% 400%;
            animation: bg 15s ease infinite;
        }

        @keyframes bg {
            0% {
                background-position: 0% 50%
            }

            50% {
                background-position: 100% 50%
            }

            100% {
                background-position: 0% 50%
            }
        }

        .orb {
            position: fixed;
            border-radius: 50%;
            filter: blur(80px);
            z-index: -1;
            animation: of 10s ease-in-out infinite;
        }

        .o1 {
            width: 400px;
            height: 400px;
            background: radial-gradient(circle, rgba(251, 191, 36, 0.25), transparent);
            top: -100px;
            right: -100px;
        }

        .o2 {
            width: 350px;
            height: 350px;
            background: radial-gradient(circle, rgba(99, 102, 241, 0.2), transparent);
            bottom: -80px;
            left: -80px;
            animation-delay: -3s;
        }

        @keyframes of {

            0%,
            100% {
                transform: translate(0, 0) scale(1)
            }

            25% {
                transform: translate(30px, -40px) scale(1.1)
            }

            50% {
                transform: translate(-20px, 20px) scale(0.95)
            }

            75% {
                transform: translate(40px, 30px) scale(1.05)
            }
        }

        .particles {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1;
            overflow: hidden;
        }

        .p {
            position: absolute;
            width: 3px;
            height: 3px;
            background: rgba(255, 255, 255, 0.12);
            border-radius: 50%;
            animation: pr linear infinite;
        }

        .p:nth-child(1) {
            left: 12%;
            animation-duration: 12s
        }

        .p:nth-child(2) {
            left: 28%;
            animation-duration: 15s;
            animation-delay: -2s;
            width: 4px;
            height: 4px
        }

        .p:nth-child(3) {
            left: 48%;
            animation-duration: 10s;
            animation-delay: -5s
        }

        .p:nth-child(4) {
            left: 68%;
            animation-duration: 18s;
            animation-delay: -3s;
            width: 2px;
            height: 2px
        }

        .p:nth-child(5) {
            left: 88%;
            animation-duration: 13s;
            animation-delay: -7s
        }

        @keyframes pr {
            0% {
                transform: translateY(100vh);
                opacity: 0
            }

            10% {
                opacity: 1
            }

            90% {
                opacity: 1
            }

            100% {
                transform: translateY(-10vh);
                opacity: 0
            }
        }

        .card {
            width: 440px;
            padding: 44px 40px;
            border-radius: 24px;
            background: rgba(255, 255, 255, 0.04);
            border: 1px solid rgba(255, 255, 255, 0.08);
            backdrop-filter: blur(30px);
            box-shadow: 0 25px 80px rgba(0, 0, 0, 0.4);
            position: relative;
            overflow: hidden;
            animation: ci 1s cubic-bezier(0.34, 1.56, 0.64, 1) forwards;
            opacity: 0;
            transform: perspective(800px) rotateY(-10deg) scale(0.9);
        }

        .card::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 1px;
            background: linear-gradient(90deg, transparent, rgba(251, 191, 36, 0.5), rgba(99, 102, 241, 0.5), transparent);
        }

        @keyframes ci {
            to {
                opacity: 1;
                transform: perspective(800px) rotateY(0) scale(1);
            }
        }

        .badge {
            display: inline-block;
            padding: 5px 16px;
            border-radius: 50px;
            background: linear-gradient(135deg, rgba(251, 191, 36, 0.2), rgba(99, 102, 241, 0.2));
            border: 1px solid rgba(251, 191, 36, 0.3);
            font-size: 0.7rem;
            font-weight: 600;
            letter-spacing: 2px;
            text-transform: uppercase;
            color: #fcd34d;
            margin-bottom: 20px;
        }

        h1 {
            font-size: 2rem;
            font-weight: 800;
            margin-bottom: 8px;
            background: linear-gradient(135deg, #fff, #fcd34d, #a5b4fc);
            background-size: 200% auto;
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
            animation: ts 4s ease-in-out infinite;
        }

        @keyframes ts {

            0%,
            100% {
                background-position: 0% center
            }

            50% {
                background-position: 200% center
            }
        }

        .sub {
            color: #8892b0;
            font-size: 0.85rem;
            margin-bottom: 28px;
            font-weight: 300;
        }

        .form-group {
            margin-bottom: 18px;
            animation: fs 0.6s ease forwards;
            opacity: 0;
            transform: translateY(15px);
        }

        .form-group:nth-child(1) {
            animation-delay: 0.3s;
        }

        .form-group:nth-child(2) {
            animation-delay: 0.4s;
        }

        .form-group:nth-child(3) {
            animation-delay: 0.5s;
        }

        .form-group:nth-child(4) {
            animation-delay: 0.6s;
        }

        .form-group:nth-child(5) {
            animation-delay: 0.7s;
        }

        .form-group:nth-child(6) {
            animation-delay: 0.8s;
        }

        @keyframes fs {
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        label {
            display: block;
            font-size: 0.75rem;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 1.5px;
            color: #8892b0;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="number"] {
            width: 100%;
            padding: 14px 18px;
            border-radius: 14px;
            background: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(255, 255, 255, 0.1);
            color: #fff;
            font-size: 0.95rem;
            font-family: 'Inter', sans-serif;
            outline: none;
            transition: all 0.3s ease;
        }

        input:focus {
            border-color: rgba(251, 191, 36, 0.5);
            box-shadow: 0 0 20px rgba(251, 191, 36, 0.15);
            background: rgba(255, 255, 255, 0.07);
        }

        input[readonly] {
            opacity: 0.6;
            cursor: not-allowed;
        }

        .btn-submit {
            width: 100%;
            padding: 16px;
            border: none;
            border-radius: 14px;
            background: linear-gradient(135deg, #f59e0b, #6366f1, #8b5cf6);
            background-size: 200% auto;
            color: #fff;
            font-size: 1rem;
            font-weight: 700;
            font-family: 'Inter', sans-serif;
            cursor: pointer;
            margin-top: 8px;
            transition: all 0.4s ease;
            animation: fs 0.6s ease 0.9s forwards;
            opacity: 0;
            transform: translateY(15px);
        }

        .btn-submit:hover {
            background-position: right center;
            transform: translateY(-3px);
            box-shadow: 0 15px 40px rgba(251, 191, 36, 0.3);
        }

        .link-row {
            text-align: center;
            margin-top: 24px;
            animation: fs 0.6s ease 1s forwards;
            opacity: 0;
            transform: translateY(15px);
        }

        .link-row a {
            color: #fcd34d;
            text-decoration: none;
            font-size: 0.85rem;
            font-weight: 500;
            transition: color 0.3s ease;
            border-bottom: 1px solid transparent;
        }

        .link-row a:hover {
            color: #fff;
            border-bottom-color: rgba(251, 191, 36, 0.5);
        }
    </style>
</head>

<body>
    <div class="bg"></div>
    <div class="orb o1"></div>
    <div class="orb o2"></div>
    <div class="particles">
        <div class="p"></div>
        <div class="p"></div>
        <div class="p"></div>
        <div class="p"></div>
        <div class="p"></div>
    </div>

    <div class="card">
        <div class="badge">Edit Record</div>
        <h1>Update Employee</h1>
        <p class="sub">Modify the details below and save changes</p>

        <form action="/update-emp" method="post">
            <div class="form-group">
                <label>Full Name</label>
                <input type="text" name="name" value="${emp.name}" placeholder="Full Name" required>
            </div>
            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" value="${emp.email}" placeholder="Email" readonly>
            </div>
            <div class="form-group">
                <label>Salary</label>
                <input type="text" name="salary" value="${emp.salary}" placeholder="Salary" required>
            </div>
            <div class="form-group">
                <label>Role</label>
                <input type="text" name="role" value="${emp.role}" placeholder="Admin or User" required>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" value="${emp.password}" placeholder="Password" required>
            </div>
            <button type="submit" class="btn-submit">Save Changes</button>
        </form>

        <div class="link-row">
            <a href="/login">Back to Dashboard</a>
        </div>
    </div>

    <script>
        var card = document.querySelector('.card');
        card.addEventListener('mousemove', function (e) {
            var r = card.getBoundingClientRect();
            var rx = (e.clientY - r.top - r.height / 2) / 25;
            var ry = (r.width / 2 - (e.clientX - r.left)) / 25;
            card.style.transform = 'perspective(800px) rotateX(' + rx + 'deg) rotateY(' + ry + 'deg)';
        });
        card.addEventListener('mouseleave', function () {
            card.style.transform = 'perspective(800px) rotateX(0) rotateY(0)';
        });
    </script>
</body>

</html>