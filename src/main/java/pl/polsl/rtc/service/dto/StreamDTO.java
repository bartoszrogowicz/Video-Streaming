package pl.polsl.rtc.service.dto;

import javax.validation.constraints.NotBlank;

public class StreamDTO {


    private long id;

    @NotBlank
    private String name;

    private String desc;

    @NotBlank
    private String url;

    public StreamDTO(long id, String name, String desc, String url) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
