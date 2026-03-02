<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Successful</title>
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
            background: linear-gradient(135deg, #0a0a1a, #0a1628, #1a0a2e, #0a0a1a);
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
            background: radial-gradient(circle, rgba(99, 102, 241, 0.3), transparent);
            top: -100px;
            left: 30%;
        }

        .o2 {
            width: 350px;
            height: 350px;
            background: radial-gradient(circle, rgba(16, 185, 129, 0.25), transparent);
            bottom: -80px;
            right: 20%;
            animation-delay: -3s;
        }

        @keyframes of {

            0%,
            100% {
                transform: translate(0, 0) scale(1)
            }

            50% {
                transform: translate(-20px, 20px) scale(0.95)
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
            animation: ci 1s cubic-bezier(0.34, 1.56, 0.64, 1) forwards;
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
            background: linear-gradient(90deg, transparent, rgba(99, 102, 241, 0.5), rgba(16, 185, 129, 0.5), transparent);
        }

        @keyframes ci {
            to {
                opacity: 1;
                transform: scale(1) rotateX(0deg);
            }
        }

        .ring {
            width: 90px;
            height: 90px;
            margin: 0 auto 28px;
            border-radius: 50%;
            border: 3px solid rgba(99, 102, 241, 0.3);
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
            animation: rp 2s ease-in-out infinite;
        }

        .ring::after {
            content: '';
            position: absolute;
            top: -3px;
            left: -3px;
            right: -3px;
            bottom: -3px;
            border-radius: 50%;
            border: 3px solid transparent;
            border-top-color: #6366f1;
            animation: rs 2s linear infinite;
        }

        @keyframes rp {

            0%,
            100% {
                box-shadow: 0 0 20px rgba(99, 102, 241, 0.1)
            }

            50% {
                box-shadow: 0 0 40px rgba(99, 102, 241, 0.25)
            }
        }

        @keyframes rs {
            to {
                transform: rotate(360deg)
            }
        }

        .chk {
            width: 36px;
            height: 36px;
            position: relative;
        }

        .chk::before {
            content: '';
            position: absolute;
            width: 14px;
            height: 3px;
            background: #6366f1;
            top: 22px;
            left: 4px;
            transform: rotate(45deg);
            animation: cd 0.3s ease 0.5s forwards;
            opacity: 0;
        }

        .chk::after {
            content: '';
            position: absolute;
            width: 24px;
            height: 3px;
            background: #6366f1;
            top: 18px;
            left: 10px;
            transform: rotate(-45deg);
            animation: cd 0.3s ease 0.7s forwards;
            opacity: 0;
        }

        @keyframes cd {
            to {
                opacity: 1
            }
        }

        h1 {
            font-size: 2rem;
            font-weight: 800;
            margin-bottom: 12px;
            background: linear-gradient(135deg, #fff, #a5b4fc);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
        }

        p {
            color: #8892b0;
            font-size: 0.95rem;
            font-weight: 300;
        }
    </style>
</head>

<body>
    <div class="bg"></div>
    <div class="orb o1"></div>
    <div class="orb o2"></div>
    <div class="card">
        <div class="ring">
            <div class="chk"></div>
        </div>
        <h1>Login Successful</h1>
        <p>You have been authenticated successfully</p>
    </div>
</body>

</html>