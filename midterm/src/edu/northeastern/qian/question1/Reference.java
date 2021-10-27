package edu.northeastern.qian.question1;

public class Reference extends Book implements iBorrowable{
    private int borrowDate;
    private int returnDate;

    public Reference(String title, double price, String publishYear) {
        super(title, price, publishYear);
        borrowDate = -1;
        returnDate = -1;
    }

    @Override
    public String description() {
        return this.getTitle() + "(title) all information is real.";
    }

    @Override
    public void setBorrowDate(int day) {
        this.borrowDate = day;
    }

    @Override
    public void setReturnDate(int day) {
        this.returnDate = day;
    }

    @Override
    public boolean isAvailable(int day) {
        return borrowDate == -1 || day < borrowDate || (returnDate != -1 && day > returnDate);
    }
}
