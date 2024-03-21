package database;

import java.util.Date;

public class Service extends BokaPlass {
    private double verd;
    private String umService;
    private String stadsetning;
    private Date date;

    public Service(double verd, String umService, String stadsetning, int setSaetisFjoldi) {
        this.verd = verd;
        this.stadsetning = stadsetning;
        this.umService = umService;
        setSaetisFjoldi(setSaetisFjoldi);
    }

    public boolean book(int fjoldiFolks) {
        boolean boka = bokaSaeti(fjoldiFolks);
        if(boka) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getVerd() {
        return verd;
    }

    public String getUmService() {
        return umService;
    }

    public String getStadsetning() {
        return stadsetning;
    }
}
