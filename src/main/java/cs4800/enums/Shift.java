package cs4800.enums;

public enum Shift {
    EARLY(8, 16),
    LATE(16, 24),
    OVERNIGHT(0, 8);

    private final int startHour;
    private final int endHour;

    Shift(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }
}