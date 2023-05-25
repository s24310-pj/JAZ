package pl.mickacz.michal;

public class User {

    private String accId;

    public User(String accId)
    {
        this.accId = accId;
    }


    public String getAccId() {
        return accId;
    }

    @Override
    public String toString() {
        return "User{" +
                "accId='" + accId + '\'' +
                '}';
    }
}
