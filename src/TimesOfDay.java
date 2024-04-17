public enum TimesOfDay {
    MORNING ("Утро"),
    DAY ("День"),
    EVENING ("Вечер"),
    NIGHT ("Ночь");

    private String title;

    TimesOfDay(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
