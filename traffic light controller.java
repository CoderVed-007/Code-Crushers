<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Traffic Light Controller</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f0f0f0;
        }
        .traffic-light {
            margin: 50px auto;
            width: 100px;
            height: 300px;
            background-color: black;
            border-radius: 10px;
            padding: 20px;
        }
        .light {
            width: 80px;
            height: 80px;
            margin: 10px auto;
            background-color: gray;
            border-radius: 50%;
        }
        .light.red {
            background-color: red;
        }
        .light.yellow {
            background-color: yellow;
        }
        .light.green {
            background-color: green;
        }
        .controls {
            margin-top: 20px;
        }
        button {
            padding: 10px 20px;
            margin: 5px;
            font-size: 16px;
        }
        .info {
            margin-top: 20px;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <h1>Traffic Light Controller</h1>
    <div class="traffic-light">
        <div id="redLight" class="light"></div>
        <div id="yellowLight" class="light"></div>
        <div id="greenLight" class="light"></div>
    </div>
    <div class="controls">
        <button id="startBtn">Start Simulation</button>
        <button id="emergencyBtn">Toggle Emergency Mode</button>
    </div>
    <div class="info">
        <p id="countdown">Time Remaining: 0s</p>
        <p id="trafficDensity">Traffic Density: 50%</p>
    </div>

    <script>
        // Traffic light logic
        class TrafficLightController {
            constructor() {
                this.currentLight = 'RED';
                this.duration = 30;
                this.emergencyMode = false;
                this.trafficDensity = 50;
                this.interval = null;

                this.redLight = document.getElementById('redLight');
                this.yellowLight = document.getElementById('yellowLight');
                this.greenLight = document.getElementById('greenLight');
                this.countdownDisplay = document.getElementById('countdown');
                this.trafficDensityDisplay = document.getElementById('trafficDensity');
                this.startBtn = document.getElementById('startBtn');
                this.emergencyBtn = document.getElementById('emergencyBtn');

                this.setupEventListeners();
            }

            setupEventListeners() {
                this.startBtn.addEventListener('click', () => this.startSimulation());
                this.emergencyBtn.addEventListener('click', () => this.toggleEmergencyMode());
            }

            updateLights() {
                this.redLight.classList.remove('red');
                this.yellowLight.classList.remove('yellow');
                this.greenLight.classList.remove('green');

                if (this.currentLight === 'RED') {
                    this.redLight.classList.add('red');
                } else if (this.currentLight === 'YELLOW') {
                    this.yellowLight.classList.add('yellow');
                } else if (this.currentLight === 'GREEN') {
                    this.greenLight.classList.add('green');
                }
            }

            startSimulation() {
                this.trafficDensity = Math.floor(Math.random() * 100);
                this.adjustLightDurations();
                clearInterval(this.interval);
                this.interval = setInterval(() => this.updateCountdown(), 1000);
                this.trafficDensityDisplay.textContent = Traffic Density: ${this.trafficDensity}%;
            }

            toggleEmergencyMode() {
                this.emergencyMode = !this.emergencyMode;
                if (this.emergencyMode) {
                    this.currentLight = 'GREEN';
                    this.duration = 60;
                } else {
                    this.startSimulation();
                }
                this.updateLights();
            }

            adjustLightDurations() {
                if (this.trafficDensity > 70) {
                    this.currentLight = 'GREEN';
                    this.duration = 40;
                } else if (this.trafficDensity > 30) {
                    this.currentLight = 'YELLOW';
                    this.duration = 10;
                } else {
                    this.currentLight = 'RED';
                    this.duration = 20;
                }
                this.updateLights();
            }

            updateCountdown() {
                if (this.duration > 0) {
                    this.duration--;
                    this.countdownDisplay.textContent = Time Remaining: ${this.duration}s;
                } else {
                    this.cycleLights();
                }
            }

            cycleLights() {
                if (!this.emergencyMode) {
                    if (this.currentLight === 'RED') {
                        this.currentLight = 'YELLOW';
                        this.duration = 30;
                    } else if (this.currentLight === 'YELLOW') {
                        this.currentLight = 'GREEN';
                        this.duration = 10;
                    } else if (this.currentLight === 'GREEN') {
                        this.currentLight = 'RED';
                        this.duration = 30;
                    }
                    this.updateLights();
                }
            }
        }

        // Initialize the TrafficLightController
        new TrafficLightController();
    </script>
</body>
</html>
