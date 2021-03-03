public enum Language {
    ENGLISH(1), FRENCH(0), GERMAN(1);

    private int priority;

    Language(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }
}
