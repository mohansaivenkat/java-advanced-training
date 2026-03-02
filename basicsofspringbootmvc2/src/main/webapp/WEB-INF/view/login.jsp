<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
            background: rgba(255, 255, 255, 0.12);
            border-radius: 50%;
            animation: particleRise linear infinite;
        }

        .particle:nth-child(1) {
            left: 15%;
            animation-duration: 12s;
        }

        .particle:nth-child(2) {
            left: 30%;
            animation-duration: 15s;
            animation-delay: -2s;
            width: 4px;
            height: 4px;
        }

        .particle:nth-child(3) {
            left: 50%;
            animation-duration: 10s;
            animation-delay: -5s;
        }

        .particle:nth-child(4) {
            left: 70%;
            animation-duration: 18s;
            animation-delay: -3s;
            width: 2px;
            height: 2px;
        }

        .particle:nth-child(5) {
            left: 85%;
            animation-duration: 13s;
            animation-delay: -7s;
        }

        .particle:nth-child(6) {
            left: 95%;
            animation-duration: 16s;
            animation-delay: -1s;
            width: 4px;
            height: 4px;
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

        .card {
            width: 420px;
            padding: 48px 40px;
            border-radius: 24px;
            background: rgba(255, 255, 255, 0.04);
            border: 1px solid rgba(255, 255, 255, 0.08);
            backdrop-filter: blur(30px);
            box-shadow: 0 25px 80px rgba(0, 0, 0, 0.4);
            position: relative;
            overflow: hidden;
            animation: cardFlipIn 1s cubic-bezier(0.34, 1.56, 0.64, 1) forwards;
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
            background: linear-gradient(90deg, transparent, rgba(99, 102, 241, 0.5), rgba(236, 72, 153, 0.5), transparent);
        }

        @keyframes cardFlipIn {
            to {
                opacity: 1;
                transform: perspective(800px) rotateY(0deg) scale(1);
            }
        }

        .card .badge {
            display: inline-block;
            padding: 5px 16px;
            border-radius: 50px;
            background: linear-gradient(135deg, rgba(99, 102, 241, 0.2), rgba(236, 72, 153, 0.2));
            border: 1px solid rgba(99, 102, 241, 0.3);
            font-size: 0.7rem;
            font-weight: 600;
            letter-spacing: 2px;
            text-transform: uppercase;
            color: #a5b4fc;
            margin-bottom: 20px;
        }

        .card h1 {
            font-size: 2rem;
            font-weight: 800;
            margin-bottom: 8px;
            background: linear-gradient(135deg, #ffffff, #a5b4fc, #ec4899);
            background-size: 200% auto;
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
            animation: textShimmer 4s ease-in-out infinite;
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

        .card p.sub {
            color: #8892b0;
            font-size: 0.85rem;
            margin-bottom: 32px;
            font-weight: 300;
        }

        .form-group {
            margin-bottom: 20px;
            animation: fieldSlide 0.6s ease forwards;
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

        @keyframes fieldSlide {
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

        input[type="email"],
        input[type="password"] {
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
            border-color: rgba(99, 102, 241, 0.5);
            box-shadow: 0 0 20px rgba(99, 102, 241, 0.15);
            background: rgba(255, 255, 255, 0.07);
        }

        .btn-submit {
            width: 100%;
            padding: 16px;
            border: none;
            border-radius: 14px;
            background: linear-gradient(135deg, #6366f1, #8b5cf6, #ec4899);
            background-size: 200% auto;
            color: #fff;
            font-size: 1rem;
            font-weight: 700;
            font-family: 'Inter', sans-serif;
            cursor: pointer;
            margin-top: 8px;
            transition: all 0.4s ease;
            animation: fieldSlide 0.6s ease 0.6s forwards;
            opacity: 0;
            transform: translateY(15px);
        }

        .btn-submit:hover {
            background-position: right center;
            transform: translateY(-3px);
            box-shadow: 0 15px 40px rgba(99, 102, 241, 0.3);
        }

        .link-row {
            text-align: center;
            margin-top: 24px;
            animation: fieldSlide 0.6s ease 0.7s forwards;
            opacity: 0;
            transform: translateY(15px);
        }

        .link-row a {
            color: #a5b4fc;
            text-decoration: none;
            font-size: 0.85rem;
            font-weight: 500;
            transition: color 0.3s ease;
            border-bottom: 1px solid transparent;
        }

        .link-row a:hover {
            color: #fff;
            border-bottom-color: rgba(99, 102, 241, 0.5);
        }
    </style>
</head>

<body>
    <div class="bg-animated"></div>
    <div class="orb orb-1"></div>
    <div class="orb orb-2"></div>
    <div class="particles">
        <div class="particle"></div>
        <div class="particle"></div>
        <div class="particle"></div>
        <div class="particle"></div>
        <div class="particle"></div>
        <div class="particle"></div>
    </div>

    <div class="card">
        <div class="badge">Welcome Back</div>
        <h1>Sign In</h1>
        <p class="sub">Enter your credentials to access your account</p>

        <form action="logincheck" method="post">
            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" placeholder="you@example.com" required>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="btn-submit">Sign In</button>
        </form>

        <div class="link-row">
            <span style="color: #8892b0;">Don't have an account? </span>
            <a href="/register">Create one</a>
        </div>
    </div>

    <script>
        const card = document.querySelector('.card');
        card.addEventListener('mousemove', (e) => {
            const rect = card.getBoundingClientRect();
            const x = e.clientX - rect.left;
            const y = e.clientY - rect.top;
            const rotateX = (y - rect.height / 2) / 25;
            const rotateY = (rect.width / 2 - x) / 25;
            card.style.transform = 'perspective(800px) rotateX(' + rotateX + 'deg) rotateY(' + rotateY + 'deg)';
        });
        card.addEventListener('mouseleave', () => {
            card.style.transform = 'perspective(800px) rotateX(0deg) rotateY(0deg)';
        });
    </script>
</body>

</html>