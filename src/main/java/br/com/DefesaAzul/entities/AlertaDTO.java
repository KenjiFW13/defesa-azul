package br.com.DefesaAzul.entities;

public class AlertaDTO {
    private String mmsi, nomeEmbarcacao, areaProtegida, status, timestamp;
    private Double latitude, longitude;
    private Long idAlertaDto;

    public AlertaDTO() {
    }

    public AlertaDTO(Long idAlertaDto, String mmsi, String nomeEmbarcacao, String areaProtegida, String status, String timestamp, Double latitude, Double longitude) {
        this.idAlertaDto = idAlertaDto;
        this.mmsi = mmsi;
        this.nomeEmbarcacao = nomeEmbarcacao;
        this.areaProtegida = areaProtegida;
        this.status = status;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId(){
        return idAlertaDto;
    }

    public Long getIdAlertaDto() {
        return idAlertaDto;
    }

    public void setIdAlertaDto(Long idAlertaDto) {
        this.idAlertaDto = idAlertaDto;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getNomeEmbarcacao() {
        return nomeEmbarcacao;
    }

    public void setNomeEmbarcacao(String nomeEmbarcacao) {
        this.nomeEmbarcacao = nomeEmbarcacao;
    }

    public String getAreaProtegida() {
        return areaProtegida;
    }

    public void setAreaProtegida(String areaProtegida) {
        this.areaProtegida = areaProtegida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "AlertaDTO{" +
                "idAlertaDto='" + idAlertaDto + '\'' +
                ", mmsi='" + mmsi + '\'' +
                ", nomeEmbarcacao='" + nomeEmbarcacao + '\'' +
                ", areaProtegida='" + areaProtegida + '\'' +
                ", status='" + status + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
