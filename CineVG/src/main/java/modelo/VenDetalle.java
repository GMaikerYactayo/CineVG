package modelo;

public class VenDetalle {

    private int IDDETVEN;
    private String CATVEN;
    private String IDCAR;
    private String IDVEN;
    private String IDSAL;
    private String ESTDETVEN;
    
    private String NOMPEL;
    private int NUMSAL;
    private String INDEX;

    public VenDetalle() {
    }
    
    public VenDetalle(VenDetalle vd) {
        this.IDDETVEN = vd.IDDETVEN;
        this.CATVEN = vd.CATVEN;
        this.IDCAR = vd.IDCAR;
        this.IDVEN = vd.IDVEN;
        this.IDSAL = vd.IDSAL;
        this.ESTDETVEN = vd.ESTDETVEN;
        this.NOMPEL = vd.NOMPEL;
        this.NUMSAL = vd.NUMSAL;
    }
    
    
    public int getIDDETVEN() {
        return IDDETVEN;
    }

    public void setIDDETVEN(int IDDETVEN) {
        this.IDDETVEN = IDDETVEN;
    }

    public String getCATVEN() {
        return CATVEN;
    }

    public void setCATVEN(String CATVEN) {
        this.CATVEN = CATVEN;
    }

    public String getIDCAR() {
        return IDCAR;
    }

    public void setIDCAR(String IDCAR) {
        this.IDCAR = IDCAR;
    }

    public String getIDVEN() {
        return IDVEN;
    }

    public void setIDVEN(String IDVEN) {
        this.IDVEN = IDVEN;
    }

    public String getIDSAL() {
        return IDSAL;
    }

    public void setIDSAL(String IDSAL) {
        this.IDSAL = IDSAL;
    }

    public String getESTDETVEN() {
        return ESTDETVEN;
    }

    public void setESTDETVEN(String ESTDETVEN) {
        this.ESTDETVEN = ESTDETVEN;
    }

    public String getNOMPEL() {
        return NOMPEL;
    }

    public void setNOMPEL(String NOMPEL) {
        this.NOMPEL = NOMPEL;
    }

    public int getNUMSAL() {
        return NUMSAL;
    }

    public void setNUMSAL(int NUMSAL) {
        this.NUMSAL = NUMSAL;
    }

    public String getINDEX() {
        return INDEX;
    }

    public void setINDEX(String INDEX) {
        this.INDEX = INDEX;
    }    
}
