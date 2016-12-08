package utility;

public class Validator {

    public static void CorrectName(String name, boolean isCorrect, boolean isCorrectFirstLetter) throws OutOfRangeLettersException, NameException, FirstLetterException {

        if (name.length() < 2) {
            throw new OutOfRangeLettersException();
        }

        if (isCorrect) {
            throw new NameException();
        }

        if (isCorrectFirstLetter) {
            throw new FirstLetterException();
        }
    }

    public static void CorrectAge(Integer age) throws OutOfRangeException {

        if (age < 18) {
            throw new OutOfRangeException();
        }
    }

    public static void CorrectEgn(String egn, boolean isCorrect) throws EGNException, EGNNumberException {

        if ((egn.length() != 10)) {
            throw new EGNException();
        }

        if (isCorrect) {
            throw new EGNNumberException();
        }
    }
}
