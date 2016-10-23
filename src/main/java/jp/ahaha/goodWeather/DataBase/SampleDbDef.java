package jp.ahaha.goodWeather.DataBase;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SampleDbDef {
    @Id
    @Getter
    @Setter
    protected Long id;
    @Getter
    @Setter
    public String name;
}
