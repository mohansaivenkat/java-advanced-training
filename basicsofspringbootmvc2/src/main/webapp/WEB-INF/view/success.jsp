<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>
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
            background: linear-gradient(135deg, #0a0a1a 0%, #0a1a12 25%, #0a1628 50%, #0a1a12 75%, #0a0a1a 100%);
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
            background: radial-gradient(circle, rgba(16, 185, 129, 0.35), transparent);
            top: -100px;
            left: 30%;
            animation-duration: 10s;
        }

        .orb-2 {
            width: 350px;
            height: 350px;
            background: radial-gradient(circle, rgba(52, 211, 153, 0.2), transparent);
            bottom: -80px;
            right: 20%;
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
            background: rgba(16, 185, 129, 0.25);
            border-radius: 50%;
            animation: particleRise linear infinite;
        }

        .particle:nth-child(1) {
            left: 15%;
            animation-duration: 12s;
        }

        .particle:nth-child(2) {
            left: 35%;
            animation-duration: 15s;
            animation-delay: -2s;
            width: 4px;
            height: 4px;
        }

        .particle:nth-child(3) {
            left: 55%;
            animation-duration: 10s;
            animation-delay: -5s;
        }

        .particle:nth-child(4) {
            left: 75%;
            animation-duration: 18s;
            animation-delay: -3s;
            width: 2px;
            height: 2px;
        }

        .particle:nth-child(5) {
            left: 90%;
            animation-duration: 13s;
            animation-delay: -7s;
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
            width: 440px;
            padding: 56px 48px;
            border-radius: 24px;
            background: rgba(255, 255, 255, 0.04);
            border: 1px solid rgba(255, 255, 255, 0.08);
            backdrop-filter: blur(30px);
            box-shadow: 0 25px 80px rgba(0, 0, 0, 0.4);
            text-align: center;
            position: relative;
            overflow: hidden;
            animation: cardBounceIn 1s cubic-bezier(0.34, 1.56, 0.64, 1) forwards;
            opacity: 0;
            transform: scale(0.5) rotateX(20deg);
        }

        .card::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 1px;
            background: linear-gradient(90deg, transparent, rgba(16, 185, 129, 0.6), rgba(52, 211, 153, 0.6), transparent);
        }

        @keyframes cardBounceIn {
            to {
                opacity: 1;
                transform: scale(1) rotateX(0deg);
            }
        }

        .success-ring {
            width: 90px;
            height: 90px;
            margin: 0 auto 28px;
            border-radius: 50%;
            border: 3px solid rgba(16, 185, 129, 0.3);
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
            animation: ringPulse 2s ease-in-out infinite;
        }

        .success-ring::after {
            content: '';
            position: absolute;
            top: -3px;
            left: -3px;
            right: -3px;
            bottom: -3px;
            border-radius: 50%;
            border: 3px solid transparent;
            border-top-color: #10b981;
            animation: ringSpin 2s linear infinite;
        }

        @keyframes ringPulse {

            0%,
            100% {
                box-shadow: 0 0 20px rgba(16, 185, 129, 0.1);
            }

            50% {
                box-shadow: 0 0 40px rgba(16, 185, 129, 0.25);
            }
        }

        @keyframes ringSpin {
            to {
                transform: rotate(360deg);
            }
        }

        .checkmark {
            width: 36px;
            height: 36px;
            position: relative;
        }

        .checkmark::before {
            content: '';
            position: absolute;
            width: 14px;
            height: 3px;
            background: #10b981;
            top: 22px;
            left: 4px;
            transform: rotate(45deg);
            animation: checkLeft 0.3s ease 0.5s forwards;
            opacity: 0;
        }

        .checkmark::after {
            content: '';
            position: absolute;
            width: 24px;
            height: 3px;
            background: #10b981;
            top: 18px;
            left: 10px;
            transform: rotate(-45deg);
            animation: checkRight 0.3s ease 0.7s forwards;
            opacity: 0;
        }

        @keyframes checkLeft {
            to {
                opacity: 1;
            }
        }

        @keyframes checkRight {
            to {
                opacity: 1;
            }
        }

        .card h1 {
            font-size: 2rem;
            font-weight: 800;
            margin-bottom: 8px;
            background: linear-gradient(135deg, #ffffff, #34d399);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
        }

        .card p.sub {
            color: #8892b0;
            font-size: 0.9rem;
            margin-bottom: 8px;
            font-weight: 300;
        }

        .name-highlight {
            color: #34d399;
            font-weight: 600;
            font-size: 1.1rem;
            display: block;
            margin-bottom: 32px;
        }

        .btn-login {
            display: inline-block;
            padding: 16px 48px;
            border-radius: 14px;
            background: linear-gradient(135deg, #10b981, #059669);
            color: #fff;
            text-decoration: none;
            font-size: 1rem;
            font-weight: 700;
            font-family: 'Inter', sans-serif;
            transition: all 0.4s ease;
            animation: fieldSlide 0.6s ease 1s forwards;
            opacity: 0;
            transform: translateY(15px);
        }

        .btn-login:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 40px rgba(16, 185, 129, 0.3);
        }

        @keyframes fieldSlide {
            to {
                opacity: 1;
                transform: translateY(0);
            }
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
    </div>

    <div class="card">
        <div class="success-ring">
            <div class="checkmark"></div>
        </div>
        <h1>Registration Complete</h1>
        <p class="sub">Welcome aboard,</p>
        <span class="name-highlight">${name}</span>
        <a href="/login" class="btn-login">Proceed to Login</a>
    </div>
</body>

</html>