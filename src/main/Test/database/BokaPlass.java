package database;

public class BokaPlass {
    private int fjoldiSaeta = 0;

    public void setSaetisFjoldi(int fjoldiSaeta) {
        this.fjoldiSaeta = fjoldiSaeta;
    }

    public int getSaetisFjoldi() {
        return fjoldiSaeta;
    }

    public boolean bokaSaeti(int fjoldiFolks) {
        if (fjoldiSaeta <= fjoldiFolks) {
            fjoldiSaeta -= fjoldiFolks;
            return true;
        } else {
            return false;
        }

    }
}
