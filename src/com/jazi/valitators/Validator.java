package com.jazi.valitators;

/**
 * Class for validators
 *
 * @author Andreev G.A.
 */
public class Validator {
    /**
     * Validates numeric value
     *
     * @param string <code>String</code> value of input
     * @return <code>true</code> if the string contains anything other than real numbers, integers and operator signs
     * and <code>false</code> otherwise
     */

    public static boolean haveLetterValidation(String string) {
        return !string.replaceAll("[^\\-?(\\d+(\\.\\d*)?|\\.\\d+)?|(-+/*().)$\n\\s]", "").equals(string);
    }

    /**
     * Validates the presence of operators of division, multiplication, subtraction, addition
     *
     * @param string <code>String</code> value of input
     * @return <code>true</code> if string not contains operator signs
     * and <code>false</code> otherwise
     */
    public static boolean noOperatorValidation(String string){
        if (string.length() == 0)
            return true;
        return string.replaceAll("[-+/*]", "").equals(string);
    }

}
