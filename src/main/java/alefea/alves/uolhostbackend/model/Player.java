package alefea.alves.uolhostbackend.model;

import alefea.alves.uolhostbackend.model.dto.PlayerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity(name = "players")
@Table(name = "players")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String phoneNumber;
    private String codiname;
    private GroupType groupType;

    public Player(PlayerDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.phoneNumber = dto.phoneNumber();
        this.groupType = dto.groupType();
    }
}
