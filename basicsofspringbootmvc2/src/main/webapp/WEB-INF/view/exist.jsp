<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Already Exists</title>
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
            background: linear-gradient(135deg, #0a0a1a 0%, #1a0a0e 25%, #1a0a2e 50%, #1a0a0e 75%, #0a0a1a 100%);
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
            background: radial-gradient(circle, rgba(239, 68, 68, 0.25), transparent);
            top: -100px;
            left: 30%;
            animation-duration: 10s;
        }

        .orb-2 {
            width: 350px;
            height: 350px;
            background: radial-gradient(circle, rgba(249, 115, 22, 0.2), transparent);
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
            animation: cardShake 0.6s cubic-bezier(0.36, 0.07, 0.19, 0.97) forwards;
        }

        .card::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 1px;
            background: linear-gradient(90deg, transparent, rgba(239, 68, 68, 0.6), rgba(249, 115, 22, 0.6), transparent);
        }

        @keyframes cardShake {
            0% {
                transform: translateX(0);
                opacity: 0;
            }

            10% {
                opacity: 1;
            }

            20% {
                transform: translateX(-12px);
            }

            40% {
                transform: translateX(10px);
            }

            60% {
                transform: translateX(-6px);
            }

            80% {
                transform: translateX(4px);
            }

            100% {
                transform: translateX(0);
                opacity: 1;
            }
        }

        .warning-ring {
            width: 90px;
            height: 90px;
            margin: 0 auto 28px;
            border-radius: 50%;
            border: 3px solid rgba(239, 68, 68, 0.3);
            display: flex;
            align-items: center;
            justify-content: center;
            animation: ringPulse 2s ease-in-out infinite;
        }

        .warning-ring::after {
            content: '';
            position: absolute;
            width: 86px;
            height: 86px;
            border-radius: 50%;
            border: 3px solid transparent;
            border-top-color: #ef4444;
            animation: ringSpin 2s linear infinite;
        }

        @keyframes ringPulse {

            0%,
            100% {
                box-shadow: 0 0 20px rgba(239, 68, 68, 0.1);
            }

            50% {
                box-shadow: 0 0 40px rgba(239, 68, 68, 0.25);
            }
        }

        @keyframes ringSpin {
            to {
                transform: rotate(360deg);
            }
        }

        .exclamation {
            font-size: 2rem;
            font-weight: 900;
            color: #ef4444;
            animation: exclamationBounce 0.6s ease 0.3s forwards;
            opacity: 0;
        }

        @keyframes exclamationBounce {
            0% {
                transform: scale(0);
                opacity: 0;
            }

            50% {
                transform: scale(1.3);
            }

            100% {
                transform: scale(1);
                opacity: 1;
            }
        }

        .card h1 {
            font-size: 1.8rem;
            font-weight: 800;
            margin-bottom: 12px;
            background: linear-gradient(135deg, #ffffff, #fca5a5);
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

        .email-highlight {
            display: inline-block;
            padding: 6px 18px;
            border-radius: 10px;
            background: rgba(239, 68, 68, 0.1);
            border: 1px solid rgba(239, 68, 68, 0.2);
            color: #fca5a5;
            font-weight: 600;
            font-size: 0.95rem;
            margin-bottom: 32px;
            word-break: break-all;
        }

        .btn-row {
            display: flex;
            gap: 12px;
            justify-content: center;
            animation: fadeUp 0.6s ease 0.8s forwards;
            opacity: 0;
            transform: translateY(15px);
        }

        @keyframes fadeUp {
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .btn-row a {
            padding: 14px 32px;
            border-radius: 14px;
            text-decoration: none;
            font-weight: 700;
            font-size: 0.9rem;
            font-family: 'Inter', sans-serif;
            transition: all 0.4s ease;
        }

        .btn-primary {
            background: linear-gradient(135deg, #6366f1, #8b5cf6);
            color: #fff;
        }

        .btn-primary:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 40px rgba(99, 102, 241, 0.3);
        }

        .btn-secondary {
            background: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(255, 255, 255, 0.1);
            color: #a5b4fc;
        }

        .btn-secondary:hover {
            background: rgba(255, 255, 255, 0.1);
            transform: translateY(-3px);
            color: #fff;
        }
    </style>
</head>

<body>
    <div class="bg-animated"></div>
    <div class="orb orb-1"></div>
    <div class="orb orb-2"></div>

    <div class="card">
        <div class="warning-ring">
            <span class="exclamation">!</span>
        </div>
        <h1>Account Already Exists</h1>
        <p class="sub">An account is already registered with</p>
        <div class="email-highlight">${email}</div>
        <div class="btn-row">
            <a href="/login" class="btn-primary">Sign In</a>
            <a href="/register" class="btn-secondary">Try Another</a>
        </div>
    </div>
</body>

</html>