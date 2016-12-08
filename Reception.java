import guest.*;
import hotel.*;
import utility.*;
import org.freixas.jcalendar.JCalendar;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ConstantConditions")
public class Reception extends JFrame implements ActionListener, FocusListener {

    public static final long serialVersionUID = 1L;
    private static final char[] chars = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ь', 'Ю', 'Я'};
    private static final int BOLD_ITALIC = Font.ITALIC + Font.BOLD;

    private JFrame mainFrame = new JFrame();
    private JFrame rUSureQuitFrame = new JFrame();
    private JFrame rUSureAddGuestFrame = new JFrame();
    private JFrame rUSureReserveRoomFrame = new JFrame();
    private JFrame addNewGuestFrame = new JFrame();
    private JFrame reserveRoomFrame = new JFrame();
    private JFrame moneyFrame = new JFrame();
    private JFrame moneyFrameLater = new JFrame();
    private JFrame changeUserFrame = new JFrame();
    private JFrame guestDataFrame = new JFrame();

    private JButton addGuest = new JButton();
    private JButton reserveRoom = new JButton();
    private JButton changeUser = new JButton();
    private JButton refresh = new JButton();
    private JButton quit = new JButton();
    private JButton submitGuestData;
    private JButton checkGuestData;
    private JButton submitMoneyData;
    private JButton checkMoneyData;
    private JButton checkMoneyDataLater;
    private JButton submitMoneyDataLater;
    private JButton submitReservation;
    private JButton checkReservation;
    private JButton continueMoneyData;
    private JButton continueMoneyDataLater;

    private JTextField firstNameTXT = new JTextField();
    private JTextField secondNameTXT = new JTextField();
    private JTextField thirdNameTXT = new JTextField();
    private JTextField egnTXT = new JTextField();
    private JTextField ageTXT = new JTextField();
    private JTextField nightsTXT = new JTextField();
    private JTextField howManyPeopleReserveTXT = new JTextField();
    private JTextField firstNameReserveTXT = new JTextField();
    private JTextField thirdNameReserveTXT = new JTextField();
    private JTextField howManyPeopleTXT = new JTextField();
    private JTextField nightsReserveTXT = new JTextField();
    private JTextField moneyTXT = new JTextField();
    private JTextField moneyTXTLater = new JTextField();

    private JLabel isCorrect1Name = new JLabel();
    private JLabel isCorrect2Name = new JLabel();
    private JLabel isCorrect3Name = new JLabel();
    private JLabel isCorrectEgn = new JLabel();
    private JLabel isCorrectAge = new JLabel();
    private JLabel isCorrectNights = new JLabel();
    private JLabel isCorrectSex = new JLabel();
    private JLabel isCorrectGuestsNumber = new JLabel();
    private JLabel isCorrectMoney = new JLabel();
    private JLabel isCorrectMoneyLater = new JLabel();
    private JLabel isCorrect1NameReserve = new JLabel();
    private JLabel isCorrect3NameReserve = new JLabel();
    private JLabel isCorrectNightsReserve = new JLabel();
    private JLabel isCorrectGuestsNumberReserve = new JLabel();
    private JLabel isCorrectCalendar = new JLabel();

    private JLabel isIncorrect1Name = new JLabel();
    private JLabel isIncorrect2Name = new JLabel();
    private JLabel isIncorrect3Name = new JLabel();
    private JLabel isIncorrectEgn = new JLabel();
    private JLabel isIncorrectAge = new JLabel();
    private JLabel isIncorrectNights = new JLabel();
    private JLabel isIncorrectSex = new JLabel();
    private JLabel isIncorrectGuestsNumber = new JLabel();
    private JLabel isIncorrectMoney = new JLabel();
    private JLabel isIncorrectMoneyLater = new JLabel();
    private JLabel isIncorrect1NameReserve = new JLabel();
    private JLabel isIncorrect3NameReserve = new JLabel();
    private JLabel isIncorrectNightsReserve = new JLabel();
    private JLabel isIncorrectGuestsNumberReserve = new JLabel();
    private JLabel isIncorrectCalendar = new JLabel();

    private JLabel[] isPaid = new JLabel[15];
    private JLabel[] isNotPaid = new JLabel[15];
    private JLabel[] isReserved = new JLabel[15];
    private JLabel[] isNotClean = new JLabel[15];

    private JLabel getAddQuestion11 = new JLabel();
    private JLabel getAddQuestion12 = new JLabel();
    private JLabel getAddQuestion13 = new JLabel();
    private JLabel getAddQuestion2 = new JLabel();
    private JLabel getAddQuestion3 = new JLabel();
    private JLabel getAddQuestion4 = new JLabel();
    private JLabel getAddQuestion5 = new JLabel();
    private JLabel getAddQuestion6 = new JLabel();
    private JLabel getReserveQuestion11R = new JLabel();
    private JLabel getReserveQuestion12R = new JLabel();
    private JLabel getReserveQuestion2R = new JLabel();
    private JLabel getReserveQuestion3R = new JLabel();
    private JLabel getReserveQuestion4R = new JLabel();

    private JLabel storeyMessage = new JLabel();
    private JLabel storeyMessageLater = new JLabel();
    private JLabel roomMessage = new JLabel();
    private JLabel roomMessageLater = new JLabel();
    private JLabel changeL = new JLabel();
    private JLabel changeLLater = new JLabel();
    private JLabel turnOverLabel = new JLabel();
    private JLabel[] greenLight = new JLabel[15];
    private JLabel[] redLight = new JLabel[15];
    private JLabel[] blueLight = new JLabel[15];
    private JLabel[] enterRoom = new JLabel[15];

    JLabel firstNameData = new JLabel();
    JLabel secondNameData = new JLabel();
    JLabel thirdNameData = new JLabel();
    JLabel ageData = new JLabel();
    JLabel egnData = new JLabel();
    JLabel sexData = new JLabel();
    JLabel nightsData = new JLabel();
    JLabel offerDateData = new JLabel();
    JLabel checkingOutDateData = new JLabel();

    private JCalendar dateChooserReserve = new JCalendar();
    private JCheckBox sexMaleCheckBox = new JCheckBox();
    private JCheckBox sexFemaleCheckBox = new JCheckBox();
    private ButtonGroup sexChooser = new ButtonGroup();
    private String[] currency = {"BGN", "USD"};
    private JComboBox<String> chooseCurrency = new JComboBox<>(currency);
    private JComboBox<String> chooseCurrencyLater = new JComboBox<>(currency);

    private String firstNameGetTXT, secondNameGetTXT, thirdNameGetTXT, egnGetTXT,
            ageGetTXT, nightsGetTXT, firstNameReserveGetTXT, thirdNameReserveGetTXT, howManyPeopleReserveGetTXT, nightsReserveGetTXT, moneyGetTXT, moneyGetTXTLater,
            howManyPeopleGetTXT;
    private int isMale = 0, isFemale = 0;

    private Guest[] roomsFirstStorey, roomsSecondStorey, roomsThirdStorey;
    private Storey storeyFirst, storeySecond, storeyThird;
    private int roomNumberForAddingGuest = -1;

    private String firstNameGuestData, secondNameGuestData, thirdNameGuestData, egnGuestData, sexGuestData, currencyGuestData, currencyGuestDataLater,
            firstNameGuestDataReserve, thirdNameGuestDataReserve;
    private int ageGuestData, nightsGuestData, howManyPeopleGuestData, roomNumGuestData, storeyGuestData, nightsGuestDataReserve, howManyPeopleGuestDataReserve;
    private BigDecimal moneyGuestData, moneyGuestDataLater;
    private LocalDate offerDate;
    private LocalDate checkingOutDate = LocalDate.of(2000, 1, 1);
    private double changeGuestData, changeGuestDataLater;
    private Guest guest;
    private boolean isPaidRoom, isNotPaidRoom, isNotCleanRoom;
    private String username, password;

    private double firstStoreyPrice = 20.0;
    private double secondStoreyPrice = 30.0;
    private double thirdStoreyPrice = 40.0;
    private double turnOver;

    private File firstStorey0File = new File("src\\files\\FirstStorey0.txt");
    private File firstStorey1File = new File("src\\files\\FirstStorey1.txt");
    private File firstStorey2File = new File("src\\files\\FirstStorey2.txt");
    private File firstStorey3File = new File("src\\files\\FirstStorey3.txt");
    private File firstStorey4File = new File("src\\files\\FirstStorey4.txt");

    private File secondStorey0File = new File("src\\files\\SecondStorey0.txt");
    private File secondStorey1File = new File("src\\files\\SecondStorey1.txt");
    private File secondStorey2File = new File("src\\files\\SecondStorey2.txt");
    private File secondStorey3File = new File("src\\files\\SecondStorey3.txt");
    private File secondStorey4File = new File("src\\files\\SecondStorey4.txt");

    private File thirdStorey0File = new File("src\\files\\ThirdStorey0.txt");
    private File thirdStorey1File = new File("src\\files\\ThirdStorey1.txt");
    private File thirdStorey2File = new File("src\\files\\ThirdStorey2.txt");
    private File thirdStorey3File = new File("src\\files\\ThirdStorey3.txt");
    private File thirdStorey4File = new File("src\\files\\ThirdStorey4.txt");

    private FileOutputStream firstStorey0Stream = new FileOutputStream(firstStorey0File, true);
    private FileOutputStream firstStorey1Stream = new FileOutputStream(firstStorey1File, true);
    private FileOutputStream firstStorey2Stream = new FileOutputStream(firstStorey2File, true);
    private FileOutputStream firstStorey3Stream = new FileOutputStream(firstStorey3File, true);
    private FileOutputStream firstStorey4Stream = new FileOutputStream(firstStorey4File, true);

    private FileOutputStream secondStorey0Stream = new FileOutputStream(secondStorey0File, true);
    private FileOutputStream secondStorey1Stream = new FileOutputStream(secondStorey1File, true);
    private FileOutputStream secondStorey2Stream = new FileOutputStream(secondStorey2File, true);
    private FileOutputStream secondStorey3Stream = new FileOutputStream(secondStorey3File, true);
    private FileOutputStream secondStorey4Stream = new FileOutputStream(secondStorey4File, true);

    private FileOutputStream thirdStorey0Stream = new FileOutputStream(thirdStorey0File, true);
    private FileOutputStream thirdStorey1Stream = new FileOutputStream(thirdStorey1File, true);
    private FileOutputStream thirdStorey2Stream = new FileOutputStream(thirdStorey2File, true);
    private FileOutputStream thirdStorey3Stream = new FileOutputStream(thirdStorey3File, true);
    private FileOutputStream thirdStorey4Stream = new FileOutputStream(thirdStorey4File, true);

    private PrintStream firstStorey0Writer = new PrintStream(firstStorey0Stream, true, "windows-1251");
    private PrintStream firstStorey1Writer = new PrintStream(firstStorey1Stream, true, "windows-1251");
    private PrintStream firstStorey2Writer = new PrintStream(firstStorey2Stream, true, "windows-1251");
    private PrintStream firstStorey3Writer = new PrintStream(firstStorey3Stream, true, "windows-1251");
    private PrintStream firstStorey4Writer = new PrintStream(firstStorey4Stream, true, "windows-1251");

    private PrintStream secondStorey0Writer = new PrintStream(secondStorey0Stream, true, "windows-1251");
    private PrintStream secondStorey1Writer = new PrintStream(secondStorey1Stream, true, "windows-1251");
    private PrintStream secondStorey2Writer = new PrintStream(secondStorey2Stream, true, "windows-1251");
    private PrintStream secondStorey3Writer = new PrintStream(secondStorey3Stream, true, "windows-1251");
    private PrintStream secondStorey4Writer = new PrintStream(secondStorey4Stream, true, "windows-1251");

    private PrintStream thirdStorey0Writer = new PrintStream(thirdStorey0Stream, true, "windows-1251");
    private PrintStream thirdStorey1Writer = new PrintStream(thirdStorey1Stream, true, "windows-1251");
    private PrintStream thirdStorey2Writer = new PrintStream(thirdStorey2Stream, true, "windows-1251");
    private PrintStream thirdStorey3Writer = new PrintStream(thirdStorey3Stream, true, "windows-1251");
    private PrintStream thirdStorey4Writer = new PrintStream(thirdStorey4Stream, true, "windows-1251");

    private Scanner firstStorey0Reader = new Scanner(firstStorey0File, "windows-1251");
    private Scanner firstStorey1Reader = new Scanner(firstStorey1File, "windows-1251");
    private Scanner firstStorey2Reader = new Scanner(firstStorey2File, "windows-1251");
    private Scanner firstStorey3Reader = new Scanner(firstStorey3File, "windows-1251");
    private Scanner firstStorey4Reader = new Scanner(firstStorey4File, "windows-1251");

    private Scanner secondStorey0Reader = new Scanner(secondStorey0File, "windows-1251");
    private Scanner secondStorey1Reader = new Scanner(secondStorey1File, "windows-1251");
    private Scanner secondStorey2Reader = new Scanner(secondStorey2File, "windows-1251");
    private Scanner secondStorey3Reader = new Scanner(secondStorey3File, "windows-1251");
    private Scanner secondStorey4Reader = new Scanner(secondStorey4File, "windows-1251");

    private Scanner thirdStorey0Reader = new Scanner(thirdStorey0File, "windows-1251");
    private Scanner thirdStorey1Reader = new Scanner(thirdStorey1File, "windows-1251");
    private Scanner thirdStorey2Reader = new Scanner(thirdStorey2File, "windows-1251");
    private Scanner thirdStorey3Reader = new Scanner(thirdStorey3File, "windows-1251");
    private Scanner thirdStorey4Reader = new Scanner(thirdStorey4File, "windows-1251");

    private File firstStorey0FileReserved = new File("src\\files\\FirstStorey0Reserved.txt");
    private File firstStorey1FileReserved = new File("src\\files\\FirstStorey1Reserved.txt");
    private File firstStorey2FileReserved = new File("src\\files\\FirstStorey2Reserved.txt");
    private File firstStorey3FileReserved = new File("src\\files\\FirstStorey3Reserved.txt");
    private File firstStorey4FileReserved = new File("src\\files\\FirstStorey4Reserved.txt");

    private File secondStorey0FileReserved = new File("src\\files\\SecondStorey0Reserved.txt");
    private File secondStorey1FileReserved = new File("src\\files\\SecondStorey1Reserved.txt");
    private File secondStorey2FileReserved = new File("src\\files\\SecondStorey2Reserved.txt");
    private File secondStorey3FileReserved = new File("src\\files\\SecondStorey3Reserved.txt");
    private File secondStorey4FileReserved = new File("src\\files\\SecondStorey4Reserved.txt");

    private File thirdStorey0FileReserved = new File("src\\files\\ThirdStorey0Reserved.txt");
    private File thirdStorey1FileReserved = new File("src\\files\\ThirdStorey1Reserved.txt");
    private File thirdStorey2FileReserved = new File("src\\files\\ThirdStorey2Reserved.txt");
    private File thirdStorey3FileReserved = new File("src\\files\\ThirdStorey3Reserved.txt");
    private File thirdStorey4FileReserved = new File("src\\files\\ThirdStorey4Reserved.txt");

    private FileOutputStream firstStorey0StreamReserved = new FileOutputStream(firstStorey0FileReserved, true);
    private FileOutputStream firstStorey1StreamReserved = new FileOutputStream(firstStorey1FileReserved, true);
    private FileOutputStream firstStorey2StreamReserved = new FileOutputStream(firstStorey2FileReserved, true);
    private FileOutputStream firstStorey3StreamReserved = new FileOutputStream(firstStorey3FileReserved, true);
    private FileOutputStream firstStorey4StreamReserved = new FileOutputStream(firstStorey4FileReserved, true);

    private FileOutputStream secondStorey0StreamReserved = new FileOutputStream(secondStorey0FileReserved, true);
    private FileOutputStream secondStorey1StreamReserved = new FileOutputStream(secondStorey1FileReserved, true);
    private FileOutputStream secondStorey2StreamReserved = new FileOutputStream(secondStorey2FileReserved, true);
    private FileOutputStream secondStorey3StreamReserved = new FileOutputStream(secondStorey3FileReserved, true);
    private FileOutputStream secondStorey4StreamReserved = new FileOutputStream(secondStorey4FileReserved, true);

    private FileOutputStream thirdStorey0StreamReserved = new FileOutputStream(thirdStorey0FileReserved, true);
    private FileOutputStream thirdStorey1StreamReserved = new FileOutputStream(thirdStorey1FileReserved, true);
    private FileOutputStream thirdStorey2StreamReserved = new FileOutputStream(thirdStorey2FileReserved, true);
    private FileOutputStream thirdStorey3StreamReserved = new FileOutputStream(thirdStorey3FileReserved, true);
    private FileOutputStream thirdStorey4StreamReserved = new FileOutputStream(thirdStorey4FileReserved, true);

    private PrintStream firstStorey0WriterReserved = new PrintStream(firstStorey0StreamReserved, true, "windows-1251");
    private PrintStream firstStorey1WriterReserved = new PrintStream(firstStorey1StreamReserved, true, "windows-1251");
    private PrintStream firstStorey2WriterReserved = new PrintStream(firstStorey2StreamReserved, true, "windows-1251");
    private PrintStream firstStorey3WriterReserved = new PrintStream(firstStorey3StreamReserved, true, "windows-1251");
    private PrintStream firstStorey4WriterReserved = new PrintStream(firstStorey4StreamReserved, true, "windows-1251");

    private PrintStream secondStorey0WriterReserved = new PrintStream(secondStorey0StreamReserved, true, "windows-1251");
    private PrintStream secondStorey1WriterReserved = new PrintStream(secondStorey1StreamReserved, true, "windows-1251");
    private PrintStream secondStorey2WriterReserved = new PrintStream(secondStorey2StreamReserved, true, "windows-1251");
    private PrintStream secondStorey3WriterReserved = new PrintStream(secondStorey3StreamReserved, true, "windows-1251");
    private PrintStream secondStorey4WriterReserved = new PrintStream(secondStorey4StreamReserved, true, "windows-1251");

    private PrintStream thirdStorey0WriterReserved = new PrintStream(thirdStorey0StreamReserved, true, "windows-1251");
    private PrintStream thirdStorey1WriterReserved = new PrintStream(thirdStorey1StreamReserved, true, "windows-1251");
    private PrintStream thirdStorey2WriterReserved = new PrintStream(thirdStorey2StreamReserved, true, "windows-1251");
    private PrintStream thirdStorey3WriterReserved = new PrintStream(thirdStorey3StreamReserved, true, "windows-1251");
    private PrintStream thirdStorey4WriterReserved = new PrintStream(thirdStorey4StreamReserved, true, "windows-1251");

    private Scanner firstStorey0ReaderReserved = new Scanner(firstStorey0FileReserved, "windows-1251");
    private Scanner firstStorey1ReaderReserved = new Scanner(firstStorey1FileReserved, "windows-1251");
    private Scanner firstStorey2ReaderReserved = new Scanner(firstStorey2FileReserved, "windows-1251");
    private Scanner firstStorey3ReaderReserved = new Scanner(firstStorey3FileReserved, "windows-1251");
    private Scanner firstStorey4ReaderReserved = new Scanner(firstStorey4FileReserved, "windows-1251");

    private Scanner secondStorey0ReaderReserved = new Scanner(secondStorey0FileReserved, "windows-1251");
    private Scanner secondStorey1ReaderReserved = new Scanner(secondStorey1FileReserved, "windows-1251");
    private Scanner secondStorey2ReaderReserved = new Scanner(secondStorey2FileReserved, "windows-1251");
    private Scanner secondStorey3ReaderReserved = new Scanner(secondStorey3FileReserved, "windows-1251");
    private Scanner secondStorey4ReaderReserved = new Scanner(secondStorey4FileReserved, "windows-1251");

    private Scanner thirdStorey0ReaderReserved = new Scanner(thirdStorey0FileReserved, "windows-1251");
    private Scanner thirdStorey1ReaderReserved = new Scanner(thirdStorey1FileReserved, "windows-1251");
    private Scanner thirdStorey2ReaderReserved = new Scanner(thirdStorey2FileReserved, "windows-1251");
    private Scanner thirdStorey3ReaderReserved = new Scanner(thirdStorey3FileReserved, "windows-1251");
    private Scanner thirdStorey4ReaderReserved = new Scanner(thirdStorey4FileReserved, "windows-1251");

    private File[] firstStoreyFilesReserved = {firstStorey0FileReserved, firstStorey1FileReserved, firstStorey2FileReserved, firstStorey3FileReserved, firstStorey4FileReserved};
    private File[] secondStoreyFilesReserved = {secondStorey0FileReserved, secondStorey1FileReserved, secondStorey2FileReserved, secondStorey3FileReserved, secondStorey4FileReserved};
    private File[] thirdStoreyFilesReserved = {thirdStorey0FileReserved, thirdStorey1FileReserved, thirdStorey2FileReserved, thirdStorey3FileReserved, thirdStorey4FileReserved};

    private File[] firstStoreyFiles = {firstStorey0File, firstStorey1File, firstStorey2File, firstStorey3File, firstStorey4File};
    private File[] secondStoreyFiles = {secondStorey0File, secondStorey1File, secondStorey2File, secondStorey3File, secondStorey4File};
    private File[] thirdStoreyFiles = {thirdStorey0File, thirdStorey1File, thirdStorey2File, thirdStorey3File, thirdStorey4File};

    private Scanner[] firstStoreyReadersReserved = {firstStorey0ReaderReserved, firstStorey1ReaderReserved, firstStorey2ReaderReserved, firstStorey3ReaderReserved, firstStorey4ReaderReserved};
    private Scanner[] secondStoreyReadersReserved = {secondStorey0ReaderReserved, secondStorey1ReaderReserved, secondStorey2ReaderReserved, secondStorey3ReaderReserved, secondStorey4ReaderReserved};
    private Scanner[] thirdStoreyReadersReserved = {thirdStorey0ReaderReserved, thirdStorey1ReaderReserved, thirdStorey2ReaderReserved, thirdStorey3ReaderReserved, thirdStorey4ReaderReserved};

    private Scanner[] firstStoreyReaders = {firstStorey0Reader, firstStorey1Reader, firstStorey2Reader, firstStorey3Reader, firstStorey4Reader};
    private Scanner[] secondStoreyReaders = {secondStorey0Reader, secondStorey1Reader, secondStorey2Reader, secondStorey3Reader, secondStorey4Reader};
    private Scanner[] thirdStoreyReaders = {thirdStorey0Reader, thirdStorey1Reader, thirdStorey2Reader, thirdStorey3Reader, thirdStorey4Reader};

    private PrintStream[] firstStoreyWriters = {firstStorey0Writer, firstStorey1Writer, firstStorey2Writer, firstStorey3Writer, firstStorey4Writer};
    private PrintStream[] secondStoreyWriters = {secondStorey0Writer, secondStorey1Writer, secondStorey2Writer, secondStorey3Writer, secondStorey4Writer};
    private PrintStream[] thirdStoreyWriters = {thirdStorey0Writer, thirdStorey1Writer, thirdStorey2Writer, thirdStorey3Writer, thirdStorey4Writer};

    private File moneyFile = new File("src\\files\\Money.txt");
    private Path path = Paths.get(moneyFile.getPath());
    private PrintStream moneyWriter = new PrintStream(new FileOutputStream(moneyFile, true));
    private Scanner moneyReader = new Scanner(moneyFile);

    public static void main(String[] args) throws IOException, OutOfRangeLettersException, FirstLetterException, NameException, OutOfRangeException, EGNNumberException, EGNException {
        new Reception();
    }

    private Reception() throws IOException, OutOfRangeLettersException, FirstLetterException, NameException, OutOfRangeException, EGNNumberException, EGNException {

        ImageIcon imageIcon = new ImageIcon("src\\images\\logo.png");

        //mainFrame defining
        mainFrame.setTitle("Рецепция");
        mainFrame.setSize(912, 725);
        mainFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setContentPane(new BackgroundPanel());
        mainFrame.setLayout(null);
        mainFrame.setIconImage(imageIcon.getImage());
        mainFrame.setVisible(false);
        Container containerPane = mainFrame.getContentPane();

        JLabel hotelName = new JLabel(new ImageIcon("src\\images\\hotel_name.png"));
        hotelName.setBounds(20 , -29, 900, 121);

        MakeStoreys(containerPane);

        if (moneyFile.length() != 0) {
            moneyReader.close();
            moneyReader = new Scanner(moneyFile);
            turnOver = Double.parseDouble(moneyReader.next());
        }

        JLabel usernameLabelForMainFrame = new JLabel();
        usernameLabelForMainFrame.setBounds(718, 92, 200, 40);
        usernameLabelForMainFrame.setFont(new Font("Times New Roman", Font.ITALIC, 22));
        usernameLabelForMainFrame.setForeground(Color.BLACK);
        containerPane.add(usernameLabelForMainFrame);

        turnOverLabel.setBounds(115, 92, 200, 40);
        turnOverLabel.setFont(new Font("Times New Roman", Font.ITALIC, 22));
        turnOverLabel.setText(String.format("%.2fBGN", turnOver));
        turnOverLabel.setForeground(Color.BLACK);
        containerPane.add(turnOverLabel);

        addGuest.setText("Добави гост");
        addGuest.setToolTipText("Ако желаете да добавите гост, кликнете тук.");
        addGuest.addActionListener(
                e -> {
                    mainFrame.setVisible(false);
                    addNewGuestFrame.setVisible(true);
                    submitMoneyData.setVisible(true);
                }
        );
        addGuest.setLocation(22, 65);

        reserveRoom.setText("Резервирай стая");
        reserveRoom.setToolTipText("Ако желаете да резервирате стая, кликнете тук.");
        reserveRoom.addActionListener(
                e -> {
                    mainFrame.setVisible(false);
                    reserveRoomFrame.setVisible(true);
                }
        );
        reserveRoom.setLocation(212, 65);

        refresh.setText("Обнови");
        refresh.setToolTipText("Ако желаете да видите печалбата, кликнете тук.");
        refresh.addActionListener(
                e -> {
                    refresh.setEnabled(false);
                    turnOverLabel.setText(String.format("%.2fBGN", turnOver));
                }
        );
        refresh.setLocation(402, 65);

        changeUser.setText("Смени потребителя");
        changeUser.setToolTipText("Ако желаете да смените потребителя, кликнете тук.");
        changeUser.addActionListener(
                e -> {
                    mainFrame.setVisible(false);
                    changeUserFrame.setVisible(true);
                }
        );
        changeUser.setLocation(592, 65);

        quit.setText("Изход");
        quit.setToolTipText("Ако желаете да излезете, кликнете тук.");
        quit.addActionListener(
                e -> {
                    rUSureQuitFrame.setVisible(true);
                    mainFrame.setVisible(false);
                }
        );
        quit.setLocation(782, 65);

        JButton[] jButtons = {addGuest, changeUser, reserveRoom, refresh, quit};
        for (JButton button : jButtons) {
            button.setSize(190, 33);
            button.setFont(new Font("Times New Roman", Font.BOLD, 17));
            button.setEnabled(false);
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            containerPane.add(button);
        } quit.setSize(100, 33);

        containerPane.add(hotelName);

        //rUSureQuitFrame defining
        rUSureQuitFrame.setTitle("Сигурен?");
        rUSureQuitFrame.setSize(276, 178);
        rUSureQuitFrame.setResizable(false);
        rUSureQuitFrame.setLocationRelativeTo(null);
        rUSureQuitFrame.setLayout(null);
        rUSureQuitFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        rUSureQuitFrame.setIconImage(imageIcon.getImage());
        rUSureQuitFrame.setVisible(false);

        Container rUSureQuitContainer = new Container();
        rUSureQuitContainer.setSize(rUSureQuitFrame.getSize());
        rUSureQuitFrame.setContentPane(rUSureQuitContainer);

        JLabel exitQuestion = new JLabel("Сигурен ли сте, че");
        exitQuestion.setFont(new Font("Arial", Font.BOLD, 14));
        exitQuestion.setBounds(105, 31, 150, 30);
        rUSureQuitContainer.add(exitQuestion);

        JLabel exitQuestion1 = new JLabel("искате да излезете?");
        exitQuestion1.setFont(new Font("Arial", Font.BOLD, 14));
        exitQuestion1.setBounds(105, 51, 150, 30);
        rUSureQuitContainer.add(exitQuestion1);

        JLabel questionMark = new JLabel(new ImageIcon("src\\images\\question.png"));
        questionMark.setBounds(20, 20, 70, 70);
        rUSureQuitContainer.add(questionMark);

        JButton yes = new JButton("Да");
        yes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        yes.setBounds(20, 105, 90, 30);
        yes.setFont(new Font("Arial", Font.BOLD, 16));
        yes.addActionListener(
                e -> {
                    rUSureQuitFrame.setVisible(false);
                    System.exit(0);
                }
        );
        rUSureQuitContainer.add(yes);

        JButton no = new JButton("Не");
        no.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        no.setBounds(162, 105, 90, 30);
        no.setFont(new Font("Arial", Font.BOLD, 16));
        no.addActionListener(
                e -> {
                    rUSureQuitFrame.setVisible(false);
                    mainFrame.setVisible(true);
                }
        );
        rUSureQuitContainer.add(no);


        //rUSureAddGuestFrame defining
        rUSureAddGuestFrame.setTitle("Сигурен?");
        rUSureAddGuestFrame.setSize(422, 298);
        rUSureAddGuestFrame.setResizable(false);
        rUSureAddGuestFrame.setLocationRelativeTo(null);
        rUSureAddGuestFrame.setLayout(null);
        rUSureAddGuestFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        rUSureAddGuestFrame.setIconImage(imageIcon.getImage());
        rUSureAddGuestFrame.setVisible(false);

        Container rUSureAddGuestContainer = new Container();
        rUSureAddGuestContainer.setSize(rUSureAddGuestFrame.getSize());
        rUSureAddGuestFrame.setContentPane(rUSureAddGuestContainer);

        JLabel questionAddGuest0 = new JLabel("Вие въведохте следните данни:");
        JLabel questionAddGuest11 = new JLabel("Име:");
        JLabel questionAddGuest12 = new JLabel("Презиме:");
        JLabel questionAddGuest13 = new JLabel("Фамилия:");
        JLabel questionAddGuest2 = new JLabel("ЕГН:");
        JLabel questionAddGuest3 = new JLabel("Възраст:");
        JLabel questionAddGuest4 = new JLabel("Ношувки:");
        JLabel questionAddGuest5 = new JLabel("Тип на стая:");
        JLabel questionAddGuest6 = new JLabel("Пол:");
        JLabel questionAddGuest7 = new JLabel("Сигурен ли сте?");

        JLabel[] questionAddGuest = {questionAddGuest0, questionAddGuest11, questionAddGuest12, questionAddGuest13, questionAddGuest2,
                questionAddGuest3, questionAddGuest4, questionAddGuest5, questionAddGuest6, questionAddGuest7};

        for (JLabel label : questionAddGuest) {
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            rUSureAddGuestContainer.add(label);
        }
        questionAddGuest0.setFont(new Font("Arial", Font.BOLD, 16));
        questionAddGuest7.setFont(new Font("Arial", Font.BOLD, 16));

        //positions
        questionAddGuest0.setBounds(110, 10, 300, 30);
        questionAddGuest11.setBounds(110, 30, 150, 30);
        questionAddGuest12.setBounds(110, 50, 150, 30);
        questionAddGuest13.setBounds(110, 70, 150, 30);
        questionAddGuest2.setBounds(110, 90, 150, 30);
        questionAddGuest3.setBounds(110, 110, 150, 30);
        questionAddGuest4.setBounds(110, 130, 150, 30);
        questionAddGuest5.setBounds(110, 150, 150, 30);
        questionAddGuest6.setBounds(110, 170, 150, 30);
        questionAddGuest7.setBounds(110, 190, 150, 30);

        JLabel[] getAddQuestion = {getAddQuestion11, getAddQuestion12, getAddQuestion13, getAddQuestion2, getAddQuestion3, getAddQuestion4, getAddQuestion5, getAddQuestion6};
        for (JLabel label : getAddQuestion) {
            label.setFont(new Font("Arial", Font.ITALIC, 14));
            label.setText(null);
            rUSureAddGuestContainer.add(label);
        }

        //positions
        getAddQuestion11.setBounds(220, 30, 200, 30);
        getAddQuestion12.setBounds(220, 50, 200, 30);
        getAddQuestion13.setBounds(220, 70, 200, 30);
        getAddQuestion2.setBounds(220, 90, 200, 30);
        getAddQuestion3.setBounds(220, 110, 200, 30);
        getAddQuestion4.setBounds(220, 130, 200, 30);
        getAddQuestion5.setBounds(220, 150, 200, 30);
        getAddQuestion6.setBounds(220, 170, 200, 30);

        JLabel questionMark1 = new JLabel(new ImageIcon("src\\images\\question.png"));
        questionMark1.setBounds(20, 20, 70, 70);
        rUSureAddGuestContainer.add(questionMark1);

        JButton yesAdding = new JButton("Да");
        yesAdding.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        yesAdding.setFont(new Font("Arial", Font.BOLD, 16));
        yesAdding.setBounds(20, 225, 90, 30);
        yesAdding.addActionListener(
                e -> {
                    rUSureAddGuestFrame.setVisible(false);
                    moneyFrame.setVisible(true);
                }
        );
        rUSureAddGuestContainer.add(yesAdding);

        JButton noAdding = new JButton("Не");
        noAdding.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        noAdding.setFont(new Font("Arial", Font.BOLD, 16));
        noAdding.setBounds(306, 225, 90, 30);
        noAdding.addActionListener(
                e -> {
                    rUSureAddGuestFrame.setVisible(false);
                    addNewGuestFrame.setVisible(true);

                    submitGuestData.setEnabled(false);
                    checkGuestData.setEnabled(true);
                    firstNameTXT.setEditable(true);
                    secondNameTXT.setEditable(true);
                    thirdNameTXT.setEditable(true);
                    egnTXT.setEditable(true);
                    ageTXT.setEditable(true);
                    nightsTXT.setEditable(true);
                    howManyPeopleTXT.setEditable(true);
                    sexMaleCheckBox.setEnabled(true);
                    sexFemaleCheckBox.setEnabled(true);
                }
        );
        rUSureAddGuestContainer.add(noAdding);


        //rUSureReserveRoomFrame defining
        rUSureReserveRoomFrame.setTitle("Сигурен?");
        rUSureReserveRoomFrame.setSize(422, 238);
        rUSureReserveRoomFrame.setResizable(false);
        rUSureReserveRoomFrame.setLocationRelativeTo(null);
        rUSureReserveRoomFrame.setLayout(null);
        rUSureReserveRoomFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        rUSureReserveRoomFrame.setIconImage(imageIcon.getImage());
        rUSureReserveRoomFrame.setVisible(false);

        Container rUSureReserveRoomContainer = new Container();
        rUSureReserveRoomContainer.setSize(rUSureReserveRoomFrame.getSize());
        rUSureReserveRoomFrame.setContentPane(rUSureReserveRoomContainer);

        JLabel questionReserveRoomR0 = new JLabel("Вие въведохте следните данни:");
        JLabel questionReserveRoomR11 = new JLabel("Име:");
        JLabel questionReserveRoomR12 = new JLabel("Фамилия:");
        JLabel questionReserveRoomR2 = new JLabel("Ношувки:");
        JLabel questionReserveRoomR3 = new JLabel("Тип на стая:");
        JLabel questionReserveRoomR4 = new JLabel("Дата:");
        JLabel questionReserveRoomR5 = new JLabel("Сигурен ли сте?");

        JLabel[] questionReserveRoom = {questionReserveRoomR0, questionReserveRoomR11, questionReserveRoomR12, questionReserveRoomR2, questionReserveRoomR3, questionReserveRoomR4, questionReserveRoomR5};
        for (JLabel label : questionReserveRoom) {
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            rUSureReserveRoomContainer.add(label);
        }
        questionReserveRoomR0.setFont(new Font("Arial", Font.BOLD, 16));
        questionReserveRoomR5.setFont(new Font("Arial", Font.BOLD, 16));

        //positions
        questionReserveRoomR0.setBounds(110, 10, 300, 30);
        questionReserveRoomR11.setBounds(110, 30, 150, 30);
        questionReserveRoomR12.setBounds(110, 50, 150, 30);
        questionReserveRoomR2.setBounds(110, 70, 150, 30);
        questionReserveRoomR3.setBounds(110, 90, 150, 30);
        questionReserveRoomR4.setBounds(110, 110, 150, 30);
        questionReserveRoomR5.setBounds(110, 130, 150, 30);

        JLabel[] getReserveQuestion = {getReserveQuestion11R, getReserveQuestion12R, getReserveQuestion2R, getReserveQuestion3R, getReserveQuestion4R};
        for (JLabel label : getReserveQuestion) {
            label.setFont(new Font("Arial", Font.ITALIC, 14));
            label.setText(null);
            rUSureReserveRoomContainer.add(label);
        }

        //positions
        getReserveQuestion11R.setBounds(220, 30, 200, 30);
        getReserveQuestion12R.setBounds(220, 50, 200, 30);
        getReserveQuestion2R.setBounds(220, 70, 200, 30);
        getReserveQuestion3R.setBounds(220, 90, 200, 30);
        getReserveQuestion4R.setBounds(220, 110, 200, 30);

        JLabel questionMarkR = new JLabel(new ImageIcon("src\\images\\question.png"));
        questionMarkR.setBounds(20, 20, 70, 70);
        rUSureReserveRoomContainer.add(questionMarkR);

        JButton yesReserve = new JButton("Да");
        yesReserve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        yesReserve.setFont(new Font("Arial", Font.BOLD, 16));
        yesReserve.setBounds(20, 165, 90, 30);
        yesReserve.addActionListener(e -> GetYesReservedOperations());
        rUSureReserveRoomContainer.add(yesReserve);

        JButton noReserve = new JButton("Не");
        noReserve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        noReserve.setFont(new Font("Arial", Font.BOLD, 16));
        noReserve.setBounds(306, 165, 90, 30);
        noReserve.addActionListener(
                e -> {
                    rUSureReserveRoomFrame.setVisible(false);
                    reserveRoomFrame.setVisible(true);

                    submitReservation.setEnabled(false);
                    checkReservation.setEnabled(true);
                    firstNameReserveTXT.setEditable(true);
                    thirdNameReserveTXT.setEditable(true);
                    nightsReserveTXT.setEditable(true);
                    howManyPeopleReserveTXT.setEditable(true);
                }
        );
        rUSureReserveRoomContainer.add(noReserve);


        //money frame defining
        moneyFrame.setTitle("Изчисляване на парите");
        moneyFrame.setSize(389, 212);
        moneyFrame.setResizable(false);
        moneyFrame.setLocationRelativeTo(null);
        moneyFrame.setLayout(null);
        moneyFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        moneyFrame.setIconImage(imageIcon.getImage());
        moneyFrame.setVisible(false);

        Container moneyContainer = new Container();
        moneyContainer.setSize(371, 212);
        moneyFrame.setContentPane(moneyContainer);

        JLabel headingMoney = new JLabel();
        headingMoney.setText("Данни за парите");
        headingMoney.setFont(new Font("Arial", BOLD_ITALIC, 25));
        headingMoney.setBounds(90, 10, 300, 40);
        moneyContainer.add(headingMoney);

        JLabel moneyL = new JLabel();
        moneyL.setText("Въведете пари:");
        moneyTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        moneyGetTXT = moneyTXT.getText();
                    }
                }
        );
        moneyL.setFont(new Font("Arial", Font.BOLD, 16));
        moneyL.setBounds(20, 60, 140, 30);
        moneyContainer.add(moneyL);

        moneyTXT.setFont(new Font("Arial", Font.ITALIC, 16));
        moneyTXT.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        moneyTXT.setBounds(153, 60, 100, 30);
        moneyContainer.add(moneyTXT);

        chooseCurrency.setFont(new Font("Arial", Font.ITALIC, 16));
        chooseCurrency.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chooseCurrency.setBounds(265, 59, 80, 30);
        chooseCurrency.addActionListener(e -> currencyGuestData = (String) chooseCurrency.getSelectedItem());
        moneyContainer.add(chooseCurrency);

        JLabel changeLabel = new JLabel();
        changeLabel.setText("Ресто:");
        changeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        changeLabel.setBounds(20, 95, 80, 30);
        moneyContainer.add(changeLabel);

        changeL.setFont(new Font("Arial", Font.ITALIC, 16));
        changeL.setBounds(100, 95, 150, 30);
        moneyContainer.add(changeL);

        isCorrectMoney.setIcon(new ImageIcon("src\\images\\correct.png"));
        isCorrectMoney.setBounds(353, 61, 10, 26);
        isCorrectMoney.setVisible(false);
        moneyContainer.add(isCorrectMoney);

        isIncorrectMoney.setIcon(new ImageIcon("src\\images\\incorrect.png"));
        isIncorrectMoney.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        isIncorrectMoney.setBounds(353, 61, 10, 26);
        isIncorrectMoney.setVisible(false);
        moneyContainer.add(isIncorrectMoney);

        roomMessage.setFont(new Font("Arial", Font.BOLD, 16));
        roomMessage.setBounds(175, 135, 120, 30);
        moneyContainer.add(roomMessage);

        storeyMessage.setFont(new Font("Arial", Font.BOLD, 16));
        storeyMessage.setBounds(20, 135, 120, 30);
        moneyContainer.add(storeyMessage);

        continueMoneyData = new JButton();
        continueMoneyData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        continueMoneyData.setBounds(333, 135, 30, 30);
        continueMoneyData.addActionListener(e -> GetContinueOperationsAddGuest());
        continueMoneyData.setIcon(new ImageIcon("src\\images\\continue_button.png"));
        continueMoneyData.setEnabled(false);
        continueMoneyData.setVisible(false);
        moneyContainer.add(continueMoneyData);

        checkMoneyData = new JButton("Проверка");
        checkMoneyData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkMoneyData.setBounds(20, 135, 120, 30);
        checkMoneyData.setFont(new Font("Arial", Font.BOLD, 16));
        checkMoneyData.addActionListener(e -> GetCheckMoneyOperations());
        moneyContainer.add(checkMoneyData);

        submitMoneyData = new JButton("Въведи");
        submitMoneyData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitMoneyData.setBounds(241, 135, 120, 30);
        submitMoneyData.setFont(new Font("Arial", Font.BOLD, 16));
        submitMoneyData.addActionListener(e -> GetSubmitMoneyOperations());
        submitMoneyData.setVisible(true);
        submitMoneyData.setEnabled(false);
        moneyContainer.add(submitMoneyData);


        //money frame later defining
        moneyFrameLater.setTitle("Изчисляване на парите");
        moneyFrameLater.setSize(389, 212);
        moneyFrameLater.setResizable(false);
        moneyFrameLater.setLocationRelativeTo(null);
        moneyFrameLater.setLayout(null);
        moneyFrameLater.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        moneyFrameLater.setIconImage(imageIcon.getImage());
        moneyFrameLater.setVisible(false);

        Container moneyContainerLater = new Container();
        moneyContainer.setSize(371, 212);
        moneyFrameLater.setContentPane(moneyContainerLater);

        JLabel headingMoneyLater = new JLabel();
        headingMoneyLater.setText("Данни за парите");
        headingMoneyLater.setFont(new Font("Arial", BOLD_ITALIC, 25));
        headingMoneyLater.setBounds(90, 10, 300, 40);
        moneyContainerLater.add(headingMoneyLater);

        JLabel moneyLLater = new JLabel();
        moneyLLater.setText("Въведете пари:");
        moneyTXTLater.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        moneyGetTXTLater = moneyTXTLater.getText();
                    }
                }
        );
        moneyLLater.setFont(new Font("Arial", Font.BOLD, 16));
        moneyLLater.setBounds(20, 60, 140, 30);
        moneyContainerLater.add(moneyLLater);

        moneyTXTLater.setFont(new Font("Arial", Font.ITALIC, 16));
        moneyTXTLater.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        moneyTXTLater.setBounds(153, 60, 100, 30);
        moneyContainerLater.add(moneyTXTLater);

        chooseCurrencyLater.setFont(new Font("Arial", Font.ITALIC, 16));
        chooseCurrencyLater.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chooseCurrencyLater.setBounds(265, 59, 80, 30);
        chooseCurrencyLater.addActionListener(e -> currencyGuestDataLater = (String) chooseCurrencyLater.getSelectedItem());
        moneyContainerLater.add(chooseCurrencyLater);

        JLabel changeLabelLater = new JLabel();
        changeLabelLater.setText("Ресто:");
        changeLabelLater.setFont(new Font("Arial", Font.BOLD, 16));
        changeLabelLater.setBounds(20, 95, 80, 30);
        moneyContainerLater.add(changeLabelLater);

        changeLLater.setFont(new Font("Arial", Font.ITALIC, 16));
        changeLLater.setBounds(100, 95, 150, 30);
        moneyContainerLater.add(changeLLater);

        isCorrectMoneyLater.setIcon(new ImageIcon("src\\images\\correct.png"));
        isCorrectMoneyLater.setBounds(353, 61, 10, 26);
        isCorrectMoneyLater.setVisible(false);
        moneyContainerLater.add(isCorrectMoneyLater);

        isIncorrectMoneyLater.setIcon(new ImageIcon("src\\images\\incorrect.png"));
        isIncorrectMoneyLater.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        isIncorrectMoneyLater.setBounds(353, 61, 10, 26);
        isIncorrectMoneyLater.setVisible(false);
        moneyContainerLater.add(isIncorrectMoneyLater);

        roomMessageLater.setFont(new Font("Arial", Font.BOLD, 16));
        roomMessageLater.setBounds(175, 135, 120, 30);
        moneyContainerLater.add(roomMessageLater);

        storeyMessageLater.setFont(new Font("Arial", Font.BOLD, 16));
        storeyMessageLater.setBounds(20, 135, 120, 30);
        moneyContainerLater.add(storeyMessageLater);

        continueMoneyDataLater = new JButton();
        continueMoneyDataLater.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        continueMoneyDataLater.setBounds(333, 135, 30, 30);
        continueMoneyDataLater.addActionListener(e -> GetContinueOperationsAddGuestLater());
        continueMoneyDataLater.setIcon(new ImageIcon("src\\images\\continue_button.png"));
        continueMoneyDataLater.setEnabled(false);
        continueMoneyDataLater.setVisible(false);
        moneyContainerLater.add(continueMoneyDataLater);

        checkMoneyDataLater = new JButton("Проверка");
        checkMoneyDataLater.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkMoneyDataLater.setBounds(20, 135, 120, 30);
        checkMoneyDataLater.setFont(new Font("Arial", Font.BOLD, 16));
        moneyContainerLater.add(checkMoneyDataLater);

        submitMoneyDataLater = new JButton("Въведи");
        submitMoneyDataLater.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitMoneyDataLater.setBounds(241, 135, 120, 30);
        submitMoneyDataLater.setFont(new Font("Arial", Font.BOLD, 16));
        submitMoneyDataLater.setVisible(true);
        submitMoneyDataLater.setEnabled(false);
        moneyContainerLater.add(submitMoneyDataLater);


        //addGuest frame defining
        addNewGuestFrame.setTitle("Добавяне на гост");
        addNewGuestFrame.setSize(408, 418);
        addNewGuestFrame.setResizable(false);
        addNewGuestFrame.setLocationRelativeTo(null);
        addNewGuestFrame.setLayout(null);
        addNewGuestFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addNewGuestFrame.setIconImage(imageIcon.getImage());
        addNewGuestFrame.setVisible(false);

        Container addGuestContainer = new Container();
        addGuestContainer.setSize(addNewGuestFrame.getSize());
        addNewGuestFrame.setContentPane(addGuestContainer);

        JLabel headingAddGuest = new JLabel();
        headingAddGuest.setText("Попълнете данните");
        headingAddGuest.setFont(new Font("Arial", BOLD_ITALIC, 25));
        headingAddGuest.setBounds(35, 10, 300, 40);
        addGuestContainer.add(headingAddGuest);

        JLabel firstNameL = new JLabel();
        firstNameL.setText("Въведете име:");
        firstNameTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        firstNameGetTXT = firstNameTXT.getText();
                    }
                }
        );

        JLabel secondNameL = new JLabel();
        secondNameL.setText("Въведете презиме:");
        secondNameTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        secondNameGetTXT = secondNameTXT.getText();
                    }
                }
        );

        JLabel thirdNameL = new JLabel();
        thirdNameL.setText("Въведете фамилия:");
        thirdNameTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        thirdNameGetTXT = thirdNameTXT.getText();
                    }
                }
        );

        JLabel egnL = new JLabel();
        egnL.setText("Въведете ЕГН:");
        egnTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        egnGetTXT = egnTXT.getText();
                    }
                }
        );

        JLabel ageL = new JLabel();
        ageL.setText("Въведете възраст:");
        ageTXT.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        ageTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        ageGetTXT = ageTXT.getText();
                    }
                }
        );

        JLabel nightsL = new JLabel();
        nightsL.setText("Въведете нощувки:");
        nightsTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        nightsGetTXT = nightsTXT.getText();
                    }
                }
        );

        JLabel howManyPeopleL = new JLabel();
        howManyPeopleL.setText("Въведете тип стая:");
        howManyPeopleTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        howManyPeopleGetTXT = howManyPeopleTXT.getText();
                    }
                }
        );

        JLabel sexL = new JLabel();
        sexL.setText("Въведете пол:");

        JLabel[] nameLabels = {firstNameL, secondNameL, thirdNameL, egnL, ageL, sexL, nightsL, howManyPeopleL};
        for (JLabel label : nameLabels) {
            addGuestContainer.add(label);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setSize(170, 30);
        }

        JTextField[] nameFields = {firstNameTXT, secondNameTXT, thirdNameTXT, egnTXT, ageTXT, nightsTXT, howManyPeopleTXT};
        for (JTextField textFields : nameFields) {
            addGuestContainer.add(textFields);
            textFields.setFont(new Font("Arial", Font.ITALIC, 16));
            textFields.setSize(170, 30);
            textFields.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        }

        //locations
        firstNameL.setLocation(20, 70);
        secondNameL.setLocation(20, 105);
        thirdNameL.setLocation(20, 140);
        egnL.setLocation(20, 175);
        ageL.setLocation(20, 210);
        nightsL.setLocation(20, 245);
        howManyPeopleL.setLocation(20, 280);
        sexL.setLocation(20, 315);

        firstNameTXT.setLocation(195, 70);
        secondNameTXT.setLocation(195, 105);
        thirdNameTXT.setLocation(195, 140);
        egnTXT.setLocation(195, 175);
        ageTXT.setLocation(195, 210);
        nightsTXT.setLocation(195, 245);
        howManyPeopleTXT.setLocation(195, 280);

        sexMaleCheckBox.setText("Мъж");
        sexMaleCheckBox.addItemListener(e -> isMale = e.getStateChange());
        sexMaleCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        sexMaleCheckBox.setBackground(Color.WHITE);
        sexMaleCheckBox.setBounds(198, 315, 80, 30);
        sexMaleCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addGuestContainer.add(sexMaleCheckBox);
        sexChooser.add(sexMaleCheckBox);

        sexFemaleCheckBox.setText("Жена");
        sexFemaleCheckBox.addItemListener(e -> isFemale = e.getStateChange());
        sexFemaleCheckBox.setFont(new Font("Arial", Font.BOLD, 16));
        sexFemaleCheckBox.setBackground(Color.WHITE);
        sexFemaleCheckBox.setBounds(275, 315, 80, 30);
        sexFemaleCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addGuestContainer.add(sexFemaleCheckBox);
        sexChooser.add(sexFemaleCheckBox);

        JLabel[] isCorrectData = {isCorrect1Name, isCorrect2Name, isCorrect3Name, isCorrectEgn, isCorrectAge, isCorrectNights, isCorrectGuestsNumber, isCorrectSex};
        for (JLabel isCorrectDataLabel : isCorrectData) {
            addGuestContainer.add(isCorrectDataLabel);
            isCorrectDataLabel.setIcon(new ImageIcon("src\\images\\correct.png"));
            isCorrectDataLabel.setSize(10, 26);
            isCorrectDataLabel.setVisible(false);
        }

        JLabel[] isIncorrectData = {isIncorrect1Name, isIncorrect2Name, isIncorrect3Name, isIncorrectEgn, isIncorrectAge, isIncorrectNights, isIncorrectGuestsNumber, isIncorrectSex};
        for (JLabel isIncorrectDataLabel : isIncorrectData) {
            addGuestContainer.add(isIncorrectDataLabel);
            isIncorrectDataLabel.setIcon(new ImageIcon("src\\images\\incorrect.png"));
            isIncorrectDataLabel.setSize(10, 26);
            isIncorrectDataLabel.setVisible(false);
            isIncorrectDataLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        //locations
        isCorrect1Name.setLocation(370, 72);
        isCorrect2Name.setLocation(370, 107);
        isCorrect3Name.setLocation(370, 142);
        isCorrectEgn.setLocation(370, 177);
        isCorrectAge.setLocation(370, 212);
        isCorrectNights.setLocation(370, 247);
        isCorrectGuestsNumber.setLocation(370, 282);
        isCorrectSex.setLocation(370, 317);

        isIncorrect1Name.setLocation(370, 72);
        isIncorrect2Name.setLocation(370, 107);
        isIncorrect3Name.setLocation(370, 142);
        isIncorrectEgn.setLocation(370, 177);
        isIncorrectAge.setLocation(370, 212);
        isIncorrectNights.setLocation(370, 247);
        isIncorrectGuestsNumber.setLocation(370, 282);
        isIncorrectSex.setLocation(370, 317);

        JButton backButtonAddGuest = new JButton(new ImageIcon("src\\images\\back_button.png"));
        backButtonAddGuest.addActionListener(e -> BackButtonForAddingGuest());
        backButtonAddGuest.setBounds(330, 10, 50, 50);
        backButtonAddGuest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addGuestContainer.add(backButtonAddGuest);

        checkGuestData = new JButton("Провери");
        checkGuestData.setBounds(20, 350, 150, 30);
        checkGuestData.setFont(new Font("Arial", Font.BOLD, 16));
        checkGuestData.addActionListener(e -> GetCheckAddNewGuestOperations());
        checkGuestData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addGuestContainer.add(checkGuestData);

        submitGuestData = new JButton("Въведи");
        submitGuestData.setBounds(230, 350, 150, 30);
        submitGuestData.setFont(new Font("Arial", Font.BOLD, 16));
        submitGuestData.setActionCommand("Submit");
        submitGuestData.setEnabled(false);
        submitGuestData.addActionListener(e -> GetSubmitAddNewGuestOperations());
        submitGuestData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addGuestContainer.add(submitGuestData);


        //reserveRoom frame defining
        reserveRoomFrame.setTitle("Резервиране на стая");
        reserveRoomFrame.setSize(408, 630);
        reserveRoomFrame.setResizable(true);
        reserveRoomFrame.setLocationRelativeTo(null);
        reserveRoomFrame.setLayout(null);
        reserveRoomFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        reserveRoomFrame.setIconImage(imageIcon.getImage());
        reserveRoomFrame.setVisible(false);

        Container reserveRoomContainer = new Container();
        reserveRoomContainer.setSize(reserveRoomFrame.getSize());
        reserveRoomFrame.setContentPane(reserveRoomContainer);

        JLabel headingReserveRoom = new JLabel();
        headingReserveRoom.setText("Попълнете данните");
        headingReserveRoom.setFont(new Font("Arial", BOLD_ITALIC, 25));
        headingReserveRoom.setBounds(35, 10, 300, 40);
        reserveRoomContainer.add(headingReserveRoom);

        JLabel firstNameLR = new JLabel();
        firstNameLR.setText("Въведете име:");
        firstNameReserveTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        firstNameReserveGetTXT = firstNameReserveTXT.getText();
                    }
                }
        );

        JLabel thirdNameLR = new JLabel();
        thirdNameLR.setText("Въведете фамилия:");
        thirdNameReserveTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        thirdNameReserveGetTXT = thirdNameReserveTXT.getText();
                    }
                }
        );

        JLabel nightsLR = new JLabel();
        nightsLR.setText("Въведете нощувки:");
        nightsReserveTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        nightsReserveGetTXT = nightsReserveTXT.getText();
                    }
                }
        );

        JLabel howManyPeopleLR = new JLabel();
        howManyPeopleLR.setText("Въведете тип стая:");
        howManyPeopleReserveTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        howManyPeopleReserveGetTXT = howManyPeopleReserveTXT.getText();
                    }
                }
        );

        JLabel dataLR = new JLabel();
        dataLR.setText("Въведете дата:");
        dateChooserReserve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dateChooserReserve.setBounds(20, 245, 344, 300);
        dateChooserReserve.setFont(new Font("Arial", Font.ITALIC, 16));
        dateChooserReserve.addDateListener(
                dateEvent -> {
                    JCalendar calendar = (JCalendar) dateEvent.getSource();
                    Date date = calendar.getDate();
                    Instant instant = date.toInstant();
                    ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
                    offerDate = zonedDateTime.toLocalDate();
                }
        );
        reserveRoomContainer.add(dateChooserReserve);

        JLabel[] nameLabelsR = {firstNameLR, thirdNameLR, nightsLR, howManyPeopleLR, dataLR};
        for (JLabel label : nameLabelsR) {
            reserveRoomContainer.add(label);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setSize(170, 30);
        }

        JTextField[] nameFieldsR = {firstNameReserveTXT, thirdNameReserveTXT, nightsReserveTXT, howManyPeopleReserveTXT};
        for (JTextField textFields : nameFieldsR) {
            reserveRoomContainer.add(textFields);
            textFields.setFont(new Font("Arial", Font.ITALIC, 16));
            textFields.setSize(170, 30);
            textFields.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        }

        //locations
        firstNameLR.setLocation(20, 70);
        thirdNameLR.setLocation(20, 105);
        nightsLR.setLocation(20, 140);
        howManyPeopleLR.setLocation(20, 175);
        dataLR.setLocation(20, 210);

        firstNameReserveTXT.setLocation(195, 70);
        thirdNameReserveTXT.setLocation(195, 105);
        nightsReserveTXT.setLocation(195, 140);
        howManyPeopleReserveTXT.setLocation(195, 175);

        JLabel[] isCorrectDataReserved = {isCorrect1NameReserve, isCorrect3NameReserve, isCorrectNightsReserve, isCorrectGuestsNumberReserve, isCorrectCalendar};
        for (JLabel isCorrectDataLabel : isCorrectDataReserved) {
            reserveRoomContainer.add(isCorrectDataLabel);
            isCorrectDataLabel.setIcon(new ImageIcon("src\\images\\correct.png"));
            isCorrectDataLabel.setSize(10, 26);
            isCorrectDataLabel.setVisible(false);
        }

        JLabel[] isIncorrectDataReserved = {isIncorrect1NameReserve, isIncorrect3NameReserve, isIncorrectNightsReserve, isIncorrectGuestsNumberReserve, isIncorrectCalendar};
        for (JLabel isIncorrectDataLabel : isIncorrectDataReserved) {
            reserveRoomContainer.add(isIncorrectDataLabel);
            isIncorrectDataLabel.setIcon(new ImageIcon("src\\images\\incorrect.png"));
            isIncorrectDataLabel.setSize(10, 26);
            isIncorrectDataLabel.setVisible(false);
            isIncorrectDataLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        isCorrect1NameReserve.setLocation(370, 72);
        isCorrect3NameReserve.setLocation(370, 107);
        isCorrectNightsReserve.setLocation(370, 142);
        isCorrectGuestsNumberReserve.setLocation(370, 177);
        isCorrectCalendar.setLocation(370, 212);

        isIncorrect1NameReserve.setLocation(370, 72);
        isIncorrect3NameReserve.setLocation(370, 107);
        isIncorrectNightsReserve.setLocation(370, 142);
        isIncorrectGuestsNumberReserve.setLocation(370, 177);
        isIncorrectCalendar.setLocation(370, 212);

        JButton backButtonReserveRoom = new JButton(new ImageIcon("src\\images\\back_button.png"));
        backButtonReserveRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButtonReserveRoom.addActionListener(e -> BackButtonForReserveRoom());
        backButtonReserveRoom.setBounds(330, 10, 50, 50);
        reserveRoomContainer.add(backButtonReserveRoom);

        checkReservation = new JButton("Провери");
        checkReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkReservation.setBounds(20, 553, 150, 30);
        checkReservation.setFont(new Font("Arial", Font.BOLD, 16));
        checkReservation.addActionListener(e -> GetCheckReservationOperations());
        reserveRoomContainer.add(checkReservation);

        submitReservation = new JButton("Въведи");
        submitReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitReservation.setBounds(230, 553, 150, 30);
        submitReservation.setFont(new Font("Arial", Font.BOLD, 16));
        submitReservation.addActionListener(e -> GetSubmitReservationOperations());
        submitReservation.setEnabled(false);
        reserveRoomContainer.add(submitReservation);


        //changeUser frame defining
        changeUserFrame.setTitle("Вход");
        changeUserFrame.setSize(408, 233);
        changeUserFrame.setResizable(true);
        changeUserFrame.setLocationRelativeTo(null);
        changeUserFrame.setLayout(null);
        changeUserFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        changeUserFrame.setIconImage(imageIcon.getImage());
        changeUserFrame.setVisible(true);

        Container changeUserContainer = new Container();
        changeUserContainer.setSize(changeUserFrame.getSize());
        changeUserFrame.setContentPane(changeUserContainer);

        JLabel headingChangeUser = new JLabel();
        headingChangeUser.setText("Попълнете данните");
        headingChangeUser.setFont(new Font("Arial", BOLD_ITALIC, 25));
        headingChangeUser.setBounds(53, 10, 300, 40);
        changeUserContainer.add(headingChangeUser);

        JLabel usernameLabel = new JLabel();
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        usernameLabel.setText("Потребителско име:");
        usernameLabel.setBounds(20, 70, 170, 30);
        changeUserContainer.add(usernameLabel);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passwordLabel.setText("Парола:");
        passwordLabel.setBounds(20, 105, 170, 30);
        changeUserContainer.add(passwordLabel);

        JTextField usernameTXT = new JTextField();
        usernameTXT.setFont(new Font("Arial", Font.ITALIC, 16));
        usernameTXT.setBounds(201, 70, 170, 30);
        usernameTXT.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        usernameTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        username = usernameTXT.getText();
                    }
                }
        );
        changeUserContainer.add(usernameTXT);

        JPasswordField passwordTXT = new JPasswordField();
        passwordTXT.setFont(new Font("Arial", Font.ITALIC, 16));
        passwordTXT.setBounds(201, 105, 170, 30);
        passwordTXT.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        passwordTXT.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        password = String.valueOf(passwordTXT.getPassword());
                    }
                }
        );
        changeUserContainer.add(passwordTXT);

        JButton checkUserData = new JButton("Провери");
        JButton submitUserData = new JButton("Въведи");

        assert username != null;
        checkUserData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkUserData.setBounds(20, 150, 150, 30);
        checkUserData.setFont(new Font("Arial", Font.BOLD, 16));
        checkUserData.setBackground(Color.WHITE);
        checkUserData.addActionListener(e -> {
                if ((username.equals("ivan_ss") && password.equals("ivanotss")) || (username.equals("simeon_ss21") && password.equals("simeonotss1"))) {
                    checkUserData.setBackground(Color.WHITE);
                    usernameTXT.setEditable(false);
                    passwordTXT.setEditable(false);
                    checkUserData.setEnabled(false);
                    submitUserData.setEnabled(true);
                } else {
                    checkUserData.setBackground(Color.PINK);
                }
            }
        );
        checkUserData.setVisible(true);
        changeUserContainer.add(checkUserData);

        submitUserData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitUserData.setBounds(220, 150, 150, 30);
        submitUserData.setFont(new Font("Arial", Font.BOLD, 16));
        submitUserData.setBackground(Color.WHITE);
        submitUserData.addActionListener(e -> {
                usernameTXT.setText("");
                passwordTXT.setText("");
                usernameTXT.setEditable(true);
                passwordTXT.setEditable(true);
                checkUserData.setEnabled(true);
                submitUserData.setEnabled(false);
                changeUserFrame.setVisible(false);
                mainFrame.setVisible(true);
                usernameLabelForMainFrame.setText(username);
            }
        );
        submitUserData.setVisible(true);
        submitUserData.setEnabled(false);
        changeUserContainer.add(submitUserData);


        //guest data frame
        guestDataFrame.setTitle("Данни за стаята");
        guestDataFrame.setSize(408, 415);
        guestDataFrame.setResizable(false);
        guestDataFrame.setLocationRelativeTo(null);
        guestDataFrame.setLayout(null);
        guestDataFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        guestDataFrame.setIconImage(imageIcon.getImage());
        guestDataFrame.setVisible(false);

        Container guestDataContainer = new Container();
        guestDataContainer.setSize(guestDataFrame.getSize());
        guestDataFrame.setContentPane(guestDataContainer);

        JLabel headingGuestData = new JLabel();
        headingGuestData.setText("Данни за госта");
        headingGuestData.setFont(new Font("Arial", BOLD_ITALIC, 25));
        headingGuestData.setBounds(65, 10, 305, 40);
        guestDataContainer.add(headingGuestData);

        JButton backButtonGuestData = new JButton(new ImageIcon("src\\images\\back_button.png"));
        backButtonGuestData.addActionListener(e -> {guestDataFrame.setVisible(false); mainFrame.setVisible(true);});
        backButtonGuestData.setBounds(330, 10, 50, 50);
        backButtonGuestData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        guestDataContainer.add(backButtonGuestData);

        JLabel firstName = new JLabel("Име:");
        JLabel secondName = new JLabel("Презиме:");
        JLabel thirdName = new JLabel("Фамилия:");
        JLabel age = new JLabel("Възраст:");
        JLabel egn = new JLabel("ЕГН:");
        JLabel sex = new JLabel("Пол:");
        JLabel nights = new JLabel("Нощувки:");
        JLabel offerDate = new JLabel("Дата на постъпване:");
        JLabel checkingOutDate = new JLabel("Дата на изписване:");

        JLabel[] jLabels = {firstName, secondName, thirdName, age, egn, sex, nights, offerDate, checkingOutDate};
        for (JLabel jLabel : jLabels) {
            guestDataContainer.add(jLabel);
            jLabel.setFont(new Font("Arial", Font.BOLD, 16));
            jLabel.setSize(170, 30);
        }

        JLabel[] jLabel = {firstNameData, secondNameData, thirdNameData, ageData, egnData, sexData, nightsData, offerDateData, checkingOutDateData};
        for (JLabel label : jLabel) {
            guestDataContainer.add(label);
            label.setFont(new Font("Arial", Font.ITALIC, 16));
            label.setSize(170, 30);
        }

        //locations
        firstName.setLocation(20, 70);
        secondName.setLocation(20, 105);
        thirdName.setLocation(20, 140);
        age.setLocation(20, 175);
        egn.setLocation(20, 210);
        sex.setLocation(20, 245);
        nights.setLocation(20, 280);
        offerDate.setLocation(20, 315);
        checkingOutDate.setLocation(20, 350);

        firstNameData.setLocation(220, 70);
        secondNameData.setLocation(220, 105);
        thirdNameData.setLocation(220, 140);
        ageData.setLocation(220, 175);
        egnData.setLocation(220, 210);
        sexData.setLocation(220, 245);
        nightsData.setLocation(220, 280);
        offerDateData.setLocation(220, 315);
        checkingOutDateData.setLocation(220, 350);


        //checking out guests
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 12);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        //everyday at 12am you run this task
        Timer timer = new Timer();
        timer.schedule(new RemoveGuestsTask(roomsFirstStorey, roomsSecondStorey, roomsThirdStorey, firstStoreyFiles, secondStoreyFiles, thirdStoreyFiles,
                        greenLight, redLight, blueLight, isNotClean, firstStoreyWriters, secondStoreyWriters, thirdStoreyWriters, isPaid, isNotPaid, enterRoom),
                today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // 60*60*24*100 = 8640000ms

        //reservations
        Calendar todayReserve = Calendar.getInstance();
        todayReserve.set(Calendar.HOUR_OF_DAY, 14);
        todayReserve.set(Calendar.MINUTE, 0);
        todayReserve.set(Calendar.SECOND, 0);

        //everyday at 14am you run this task
        Timer timer2 = new Timer();
        timer2.schedule(new ReserveGuestTask(roomsFirstStorey, roomsSecondStorey, roomsThirdStorey, firstStoreyReadersReserved, secondStoreyReadersReserved, thirdStoreyReadersReserved,
                        firstStoreyFilesReserved, secondStoreyFilesReserved, thirdStoreyFilesReserved, greenLight, redLight, blueLight, isPaid, isNotPaid, isReserved),
                todayReserve.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // 60*60*24*100 = 8640000ms

        //making room clean
        Calendar todayClean = Calendar.getInstance();
        todayClean.set(Calendar.HOUR_OF_DAY, 14);
        todayClean.set(Calendar.MINUTE, 0);
        todayClean.set(Calendar.SECOND, 0);

        //everyday at 14am you run this task
        Timer timer3 = new Timer();
        timer3.schedule(new CleanRoomTask(isNotClean, firstStoreyFiles, secondStoreyFiles, thirdStoreyFiles,
                firstStoreyReaders, secondStoreyReaders, thirdStoreyReaders,
                roomsFirstStorey, roomsSecondStorey, roomsThirdStorey), todayClean.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // 60*60*24*100 = 8640000ms

        //cleaning money for the day
        Calendar todayMoney = Calendar.getInstance();
        todayMoney.set(Calendar.HOUR_OF_DAY, 23);
        todayMoney.set(Calendar.MINUTE, 59);
        todayMoney.set(Calendar.SECOND, 0);

        //everyday at 14am you run this task
        Timer timer4 = new Timer();
        timer4.schedule(new DeleteMoneyFileTask(moneyFile, turnOver), todayMoney.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // 60*60*24*100 = 8640000ms

        addGuest.setEnabled(true);
        reserveRoom.setEnabled(true);
        changeUser.setEnabled(true);
        quit.setEnabled(true);
    }

    private void MakeStoreys(Container containerPane) throws OutOfRangeLettersException, NameException, FirstLetterException, OutOfRangeException, EGNException, EGNNumberException {
        for (int i = 0; i < greenLight.length; i++) {
            int finalI = i;
            greenLight[i] = new JLabel();
            containerPane.add(greenLight[i]);
            greenLight[i].setIcon(new ImageIcon("src\\images\\light_green.gif"));
            greenLight[i].setSize(28, 28);
            greenLight[i].setVisible(false);
            greenLight[i].addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (finalI <= 4) {
                                mainFrame.setVisible(false);
                                addNewGuestFrame.setVisible(true);
                                roomNumberForAddingGuest = finalI;
                                howManyPeopleTXT.setText("1");
                                howManyPeopleGuestData = 1;
                                howManyPeopleTXT.setEditable(false);
                            } else if (finalI <= 9) {
                                mainFrame.setVisible(false);
                                addNewGuestFrame.setVisible(true);
                                roomNumberForAddingGuest = finalI - 5;
                                howManyPeopleTXT.setText("2");
                                howManyPeopleGuestData = 2;
                                howManyPeopleTXT.setEditable(false);
                            } else {
                                mainFrame.setVisible(false);
                                addNewGuestFrame.setVisible(true);
                                roomNumberForAddingGuest = finalI - 10;
                                howManyPeopleTXT.setText("3");
                                howManyPeopleGuestData = 3;
                                howManyPeopleTXT.setEditable(false);
                            }
                        }
                    }
            );
            greenLight[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            greenLight[i].setToolTipText("Стаята е свободна. Кликнете, за да добавите гост.");
        }

        for (int i = 0; i < redLight.length; i++) {
            redLight[i] = new JLabel();
            containerPane.add(redLight[i]);
            redLight[i].setIcon(new ImageIcon("src\\images\\light_red.gif"));
            redLight[i].setSize(28, 28);
            redLight[i].setVisible(false);
            redLight[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            redLight[i].setToolTipText("Стаята е заета.");
        }

        for (int i = 0; i < blueLight.length; i++) {
            blueLight[i] = new JLabel();
            containerPane.add(blueLight[i]);
            blueLight[i].setIcon(new ImageIcon("src\\images\\light_blue.gif"));
            blueLight[i].setSize(28, 28);
            blueLight[i].setVisible(false);
            blueLight[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            blueLight[i].setToolTipText("Стаята е резервирана.");
        }

        for (int i = 0; i < isPaid.length; i++) {
            isPaid[i] = new JLabel();
            containerPane.add(isPaid[i]);
            isPaid[i].setIcon(new ImageIcon("src\\images\\tick.png"));
            isPaid[i].setSize(28, 28);
            isPaid[i].setVisible(false);
            isPaid[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            isPaid[i].setToolTipText("Стаята е платена.");
        }

        for (int i = 0; i < isNotPaid.length; i++) {
            isNotPaid[i] = new JLabel();
            containerPane.add(isNotPaid[i]);
            isNotPaid[i].setIcon(new ImageIcon("src\\images\\x.png"));
            isNotPaid[i].setSize(28, 28);
            isNotPaid[i].setVisible(false);
            isNotPaid[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            isNotPaid[i].setToolTipText("Стаята не е платена. Кликнете за плащане.");
        }

        for (int i = 0; i < isReserved.length; i++) {
            isReserved[i] = new JLabel();
            containerPane.add(isReserved[i]);
            isReserved[i].setIcon(new ImageIcon("src\\images\\dash.png"));
            isReserved[i].setSize(28, 28);
            isReserved[i].setVisible(false);
            isReserved[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            isReserved[i].setToolTipText("Стаята е резервирана. Кликнете за попълване на данните.");
        }

        for (int i = 0; i < isNotClean.length; i++) {
            isNotClean[i] = new JLabel();
            containerPane.add(isNotClean[i]);
            isNotClean[i].setIcon(new ImageIcon("src\\images\\broom.png"));
            isNotClean[i].setSize(28, 28);
            isNotClean[i].setVisible(false);
            isNotClean[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            isNotClean[i].setToolTipText("Стаята се почиства.");
        }

        for (int i = 0; i < enterRoom.length; i++) {
            int finalI = i;
            enterRoom[i] = new JLabel();
            containerPane.add(enterRoom[i]);
            enterRoom[i].setIcon(new ImageIcon("src\\images\\door.png"));
            enterRoom[i].setSize(28, 28);
            enterRoom[i].setVisible(false);
            enterRoom[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            enterRoom[i].setToolTipText("Кликнете, за да видите данните на госта.");
            enterRoom[i].addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (finalI <= 4) {
                                mainFrame.setVisible(false);
                                guestDataFrame.setVisible(true);
                                SetEnterRoomListener(roomsFirstStorey, finalI);
                            } else if (finalI <= 9) {
                                mainFrame.setVisible(false);
                                guestDataFrame.setVisible(true);
                                SetEnterRoomListener(roomsSecondStorey, finalI - 5);
                            } else {
                                mainFrame.setVisible(false);
                                guestDataFrame.setVisible(true);
                                SetEnterRoomListener(roomsThirdStorey, finalI - 10);
                            }
                        }
                    }
            );
        }

        int counter = 0;
        enterRoom[counter++].setLocation(152, 618);
        enterRoom[counter++].setLocation(333, 618);
        enterRoom[counter++].setLocation(516, 618);
        enterRoom[counter++].setLocation(696, 618);
        enterRoom[counter++].setLocation(876, 618);

        enterRoom[counter++].setLocation(152, 431);
        enterRoom[counter++].setLocation(333, 431);
        enterRoom[counter++].setLocation(516, 431);
        enterRoom[counter++].setLocation(696, 431);
        enterRoom[counter++].setLocation(876, 431);

        enterRoom[counter++].setLocation(152, 243);
        enterRoom[counter++].setLocation(333, 243);
        enterRoom[counter++].setLocation(516, 243);
        enterRoom[counter++].setLocation(696, 243);
        enterRoom[counter].setLocation(876, 243);

        counter = 0;
        isNotClean[counter++].setLocation(152, 618);
        isNotClean[counter++].setLocation(333, 618);
        isNotClean[counter++].setLocation(516, 618);
        isNotClean[counter++].setLocation(696, 618);
        isNotClean[counter++].setLocation(876, 618);

        isNotClean[counter++].setLocation(152, 431);
        isNotClean[counter++].setLocation(333, 431);
        isNotClean[counter++].setLocation(516, 431);
        isNotClean[counter++].setLocation(696, 431);
        isNotClean[counter++].setLocation(876, 431);

        isNotClean[counter++].setLocation(152, 243);
        isNotClean[counter++].setLocation(333, 243);
        isNotClean[counter++].setLocation(516, 243);
        isNotClean[counter++].setLocation(696, 243);
        isNotClean[counter].setLocation(876, 243);

        counter = 0;
        isPaid[counter++].setLocation(152, 507);
        isPaid[counter++].setLocation(333, 507);
        isPaid[counter++].setLocation(516, 507);
        isPaid[counter++].setLocation(696, 507);
        isPaid[counter++].setLocation(876, 507);

        isPaid[counter++].setLocation(152, 320);
        isPaid[counter++].setLocation(333, 320);
        isPaid[counter++].setLocation(516, 320);
        isPaid[counter++].setLocation(696, 320);
        isPaid[counter++].setLocation(876, 320);

        isPaid[counter++].setLocation(152, 132);
        isPaid[counter++].setLocation(333, 132);
        isPaid[counter++].setLocation(516, 132);
        isPaid[counter++].setLocation(696, 132);
        isPaid[counter].setLocation(876, 132);

        counter = 0;
        isNotPaid[counter++].setLocation(152, 540);
        isNotPaid[counter++].setLocation(333, 540);
        isNotPaid[counter++].setLocation(516, 540);
        isNotPaid[counter++].setLocation(696, 540);
        isNotPaid[counter++].setLocation(876, 540);

        isNotPaid[counter++].setLocation(152, 353);
        isNotPaid[counter++].setLocation(333, 353);
        isNotPaid[counter++].setLocation(516, 353);
        isNotPaid[counter++].setLocation(696, 353);
        isNotPaid[counter++].setLocation(876, 353);

        isNotPaid[counter++].setLocation(152, 165);
        isNotPaid[counter++].setLocation(333, 165);
        isNotPaid[counter++].setLocation(516, 165);
        isNotPaid[counter++].setLocation(696, 165);
        isNotPaid[counter].setLocation(876, 165);

        counter = 0;
        isReserved[counter++].setLocation(152, 573);
        isReserved[counter++].setLocation(333, 573);
        isReserved[counter++].setLocation(516, 573);
        isReserved[counter++].setLocation(696, 573);
        isReserved[counter++].setLocation(876, 573);

        isReserved[counter++].setLocation(152, 386);
        isReserved[counter++].setLocation(333, 386);
        isReserved[counter++].setLocation(516, 386);
        isReserved[counter++].setLocation(696, 386);
        isReserved[counter++].setLocation(876, 386);

        isReserved[counter++].setLocation(152, 198);
        isReserved[counter++].setLocation(333, 198);
        isReserved[counter++].setLocation(516, 198);
        isReserved[counter++].setLocation(696, 198);
        isReserved[counter].setLocation(876, 198);


        AddingLights(redLight);
        AddingLights(greenLight);
        AddingLights(blueLight);
        AddingRemainderListeners(isNotPaid, "MoneyFrame", firstStoreyFilesReserved, secondStoreyFilesReserved, thirdStoreyFilesReserved,
                firstStoreyReadersReserved, secondStoreyReadersReserved, thirdStoreyReadersReserved, firstStoreyFiles, secondStoreyFiles, thirdStoreyFiles,
                firstStoreyReaders, secondStoreyReaders, thirdStoreyReaders);
        AddingRemainderListeners(isReserved, "AddGuestFrame", firstStoreyFilesReserved, secondStoreyFilesReserved, thirdStoreyFilesReserved,
                firstStoreyReadersReserved, secondStoreyReadersReserved, thirdStoreyReadersReserved, firstStoreyFiles, secondStoreyFiles, thirdStoreyFiles,
                firstStoreyReaders, secondStoreyReaders, thirdStoreyReaders);

        // declaring first storey
        roomsFirstStorey = new Guest[5];
        for (int room = 0; room < roomsFirstStorey.length; room++) {
            switch (room) {
                case 0: {
                    isNotPaidRoom = RefreshRoomsState(firstStorey0Reader, firstStorey0File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[0].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[0].setVisible(true);
                    } else {
                        isPaid[0].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[0].setVisible(true);
                    }

                    roomsFirstStorey[room] = guest;
                    if (roomsFirstStorey[room] == null) {
                        greenLight[0].setVisible(true);
                    } else {
                        redLight[0].setVisible(true);
                        enterRoom[0].setVisible(true);
                    }
                    guest = null;
                } break;

                case 1: {
                    isNotPaidRoom = RefreshRoomsState(firstStorey1Reader, firstStorey1File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[1].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[1].setVisible(true);
                    } else {
                        isPaid[1].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[1].setVisible(true);
                    }

                    roomsFirstStorey[room] = guest;
                    if (roomsFirstStorey[room] == null) {
                        greenLight[1].setVisible(true);
                    } else {
                        redLight[1].setVisible(true);
                        enterRoom[1].setVisible(true);
                    }
                    guest = null;
                } break;

                case 2: {
                    isNotPaidRoom = RefreshRoomsState(firstStorey2Reader, firstStorey2File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[2].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[2].setVisible(true);
                    } else {
                        isPaid[2].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[2].setVisible(true);
                    }

                    roomsFirstStorey[room] = guest;
                    if (roomsFirstStorey[room] == null) {
                        greenLight[2].setVisible(true);
                    } else {
                        redLight[2].setVisible(true);
                        enterRoom[2].setVisible(true);
                    }
                    guest = null;
                } break;

                case 3: {
                    isNotPaidRoom = RefreshRoomsState(firstStorey3Reader, firstStorey3File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[3].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[3].setVisible(true);
                    } else {
                        isPaid[3].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[3].setVisible(true);
                    }

                    roomsFirstStorey[room] = guest;
                    if (roomsFirstStorey[room] == null) {
                        greenLight[3].setVisible(true);
                    } else {
                        redLight[3].setVisible(true);
                        enterRoom[3].setVisible(true);
                    }
                    guest = null;
                } break;

                case 4: {
                    isNotPaidRoom = RefreshRoomsState(firstStorey4Reader, firstStorey4File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[4].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[4].setVisible(true);
                    } else {
                        isPaid[4].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[4].setVisible(true);
                    }

                    roomsFirstStorey[room] = guest;
                    if (roomsFirstStorey[room] == null) {
                        greenLight[4].setVisible(true);
                    } else {
                        redLight[4].setVisible(true);
                        enterRoom[4].setVisible(true);
                    }
                    guest = null;
                } break;
            }
        }
        // finalise first storey
        storeyFirst = new Storey(1, 1, roomsFirstStorey, firstStoreyPrice);

        // declaring second storey
        roomsSecondStorey = new Guest[5];
        for (int room = 0; room < roomsSecondStorey.length; room++) {
            switch (room) {
                case 0: {
                    isNotPaidRoom = RefreshRoomsState(secondStorey0Reader, secondStorey0File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[5].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[5].setVisible(true);
                    } else {
                        isPaid[5].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[5].setVisible(true);
                    }

                    roomsSecondStorey[room] = guest;
                    if (roomsSecondStorey[room] == null) {
                        greenLight[5].setVisible(true);
                    } else {
                        redLight[5].setVisible(true);
                        enterRoom[5].setVisible(true);
                    }
                    guest = null;
                } break;

                case 1: {
                    isNotPaidRoom = RefreshRoomsState(secondStorey1Reader, secondStorey1File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[6].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[6].setVisible(true);
                    } else {
                        isPaid[6].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[6].setVisible(true);
                    }

                    roomsSecondStorey[room] = guest;
                    if (roomsSecondStorey[room] == null) {
                        greenLight[6].setVisible(true);
                    } else {
                        redLight[6].setVisible(true);
                        enterRoom[6].setVisible(true);
                    }
                    guest = null;
                } break;

                case 2: {
                    isNotPaidRoom = RefreshRoomsState(secondStorey2Reader, secondStorey2File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[7].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[7].setVisible(true);
                    } else {
                        isPaid[7].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[7].setVisible(true);
                    }

                    roomsSecondStorey[room] = guest;
                    if (roomsSecondStorey[room] == null) {
                        greenLight[7].setVisible(true);
                    } else {
                        redLight[7].setVisible(true);
                        enterRoom[7].setVisible(true);
                    }
                    guest = null;
                } break;

                case 3: {
                    isNotPaidRoom = RefreshRoomsState(secondStorey3Reader, secondStorey3File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[8].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[8].setVisible(true);
                    } else {
                        isPaid[8].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[8].setVisible(true);
                    }

                    roomsSecondStorey[room] = guest;
                    if (roomsSecondStorey[room] == null) {
                        greenLight[8].setVisible(true);
                    } else {
                        redLight[8].setVisible(true);
                        enterRoom[8].setVisible(true);
                    }
                    guest = null;
                } break;

                case 4: {
                    isNotPaidRoom = RefreshRoomsState(secondStorey4Reader, secondStorey4File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[9].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[9].setVisible(true);
                    } else {
                        isPaid[9].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[9].setVisible(true);
                    }

                    roomsSecondStorey[room] = guest;
                    if (roomsSecondStorey[room] == null) {
                        greenLight[9].setVisible(true);
                    } else {
                        redLight[9].setVisible(true);
                        enterRoom[9].setVisible(true);
                    }
                    guest = null;
                } break;
            }
        }
        // finalise second storey
        storeySecond = new Storey(2, 2, roomsSecondStorey, secondStoreyPrice);

        // declaring third storey
        roomsThirdStorey = new Guest[5];
        for (int room = 0; room < roomsThirdStorey.length; room++) {
            switch (room) {
                case 0: {
                    isNotPaidRoom = RefreshRoomsState(thirdStorey0Reader, thirdStorey0File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[10].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[10].setVisible(true);
                    } else {
                        isPaid[10].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[10].setVisible(true);
                    }

                    roomsThirdStorey[room] = guest;
                    if (roomsThirdStorey[room] == null) {
                        greenLight[10].setVisible(true);
                    } else {
                        redLight[10].setVisible(true);
                        enterRoom[10].setVisible(true);
                    }
                    guest = null;
                } break;

                case 1: {
                    isNotPaidRoom = RefreshRoomsState(thirdStorey1Reader, thirdStorey1File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[11].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[11].setVisible(true);
                    } else {
                        isPaid[11].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[11].setVisible(true);
                    }

                    roomsThirdStorey[room] = guest;
                    if (roomsThirdStorey[room] == null) {
                        greenLight[11].setVisible(true);
                    } else {
                        redLight[11].setVisible(true);
                        enterRoom[11].setVisible(true);
                    }
                    guest = null;
                } break;

                case 2: {
                    isNotPaidRoom = RefreshRoomsState(thirdStorey2Reader, thirdStorey2File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[12].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[12].setVisible(true);
                    } else {
                        isPaid[12].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[12].setVisible(true);
                    }


                    roomsThirdStorey[room] = guest;
                    if (roomsThirdStorey[room] == null) {
                        greenLight[12].setVisible(true);
                    } else {
                        redLight[12].setVisible(true);
                        enterRoom[12].setVisible(true);
                    }
                    guest = null;
                } break;

                case 3: {
                    isNotPaidRoom = RefreshRoomsState(thirdStorey3Reader, thirdStorey3File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[13].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[13].setVisible(true);
                    } else {
                        isPaid[13].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[13].setVisible(true);
                    }

                    roomsThirdStorey[room] = guest;
                    if (roomsThirdStorey[room] == null) {
                        greenLight[13].setVisible(true);
                    } else {
                        redLight[13].setVisible(true);
                        enterRoom[13].setVisible(true);
                    }
                    guest = null;
                } break;

                case 4: {
                    isNotPaidRoom = RefreshRoomsState(thirdStorey4Reader, thirdStorey4File).equals(BigDecimal.valueOf(0.00));
                    if (isPaidRoom) {
                        isPaid[14].setVisible(true);
                    } else if (isNotPaidRoom) {
                        isNotPaid[14].setVisible(true);
                    } else {
                        isPaid[14].setVisible(true);
                    }

                    if (isNotCleanRoom) {
                        isNotClean[14].setVisible(true);
                    }

                    roomsThirdStorey[room] = guest;
                    if (roomsThirdStorey[room] == null) {
                        greenLight[14].setVisible(true);
                    } else {
                        redLight[14].setVisible(true);
                        enterRoom[14].setVisible(true);
                    }
                    guest = null;
                } break;
            }
        }
        // finalise third storey
        storeyThird = new Storey(3, 3, roomsThirdStorey, thirdStoreyPrice);
    }

    private void SetEnterRoomListener(Guest guest[], int i) {
        firstNameData.setText(guest[i].getFirstName());
        secondNameData.setText(guest[i].getSecondName());
        thirdNameData.setText(guest[i].getThirdName());
        ageData.setText(String.valueOf(guest[i].getAge()));
        egnData.setText(guest[i].getEgn());
        sexData.setText(guest[i].getSex());
        nightsData.setText(String.valueOf(guest[i].getNights()));
        offerDateData.setText(String.valueOf(guest[i].getOfferDate()));
        checkingOutDateData.setText(String.valueOf(guest[i].getCheckingOutDate()));
    }

    private void AddingLights(JLabel[] light) {
        int counter = 0;
        light[counter++].setLocation(8, 507);
        light[counter++].setLocation(187, 507);
        light[counter++].setLocation(370, 507);
        light[counter++].setLocation(550, 507);
        light[counter++].setLocation(734, 507);

        light[counter++].setLocation(8, 320);
        light[counter++].setLocation(187, 320);
        light[counter++].setLocation(370, 320);
        light[counter++].setLocation(550, 320);
        light[counter++].setLocation(734, 320);

        light[counter++].setLocation(8, 132);
        light[counter++].setLocation(187, 132);
        light[counter++].setLocation(370, 132);
        light[counter++].setLocation(550, 132);
        light[counter].setLocation(734, 132);
    }

    //operations for later paying and reservations
    private void AddingRemainderListeners(JLabel[] remainder, String framesToOpen, File[] firstStoreyFilesReserved, File[] secondStoreyFilesReserved, File[] thirdStoreyFilesReserved,
                                          Scanner[] firstStoreyReadersReserved, Scanner[] secondStoreyReadersReserved, Scanner[] thirdStoreyReadersReserved,
                                          File[] firstStoreyFiles, File[] secondStoreyFiles, File[] thirdStoreyFiles,
                                          Scanner[] firstStoreyReaders, Scanner[] secondStoreyReaders, Scanner[] thirdStoreyReaders) {
        if (framesToOpen.equals("MoneyFrame")) {
            for (int i = 0; i < remainder.length; i++) {
                int finalI = i;
                int finalI1 = i;
                remainder[i].addMouseListener(
                        new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                mainFrame.setVisible(false);
                                moneyFrameLater.setVisible(true);
                                submitMoneyDataLater.setVisible(true);
                                if (finalI <= 4) {
                                    SetMoneyOperations(firstStoreyReaders, finalI, firstStoreyFiles, storeyFirst, finalI1);
                                } else if (finalI <= 9) {
                                    SetMoneyOperations(secondStoreyReaders, finalI, secondStoreyFiles, storeySecond, finalI1);
                                } else {
                                    SetMoneyOperations(thirdStoreyReaders, finalI, thirdStoreyFiles, storeyThird, finalI1);
                                }
                            }
                        }
                );
            }
        }

        if (framesToOpen.equals("AddGuestFrame")) {
            for (int i = 0; i < remainder.length; i++) {
                int finalI = i;
                int finalI1 = i;
                remainder[i].addMouseListener(
                        new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                mainFrame.setVisible(false);
                                addNewGuestFrame.setVisible(true);
                                submitGuestData.setEnabled(false);
                                if (finalI <= 4) {
                                    SetReservedOperations(firstStoreyReadersReserved, finalI, firstStoreyFilesReserved, finalI1);
                                } else if (finalI <= 9) {
                                    SetReservedOperations(secondStoreyReadersReserved, finalI, secondStoreyFilesReserved, finalI1);
                                } else {
                                    SetReservedOperations(thirdStoreyReadersReserved, finalI, thirdStoreyFilesReserved, finalI1);
                                }
                            }
                        }
                );
            }
        }
    }

    private void SetMoneyOperations(Scanner[] reader, int finalI, File[] file, Storey storey, int finalI1) {
        if (finalI > 4 && finalI <= 9) {
            finalI -= 5;
        } else if (finalI > 9){
            finalI -= 10;
        }
        reader[finalI].close();
        try {
            reader[finalI] = new Scanner(file[finalI]);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        String nothing;
        for (int i = 0; i <= 5; i++) {
            nothing = reader[finalI].next();
        }
        int howManyPeople = reader[finalI].nextInt();
        int nights = reader[finalI].nextInt();
        int roomNum = reader[finalI].nextInt();
        nothing = reader[finalI].next();
        nothing = reader[finalI].next();
        nothing = reader[finalI].next();
        double price = Double.parseDouble(reader[finalI].next());

        storeyGuestData = howManyPeople;
        howManyPeopleGuestData = howManyPeople;
        nightsGuestData = nights;
        roomNumGuestData = roomNum;

        moneyGuestData = BigDecimal.valueOf(0.00);
        checkMoneyDataLater.addActionListener(
                e -> {
                    //noinspection LoopStatementThatDoesntLoop
                    do {
                        try {
                            if (moneyTXTLater.getText() == null || moneyTXTLater.getText().equals("")) {
                                throw new OutOfRangeException();
                            } else {
                                moneyGuestDataLater = BigDecimal.valueOf(Double.parseDouble(moneyGetTXTLater));
                                //changing money
                                if (currencyGuestDataLater == null) {
                                    throw new CurrencyException();
                                }


                                switch (howManyPeople) {
                                    case 1: {
                                        if (currencyGuestDataLater.equals("USD")) {
                                            moneyGuestDataLater = BigDecimal.valueOf(CurrencyConverter(moneyGuestDataLater.doubleValue()));
                                        }

                                        if (moneyGuestDataLater.doubleValue() < price) {
                                            throw new OutOfRangeException();
                                        }
                                    } break;

                                    case 2: {
                                        if (currencyGuestDataLater.equals("USD")) {
                                            moneyGuestDataLater = BigDecimal.valueOf(CurrencyConverter(moneyGuestDataLater.doubleValue()));
                                        }

                                        if (moneyGuestDataLater.doubleValue() < price) {
                                            throw new OutOfRangeException();
                                        }
                                    } break;

                                    case 3: {
                                        if (currencyGuestDataLater.equals("USD")) {
                                            moneyGuestDataLater = BigDecimal.valueOf(CurrencyConverter(moneyGuestDataLater.doubleValue()));
                                        }

                                        if (moneyGuestDataLater.doubleValue() < price) {
                                            throw new OutOfRangeException();
                                        }
                                    } break;
                                }
                            }

                            isIncorrectMoneyLater.setVisible(false);
                            isCorrectMoneyLater.setVisible(true);
                            moneyTXTLater.setBackground(Color.WHITE);
                            chooseCurrencyLater.setBackground(Color.WHITE);
                            checkMoneyDataLater.setEnabled(false);
                            submitMoneyDataLater.setEnabled(true);
                            chooseCurrencyLater.setEnabled(false);
                            moneyTXTLater.setEditable(false);

                            break;

                        } catch (NumberFormatException nfe) {
                            isIncorrectMoneyLater.setVisible(true);
                            isIncorrectMoneyLater.setToolTipText("Това не е число.");
                            moneyTXTLater.setBackground(Color.PINK);
                            break;
                        } catch (OutOfRangeException ore) {
                            isIncorrectMoneyLater.setVisible(true);
                            isIncorrectMoneyLater.setToolTipText("Парите не са достатъчно.");
                            moneyTXTLater.setBackground(Color.PINK);
                            break;
                        } catch (CurrencyException ce) {
                            isIncorrectMoneyLater.setVisible(true);
                            isIncorrectMoneyLater.setToolTipText("Трябва да изберете валута.");
                            chooseCurrencyLater.setBackground(Color.PINK);
                            break;
                        } catch (Exception ea) {
                            isIncorrectMoneyLater.setVisible(true);
                            isIncorrectMoneyLater.setToolTipText("Има грешка, но не е ясно каква.");
                            moneyTXTLater.setBackground(Color.PINK);
                            break;
                        }
                    } while (true);
                }
        );

        submitMoneyDataLater.addActionListener(
                e -> {
                    roomMessageLater.setVisible(true);
                    storeyMessageLater.setVisible(true);
                    moneyTXTLater.setEditable(false);
                    chooseCurrencyLater.setEnabled(false);
                    continueMoneyDataLater.setVisible(true);
                    continueMoneyDataLater.setEnabled(true);
                    checkMoneyDataLater.setEnabled(false);
                    submitMoneyDataLater.setVisible(false);
                    checkMoneyDataLater.setVisible(false);
                    turnOver += MoneyProcessing(storey, roomNumGuestData, storeyGuestData, moneyGuestDataLater, changeLLater, roomMessageLater, storeyMessageLater, price, true);
                    refresh.setEnabled(true);
                    try {
                        Files.newOutputStream(path);
                    } catch (IOException ea) {
                        ea.printStackTrace();
                    }
                    moneyWriter.println(moneyGuestDataLater);
                    moneyWriter.flush();
                    isNotPaid[finalI1].setVisible(false);
                    isPaid[finalI1].setVisible(true);
                    WriterAgain(roomNumGuestData, storeyGuestData, moneyGuestDataLater.doubleValue());
                }
        );

    }

    private void SetReservedOperations(Scanner[] reader, int finalI, File[] reservedFile, int finalI1) {
        if (finalI > 4 && finalI <= 9) {
            finalI -= 5;
        } else if (finalI > 9){
            finalI -= 10;
        }
        reader[finalI].close();
        try {
            reader[finalI] = new Scanner(reservedFile[finalI]);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        String firstName = reader[finalI].next();
        String thirdName = reader[finalI].next();
        int howManyPeople = reader[finalI].nextInt();
        int nights = reader[finalI].nextInt();
        int roomNum = reader[finalI].nextInt();
        reader[finalI].close();

        Path path = Paths.get(reservedFile[finalI].getPath());
        try {
            Files.newOutputStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        isReserved[finalI1].setVisible(false);
        blueLight[finalI1].setVisible(false);

        firstNameTXT.setText(firstName);
        firstNameGetTXT = firstName;
        thirdNameTXT.setText(thirdName);
        thirdNameGetTXT = thirdName;
        howManyPeopleTXT.setText(String.valueOf(howManyPeople));
        howManyPeopleGetTXT = String.valueOf(howManyPeople);
        nightsTXT.setText(String.valueOf(nights));
        nightsGetTXT = String.valueOf(nights);
        roomNumGuestData = roomNum;
    }

    private void GetContinueOperationsAddGuestLater() {
        moneyTXTLater.setEditable(true);
        chooseCurrencyLater.setEnabled(true);
        moneyTXTLater.setText("");
        changeLLater.setText("");
        roomMessageLater.setVisible(false);
        storeyMessageLater.setVisible(false);
        continueMoneyDataLater.setVisible(false);
        checkMoneyDataLater.setVisible(true);
        checkMoneyDataLater.setEnabled(true);
        submitMoneyDataLater.setVisible(true);
        submitMoneyDataLater.setEnabled(false);
        isCorrectMoneyLater.setVisible(false);
        isIncorrectMoneyLater.setVisible(false);
        moneyFrameLater.setVisible(false);
        mainFrame.setVisible(true);

        moneyGuestDataLater = BigDecimal.valueOf(0.00);
        currencyGuestDataLater = null;
    }

    private void GetContinueOperationsAddGuest() {
        moneyFrame.setVisible(false);
        mainFrame.setVisible(true);

        firstNameTXT.setText("");
        secondNameTXT.setText("");
        thirdNameTXT.setText("");
        egnTXT.setText("");
        ageTXT.setText("");
        nightsTXT.setText("");
        howManyPeopleTXT.setText("");
        sexChooser.clearSelection();

        firstNameTXT.setBackground(Color.WHITE);
        secondNameTXT.setBackground(Color.WHITE);
        thirdNameTXT.setBackground(Color.WHITE);
        ageTXT.setBackground(Color.WHITE);
        nightsTXT.setBackground(Color.WHITE);
        egnTXT.setBackground(Color.WHITE);
        howManyPeopleTXT.setBackground(Color.WHITE);
        sexMaleCheckBox.setBackground(Color.WHITE);
        sexFemaleCheckBox.setBackground(Color.WHITE);

        isCorrect1Name.setVisible(false);
        isCorrect2Name.setVisible(false);
        isCorrect3Name.setVisible(false);
        isCorrectEgn.setVisible(false);
        isCorrectAge.setVisible(false);
        isCorrectNights.setVisible(false);
        isCorrectGuestsNumber.setVisible(false);
        isCorrectSex.setVisible(false);

        isIncorrect1Name.setVisible(false);
        isIncorrect2Name.setVisible(false);
        isIncorrect3Name.setVisible(false);
        isIncorrectEgn.setVisible(false);
        isIncorrectAge.setVisible(false);
        isIncorrectNights.setVisible(false);
        isIncorrectGuestsNumber.setVisible(false);
        isIncorrectSex.setVisible(false);

        checkGuestData.setEnabled(true);
        submitGuestData.setEnabled(false);
        firstNameTXT.setEditable(true);
        secondNameTXT.setEditable(true);
        thirdNameTXT.setEditable(true);
        egnTXT.setEditable(true);
        ageTXT.setEditable(true);
        nightsTXT.setEditable(true);
        howManyPeopleTXT.setEditable(true);
        sexMaleCheckBox.setEnabled(true);
        sexFemaleCheckBox.setEnabled(true);

        roomMessage.setVisible(false);
        storeyMessage.setVisible(false);
        checkMoneyData.setVisible(true);
        checkMoneyData.setEnabled(true);
        submitMoneyData.setVisible(true);
        submitMoneyData.setEnabled(false);

        changeL.setText("");
        moneyTXT.setText("");
        moneyTXT.setEditable(true);
        chooseCurrency.setEnabled(true);
        currencyGuestData = null;
        isCorrectMoney.setVisible(false);
        continueMoneyData.setVisible(false);
        refresh.setEnabled(true);

        firstNameGuestData = null;
        secondNameGuestData = null;
        thirdNameGuestData = null;
        egnGuestData = null;
        ageGuestData = 0;
        isMale = 0;
        isFemale = 0;
        howManyPeopleGuestData = 0;
        nightsGuestData = 0;
        moneyGuestData = BigDecimal.valueOf(0.00);
        currencyGuestData = null;
        roomNumberForAddingGuest = -1;
    }

    private void GetCheckMoneyOperations() {
        //noinspection LoopStatementThatDoesntLoop
        do {
            try {
                if (moneyTXT.getText() == null || moneyTXT.getText().equals("")) {
                        moneyGuestData = BigDecimal.valueOf(0.00);
                } else {
                    moneyGuestData = BigDecimal.valueOf(Double.parseDouble(moneyGetTXT));
                    //changing money
                    if (currencyGuestData == null) {
                        throw new CurrencyException();
                    }


                    switch (howManyPeopleGuestData) {
                        case 1: {
                            if (currencyGuestData.equals("USD")) {
                                moneyGuestData = BigDecimal.valueOf(CurrencyConverter(moneyGuestData.doubleValue()));
                            }

                            if (moneyGuestData.doubleValue() < (storeyFirst.getPriceForRoom() * nightsGuestData)) {
                                throw new OutOfRangeException();
                            }
                        } break;

                        case 2: {
                            if (currencyGuestData.equals("USD")) {
                                moneyGuestData = BigDecimal.valueOf(CurrencyConverter(moneyGuestData.doubleValue()));
                            }

                            if (moneyGuestData.doubleValue() < (storeySecond.getPriceForRoom() * nightsGuestData)) {
                                throw new OutOfRangeException();
                            }
                        } break;

                        case 3: {
                            if (currencyGuestData.equals("USD")) {
                                moneyGuestData = BigDecimal.valueOf(CurrencyConverter(moneyGuestData.doubleValue()));
                            }

                            if (moneyGuestData.doubleValue() < (storeyThird.getPriceForRoom() * nightsGuestData)) {
                                throw new OutOfRangeException();
                            }
                        } break;
                    }
                }

                isIncorrectMoney.setVisible(false);
                isCorrectMoney.setVisible(true);
                moneyTXT.setBackground(Color.WHITE);
                chooseCurrency.setBackground(Color.WHITE);
                checkMoneyData.setEnabled(false);
                submitMoneyData.setEnabled(true);
                chooseCurrency.setEnabled(false);
                moneyTXT.setEditable(false);

                break;

            } catch (NumberFormatException nfe) {
                isIncorrectMoney.setVisible(true);
                isIncorrectMoney.setToolTipText("Това не е число.");
                moneyTXT.setBackground(Color.PINK);
                break;
            } catch (OutOfRangeException ore) {
                isIncorrectMoney.setVisible(true);
                isIncorrectMoney.setToolTipText("Парите не са достатъчно.");
                moneyTXT.setBackground(Color.PINK);
                break;
            } catch (CurrencyException ce) {
                isIncorrectMoney.setVisible(true);
                isIncorrectMoney.setToolTipText("Трябва да изберете валута.");
                chooseCurrency.setBackground(Color.PINK);
                break;
            } catch (Exception e) {
                isIncorrectMoney.setVisible(true);
                isIncorrectMoney.setToolTipText("Има грешка, но не е ясно каква.");
                moneyTXT.setBackground(Color.PINK);
                break;
            }
        } while (true);
    }

    private void GetSubmitReservationOperations() {
        reserveRoomFrame.setVisible(false);
        rUSureReserveRoomFrame.setVisible(true);

        getReserveQuestion11R.setText(firstNameGuestDataReserve);
        getReserveQuestion12R.setText(thirdNameGuestDataReserve);
        getReserveQuestion2R.setText(String.valueOf(nightsGuestDataReserve));
        getReserveQuestion3R.setText(String.valueOf(howManyPeopleGuestDataReserve));
        getReserveQuestion4R.setText(String.valueOf(offerDate));
    }

    private void GetSubmitAddNewGuestOperations() {
        addNewGuestFrame.setVisible(false);
        rUSureAddGuestFrame.setVisible(true);

        getAddQuestion11.setText(firstNameGuestData);
        getAddQuestion12.setText(secondNameGuestData);
        getAddQuestion13.setText(thirdNameGuestData);
        getAddQuestion2.setText(egnGuestData);
        getAddQuestion3.setText(String.valueOf(ageGuestData));
        getAddQuestion4.setText(String.valueOf(nightsGuestData));
        getAddQuestion5.setText(String.valueOf(howManyPeopleGuestData));
        getAddQuestion6.setText(sexGuestData);
    }

    private boolean CheckIfThereIsEmptyFiles(File[] files) {
        boolean isEmpty = false;
        for (File aFile : files) {
            if (aFile.length() == 0) {
                isEmpty = true;
                break;
            }
        }
        if (!isEmpty) {
            rUSureReserveRoomFrame.setVisible(false);
            reserveRoomFrame.setVisible(true);
            nightsReserveTXT.setEditable(true);
            dateChooserReserve.setEnabled(true);
            howManyPeopleReserveTXT.setEditable(true);
            isCorrectGuestsNumberReserve.setVisible(false);
            isIncorrectGuestsNumberReserve.setVisible(true);
            isIncorrectGuestsNumberReserve.setToolTipText("Няма свободни стаи от този тип.");
            checkReservation.setEnabled(true);
            submitReservation.setEnabled(false);
        }
        return isEmpty;
    }

    private void GetYesReservedOperations() {
        int remainder = howManyPeopleGuestDataReserve;
        int room;
        boolean[] isCorrect = {true, true, true};
        switch (remainder) {
            case 1: {
                isCorrect[0] = CheckIfThereIsEmptyFiles(firstStoreyFilesReserved);
                for (room = 0; room < roomsFirstStorey.length; room++) {
                    if (firstStoreyFilesReserved[room].length() != 0) {
                        continue;
                    }
                    if ((roomsFirstStorey[room] == null) && (firstStoreyFilesReserved[room].length() == 0)) {
                        guest.setRoomNum(room);
                        WriterReserved(room, 1);
                        guest = null;
                        isCorrect[0] = true;
                        break;
                    } else if (roomsFirstStorey[room].getCheckingOutDate().compareTo(offerDate) <= 0) {
                        guest.setRoomNum(room);
                        WriterReserved(room, 1);
                        guest = null;
                        isCorrect[0] = true;
                        break;
                    }
                }
            } break;
            case 2: {
                isCorrect[1] = CheckIfThereIsEmptyFiles(secondStoreyFilesReserved);
                for (room = 0; room < roomsSecondStorey.length; room++) {
                    if (secondStoreyFilesReserved[room].length() != 0) {
                        continue;
                    }
                    if ((roomsSecondStorey[room] == null) && (secondStoreyFilesReserved[room].length() == 0)) {
                        guest.setRoomNum(room);
                        WriterReserved(room, 2);
                        isCorrect[1] = true;
                        guest = null;
                        break;
                    } else if (roomsSecondStorey[room].getCheckingOutDate().compareTo(offerDate) <= 0) {
                        roomsSecondStorey[room].setRoomNum(room);
                        WriterReserved(room, 2);
                        isCorrect[1] = true;
                        guest = null;
                        break;
                    }
                }
            } break;
            case 3: {
                isCorrect[2] = CheckIfThereIsEmptyFiles(thirdStoreyFilesReserved);
                for (room = 0; room < roomsThirdStorey.length; room++) {
                    if (thirdStoreyFilesReserved[room].length() != 0) {
                        continue;
                    }
                    if ((roomsThirdStorey[room] == null) && (thirdStoreyFilesReserved[room].length() == 0)) {
                        guest.setRoomNum(room);
                        WriterReserved(room, 3);
                        isCorrect[2] = true;
                        guest = null;
                        break;
                    } else if (roomsThirdStorey[room].getCheckingOutDate().compareTo(offerDate) <= 0) {
                        guest.setRoomNum(room);
                        WriterReserved(room, 3);
                        isCorrect[2] = true;
                        guest = null;
                        break;
                    }
                }
            } break;
        }
        if (isCorrect[0] && isCorrect[1] && isCorrect[2]) {
            rUSureReserveRoomFrame.setVisible(false);
            reserveRoomFrame.setVisible(false);
            mainFrame.setVisible(true);

            firstNameReserveTXT.setText("");
            thirdNameReserveTXT.setText("");
            nightsReserveTXT.setText("");
            howManyPeopleReserveTXT.setText("");

            firstNameReserveTXT.setBackground(Color.WHITE);
            thirdNameReserveTXT.setBackground(Color.WHITE);
            nightsReserveTXT.setBackground(Color.WHITE);
            howManyPeopleReserveTXT.setBackground(Color.WHITE);

            isCorrect1NameReserve.setVisible(false);
            isCorrect3NameReserve.setVisible(false);
            isCorrectNightsReserve.setVisible(false);
            isCorrectGuestsNumberReserve.setVisible(false);
            isCorrectCalendar.setVisible(false);

            isIncorrect1NameReserve.setVisible(false);
            isIncorrect3NameReserve.setVisible(false);
            isIncorrectNightsReserve.setVisible(false);
            isIncorrectGuestsNumberReserve.setVisible(false);
            isIncorrectCalendar.setVisible(false);

            firstNameReserveTXT.setEditable(true);
            thirdNameReserveTXT.setEditable(true);
            nightsReserveTXT.setEditable(true);
            howManyPeopleReserveTXT.setEditable(true);
            dateChooserReserve.setEnabled(true);
            checkReservation.setEnabled(true);
            submitReservation.setEnabled(false);

            firstNameGuestDataReserve = null;
            thirdNameGuestDataReserve = null;
            howManyPeopleGuestDataReserve = 0;
            nightsGuestDataReserve = 0;
            offerDate = null;
        }
    }

    private boolean CheckIfTheFileIsEmptyAddGuest(File[] files) {
        boolean isEmpty = false;
        for (File aFile : files) {
            if (aFile.length() == 0) {
                isEmpty = true;
                break;
            }
        }
        if (!isEmpty) {
            moneyFrame.setVisible(false);
            addNewGuestFrame.setVisible(true);
            nightsTXT.setEditable(true);
            howManyPeopleTXT.setEditable(true);
            checkGuestData.setEnabled(true);
            submitGuestData.setEnabled(false);
            checkMoneyData.setVisible(true);
            checkMoneyData.setEnabled(true);
            submitMoneyData.setVisible(true);
            submitMoneyData.setEnabled(false);
            isCorrectGuestsNumber.setVisible(false);
            isIncorrectGuestsNumber.setVisible(true);
            isCorrectMoney.setVisible(false);
            isIncorrectMoney.setVisible(false);
            isIncorrectGuestsNumber.setToolTipText("Няма свободни стаи от този тип.");
            moneyTXT.setEditable(true);
            chooseCurrency.setEnabled(true);
        }
        return isEmpty;
    }

    private void CheckSubmitMoneyOperations(Scanner[] scanner, File[] file, Guest[] guests, int storey) {
        boolean[] isCorrect = {true, true, true};
        switch (storey) {
            case 1: {
                isCorrect[0] = CheckIfTheFileIsEmptyAddGuest(firstStoreyFiles);
                for (int room = 0; room < guests.length; room++) {
                    if (roomNumberForAddingGuest != -1) {
                        CheckingRooms1(roomNumberForAddingGuest, isPaid, isNotPaid);
                        roomNumberForAddingGuest = -1;
                        break;
                    } else {
                        if (isNotClean[room].isVisible()) {
                            continue;
                        }
                        if (file[room].length() == 0) {
                            if (guests[room] != null) {
                                continue;
                            }
                            CheckingRooms1(room, isPaid, isNotPaid);
                            isCorrect[0] = true;
                            break;

                        } else if (GetOfferDateReserved(scanner[room], file[room]).compareTo(checkingOutDate) >= 0) {
                            if (guests[room] != null) {
                                continue;
                            }
                            CheckingRooms1(room, isPaid, isNotPaid);
                            isCorrect[0] = true;
                            break;
                        }
                    }
                }
            } break;

            case 2: {
                isCorrect[1] = CheckIfTheFileIsEmptyAddGuest(secondStoreyFiles);
                for (int room = 0; room < guests.length; room++) {
                    if (roomNumberForAddingGuest != -1) {
                        CheckingRooms2(roomNumberForAddingGuest, isPaid, isNotPaid);
                        roomNumberForAddingGuest = -1;
                        break;
                    } else {
                        if (isNotClean[room + 5].isVisible()) {
                            continue;
                        }
                        if (file[room].length() == 0) {
                            if (guests[room] != null) {
                                continue;
                            }
                            CheckingRooms2(room, isPaid, isNotPaid);
                            isCorrect[1] = true;
                            break;

                        } else if (GetOfferDateReserved(scanner[room], file[room]).compareTo(checkingOutDate) >= 0) {
                            if (guests[room] != null) {
                                continue;
                            }
                            CheckingRooms2(room, isPaid, isNotPaid);
                            isCorrect[1] = true;
                            break;
                        }
                    }

                }
            } break;

            case 3: {
                isCorrect[2] = CheckIfTheFileIsEmptyAddGuest(thirdStoreyFiles);
                for (int room = 0; room < guests.length; room++) {
                    if (roomNumberForAddingGuest != -1) {
                        CheckingRooms3(roomNumberForAddingGuest, isPaid, isNotPaid);
                        roomNumberForAddingGuest = -1;
                        break;
                    } else {
                        if (isNotClean[room + 10].isVisible()) {
                            continue;
                        }
                        if (file[room].length() == 0) {
                            if (guests[room] != null) {
                                continue;
                            }
                            CheckingRooms3(room, isPaid, isNotPaid);
                            isCorrect[2] = true;
                            break;

                        } else if (GetOfferDateReserved(scanner[room], file[room]).compareTo(checkingOutDate) >= 0) {
                            if (guests[room] != null) {
                                continue;
                            }
                            CheckingRooms3(room, isPaid, isNotPaid);
                            isCorrect[2] = true;
                            break;
                        }
                    }

                }
            } break;
        }
        if (isCorrect[0] && isCorrect[1] && isCorrect[2]) {
            ButtonsVisible();
        }

    }

    private void GetSubmitMoneyOperations() {
        checkMoneyData.setVisible(false);
        submitMoneyData.setVisible(false);
        int remainder = howManyPeopleGuestData;
        switch (remainder) {
            case 1: {
                CheckSubmitMoneyOperations(firstStoreyReadersReserved, firstStoreyFilesReserved, roomsFirstStorey, remainder);
            } break;
            case 2: {
                CheckSubmitMoneyOperations(secondStoreyReadersReserved, secondStoreyFilesReserved, roomsSecondStorey, remainder);
            } break;
            case 3: {
                CheckSubmitMoneyOperations(thirdStoreyReadersReserved, thirdStoreyFilesReserved, roomsThirdStorey, remainder);
            } break;
        }
    }

    private void ButtonsVisible() {
        continueMoneyData.setVisible(true);
        continueMoneyData.setEnabled(true);
        roomMessage.setVisible(true);
        storeyMessage.setVisible(true);
    }

    private void CheckingRooms1(int room, JLabel[] isPaid, JLabel[] isNotPaid) {
        roomNumGuestData = room;
        if (roomsFirstStorey[room] == null) {
            roomsFirstStorey[room] = guest;
            roomsFirstStorey[roomNumGuestData].setRoomNum(roomNumGuestData);
            storeyGuestData = 1;
            turnOver += MoneyProcessing(storeyFirst, roomNumGuestData, storeyGuestData, moneyGuestData, changeL, roomMessage, storeyMessage, 0.0, false);
            try {
                Files.newOutputStream(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            moneyWriter.println(turnOver);
            moneyWriter.flush();
            if (moneyGuestData.equals(BigDecimal.valueOf(0.00))) {
                isPaid[room].setVisible(false);
                isNotPaid[room].setVisible(true);
            } else {
                isNotPaid[room].setVisible(false);
                isPaid[room].setVisible(true);
            }
            Writer(room, 1, firstStoreyPrice);
            greenLight[room].setVisible(false);
            redLight[room].setVisible(true);
            enterRoom[room].setVisible(true);
            blueLight[room].setVisible(false);
            guest = null;
        }
    }

    private void CheckingRooms2(int room, JLabel[] isPaid, JLabel[] isNotPaid) {
        roomNumGuestData = room;
        if (roomsSecondStorey[room] == null) {
            roomsSecondStorey[room] = guest;
            roomsSecondStorey[roomNumGuestData].setRoomNum(roomNumGuestData);
            storeyGuestData = 2;
            turnOver += MoneyProcessing(storeySecond, roomNumGuestData, storeyGuestData, moneyGuestData, changeL, roomMessage, storeyMessage, 0.0, false);
            try {
                Files.newOutputStream(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            moneyWriter.println(turnOver);
            moneyWriter.flush();
            if (moneyGuestData.equals(BigDecimal.valueOf(0.00))) {
                isPaid[room + 5].setVisible(false);
                isNotPaid[room + 5].setVisible(true);
            } else {
                isNotPaid[room + 5].setVisible(false);
                isPaid[room + 5].setVisible(true);
            }
            Writer(room, 2, secondStoreyPrice);
            greenLight[room + 5].setVisible(false);
            redLight[room + 5].setVisible(true);
            enterRoom[room + 5].setVisible(true);
            blueLight[room + 5].setVisible(false);
            guest = null;
        }
    }

    private void CheckingRooms3(int room, JLabel[] isPaid, JLabel[] isNotPaid) {
        roomNumGuestData = room;
        if (roomsThirdStorey[room] == null) {
            roomsThirdStorey[room] = guest;
            roomsThirdStorey[roomNumGuestData].setRoomNum(roomNumGuestData);
            storeyGuestData = 3;
            turnOver += MoneyProcessing(storeyThird, roomNumGuestData, storeyGuestData, moneyGuestData, changeL, roomMessage, storeyMessage, 0.0, false);
            try {
                Files.newOutputStream(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            moneyWriter.println(turnOver);
            moneyWriter.flush();
            if (moneyGuestData.equals(BigDecimal.valueOf(0.00))) {
                isPaid[room + 10].setVisible(false);
                isNotPaid[room + 10].setVisible(true);
            } else {
                isNotPaid[room + 10].setVisible(false);
                isPaid[room + 10].setVisible(true);
            }
            Writer(room, 3, thirdStoreyPrice);
            greenLight[room + 10].setVisible(false);
            redLight[room + 10].setVisible(true);
            enterRoom[room + 10].setVisible(true);
            blueLight[room + 10].setVisible(false);
            guest = null;
        }
    }

    private LocalDate GetOfferDateReserved(Scanner scanner, File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String nothing = scanner.next();
        nothing = scanner.next();
        nothing = scanner.next();
        nothing = scanner.next();
        nothing = scanner.next();
        LocalDate offerDate = LocalDate.parse(scanner.next());
        scanner.close();
        return offerDate;
    }

    private BigDecimal RefreshRoomsState(Scanner scanner, File file) throws OutOfRangeLettersException, NameException, FirstLetterException, OutOfRangeException, EGNException, EGNNumberException {
        String firstName = null;
        String secondName;
        String thirdName;
        int age;
        String egn;
        String sex;
        int howManyPeople;
        int nights;
        int roomNum;
        LocalDate checkingOutDate;
        LocalDate offerDate;
        BigDecimal moneyGuestData = BigDecimal.valueOf(0.10);
        String nothing;

        if (file.length() == 0) {
            isNotCleanRoom = false;
            guest = null;
            moneyGuestData = BigDecimal.valueOf(0.10);
        } else {
            scanner.close();
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (!scanner.hasNext()) {
                guest = null;
            } else {
                firstName = scanner.nextLine();
            }

            if (!scanner.hasNext()) {
                isNotCleanRoom = true;
                guest = null;
            } else if (guest == null){
                isNotCleanRoom = false;
                secondName = scanner.next();
                thirdName = scanner.next();
                age = scanner.nextInt();
                egn = scanner.next();
                sex = scanner.next();
                howManyPeople = scanner.nextInt();
                nights = scanner.nextInt();
                roomNum = scanner.nextInt();
                offerDate = LocalDate.parse(scanner.next());
                checkingOutDate = LocalDate.parse(scanner.next());
                moneyGuestData = BigDecimal.valueOf(Double.parseDouble(scanner.next()));
                nothing = scanner.next();
                nothing = scanner.next();
                isPaidRoom = scanner.hasNext();
                guest = Guest.GuestSum(firstName, secondName, thirdName, age, egn, sex, howManyPeople, nights, roomNum, offerDate, checkingOutDate);
            }
        }
        return moneyGuestData;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {}

    @SuppressWarnings("ConstantConditions")
    private void GetCheckReservationOperations() {
        String nameValidator = null;
        String isNullData = null;
        String isNumber = null;
        String calendar = null;

        //noinspection LoopStatementThatDoesntLoop
        do {
            try {
                //first name
                firstNameGuestDataReserve = firstNameReserveGetTXT;

                nameValidator = "first name";
                isNullData = "first name";

                String firstNameIn = String.valueOf(firstNameGuestDataReserve);
                boolean isWrongLetters1 = getLetters(firstNameIn);
                boolean isWrongFirstLetter1 = true;
                char firstLetter1 = firstNameGuestDataReserve.charAt(0);
                for (char aChar : chars) {
                    if (firstLetter1 == aChar) {
                        isWrongFirstLetter1 = false;
                        break;
                    }
                }

                Validator.CorrectName(firstNameIn, isWrongLetters1, isWrongFirstLetter1);
                isIncorrect1NameReserve.setVisible(false);
                isCorrect1NameReserve.setVisible(true);
                firstNameReserveTXT.setBackground(Color.WHITE);
                firstNameReserveTXT.setEditable(false);

                //third name
                thirdNameGuestDataReserve = thirdNameReserveGetTXT;

                nameValidator = "third name";
                isNullData = "third name";

                String thirdNameIn = String.valueOf(thirdNameGuestDataReserve);
                boolean isWrongLetters3 = getLetters(thirdNameIn);
                boolean isWrongFirstLetter3 = true;
                char firstLetter3 = thirdNameGuestDataReserve.charAt(0);
                for (char aChar : chars) {
                    if (firstLetter3 == aChar) {
                        isWrongFirstLetter3 = false;
                        break;
                    }
                }

                Validator.CorrectName(thirdNameIn, isWrongLetters3, isWrongFirstLetter3);
                isIncorrect3NameReserve.setVisible(false);
                isCorrect3NameReserve.setVisible(true);
                thirdNameReserveTXT.setBackground(Color.WHITE);
                thirdNameReserveTXT.setEditable(false);

                //nights
                isNullData = "nights";
                isNumber = "nights";

                nightsGuestDataReserve = Integer.parseInt(nightsReserveGetTXT);
                if (nightsGuestDataReserve <= 0) {
                    throw new NightsException();
                }

                isIncorrectNightsReserve.setVisible(false);
                isCorrectNightsReserve.setVisible(true);
                nightsReserveTXT.setBackground(Color.WHITE);
                nightsReserveTXT.setEditable(false);

                //how many people
                isNullData = "guest's number";
                isNumber = "guest's number";

                howManyPeopleGuestDataReserve = Integer.parseInt(howManyPeopleReserveGetTXT);
                if (howManyPeopleGuestDataReserve != 1 && howManyPeopleGuestDataReserve != 2 && howManyPeopleGuestDataReserve != 3) {
                    throw new HowManyPeopleException();
                }

                isIncorrectGuestsNumberReserve.setVisible(false);
                isCorrectGuestsNumberReserve.setVisible(true);
                howManyPeopleReserveTXT.setBackground(Color.WHITE);
                howManyPeopleReserveTXT.setEditable(false);

                if (offerDate == null) {
                    calendar = "null";
                    throw new CalendarException();
                }

                if (offerDate.compareTo(LocalDate.now()) < 0) {
                    calendar = "impossible";
                    throw new CalendarException();
                }

                checkingOutDate = offerDate.plusDays(nightsGuestDataReserve);
                isIncorrectCalendar.setVisible(false);
                isCorrectCalendar.setVisible(true);
                dateChooserReserve.setBackground(Color.WHITE);
                dateChooserReserve.setEnabled(false);

                String reservation = "Резервация";
                String egnReservation = "0000000000";
                int age = 18;
                Validator.CorrectAge(age);
                Validator.CorrectName(reservation, false, false);
                Validator.CorrectEgn(egnReservation, false);

                guest = Guest.GuestSum
                        (firstNameGuestDataReserve, reservation, thirdNameGuestDataReserve, age, egnReservation, reservation,
                                howManyPeopleGuestDataReserve, nightsGuestDataReserve, 0, offerDate, checkingOutDate);

                checkReservation.setEnabled(false);
                submitReservation.setEnabled(true);

                break;

            } catch (NumberFormatException nfe) {
                assert isNumber != null;
                switch (isNumber) {
                    case "nights": {
                        isIncorrectNightsReserve.setVisible(true);
                        isIncorrectNightsReserve.setToolTipText("Това не е число.");
                        nightsReserveTXT.setBackground(Color.PINK);
                    } break;

                    case "guest's number": {
                        isIncorrectGuestsNumberReserve.setVisible(true);
                        isIncorrectGuestsNumberReserve.setToolTipText("Това не е число.");
                        howManyPeopleReserveTXT.setBackground(Color.PINK);
                    } break;
                }
                break;
            } catch (CalendarException ce) {
                switch (calendar) {
                    case "null": {
                        isIncorrectCalendar.setVisible(true);
                        isIncorrectCalendar.setToolTipText("Трябва да изберете дата.");
                        dateChooserReserve.setBackground(Color.PINK);
                        break;
                    }
                    case "impossible": {
                        isIncorrectCalendar.setVisible(true);
                        isIncorrectCalendar.setToolTipText("Датата не може да съответства на предишен ден.");
                        dateChooserReserve.setBackground(Color.PINK);
                        break;
                    }
                }
                break;
            } catch (HowManyPeopleException hmpeа) {
                isIncorrectGuestsNumberReserve.setVisible(true);
                isIncorrectGuestsNumberReserve.setToolTipText("Числото не може да бъде различно от 1, 2 или 3.");
                howManyPeopleReserveTXT.setBackground(Color.PINK);
                break;
            } catch (NightsException nieа) {
                isIncorrectNightsReserve.setVisible(true);
                isIncorrectNightsReserve.setToolTipText("Числото трябва да бъде позитивно.");
                nightsReserveTXT.setBackground(Color.PINK);
                break;
            } catch (NullPointerException npeа) {
                switch (isNullData) {
                    case "first name": {
                        isIncorrect1NameReserve.setVisible(true);
                        isIncorrect1NameReserve.setToolTipText("Трябва да въведете информация.");
                        firstNameReserveTXT.setBackground(Color.PINK);
                    } break;

                    case "third name": {
                        isIncorrect3NameReserve.setVisible(true);
                        isIncorrect3NameReserve.setToolTipText("Трябва да въведете информация.");
                        thirdNameReserveTXT.setBackground(Color.PINK);
                    } break;

                    case "nights": {
                        isIncorrectNightsReserve.setVisible(true);
                        isIncorrectNightsReserve.setToolTipText("Трябва да въведете информация.");
                        nightsReserveTXT.setBackground(Color.PINK);
                    } break;

                    case "guest's number": {
                        isIncorrectGuestsNumberReserve.setVisible(true);
                        isIncorrectGuestsNumberReserve.setToolTipText("Трябва да въведете информация.");
                        howManyPeopleReserveTXT.setBackground(Color.PINK);
                    } break;
                }
                break;
            } catch (OutOfRangeLettersException orl) {
                switch (nameValidator) {
                    case "first name": {
                        isIncorrect1NameReserve.setVisible(true);
                        isIncorrect1NameReserve.setToolTipText("Името трябва да съдържа повече от 1 буква.");
                        firstNameReserveTXT.setBackground(Color.PINK);
                    } break;

                    case "third name": {
                        isIncorrect3NameReserve.setVisible(true);
                        isIncorrect3NameReserve.setToolTipText("Името трябва да съдържа повече от 1 буква.");
                        thirdNameReserveTXT.setBackground(Color.PINK);
                    } break;
                }
                break;
            } catch (NameException ne) {
                switch (nameValidator) {
                    case "first name": {
                        isIncorrect1NameReserve.setVisible(true);
                        isIncorrect1NameReserve.setToolTipText("Името не може да съдържа цифри или празни места.");
                        firstNameReserveTXT.setBackground(Color.PINK);
                    } break;

                    case "third name": {
                        isIncorrect3NameReserve.setVisible(true);
                        isIncorrect3NameReserve.setToolTipText("Името не може да съдържа цифри или празни места.");
                        thirdNameReserveTXT.setBackground(Color.PINK);
                    }break;
                }
                break;
            } catch (FirstLetterException fle) {
                switch (nameValidator) {
                    case "first name": {
                        isIncorrect1NameReserve.setVisible(true);
                        isIncorrect1NameReserve.setToolTipText("Първата буква трябва да бъде главна.");
                        firstNameReserveTXT.setBackground(Color.PINK);
                    } break;

                    case "third name": {
                        isIncorrect3NameReserve.setVisible(true);
                        isIncorrect3NameReserve.setToolTipText("Първата буква трябва да бъде главна.");
                        thirdNameReserveTXT.setBackground(Color.PINK);
                    } break;
                }
                break;
            } catch (Exception e) {
                JLabel[] label = {isIncorrect1NameReserve, isIncorrect3NameReserve, isIncorrectNightsReserve, isIncorrectGuestsNumberReserve, isIncorrectCalendar};
                for (JLabel jLabel : label) {
                    jLabel.setVisible(true);
                    jLabel.setToolTipText("Има грешка, но не е ясно каква.");
                }
                break;
            }
        } while (true);
    }

    @SuppressWarnings("ConstantConditions")
    private void GetCheckAddNewGuestOperations() {
        String nameValidator = null;
        String isNullData = null;
        String isNumber = null;

        //noinspection LoopStatementThatDoesntLoop
        do {
            try {
                //first name
                firstNameGuestData = firstNameGetTXT;

                nameValidator = "first name";
                isNullData = "first name";

                String firstNameIn = String.valueOf(firstNameGuestData);
                boolean isWrongLetters1 = getLetters(firstNameIn);
                boolean isWrongFirstLetter1 = true;
                char firstLetter1 = firstNameGuestData.charAt(0);
                for (char aChar : chars) {
                    if (firstLetter1 == aChar) {
                        isWrongFirstLetter1 = false;
                        break;
                    }
                }

                Validator.CorrectName(firstNameIn, isWrongLetters1, isWrongFirstLetter1);
                isIncorrect1Name.setVisible(false);
                isCorrect1Name.setVisible(true);
                firstNameTXT.setBackground(Color.WHITE);
                firstNameTXT.setEditable(false);

                //second name
                secondNameGuestData = secondNameGetTXT;

                nameValidator = "second name";
                isNullData = "second name";

                String secondNameIn = String.valueOf(secondNameGuestData);
                boolean isWrongLetters2 = getLetters(secondNameIn);
                boolean isWrongFirstLetter2 = true;
                char firstLetter2 = secondNameGuestData.charAt(0);
                for (char aChar : chars) {
                    if (firstLetter2 == aChar) {
                        isWrongFirstLetter2 = false;
                        break;
                    }
                }

                Validator.CorrectName(secondNameIn, isWrongLetters2, isWrongFirstLetter2);
                isIncorrect2Name.setVisible(false);
                isCorrect2Name.setVisible(true);
                secondNameTXT.setBackground(Color.WHITE);
                secondNameTXT.setEditable(false);

                //third name
                thirdNameGuestData = thirdNameGetTXT;

                nameValidator = "third name";
                isNullData = "third name";

                String thirdNameIn = String.valueOf(thirdNameGuestData);
                boolean isWrongLetters3 = getLetters(thirdNameIn);
                boolean isWrongFirstLetter3 = true;
                char firstLetter3 = thirdNameGuestData.charAt(0);
                for (char aChar : chars) {
                    if (firstLetter3 == aChar) {
                        isWrongFirstLetter3 = false;
                        break;
                    }
                }

                Validator.CorrectName(thirdNameIn, isWrongLetters3, isWrongFirstLetter3);
                isIncorrect3Name.setVisible(false);
                isCorrect3Name.setVisible(true);
                thirdNameTXT.setBackground(Color.WHITE);
                thirdNameTXT.setEditable(false);

                //egn
                egnGuestData = egnGetTXT;

                isNullData = "egn";

                String egnIn = String.valueOf(egnGuestData);
                boolean isWrongNumbers = getNumbers(egnIn);

                Validator.CorrectEgn(egnIn, isWrongNumbers);
                isIncorrectEgn.setVisible(false);
                isCorrectEgn.setVisible(true);
                egnTXT.setBackground(Color.WHITE);
                egnTXT.setEditable(false);

                //age
                isNullData = "age";
                isNumber = "age";

                ageGuestData = Integer.parseInt(ageGetTXT);
                Validator.CorrectAge(ageGuestData);
                isIncorrectAge.setVisible(false);
                isCorrectAge.setVisible(true);
                ageTXT.setBackground(Color.WHITE);
                ageTXT.setEditable(false);

                //nights
                isNullData = "nights";
                isNumber = "nights";

                nightsGuestData = Integer.parseInt(nightsGetTXT);
                if (nightsGuestData <= 0) {
                    throw new NightsException();
                }

                isIncorrectNights.setVisible(false);
                isCorrectNights.setVisible(true);
                nightsTXT.setBackground(Color.WHITE);
                nightsTXT.setEditable(false);

                //how many people
                isNullData = "guest's number";
                isNumber = "guest's number";

                if (howManyPeopleGuestData != 1 && howManyPeopleGuestData != 2 && howManyPeopleGuestData != 3) {
                    howManyPeopleGuestData = Integer.parseInt(howManyPeopleGetTXT);
                    if (howManyPeopleGuestData != 1 && howManyPeopleGuestData != 2 && howManyPeopleGuestData != 3) {
                        throw new HowManyPeopleException();
                    }
                }

                isIncorrectGuestsNumber.setVisible(false);
                isCorrectGuestsNumber.setVisible(true);
                howManyPeopleTXT.setBackground(Color.WHITE);
                howManyPeopleTXT.setEditable(false);

                //sex
                if (isMale == 0 && isFemale == 0) {
                    throw new CheckBoxException();
                } else if (isMale == 1) {
                    sexGuestData = "Мъж";
                } else if (isFemale == 1) {
                    sexGuestData = "Жена";
                }

                isIncorrectSex.setVisible(false);
                isCorrectSex.setVisible(true);
                sexMaleCheckBox.setBackground(Color.WHITE);
                sexFemaleCheckBox.setBackground(Color.WHITE);
                sexMaleCheckBox.setEnabled(false);
                sexFemaleCheckBox.setEnabled(false);
                offerDate = LocalDate.now();

                if (LocalTime.now().compareTo(LocalTime.of(11, 59, 59)) < 0) {
                    checkingOutDate = LocalDate.now().plusDays(nightsGuestData - 1);
                } else {
                    checkingOutDate = LocalDate.now().plusDays(nightsGuestData);
                }

                guest = Guest.GuestSum
                        (firstNameGuestData, secondNameGuestData, thirdNameGuestData, ageGuestData, egnGuestData, sexGuestData,
                                howManyPeopleGuestData, nightsGuestData, 0, offerDate, checkingOutDate);

                checkGuestData.setEnabled(false);
                submitGuestData.setEnabled(true);

                break;

            } catch (NumberFormatException nfe) {
                assert isNumber != null;
                switch (isNumber) {
                    case "age": {
                        isIncorrectAge.setVisible(true);
                        isIncorrectAge.setToolTipText("Това не е число.");
                        ageTXT.setBackground(Color.PINK);
                    } break;

                    case "nights": {
                        isIncorrectNights.setVisible(true);
                        isIncorrectNights.setToolTipText("Това не е число.");
                        nightsTXT.setBackground(Color.PINK);
                    } break;

                    case "guest's number": {
                        isIncorrectGuestsNumber.setVisible(true);
                        isIncorrectGuestsNumber.setToolTipText("Това не е число.");
                        howManyPeopleTXT.setBackground(Color.PINK);
                    } break;
                }
                break;
            } catch (HowManyPeopleException hmpe) {
                isIncorrectGuestsNumber.setVisible(true);
                isIncorrectGuestsNumber.setToolTipText("Числото не може да бъде различно от 1, 2 или 3.");
                howManyPeopleTXT.setBackground(Color.PINK);
                break;
            } catch (NightsException nie) {
                isIncorrectNights.setVisible(true);
                isIncorrectNights.setToolTipText("Числото трябва да бъде позитивно.");
                nightsTXT.setBackground(Color.PINK);
                break;
            } catch (CheckBoxException cbe) {
                isIncorrectSex.setVisible(true);
                isIncorrectSex.setToolTipText("Трябва да изберете пол.");
                sexFemaleCheckBox.setBackground(Color.PINK);
                sexMaleCheckBox.setBackground(Color.PINK);
                break;
            } catch (OutOfRangeException ore) {
                isIncorrectAge.setVisible(true);
                isIncorrectAge.setToolTipText("Възрастта трябва да бъде по-голяма от 18.");
                ageTXT.setBackground(Color.PINK);
                break;
            } catch (EGNException ee) {
                isIncorrectEgn.setVisible(true);
                isIncorrectEgn.setToolTipText("ЕГН-то трябва да има дължина 10 символа.");
                egnTXT.setBackground(Color.PINK);
                break;
            } catch (NullPointerException npe) {
                switch (isNullData) {
                    case "first name": {
                        isIncorrect1Name.setVisible(true);
                        isIncorrect1Name.setToolTipText("Трябва да въведете информация.");
                        firstNameTXT.setBackground(Color.PINK);
                    } break;

                    case "second name": {
                        isIncorrect2Name.setVisible(true);
                        isIncorrect2Name.setToolTipText("Трябва да въведете информация.");
                        secondNameTXT.setBackground(Color.PINK);
                    } break;

                    case "third name": {
                        isIncorrect3Name.setVisible(true);
                        isIncorrect3Name.setToolTipText("Трябва да въведете информация.");
                        thirdNameTXT.setBackground(Color.PINK);
                    } break;

                    case "egn": {
                        isIncorrectEgn.setVisible(true);
                        isIncorrectEgn.setToolTipText("Трябва да въведете информация.");
                        egnTXT.setBackground(Color.PINK);
                    } break;

                    case "age": {
                        isIncorrectAge.setVisible(true);
                        isIncorrectAge.setToolTipText("Трябва да въведете информация.");
                        ageTXT.setBackground(Color.PINK);
                    } break;

                    case "nights": {
                        isIncorrectNights.setVisible(true);
                        isIncorrectNights.setToolTipText("Трябва да въведете информация.");
                        nightsTXT.setBackground(Color.PINK);
                    } break;

                    case "guest's number": {
                        isIncorrectGuestsNumber.setVisible(true);
                        isIncorrectGuestsNumber.setToolTipText("Трябва да въведете информация.");
                        howManyPeopleTXT.setBackground(Color.PINK);
                    } break;
                }
                break;
            } catch (EGNNumberException ene) {
                isIncorrectEgn.setVisible(true);
                isIncorrectEgn.setToolTipText("ЕГН-то не може да съдържа букви или празни места.");
                egnTXT.setBackground(Color.PINK);
                break;
            } catch (OutOfRangeLettersException orl) {
                switch (nameValidator) {
                    case "first name": {
                        isIncorrect1Name.setVisible(true);
                        isIncorrect1Name.setToolTipText("Името трябва да съдържа повече от 1 буква.");
                        firstNameTXT.setBackground(Color.PINK);
                    } break;

                    case "second name": {
                        isIncorrect2Name.setVisible(true);
                        isIncorrect2Name.setToolTipText("Името трябва да съдържа повече от 1 буква.");
                        secondNameTXT.setBackground(Color.PINK);
                    } break;

                    case "third name": {
                        isIncorrect3Name.setVisible(true);
                        isIncorrect3Name.setToolTipText("Името трябва да съдържа повече от 1 буква.");
                        thirdNameTXT.setBackground(Color.PINK);
                    } break;
                }
                break;
            } catch (NameException ne) {
                switch (nameValidator) {
                    case "first name": {
                        isIncorrect1Name.setVisible(true);
                        isIncorrect1Name.setToolTipText("Името не може да съдържа цифри или празни места.");
                        firstNameTXT.setBackground(Color.PINK);
                    } break;

                    case "second name": {
                        isIncorrect2Name.setVisible(true);
                        isIncorrect2Name.setToolTipText("Името не може да съдържа цифри или празни места.");
                        secondNameTXT.setBackground(Color.PINK);
                    } break;

                    case "third name": {
                        isIncorrect3Name.setVisible(true);
                        isIncorrect3Name.setToolTipText("Името не може да съдържа цифри или празни места.");
                        thirdNameTXT.setBackground(Color.PINK);
                    }break;
                }
                break;
            } catch (FirstLetterException fle) {
                switch (nameValidator) {
                    case "first name": {
                        isIncorrect1Name.setVisible(true);
                        isIncorrect1Name.setToolTipText("Първата буква трябва да бъде главна.");
                        firstNameTXT.setBackground(Color.PINK);
                    } break;

                    case "second name": {
                        isIncorrect2Name.setVisible(true);
                        isIncorrect2Name.setToolTipText("Първата буква трябва да бъде главна.");
                        secondNameTXT.setBackground(Color.PINK);
                    } break;

                    case "third name": {
                        isIncorrect3Name.setVisible(true);
                        isIncorrect3Name.setToolTipText("Първата буква трябва да бъде главна.");
                        thirdNameTXT.setBackground(Color.PINK);
                    } break;
                }
                break;
            } catch (Exception e) {
                JLabel[] label = {isIncorrect1Name, isIncorrect2Name, isIncorrect3Name, isIncorrectEgn,
                        isIncorrectAge, isIncorrectNights, isIncorrectSex, isIncorrectGuestsNumber};
                for (JLabel jLabel : label) {
                    jLabel.setVisible(true);
                    jLabel.setToolTipText("Има грешка, но не е ясно каква.");
                }
                break;
            }
        } while (true);
    }

    private void BackButtonForAddingGuest() {
        addNewGuestFrame.setVisible(false);
        mainFrame.setVisible(true);

        firstNameTXT.setText("");
        secondNameTXT.setText("");
        thirdNameTXT.setText("");
        egnTXT.setText("");
        ageTXT.setText("");
        nightsTXT.setText("");
        howManyPeopleTXT.setText("");
        sexChooser.clearSelection();

        firstNameTXT.setBackground(Color.WHITE);
        secondNameTXT.setBackground(Color.WHITE);
        thirdNameTXT.setBackground(Color.WHITE);
        ageTXT.setBackground(Color.WHITE);
        nightsTXT.setBackground(Color.WHITE);
        egnTXT.setBackground(Color.WHITE);
        howManyPeopleTXT.setBackground(Color.WHITE);
        sexMaleCheckBox.setBackground(Color.WHITE);
        sexFemaleCheckBox.setBackground(Color.WHITE);

        isCorrect1Name.setVisible(false);
        isCorrect2Name.setVisible(false);
        isCorrect3Name.setVisible(false);
        isCorrectEgn.setVisible(false);
        isCorrectAge.setVisible(false);
        isCorrectNights.setVisible(false);
        isCorrectGuestsNumber.setVisible(false);
        isCorrectSex.setVisible(false);

        isIncorrect1Name.setVisible(false);
        isIncorrect2Name.setVisible(false);
        isIncorrect3Name.setVisible(false);
        isIncorrectEgn.setVisible(false);
        isIncorrectAge.setVisible(false);
        isIncorrectNights.setVisible(false);
        isIncorrectGuestsNumber.setVisible(false);
        isIncorrectSex.setVisible(false);

        firstNameTXT.setEditable(true);
        secondNameTXT.setEditable(true);
        thirdNameTXT.setEditable(true);
        egnTXT.setEditable(true);
        ageTXT.setEditable(true);
        nightsTXT.setEditable(true);
        howManyPeopleTXT.setEditable(true);
        sexMaleCheckBox.setEnabled(true);
        sexFemaleCheckBox.setEnabled(true);

        checkGuestData.setEnabled(true);
        submitGuestData.setEnabled(false);
    }

    private void BackButtonForReserveRoom() {
        reserveRoomFrame.setVisible(false);
        mainFrame.setVisible(true);

        firstNameReserveTXT.setText("");
        thirdNameReserveTXT.setText("");
        nightsReserveTXT.setText("");
        howManyPeopleReserveTXT.setText("");

        firstNameReserveTXT.setBackground(Color.WHITE);
        thirdNameReserveTXT.setBackground(Color.WHITE);
        nightsReserveTXT.setBackground(Color.WHITE);
        howManyPeopleReserveTXT.setBackground(Color.WHITE);

        isCorrect1NameReserve.setVisible(false);
        isCorrect3NameReserve.setVisible(false);
        isCorrectNightsReserve.setVisible(false);
        isCorrectGuestsNumberReserve.setVisible(false);
        isCorrectCalendar.setVisible(false);

        isIncorrect1NameReserve.setVisible(false);
        isIncorrect3NameReserve.setVisible(false);
        isIncorrectGuestsNumberReserve.setVisible(false);
        isIncorrectNightsReserve.setVisible(false);
        isIncorrectCalendar.setVisible(false);

        firstNameReserveTXT.setEditable(true);
        thirdNameReserveTXT.setEditable(true);
        nightsReserveTXT.setEditable(true);
        howManyPeopleReserveTXT.setEditable(true);
        dateChooserReserve.setEnabled(true);
        dateChooserReserve.setEnabled(true);

        checkReservation.setEnabled(true);
        submitReservation.setEnabled(false);
    }

    private PrintStreams ChooseTXT(int room, int storey) {
        PrintStreams result = null;
        switch (storey) {
            case 1: {
                switch (room) {
                    case 0: result = new PrintStreams(firstStorey0Writer, firstStorey0WriterReserved); break;
                    case 1: result = new PrintStreams(firstStorey1Writer, firstStorey1WriterReserved); break;
                    case 2: result = new PrintStreams(firstStorey2Writer, firstStorey2WriterReserved); break;
                    case 3: result = new PrintStreams(firstStorey3Writer, firstStorey3WriterReserved); break;
                    case 4: result = new PrintStreams(firstStorey4Writer, firstStorey4WriterReserved); break;
                }
            }
            break;

            case 2: {
                switch (room) {
                    case 0: result = new PrintStreams(secondStorey0Writer, secondStorey0WriterReserved); break;
                    case 1: result = new PrintStreams(secondStorey1Writer, secondStorey1WriterReserved); break;
                    case 2: result = new PrintStreams(secondStorey2Writer, secondStorey2WriterReserved); break;
                    case 3: result = new PrintStreams(secondStorey3Writer, secondStorey3WriterReserved); break;
                    case 4: result = new PrintStreams(secondStorey4Writer, secondStorey4WriterReserved); break;
                }
            }
            break;

            case 3: {
                switch (room) {
                    case 0: result = new PrintStreams(thirdStorey0Writer, thirdStorey0WriterReserved); break;
                    case 1: result = new PrintStreams(thirdStorey1Writer, thirdStorey1WriterReserved); break;
                    case 2: result = new PrintStreams(thirdStorey2Writer, thirdStorey2WriterReserved); break;
                    case 3: result = new PrintStreams(thirdStorey3Writer, thirdStorey3WriterReserved); break;
                    case 4: result = new PrintStreams(thirdStorey4Writer, thirdStorey4WriterReserved); break;
                }
            }
            break;
        }
        return result;
    }

    private void Writer(int remainderRoom, int remainderStorey, double priceForRoom) {
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getFirstName());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getSecondName());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getThirdName());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getAge());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getEgn());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getSex());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getHowManyPeople());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getNights());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getRoomNum());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getOfferDate());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(guest.getCheckingOutDate());
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println(moneyGuestData);
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println((priceForRoom * nightsGuestData));
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().print(changeGuestData);
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().flush();
    }

    private void WriterAgain(int remainderRoom, int remainderStorey, double priceForRoom) {
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().println();
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().print(priceForRoom);
        ChooseTXT(remainderRoom, remainderStorey).getNoReserved().flush();
    }

    private void WriterReserved(int remainderRoom, int remainderStorey) {
        ChooseTXT(remainderRoom, remainderStorey).getIsReserved().println(guest.getFirstName());
        ChooseTXT(remainderRoom, remainderStorey).getIsReserved().println(guest.getThirdName());
        ChooseTXT(remainderRoom, remainderStorey).getIsReserved().println(guest.getHowManyPeople());
        ChooseTXT(remainderRoom, remainderStorey).getIsReserved().println(guest.getNights());
        ChooseTXT(remainderRoom, remainderStorey).getIsReserved().println(guest.getRoomNum());
        ChooseTXT(remainderRoom, remainderStorey).getIsReserved().println(guest.getOfferDate());
        ChooseTXT(remainderRoom, remainderStorey).getIsReserved().print(guest.getCheckingOutDate());
        ChooseTXT(remainderRoom, remainderStorey).getIsReserved().flush();
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {}

    @Override
    public void focusLost(FocusEvent focusEvent) {
    }

    //process money
    private double MoneyProcessing(Storey storey, int roomNum, int storeyNum, BigDecimal moneyGuestData, JLabel change, JLabel roomMessage, JLabel storeyMessage, double price, boolean isLater) {
        double changeGuestData;
        if (!isLater) {
            if (moneyGuestData.doubleValue() == (storey.getPriceForRoom() * nightsGuestData) || moneyGuestData.equals(BigDecimal.valueOf(0.00))) {
                changeGuestData = 0.00;
                change.setText(String.valueOf(String.format("%.2fBGN", changeGuestData)));
                roomMessage.setText(String.format("Стая %d", roomNum));
                storeyMessage.setText(String.format("Етаж %d", storeyNum));
            } else {
                changeGuestData = moneyGuestData.doubleValue() - (storey.getPriceForRoom() * nightsGuestData);
                change.setText(String.valueOf(String.format("%.2fBGN", changeGuestData)));
                roomMessage.setText(String.format("Стая %d", roomNum));
                storeyMessage.setText(String.format("Етаж %d", storeyNum));
            }
        } else {
            if (moneyGuestData.doubleValue() == price) {
                changeGuestData = 0.00;
                change.setText(String.valueOf(String.format("%.2fBGN", changeGuestData)));
                roomMessage.setText(String.format("Стая %d", roomNum));
                storeyMessage.setText(String.format("Етаж %d", storeyNum));
            } else {
                changeGuestData = moneyGuestData.doubleValue() - price;
                change.setText(String.valueOf(String.format("%.2fBGN", changeGuestData)));
                roomMessage.setText(String.format("Стая %d", roomNum));
                storeyMessage.setText(String.format("Етаж %d", storeyNum));
            }
        }

        return moneyGuestData.doubleValue() - changeGuestData;
    }

    //currency converter
    private static double CurrencyConverter(double moneyInCurrency) {
        double exchangeRateUSD = 1.76535;
        return exchangeRateUSD * moneyInCurrency;
    }

    //get letters
    private static boolean getLetters(String nameIn) {
        boolean isWrongLetters = true;
        boolean isCorrectLatestLetter = false;
        int aChar;

        String[] array = new String[nameIn.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(nameIn.charAt(i));
        }

        for (int i = 0; i < nameIn.length(); i++) {
            for (aChar = 0; aChar < chars.length; aChar++) {

                if (i == nameIn.length() - 1) {
                    for (char aChar1 : chars) {
                        if (array[i].equalsIgnoreCase(String.valueOf(aChar1))) {
                            isWrongLetters = true;
                            isCorrectLatestLetter = true;
                            break;
                        } else {
                            isWrongLetters = false;
                            isCorrectLatestLetter = false;
                        }
                    }
                }

                if (array[i].equalsIgnoreCase(String.valueOf(chars[aChar]))) {
                    isWrongLetters = true;
                    break;
                }
            }
            if ((i == nameIn.length() - 1) && (isWrongLetters) && (isCorrectLatestLetter)) {
                isWrongLetters = false;
                break;
            } else if (isWrongLetters && (i == nameIn.length() - 1)){
                break;
            } else if (isWrongLetters && (aChar == chars.length)){
                break;
            } else if (!isWrongLetters && (aChar == chars.length)){
                isWrongLetters = true;
                break;
            } else {
                isWrongLetters = false;
            }
        }

        return isWrongLetters;
    }

    //get numbers
    private static boolean getNumbers(String egnIn) {
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean isWrongNumbers = true;
        boolean isCorrectLatestNumber = false;
        int anInt;

        String[] array = new String[egnIn.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(egnIn.charAt(i));
        }

        for (int i = 0; i < egnIn.length(); i++) {
            for (anInt = 0; anInt < ints.length; anInt++) {

                if (i == egnIn.length() - 1) {
                    for (int anInt1 : ints) {
                        if (array[i].equalsIgnoreCase(String.valueOf(anInt1))) {
                            isWrongNumbers = true;
                            isCorrectLatestNumber = true;
                            break;
                        } else {
                            isWrongNumbers = false;
                            isCorrectLatestNumber = false;
                        }
                    }
                }

                if (array[i].equalsIgnoreCase(String.valueOf(ints[anInt]))) {
                    isWrongNumbers = true;
                    break;
                }

            }
            if ((i == egnIn.length() - 1) && (isWrongNumbers) && (isCorrectLatestNumber)) {
                isWrongNumbers = false;
                break;
            } else if (isWrongNumbers && (i == egnIn.length() - 1)){
                break;
            } else if (isWrongNumbers && (anInt == ints.length)){
                break;
            } else if (!isWrongNumbers && (anInt == ints.length)){
                isWrongNumbers = true;
                break;
            } else {
                isWrongNumbers = false;
            }
        }

        return isWrongNumbers;
    }
}
