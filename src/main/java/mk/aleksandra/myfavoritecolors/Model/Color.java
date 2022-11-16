package mk.aleksandra.myfavoritecolors.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colors")
public class Color {


    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    public Long id;

    public String Name;

    public String Code;
}
