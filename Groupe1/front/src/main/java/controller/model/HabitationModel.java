package controller.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by user on 23/03/2016.
 */
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "session")
public class HabitationModel {

    private HabStep1 habStep1;

    public HabStep1 getHabStep1() {
        return habStep1;
    }

    public void setHabStep1(HabStep1 habStep1) {
        this.habStep1 = habStep1;
    }
}
