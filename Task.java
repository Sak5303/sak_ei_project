package ei;

public class Task {
    String description;
    int startTime;
    int endTime;
    char priority;

    public Task(String description, int startTime, int endTime, char priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public char getPriority() {
        return priority;
    }
}
