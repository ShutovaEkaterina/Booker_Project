package createBooking;

public class NewBooking {
    private String firstname;
    private String lastname;
    private String additionalneeds;
    private String checkin;
    private String checkout;
    private int totalprice;
    private boolean depositpaid;

    public NewBooking(String firstname, String lastname, String additionalneeds, String checkin, String checkout, int totalprice, boolean depositpaid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.additionalneeds = additionalneeds;
        this.checkin = checkin;
        this.checkout = checkout;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
    }

    public NewBooking() {
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

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
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

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
}
