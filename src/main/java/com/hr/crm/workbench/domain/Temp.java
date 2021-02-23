package com.hr.crm.workbench.domain;

public class Temp {
    private String id;
    private String mag_r;
    private String u_g;
    private String g_r;
    private String r_i;
    private String i_z;
    private String z_spec;
    private String equals_nearly;
    private String equals_absolu;

    private Happy_A happy_a;

    public Happy_A getHappy_a() {
        return happy_a;
    }

    public void setHappy_a(Happy_A happy_a) {
        this.happy_a = happy_a;
    }

    public String getEquals_nearly() {
        return equals_nearly;
    }

    public void setEquals_nearly(String equals_nearly) {
        this.equals_nearly = equals_nearly;
    }

    public String getEquals_absolu() {
        return equals_absolu;
    }

    public void setEquals_absolu(String equals_absolu) {
        this.equals_absolu = equals_absolu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMag_r() {
        return mag_r;
    }

    public void setMag_r(String mag_r) {
        this.mag_r = mag_r;
    }

    public String getU_g() {
        return u_g;
    }

    public void setU_g(String u_g) {
        this.u_g = u_g;
    }

    public String getG_r() {
        return g_r;
    }

    public void setG_r(String g_r) {
        this.g_r = g_r;
    }

    public String getR_i() {
        return r_i;
    }

    public void setR_i(String r_i) {
        this.r_i = r_i;
    }

    public String getI_z() {
        return i_z;
    }

    public void setI_z(String i_z) {
        this.i_z = i_z;
    }

    public String getZ_spec() {
        return z_spec;
    }

    public void setZ_spec(String z_spec) {
        this.z_spec = z_spec;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", mag_r='" + mag_r + '\'' +
                ", u_g='" + u_g + '\'' +
                ", g_r='" + g_r + '\'' +
                ", r_i='" + r_i + '\'' +
                ", i_z='" + i_z + '\'' +
                ", z_spec='" + z_spec + '\'' +
                ", equals_nearly='" + equals_nearly + '\'' +
                ", equals_absolu='" + equals_absolu + '\'' +
                ", happy_a=" + happy_a +
                '}';
    }

}
