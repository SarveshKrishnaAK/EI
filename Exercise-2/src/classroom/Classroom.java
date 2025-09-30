package src.classroom;

import java.util.UUID;

public class Classroom {
    private final String id;
    private final String name;

    public Classroom(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
