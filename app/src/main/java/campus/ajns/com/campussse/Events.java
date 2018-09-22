package campus.ajns.com.campussse;

public class Events {

    private  String evname;
    private  String evloc;
    private String evtime;
   // private String evdescri;


    public Events(String evname, String evloc,String evtime) {
        this.evname = evname;
        this.evloc = evloc;
        this.evtime=evtime;
      //  this.evdescri=evdescri;

    }

    public String getEvname() {
        return evname;
    }

    public String getEvloc() {
        return evloc;
    }

    public String getEvtime() {
        return evtime;
    }

//    public String getEvdescri() {
//        return evdescri;
//    }
}
