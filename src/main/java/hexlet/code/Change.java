package hexlet.code;

import java.util.Objects;

public final class Change {

    private final Status status;
    private final Object oldValue;
    private final Object newValue;

    public Change(Status statusName, Object fromValue, Object toValue) {
        this.status = statusName;
        this.oldValue = fromValue;
        this.newValue = toValue;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Status getStatus() {
        return status;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Change change = (Change) o;
        return status == change.status && Objects.equals(oldValue, change.oldValue) && Objects.equals(newValue,
                change.newValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, oldValue, newValue);
    }

    @Override
    public String toString() {
        return "Change{"
                + "status=" + status
                + ", oldValue=" + oldValue
                + ", newValue=" + newValue
                + '}';
    }

    public static final class Builder {

        private Status status;
        private Object oldValue;
        private Object newValue;

        private Builder() {
        }

        public Builder status(Status statusName) {
            this.status = statusName;
            return this;
        }

        public Builder oldValue(Object fromValue) {
            this.oldValue = fromValue;
            return this;
        }

        public Builder newValue(Object toValue) {
            this.newValue = toValue;
            return this;
        }

        public Change build() {
            return new Change(status, oldValue, newValue);
        }
    }

    public enum Status {
        ADDED,
        DELETED,
        UNCHANGED,
        CHANGED
    }
}
