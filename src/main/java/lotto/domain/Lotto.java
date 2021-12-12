package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<NumberGroup> numberGroups;

    public Lotto(List<NumberGroup> numberGroups) {
        this.numberGroups = numberGroups;
    }

    public boolean appropriate(int count) {
        return numberGroups.size() == count;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numberGroups=" + numberGroups.toString() +
                '}';
    }
}
