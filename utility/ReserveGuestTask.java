package utility;

import guest.Guest;
import javax.swing.JLabel;
import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.TimerTask;

public class ReserveGuestTask extends TimerTask {
    private Guest[] roomsFirstStorey;
    private Guest[] roomsSecondStorey;
    private Guest[] roomsThirdStorey;
    private Scanner[] firstStoreyReaders;
    private Scanner[] secondStoreyReaders;
    private Scanner[] thirdStoreyReaders;
    private File[] firstStoreyFiles;
    private File[] secondStoreyFiles;
    private File[] thirdStoreyFiles;
    private JLabel[] greenLight;
    private JLabel[] redLight;
    private JLabel[] blueLight;
    private JLabel[] tick;
    private JLabel[] x;
    private JLabel[] dash;

    public ReserveGuestTask(Guest[] roomsFirstStorey, Guest[] roomsSecondStorey, Guest[] roomsThirdStorey,
                            Scanner[] firstStoreyReaders, Scanner[] secondStoreyReaders, Scanner[] thirdStoreyReader,
                            File[] firstStoreyFiles, File[] secondStoreyFiles, File[] thirdStoreyFiles,
                            JLabel[] greenLight, JLabel[] redLight, JLabel[] blueLight,
                            JLabel[] tick, JLabel[] x, JLabel[] dash) {
        this.setRoomsFirstStorey(roomsFirstStorey);
        this.setRoomsSecondStorey(roomsSecondStorey);
        this.setRoomsThirdStorey(roomsThirdStorey);
        this.setFirstStoreyReaders(firstStoreyReaders);
        this.setSecondStoreyReaders(secondStoreyReaders);
        this.setThirdStoreyReaders(thirdStoreyReader);
        this.setGreenLight(greenLight);
        this.setRedLight(redLight);
        this.setBlueLight(blueLight);
        this.setFirstStoreyFiles(firstStoreyFiles);
        this.setSecondStoreyFiles(secondStoreyFiles);
        this.setThirdStoreyFiles(thirdStoreyFiles);
        this.setTick(tick);
        this.setX(x);
        this.setDash(dash);
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

    private void setThirdStoreyReaders(Scanner[] thirdStoreyReader) {
        this.thirdStoreyReaders = thirdStoreyReader;
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

    private JLabel[] getTick() {
        return tick;
    }

    private void setTick(JLabel[] tick) {
        this.tick = tick;
    }

    private JLabel[] getX() {
        return x;
    }

    private void setX(JLabel[] x) {
        this.x = x;
    }

    private JLabel[] getDash() {
        return dash;
    }

    private void setDash(JLabel[] dash) {
        this.dash = dash;
    }

    @Override
    public void run() {
        ChooseStorey(getRoomsFirstStorey(), getFirstStoreyReaders(), getFirstStoreyFiles(), 1);
        ChooseStorey(getRoomsSecondStorey(), getSecondStoreyReaders(), getSecondStoreyFiles(), 2);
        ChooseStorey(getRoomsThirdStorey(), getThirdStoreyReaders(), getThirdStoreyFiles(), 3);
    }

    private void ChooseStorey(Guest[] storey, Scanner[] scanners, File[] files, int storeyNum) {
        switch (storeyNum) {
            case 1: {
                for (int i = 0; i < storey.length; i++) {
                    if (files[i].length() != 0) {
                        String nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        LocalDate offerDate = LocalDate.parse(scanners[i].next());
                        scanners[i].close();
                        if (offerDate.equals(LocalDate.now())) {
                            getGreenLight()[i].setVisible(false);
                            getRedLight()[i].setVisible(false);
                            getBlueLight()[i].setVisible(true);
                            getTick()[i].setVisible(false);
                            getX()[i].setVisible(false);
                            getDash()[i].setVisible(true);
                        }
                    }
                }

            } break;

            case 2: {
                for (int i = 0; i < storey.length; i++) {
                    if (files[i].length() != 0) {
                        String nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        LocalDate offerDate = LocalDate.parse(scanners[i].next());
                        if (offerDate.equals(LocalDate.now())) {
                            getGreenLight()[i + 5].setVisible(false);
                            getRedLight()[i + 5].setVisible(false);
                            getBlueLight()[i + 5].setVisible(true);
                            getTick()[i + 5].setVisible(false);
                            getX()[i + 5].setVisible(false);
                            getDash()[i + 5].setVisible(true);
                        }
                    }
                }
            } break;

            case 3: {
                for (int i = 0; i < storey.length; i++) {
                    if (files[i].length() != 0) {
                        String nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        nothing = scanners[i].next();
                        LocalDate offerDate = LocalDate.parse(scanners[i].next());
                        if (offerDate.equals(LocalDate.now())) {
                            getGreenLight()[i+ 10].setVisible(false);
                            getRedLight()[i + 10].setVisible(false);
                            getBlueLight()[i + 10].setVisible(true);
                            getTick()[i + 10].setVisible(false);
                            getX()[i + 10].setVisible(false);
                            getDash()[i + 10].setVisible(true);
                        }
                    }
                }
            } break;
        }
    }
}
