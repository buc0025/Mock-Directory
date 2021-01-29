public class Record {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Record(String id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        setPhoneNumber(phoneNumber);
//        this.phoneNumber = getPhoneNumber();
//        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
//        if (isValidPhoneNumber()) {
//            return phoneNumber;
//        } else {
//            return "Not a valid phone number";
//        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "Not a valid phone number";
        }
//        this.phoneNumber = phoneNumber;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        if (phoneNumber.length() == 10 || phoneNumber.length() == 11) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return getFirstName() + " " + getLastName() + "'s phone number: " + getPhoneNumber();
    }
}
