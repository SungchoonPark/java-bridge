package bridge.dto;

public class MovingDto {
    private String command;
    private boolean isSuccess;

    public MovingDto(String command, boolean isSuccess) {
        this.command = command;
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        return "MovingDto{" +
                "command='" + command + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
