package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TimerTask;

public class DeleteMoneyFileTask extends TimerTask {
    private File file;
    private double turnOver;

    public DeleteMoneyFileTask(File file, double turnOver) {
        this.setFile(file);
        this.setTurnOver(turnOver);
    }

    private File getFile() {
        return file;
    }

    private void setFile(File file) {
        this.file = file;
    }

    private double getTurnOver() {
        return turnOver;
    }

    private void setTurnOver(double turnOver) {
        this.turnOver = turnOver;
    }

    @Override
    public void run() {
        Path path = Paths.get(getFile().getPath());
        try {
            Files.newOutputStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        turnOver = 0.00;
    }
}
