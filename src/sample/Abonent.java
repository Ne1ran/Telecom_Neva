package sample;

public class Abonent {
    private String id;
    private String fio;
    private String gender;
    private String date;
    private String number;
    private String email;
    private String addresspspt;
    private String addressact;
    private String passport;
    private String subdivision;
    private String whogave;
    private String date_pspt;
    private String contract_num;
    private String contract_date;
    private String contract_type;
    private String breakreason;
    private String personal_account;
    private String services1;
    private String services2;
    private String services3;
    private String contract_break_date;
    private String arendainfo;
    private String tech_id;

    public Abonent(String id, String fio, String gender, String date, String number, String email, String addresspspt,
                   String addressact, String passport, String subdivision, String whogave, String date_pspt,
                   String contract_num, String contract_date, String contract_type, String breakreason,
                   String personal_account, String services1, String services2, String services3,
                   String contract_break_date, String arendainfo, String tech_id) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.date = date;
        this.number = number;
        this.email = email;
        this.addresspspt = addresspspt;
        this.addressact = addressact;
        this.passport = passport;
        this.subdivision = subdivision;
        this.whogave = whogave;
        this.date_pspt = date_pspt;
        this.contract_num = contract_num;
        this.contract_date = contract_date;
        this.contract_type = contract_type;
        this.breakreason = breakreason;
        this.personal_account = personal_account;
        this.services1 = services1;
        this.services2 = services2;
        this.services3 = services3;
        this.contract_break_date = contract_break_date;
        this.arendainfo = arendainfo;
        this.tech_id = tech_id;
    }

    public Abonent() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresspspt() {
        return addresspspt;
    }

    public void setAddresspspt(String addresspspt) {
        this.addresspspt = addresspspt;
    }

    public String getAddressact() {
        return addressact;
    }

    public void setAddressact(String addressact) {
        this.addressact = addressact;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getWhogave() {
        return whogave;
    }

    public void setWhogave(String whogave) {
        this.whogave = whogave;
    }

    public String getDate_pspt() {
        return date_pspt;
    }

    public void setDate_pspt(String date_pspt) {
        this.date_pspt = date_pspt;
    }

    public String getContract_num() {
        return contract_num;
    }

    public void setContract_num(String contract_num) {
        this.contract_num = contract_num;
    }

    public String getContract_date() {
        return contract_date;
    }

    public void setContract_date(String contract_date) {
        this.contract_date = contract_date;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getBreakreason() {
        return breakreason;
    }

    public void setBreakreason(String breakreason) {
        this.breakreason = breakreason;
    }

    public String getPersonal_account() {
        return personal_account;
    }

    public void setPersonal_account(String personal_account) {
        this.personal_account = personal_account;
    }

    public String getServices1() {
        return services1;
    }

    public void setServices1(String services1) {
        this.services1 = services1;
    }

    public String getServices2() {
        return services2;
    }

    public void setServices2(String services2) {
        this.services2 = services2;
    }

    public String getServices3() {
        return services3;
    }

    public void setServices3(String services3) {
        this.services3 = services3;
    }

    public String getContract_break_date() {
        return contract_break_date;
    }

    public void setContract_break_date(String contract_break_date) {
        this.contract_break_date = contract_break_date;
    }

    public String getArendainfo() {
        return arendainfo;
    }

    public void setArendainfo(String arendainfo) {
        this.arendainfo = arendainfo;
    }

    public String getTech_id() {
        return tech_id;
    }

    public void setTech_id(String tech_id) {
        this.tech_id = tech_id;
    }
}
