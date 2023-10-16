package at.gepardec.health;

import javax.inject.Singleton;

@Singleton
public class State {

    private static final String serviceName = "MainService";

    boolean liveness = true;
    boolean readiness = true;


    public String getServiceName() {
        return serviceName;
    }

    public boolean getLiveness() {
        return liveness;
    }

    public boolean getReadiness() {
        return readiness;
    }

    public void setLiveness(boolean liveness) {
        this.liveness = liveness;
    }

    public void setReadiness(boolean readiness) {
        this.readiness = readiness;
    }
}
