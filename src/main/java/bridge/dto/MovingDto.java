package bridge.dto;

public class MovingDto {
    private final String command;
    private final boolean isSuccess;

    public MovingDto(String command, boolean isSuccess) {
        this.command = command;
        this.isSuccess = isSuccess;
    }

    public String getCommand() {
        return command;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
