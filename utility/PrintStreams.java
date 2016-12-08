package utility;

import java.io.PrintStream;

public class PrintStreams {
    private PrintStream noReserved;
    private PrintStream isReserved;

    public PrintStreams(PrintStream noReserved, PrintStream isReserved) {
        this.setNoReserved(noReserved);
        this.setIsReserved(isReserved);
    }

    public PrintStream getNoReserved() {
        return noReserved;
    }

    private void setNoReserved(PrintStream noReserved) {
        this.noReserved = noReserved;
    }

    public PrintStream getIsReserved() {
        return isReserved;
    }

    private void setIsReserved(PrintStream isReserved) {
        this.isReserved = isReserved;
    }
}
