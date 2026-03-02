<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
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
            top: -80px;
            left: -80px;
        }

        .o2 {
            width: 300px;
            height: 300px;
            background: radial-gradient(circle, rgba(236, 72, 153, 0.2), transparent);
            bottom: -60px;
            right: -60px;
            animation-delay: -4s;
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
            left: 15%;
            animation-duration: 12s
        }

        .p:nth-child(2) {
            left: 35%;
            animation-duration: 15s;
            animation-delay: -2s;
            width: 4px;
            height: 4px
        }

        .p:nth-child(3) {
            left: 55%;
            animation-duration: 10s;
            animation-delay: -5s
        }

        .p:nth-child(4) {
            left: 75%;
            animation-duration: 18s;
            animation-delay: -3s;
            width: 2px;
            height: 2px
        }

        .p:nth-child(5) {
            left: 90%;
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
            width: 500px;
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
            background: linear-gradient(135deg, rgba(99, 102, 241, 0.2), rgba(236, 72, 153, 0.2));
            border: 1px solid rgba(99, 102, 241, 0.3);
            font-size: 0.7rem;
            font-weight: 600;
            letter-spacing: 2px;
            text-transform: uppercase;
            color: #a5b4fc;
            margin-bottom: 20px;
        }

        .avatar {
            width: 80px;
            height: 80px;
            margin: 0 auto 24px;
            border-radius: 50%;
            position: relative;
            background: linear-gradient(135deg, #6366f1, #ec4899);
            display: flex;
            align-items: center;
            justify-content: center;
            animation: ap 3s ease-in-out infinite;
        }

        .avatar-letter {
            font-size: 2rem;
            font-weight: 800;
            color: #fff;
        }

        @keyframes ap {

            0%,
            100% {
                box-shadow: 0 0 20px rgba(99, 102, 241, 0.2)
            }

            50% {
                box-shadow: 0 0 50px rgba(99, 102, 241, 0.4)
            }
        }

        h1 {
            font-size: 2.2rem;
            font-weight: 800;
            margin-bottom: 8px;
            background: linear-gradient(135deg, #fff 0%, #a5b4fc 40%, #ec4899 100%);
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

        .welcome {
            color: #8892b0;
            font-size: 1rem;
            font-weight: 300;
            margin-bottom: 32px;
        }

        .name-hl {
            color: #a5b4fc;
            font-weight: 600;
        }

        .nav-links {
            display: flex;
            gap: 12px;
            justify-content: center;
            animation: fu 0.6s ease 0.8s forwards;
            opacity: 0;
            transform: translateY(15px);
        }

        @keyframes fu {
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .nav-links a {
            padding: 14px 28px;
            border-radius: 14px;
            text-decoration: none;
            font-weight: 600;
            font-size: 0.9rem;
            font-family: 'Inter', sans-serif;
            transition: all 0.4s ease;
        }

        .btn-p {
            background: linear-gradient(135deg, #6366f1, #8b5cf6);
            color: #fff;
        }

        .btn-p:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 40px rgba(99, 102, 241, 0.3);
        }

        .btn-s {
            background: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(255, 255, 255, 0.1);
            color: #a5b4fc;
        }

        .btn-s:hover {
            background: rgba(255, 255, 255, 0.1);
            transform: translateY(-3px);
            color: #fff;
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
        <div class="badge">User Portal</div>
        <div class="avatar"><span class="avatar-letter" id="av">U</span></div>
        <h1>Welcome Back</h1>
        <p class="welcome">Signed in as <span class="name-hl">${name}</span></p>
        <div class="nav-links">
            <a href="/register" class="btn-p">Register New</a>
            <a href="/login" class="btn-s">Logout</a>
        </div>
    </div>

    <script>
        var name = document.querySelector('.name-hl');
        if (name && name.textContent.trim().length > 0) {
            document.getElementById('av').textContent = name.textContent.trim().charAt(0).toUpperCase();
        }
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