package iban_check;


public class IbanCustomValidator {
    private final String country;
    private final String countryCode;
    private String ibanFormat;
    private boolean isValid;
    private int lengthConstant;
    private final String iBan;
    private String bBan;

    public IbanCustomValidator(String iBan) {
        this.iBan = iBan;
        this.countryCode = iBan.substring(0, 2);
        String[] lineConst = IbanData.getIbanDataByCountryCode(countryCode);

        if (lineConst.length > 0) {
            this.lengthConstant = Integer.parseInt(lineConst[1]);
            this.country = lineConst[0];
            this.bBan = lineConst[2];
            this.ibanFormat = lineConst[3];
            this.isValid = iBan.length() == this.lengthConstant;
        } else {
            this.country = "OTHER";
            this.isValid = false;
            System.out.println(CollorCodes.ANSI_RED.ansiCode + "IBAN number " + iBan + " not in COUNTRY table." + CollorCodes.ANSI_RESET.ansiCode);
        }
    }

    public String getCountry() {
        return country;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getIbanFormat() {
        return ibanFormat;
    }

    public String getBban() {
        return bBan;
    }

    public int getLengthConstant() {
        return lengthConstant;
    }
}
