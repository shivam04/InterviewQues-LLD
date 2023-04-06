package bms.bookmyshow.src.main.java.com.example.bookmyshow.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;

    @OneToMany
    List<Theatre> theatres;
}
