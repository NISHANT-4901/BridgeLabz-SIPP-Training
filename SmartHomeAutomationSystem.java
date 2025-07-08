interface Controllable {
    void turnOn();

    void turnOff();
}

abstract class Appliance implements Controllable {
    private boolean isOn;
    private int power;

    public Appliance(int power) {
        this.power = power;
        this.isOn = false;
    }

    public int getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }

    protected void setOn(boolean state) {
        this.isOn = state;
    }
}

class Light extends Appliance {
    public Light(int power) {
        super(power);
    }

    public void turnOn() {
        setOn(true);
        System.out.println("Light is ON");
    }

    public void turnOff() {
        setOn(false);
        System.out.println("Light is OFF");
    }
}

class Fan extends Appliance {
    public Fan(int power) {
        super(power);
    }

    public void turnOn() {
        setOn(true);
        System.out.println("Fan is ON");
    }

    public void turnOff() {
        setOn(false);
        System.out.println("Fan is OFF");
    }
}

class AC extends Appliance {
    public AC(int power) {
        super(power);
    }

    public void turnOn() {
        setOn(true);
        System.out.println("AC is ON");
    }

    public void turnOff() {
        setOn(false);
        System.out.println("AC is OFF");
    }
}

class UserController {
    public void toggleAppliance(Controllable appliance, boolean turnOn) {
        if (turnOn) {
            appliance.turnOn();
        } else {
            appliance.turnOff();
        }
    }

    public void compareEnergyUsage(Appliance a1, Appliance a2) {
        if (a1.getPower() > a2.getPower()) {
            System.out.println("First appliance uses more power.");
        } else if (a1.getPower() < a2.getPower()) {
            System.out.println("Second appliance uses more power.");
        } else {
            System.out.println("Both appliances use the same power.");
        }
    }
}

public class SmartHomeAutomationSystem {
    public static void main(String[] args) {
        Light light = new Light(40);
        Fan fan = new Fan(70);
        AC ac = new AC(150);

        UserController controller = new UserController();

        controller.toggleAppliance(light, true);
        controller.toggleAppliance(fan, true);
        controller.toggleAppliance(ac, false);

        controller.compareEnergyUsage(fan, ac);
    }
}
