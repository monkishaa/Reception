package utility;

import guest.Guest;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.TimerTask;

public class RemoveGuestsTask extends TimerTask {
    private Guest[] roomsFirstStorey;
    private Guest[] roomsSecondStorey;
    private Guest[] roomsThirdStorey;
    private File[] firstStoreyFiles;
    private File[] secondStoreyFiles;
    private File[] thirdStoreyFiles;
    private JLabel[] greenLight;
    private JLabel[] redLight;
    private JLabel[] blueLight;
    private JLabel[] brooms;
    private PrintStream[] firstStoreyWriters;
    private PrintStream[] secondStoreyWriters;
    private PrintStream[] thirdStoreyWriters;
    private JLabel[] isPaid;
    private JLabel[] isNotPaid;
    private JLabel[] enterRoom;

    public RemoveGuestsTask(Guest[] roomsFirstStorey, Guest[] roomsSecondStorey, Guest[] roomsThirdStorey,
                            File[] firstStoreyFiles, File[] secondStoreyFiles, File[] thirdStoreyFiles,
                            JLabel[] greenLight, JLabel[] redLight, JLabel[] blueLight, JLabel[] brooms,
                            PrintStream[] firstStoreyWriters, PrintStream[] secondStoreyWriters, PrintStream[] thirdStoreyWriters,
                            JLabel[] isPaid, JLabel[] isNotPaid, JLabel[] enterRoom) {
        this.setRoomsFirstStorey(roomsFirstStorey);
        this.setRoomsSecondStorey(roomsSecondStorey);
        this.setRoomsThirdStorey(roomsThirdStorey);
        this.setFirstStoreyFiles(firstStoreyFiles);
        this.setSecondStoreyFiles(secondStoreyFiles);
        this.setThirdStoreyFiles(thirdStoreyFiles);
        this.setGreenLight(greenLight);
        this.setRedLight(redLight);
        this.setBlueLight(blueLight);
        this.setBrooms(brooms);
        this.setFirstStoreyWriters(firstStoreyWriters);
        this.setSecondStoreyWriters(secondStoreyWriters);
        this.setThirdStoreyWriters(thirdStoreyWriters);
        this.setIsPaid(isPaid);
        this.setIsNotPaid(isNotPaid);
        this.setEnterRoom(enterRoom);
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

    private JLabel[] getGreenLight() {
        return greenLight;
    }

    private void setGreenLight(JLabel[] greenLight) {
        this.greenLight = greenLight;
    }

    private JLabel[] getRedLight() {
        return redLight;
    }

    private void setRedLight(JLabel[] redLight) {
        this.redLight = redLight;
    }

    private JLabel[] getBlueLight() {
        return blueLight;
    }

    private void setBlueLight(JLabel[] blueLight) {
        this.blueLight = blueLight;
    }

    private JLabel[] getBrooms() {
        return brooms;
    }

    private void setBrooms(JLabel[] brooms) {
        this.brooms = brooms;
    }

    private PrintStream[] getFirstStoreyWriters() {
        return firstStoreyWriters;
    }

    private void setFirstStoreyWriters(PrintStream[] firstStoreyWriters) {
        this.firstStoreyWriters = firstStoreyWriters;
    }

    private PrintStream[] getSecondStoreyWriters() {
        return secondStoreyWriters;
    }

    private void setSecondStoreyWriters(PrintStream[] secondStoreyWriters) {
        this.secondStoreyWriters = secondStoreyWriters;
    }

    private PrintStream[] getThirdStoreyWriters() {
        return thirdStoreyWriters;
    }

    private void setThirdStoreyWriters(PrintStream[] thirdStoreyWriters) {
        this.thirdStoreyWriters = thirdStoreyWriters;
    }

    private JLabel[] getIsPaid() {
        return isPaid;
    }

    private void setIsPaid(JLabel[] isPaid) {
        this.isPaid = isPaid;
    }

    private JLabel[] getIsNotPaid() {
        return isNotPaid;
    }

    private void setIsNotPaid(JLabel[] isNotPaid) {
        this.isNotPaid = isNotPaid;
    }

    private JLabel[] getEnterRoom() {
        return enterRoom;
    }

    private void setEnterRoom(JLabel[] enterRoom) {
        this.enterRoom = enterRoom;
    }

    @Override
    public void run() {
        ChooseStorey(getRoomsFirstStorey(), getFirstStoreyFiles(), getFirstStoreyWriters(), 1, getIsPaid(), getIsNotPaid());
        ChooseStorey(getRoomsSecondStorey(), getSecondStoreyFiles(), getSecondStoreyWriters(), 2, getIsPaid(), getIsNotPaid());
        ChooseStorey(getRoomsThirdStorey(), getThirdStoreyFiles(), getThirdStoreyWriters(), 3, getIsPaid(), getIsNotPaid());
    }

    private void ChooseStorey(Guest[] storey, File[] files, PrintStream[] printStreams, int storeyNum, JLabel[] isPaid, JLabel[] isNotPaid) {
        switch (storeyNum) {
            case 1: {
                for (int i = 0; i < storey.length; i++) {
                    if (storey[i] == null) {
                        continue;
                    }
                    if (LocalDate.now().equals(storey[i].getCheckingOutDate())) {
                        storey[i] = null;
                        Path path = Paths.get(files[i].getPath());
                        try {
                            Files.newOutputStream(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        printStreams[i].print("За почистване");
                        printStreams[i].flush();
                        getRedLight()[i].setVisible(false);
                        getBlueLight()[i].setVisible(false);
                        getGreenLight()[i].setVisible(true);
                        getBrooms()[i].setVisible(true);
                        getEnterRoom()[i].setVisible(false);
                        isNotPaid[i].setVisible(false);
                        isPaid[i].setVisible(true);
                    }
                }

            } break;

            case 2: {
                for (int i = 0; i < storey.length; i++) {
                    if (storey[i] == null) {
                        continue;
                    }
                    if (LocalDate.now().equals(storey[i].getCheckingOutDate())) {
                        storey[i] = null;
                        Path path = Paths.get(files[i].getPath());
                        try {
                            Files.newOutputStream(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        printStreams[i].print("За почистване");
                        printStreams[i].flush();
                        getRedLight()[i + 5].setVisible(false);
                        getBlueLight()[i + 5].setVisible(false);
                        getGreenLight()[i + 5].setVisible(true);
                        getBrooms()[i + 5].setVisible(true);
                        getEnterRoom()[i + 5].setVisible(false);
                        isNotPaid[i + 5].setVisible(false);
                        isPaid[i + 5].setVisible(true);
                    }
                }
            } break;

            case 3: {
                for (int i = 0; i < storey.length; i++) {
                    if (storey[i] == null) {
                        continue;
                    }
                    if (LocalDate.now().equals(storey[i].getCheckingOutDate())) {
                        storey[i] = null;
                        Path path = Paths.get(files[i].getPath());
                        try {
                            Files.newOutputStream(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        printStreams[i].print("За почистване");
                        printStreams[i].flush();
                        getRedLight()[i + 10].setVisible(false);
                        getBlueLight()[i + 10].setVisible(false);
                        getGreenLight()[i + 10].setVisible(true);
                        getBrooms()[i + 10].setVisible(true);
                        getEnterRoom()[i + 10].setVisible(false);
                        isNotPaid[i + 10].setVisible(false);
                        isPaid[i + 10].setVisible(true);
                    }
                }
            } break;
        }
    }
}
