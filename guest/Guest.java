package guest;

import utility.*;
import java.time.LocalDate;

public class Guest {
    private boolean isCorrect;
    private boolean isCorrectFirstLetter;
    private String firstName;
    private String secondName;
    private String thirdName;
    private int age;
    private String egn;
    private String sex;
    private int howManyPeople;
    private int nights;
    private int roomNum;
    private LocalDate checkingOutDate;
    private LocalDate offerDate;

    private Guest(String firstName, String secondName, String thirdName, int age, String egn, String sex, int howManyPeople, int nights, int roomNum,
                   LocalDate offerDate, LocalDate checkingOutDate)
            throws OutOfRangeLettersException, NameException, FirstLetterException, OutOfRangeException, EGNException, EGNNumberException {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setThirdName(thirdName);
        this.setAge(age);
        this.setEgn(egn);
        this.setSex(sex);
        this.setRoomNum(roomNum);
        this.setNights(nights);
        this.setHowManyPeople(howManyPeople);
        this.setCheckingOutDate(checkingOutDate);
        this.setOfferDate(offerDate);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) throws OutOfRangeLettersException, NameException, FirstLetterException {
        Validator.CorrectName(firstName, isCorrect, isCorrectFirstLetter);

        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    private void setSecondName(String secondName) throws OutOfRangeLettersException, NameException, FirstLetterException {
        Validator.CorrectName(secondName, isCorrect, isCorrectFirstLetter);
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    private void setThirdName(String thirdName) throws OutOfRangeLettersException, NameException, FirstLetterException {
        Validator.CorrectName(thirdName, isCorrect, isCorrectFirstLetter);

        this.thirdName = thirdName;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) throws OutOfRangeException {
        Validator.CorrectAge(age);

        this.age = age;
    }

    public String getEgn() {
        return egn;
    }

    private void setEgn(String egn) throws EGNException, EGNNumberException {
        Validator.CorrectEgn(egn, isCorrect);

        this.egn = egn;
    }

    public String getSex() {
        return sex;
    }

    private void setSex(String sex) {
        this.sex = sex;
    }

    public int getHowManyPeople() {
        return howManyPeople;
    }

    private void setHowManyPeople(int howManyPeople) {
        this.howManyPeople = howManyPeople;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getNights() {
        return nights;
    }

    private void setNights(int nights) {
        this.nights = nights;
    }

    public LocalDate getCheckingOutDate() {
        return checkingOutDate;
    }

    private void setCheckingOutDate(LocalDate checkingOutDate) {
        this.checkingOutDate = checkingOutDate;
    }

    public LocalDate getOfferDate() {
        return offerDate;
    }

    private void setOfferDate(LocalDate offerDate) {
        this.offerDate = offerDate;
    }

    public static Guest GuestSum(String firstName, String secondName, String thirdName, int age,
                                 String egn, String sex, int howManyPeople, int nights, int roomNum, LocalDate offerData, LocalDate checkingOutDateTime)
            throws FirstLetterException, EGNNumberException, EGNException, OutOfRangeException, OutOfRangeLettersException, NameException {
        return new Guest (firstName, secondName, thirdName, age, egn, sex, howManyPeople, nights, roomNum, offerData, checkingOutDateTime);
    }
}
