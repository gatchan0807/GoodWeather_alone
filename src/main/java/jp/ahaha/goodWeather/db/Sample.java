package jp.ahaha.goodWeather.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sample {
    @Id
    protected long id;
    @Getter
    @Setter
    public String name;
}
