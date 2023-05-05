package com.example.simplyrugbysoftware;

public class Member {
    private String DateRegex = ("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

    private String ukAddressregex = ("([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})");
    private String Fname;
    private String Sname;
    private String Sex;
    private String Email;
    private String HomeAddress;
    private int MemberID;
    static int NextID = 0;

    private String Dob;

    public Member(String fname, String sname, String sex, String email, String homeAddress, int memberID, String Dob) {
        try {
        setFname(fname);
        setSname(sname);
        setSex(sex);
        setEmail(email);
        setHomeAddress(homeAddress);
        setMemberID(memberID);
        setDob(Dob);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Member() {

    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) throws Exception{


        try {

            if (fname.matches("\\D*")){
                Fname = fname;}
            else {
                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the fname has to contain only letters");
        }



    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) throws Exception{

        try {
        if (sname.matches("\\D*")){
            Sname = sname;}
        else {
            throw new Exception();
        }
        } catch(Exception e){
            throw new Exception("the sname has to contain only letters");
    }
   }



    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) throws Exception{

        try {

//            (sex == "M" || sex == "F")

            sex.toUpperCase();
            if (sex.equals("M") || sex.equals("F")){
                Sex = sex;} else {
                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("make sure that the sex field has either M(male) or F(female)");
        }
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) throws Exception{


        try {


            if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$*")){
                Email = email;} else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("make sure that the email contains '@' and '.'");
        }


    }

    public String getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(String homeAddress) throws Exception{

        try {

            if (homeAddress.matches(ukAddressregex)){
                HomeAddress = homeAddress;} else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("make sure that the address field is a uk postcode");
        }
    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int memberID) throws Exception {


        try {
            if (memberID >= 0){
                MemberID = memberID;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the member id cannot be less than 1");
        }


    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) throws Exception {

        try {

            if (dob.matches(DateRegex)){
                Dob = dob;} else{ new Exception();}
        }catch (Exception e){
            throw new Exception("the date field is not correct");
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "Fname='" + Fname + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Email='" + Email + '\'' +
                ", HomeAddress='" + HomeAddress + '\'' +
                ", MemberID=" + MemberID +
                ", Dob=" + Dob +
                '}';
    }
}
