class SimpleTask extends Task {
    private int startHour;
    private int endHour;

    public SimpleTask(String name, String status, int startHour, int endHour) {
        super(name, status);
        this.startHour = startHour;
        this.endHour = endHour;
    }

    @Override
    public int estimateDuration() {
        return endHour - startHour;
    }
}