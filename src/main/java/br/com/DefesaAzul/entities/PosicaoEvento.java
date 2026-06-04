package br.com.DefesaAzul.entities;

public class PosicaoEvento {
    private String idPosicaoEvento;
    private float lat_posicao, lon_posicao, bbox_lat_min, bbox_lon_min, bbox_lat_max, bbox_lon_max;
    private int idEvento;

    public PosicaoEvento() {
    }

    public PosicaoEvento(String idPosicaoEvento, float lat_posicao, float lon_posicao, float bbox_lat_min, float bbox_lon_min, float bbox_lat_max, float bbox_lon_max, int idEvento) {
        this.idPosicaoEvento = idPosicaoEvento;
        this.lat_posicao = lat_posicao;
        this.lon_posicao = lon_posicao;
        this.bbox_lat_min = bbox_lat_min;
        this.bbox_lon_min = bbox_lon_min;
        this.bbox_lat_max = bbox_lat_max;
        this.bbox_lon_max = bbox_lon_max;
        this.idEvento = idEvento;
    }

    public String getIdPosicaoEvento() {
        return idPosicaoEvento;
    }

    public void setIdPosicaoEvento(String idPosicaoEvento) {
        this.idPosicaoEvento = idPosicaoEvento;
    }

    public float getLat_posicao() {
        return lat_posicao;
    }

    public void setLat_posicao(float lat_posicao) {
        this.lat_posicao = lat_posicao;
    }

    public float getLon_posicao() {
        return lon_posicao;
    }

    public void setLon_posicao(float lon_posicao) {
        this.lon_posicao = lon_posicao;
    }

    public float getBbox_lat_min() {
        return bbox_lat_min;
    }

    public void setBbox_lat_min(float bbox_lat_min) {
        this.bbox_lat_min = bbox_lat_min;
    }

    public float getBbox_lon_min() {
        return bbox_lon_min;
    }

    public void setBbox_lon_min(float bbox_lon_min) {
        this.bbox_lon_min = bbox_lon_min;
    }

    public float getBbox_lat_max() {
        return bbox_lat_max;
    }

    public void setBbox_lat_max(float bbox_lat_max) {
        this.bbox_lat_max = bbox_lat_max;
    }

    public float getBbox_lon_max() {
        return bbox_lon_max;
    }

    public void setBbox_lon_max(float bbox_lon_max) {
        this.bbox_lon_max = bbox_lon_max;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "Posição do Evento{" +
                "ID Posição Evento='" + idPosicaoEvento + '\'' +
                ", Latitude posição=" + lat_posicao +
                ", Longitude posição=" + lon_posicao +
                ", bbox_lat_min=" + bbox_lat_min +
                ", bbox_lon_min=" + bbox_lon_min +
                ", bbox_lat_max=" + bbox_lat_max +
                ", bbox_lon_max=" + bbox_lon_max +
                ", ID Evento=" + idEvento +
                '}';
    }
}
