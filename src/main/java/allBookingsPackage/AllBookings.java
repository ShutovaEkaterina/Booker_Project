package allBookingsPackage;

import java.util.Date;

public class AllBookings {
    private String firstname;
    private String lastname;
    private Date checkin;
    private Date checkout;

    public AllBookings(String firstname, String lastname, Date checkin, Date checkout) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public AllBookings() {
    }

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

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
}
