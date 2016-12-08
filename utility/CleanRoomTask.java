package utility;

import guest.Guest;
import javax.swing.JLabel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TimerTask;

public class CleanRoomTask extends TimerTask {
    private JLabel[] broom;
    private Guest[] roomsFirstStorey;
    private Guest[] roomsSecondStorey;
    private Guest[] roomsThirdStorey;
    private File[] firstStoreyFiles;
    private File[] secondStoreyFiles;
    private File[] thirdStoreyFiles;
    private Scanner[] firstStoreyReaders;
    private Scanner[] secondStoreyReaders;
    private Scanner[] thirdStoreyReaders;

    public CleanRoomTask(JLabel[] broom, File[] firstStoreyFiles, File[] secondStoreyFiles, File[] thirdStoreyFiles,
                         Scanner[] firstStoreyReaders, Scanner[] secondStoreyReaders, Scanner[] thirdStoreyReaders,
                         Guest[] roomsFirstStorey, Guest[] roomsSecondStorey, Guest[] roomsThirdStorey) {
        this.setBroom(broom);
        this.setFirstStoreyFiles(firstStoreyFiles);
        this.setSecondStoreyFiles(secondStoreyFiles);
        this.setThirdStoreyFiles(thirdStoreyFiles);
        this.setFirstStoreyReaders(firstStoreyReaders);
        this.setSecondStoreyReaders(secondStoreyReaders);
        this.setThirdStoreyReaders(thirdStoreyReaders);
        this.setRoomsFirstStorey(roomsFirstStorey);
        this.setRoomsSecondStorey(roomsSecondStorey);
        this.setRoomsThirdStorey(roomsThirdStorey);
    }

    private JLabel[] getBroom() {
        return broom;
    }

    private void setBroom(JLabel[] broom) {
        this.broom = broom;
    }

    private File[] getFirstStoreyFiles() {
        return firstStoreyFiles;
    }

    private void setFirstStoreyFiles(File[] firstStoreyFiles) {
        this.firstStoreyFiles = firstStoreyFiles;
    }

    private File[] getSecondStoreyFiles() {
        return secondStoreyFiles;
    }

    private void setSecondStoreyFiles(File[] secondStoreyFiles) {
        this.secondStoreyFiles = secondStoreyFiles;
    }

    private File[] getThirdStoreyFiles() {
        return thirdStoreyFiles;
    }

    private void setThirdStoreyFiles(File[] thirdStoreyFiles) {
        this.thirdStoreyFiles = thirdStoreyFiles;
    }

    private Scanner[] getFirstStoreyReaders() {
        return firstStoreyReaders;
    }

    private void setFirstStoreyReaders(Scanner[] firstStoreyReaders) {
        this.firstStoreyReaders = firstStoreyReaders;
    }

    private Scanner[] getSecondStoreyReaders() {
        return secondStoreyReaders;
    }

    private void setSecondStoreyReaders(Scanner[] secondStoreyReaders) {
        this.secondStoreyReaders = secondStoreyReaders;
    }

    private Scanner[] getThirdStoreyReaders() {
        return thirdStoreyReaders;
    }

    private void setThirdStoreyReaders(Scanner[] thirdStoreyReaders) {
        this.thirdStoreyReaders = thirdStoreyReaders;
    }

    private Guest[] getRoomsFirstStorey() {
        return roomsFirstStorey;
    }

    private void setRoomsFirstStorey(Guest[] roomsFirstStorey) {
        this.roomsFirstStorey = roomsFirstStorey;
    }

    private Guest[] getRoomsSecondStorey() {
        return roomsSecondStorey;
    }

    private void setRoomsSecondStorey(Guest[] roomsSecondStorey) {
        this.roomsSecondStorey = roomsSecondStorey;
    }

    private Guest[] getRoomsThirdStorey() {
        return roomsThirdStorey;
    }

    private void setRoomsThirdStorey(Guest[] roomsThirdStorey) {
        this.roomsThirdStorey = roomsThirdStorey;
    }


    @Override
    public void run() {
        for (JLabel jLabel : broom) {
            jLabel.setVisible(false);
        }
        ChooseStorey(getRoomsFirstStorey(), getFirstStoreyFiles(), getFirstStoreyReaders(), 1);
        ChooseStorey(getRoomsSecondStorey(), getSecondStoreyFiles(), getSecondStoreyReaders(), 2);
        ChooseStorey(getRoomsThirdStorey(), getThirdStoreyFiles(), getThirdStoreyReaders(), 3);
    }

    private void ChooseStorey(Guest[] storey, File[] files, Scanner[] scanners, int storeyNum) {
        switch (storeyNum) {
            case 1: {
                GetOperations(storey, files, scanners);
            }
            break;

            case 2: {
                GetOperations(storey, files, scanners);
            }
            break;

            case 3: {
                GetOperations(storey, files, scanners);
            }
            break;
        }
    }

    private void GetOperations(Guest[] storey, File[] files, Scanner[] scanners) {
        for (int i = 0; i < storey.length; i++) {
            if (files[i].length() == 0) {
                continue;
            }
            scanners[i].close();
            try {
                scanners[i] = new Scanner(files[i]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String nothing = scanners[i].nextLine();
            if (nothing.equals("За почистване")) {
                Path path = Paths.get(files[i].getPath());
                try {
                    Files.newOutputStream(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




