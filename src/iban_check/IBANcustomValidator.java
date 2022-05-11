package iban_check;


public class IBANcustomValidator {
    private String country;
    private String countryCode;
    private String ibanFormat;
    private boolean isValid;
    private int lengthConstant;
    private String iBAN;
    private String bban;

    public IBANcustomValidator(String iBAN) {
        this.iBAN = iBAN;
        this.countryCode = iBAN.substring(0,2);
        String[] lineConst = IbanData.getIbanDataByCountryCode(countryCode);

        if (lineConst.length > 0) {
            this.lengthConstant = Integer.parseInt(lineConst[1]);
            this.country = lineConst[0];
            this.bban = lineConst[2];
            this.ibanFormat = lineConst[3];
            if (iBAN.length() == this.lengthConstant) {
                this.isValid = true;
            } else {
                this.isValid = false;
            }
        } else {
            this.country = "OTHER";
            this.isValid = false;
            System.out.println(Main.ANSI_RED+"IBAN number "+iBAN+" not in COUNTRY table."+Main.ANSI_RESET);
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
        return bban;
    }

    public int getLengthConstant() {
        return lengthConstant;
    }
}
