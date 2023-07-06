package kc.si6b.kampuskita.Model;

import java.util.List;

public class ModelRespon {
   private  String kode, pesan;
   private List<ModelKampus> data;

    public String getKode() {
        return kode;
    }

    public String getPesan() {
        return pesan;
    }

    public List<ModelKampus> getData() {
        return data;
    }
}
