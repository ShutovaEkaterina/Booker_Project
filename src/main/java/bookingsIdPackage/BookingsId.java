package bookingsIdPackage;

public class BookingsId {
    private String firstname;
    private String lastname;
    private String checkin;
    private String checkout;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public BookingsId(String firstname, String lastname, String checkin, String checkout) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingsId() {
    }
}
