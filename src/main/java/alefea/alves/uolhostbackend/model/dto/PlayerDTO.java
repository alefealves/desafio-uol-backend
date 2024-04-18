package alefea.alves.uolhostbackend.model.dto;

import alefea.alves.uolhostbackend.model.GroupType;

public record PlayerDTO(
        String name,
        String email,
        String phoneNumber,
        GroupType groupType
) {
}
