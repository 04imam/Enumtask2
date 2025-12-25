enum TrafficLight {
    RED,
    YELLOW,
    GREEN
}


class TrafficLightSimulator {

    private TrafficLight currentLight;

    public TrafficLightSimulator(TrafficLight initialLight) {
        this.currentLight = initialLight;
    }

    public void changeColor(TrafficLight light) {
        switch (light) {
            case RED:
                currentLight = TrafficLight.GREEN;
                break;
            case GREEN:
                currentLight = TrafficLight.YELLOW;
                break;
            case YELLOW:
                currentLight = TrafficLight.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "Current traffic light: " + currentLight;
    }

    public TrafficLight getCurrentLight() {
        return currentLight;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        TrafficLightSimulator simulator =
                new TrafficLightSimulator(TrafficLight.RED);

        for (int i = 0; i < 10; i++) {
            System.out.println(simulator.toString());
            simulator.changeColor(simulator.getCurrentLight());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
