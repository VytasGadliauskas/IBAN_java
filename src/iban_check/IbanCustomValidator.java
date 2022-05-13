package iban_check;


import java.util.regex.Pattern;

public class IbanCustomValidator {
    private final String iBan;
    private String country, bBan, ibanFormat;
    private int lengthConstant;

    public IbanCustomValidator(String iBan) {
        this.iBan = iBan;
        String countryCode = iBan.substring(0, 2);
        String[] ibanConst = IbanData.getIbanDataByCountryCode(countryCode);

        if (ibanConst.length > 0) {
            this.lengthConstant = Integer.parseInt(ibanConst[1]);
            this.country = ibanConst[0];
            this.bBan = ibanConst[2];
            this.ibanFormat = ibanConst[3];
        } else {
            this.country = "OTHER";
            this.lengthConstant = 0;
        }
    }

    public boolean isValid() {
        if (!Pattern.compile("^[0-9A-Z]*$").matcher(iBan).matches()) {
            return false;
        }

        if (iBan.length() != this.lengthConstant) {
            return false;
        }

        String swappedIban = iBan.substring(4) + iBan.substring(0, 4);
        return swappedIban.chars()
                .reduce(0, (int previousMod, int _char) -> {
                    int value = Integer.parseInt(Character.toString((char) _char), 36);
                    int factor = value < 10 ? 10 : 100;
                    return ((factor * previousMod + value) % 97);
                }) == 1;
    }


    public String getCountry() {
        return country;
    }
}
