package mk.aleksandra.myfavoritecolors.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    @NotNull
    @Column(unique = true, length = 30)
    public String Name;


    @Column(unique = true)
    public String Code;
}
