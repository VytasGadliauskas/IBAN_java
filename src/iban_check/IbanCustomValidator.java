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
        return Mod97_10(iBan);
    }

    public boolean Mod97_10(String iBan) {
        String swappedIban = iBan.substring(4) + iBan.substring(0, 4);
        char[] iBanChars = swappedIban.toCharArray();
        int prevMod = 0;
        for (char el : iBanChars) {
            int value = Integer.parseInt(Character.toString(el), 36);
            int factor = value < 10 ? 10 : 100;
            prevMod = (factor * prevMod + value) % 97;
        }
        return prevMod == 1;
    }

    public String getCountry() {
        return country;
    }
}
