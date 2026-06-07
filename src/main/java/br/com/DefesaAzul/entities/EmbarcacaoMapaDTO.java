package br.com.DefesaAzul.entities;

public class EmbarcacaoMapaDTO {

    private String mmsi;
    private String nome;
    private Double latitude;
    private Double longitude;
    private Double velocidade;
    private boolean autorizada;

    public EmbarcacaoMapaDTO() {}

    public EmbarcacaoMapaDTO(String mmsi, String nome, Double latitude,
                             Double longitude, Double velocidade, boolean autorizada) {
        this.mmsi = mmsi;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.velocidade = velocidade;
        this.autorizada = autorizada;
    }

    public String getMmsi() { return mmsi; }
    public void setMmsi(String mmsi) { this.mmsi = mmsi; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Double getVelocidade() { return velocidade; }
    public void setVelocidade(Double velocidade) { this.velocidade = velocidade; }

    public boolean isAutorizada() { return autorizada; }
    public void setAutorizada(boolean autorizada) { this.autorizada = autorizada; }

    @Override
    public String toString() {
        return "EmbarcacaoMapaDTO{" +
                "mmsi='" + mmsi + '\'' +
                ", nome='" + nome + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", velocidade=" + velocidade +
                ", autorizada=" + autorizada +
                '}';
    }
}