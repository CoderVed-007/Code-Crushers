class TrafficLightController {
    constructor() {
        this.currentLight = "RED";
        this.duration = 30;
        this.trafficDensity = 50;
        this.emergencyMode = false;
        this.timer = null;

        this.initialize();
    }

    initialize() {
        // Create main container
        const container = document.createElement("div");
        document.body.appendChild(container);

        // Create traffic light canvas
        const canvas = document.createElement("canvas");
        canvas.width = 800;
        canvas.height = 600;
        container.appendChild(canvas);
        this.ctx = canvas.getContext("2d");

        // Create control buttons
        const buttonContainer = document.createElement("div");
        const startButton = document.createElement("button");
        startButton.textContent = "Start Traffic Simulation";
        const emergencyButton = document.createElement("button");
        emergencyButton.textContent = "Activate Emergency Mode";
        buttonContainer.appendChild(startButton);
        buttonContainer.appendChild(emergencyButton);
        container.appendChild(buttonContainer);

        // Add event listeners to buttons
        startButton.addEventListener("click", () => this.startTrafficSimulation());
        emergencyButton.addEventListener("click", () => this.toggleEmergencyMode());

        // Start real-time updates
        this.startRealTimeUpdates();
    }

    drawTrafficLight() {
        const ctx = this.ctx;

        // Clear the canvas
        ctx.clearRect(0, 0, 800, 600);

        // Draw traffic light frame
        ctx.fillStyle = "black";
        ctx.fillRect(300, 50, 200, 400);

        // Draw lights
        this.drawLight(ctx, "red", 350, 75, this.currentLight === "RED");
        this.drawLight(ctx, "yellow", 350, 200, this.currentLight === "YELLOW");
        this.drawLight(ctx, "green", 350, 325, this.currentLight === "GREEN");

        // Draw time remaining
        ctx.fillStyle = "black";
        ctx.font = "20px Arial";
        ctx.fillText(Time Remaining: ${this.duration}s, 320, 470);

        // Emergency mode indicator
        if (this.emergencyMode) {
            ctx.fillStyle = "orange";
            ctx.font = "16px Arial";
            ctx.fillText("EMERGENCY MODE ACTIVE", 320, 500);
        }

        // Traffic density display
        ctx.fillStyle = "blue";
        ctx.font = "14px Arial";
        ctx.fillText(Traffic Density: ${this.trafficDensity}%, 320, 530);
    }

    drawLight(ctx, color, x, y, active) {
        ctx.fillStyle = active ? color : "gray";
        ctx.beginPath();
        ctx.arc(x + 50, y + 50, 50, 0, Math.PI * 2);
        ctx.fill();
    }

    startTrafficSimulation() {
        this.trafficDensity = this.fetchRealTimeTrafficDensity();
        this.adjustLightDurations();
        this.drawTrafficLight();
    }

    toggleEmergencyMode() {
        this.emergencyMode = !this.emergencyMode;
        if (this.emergencyMode) {
            this.setCurrentLightAndDuration("GREEN", 60);
        } else {
            this.startTrafficSimulation();
        }
        this.drawTrafficLight();
    }

    fetchRealTimeTrafficDensity() {
        return Math.floor(Math.random() * 101); // Random traffic density (0-100%)
    }

    adjustLightDurations() {
        if (this.trafficDensity > 70) {
            this.setCurrentLightAndDuration("GREEN", 40);
        } else if (this.trafficDensity > 30) {
            this.setCurrentLightAndDuration("YELLOW", 10);
        } else {
            this.setCurrentLightAndDuration("RED", 20);
        }
    }

    setCurrentLightAndDuration(light, duration) {
        this.currentLight = light;
        this.duration = duration;
    }

    startRealTimeUpdates() {
        if (this.timer) {
            clearInterval(this.timer);
        }

        this.timer = setInterval(() => {
            if (this.duration > 0) {
                this.duration--;
            } else {
                this.cycleToNextLight();
            }
            this.drawTrafficLight();
        }, 1000);
    }

    cycleToNextLight() {
        switch (this.currentLight) {
            case "RED":
                this.setCurrentLightAndDuration("GREEN", 30);
                break;
            case "GREEN":
                this.setCurrentLightAndDuration("YELLOW", 10);
                break;
            case "YELLOW":
                this.setCurrentLightAndDuration("RED", 30);
                break;
        }
    }
}

// Initialize the traffic light controller
new TrafficLightController();
