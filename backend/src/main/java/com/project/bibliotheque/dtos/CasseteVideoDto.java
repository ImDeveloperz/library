package com.project.bibliotheque.dtos;

import com.project.bibliotheque.entities.FormatExtention;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasseteVideoDto extends DocumentDto{
    @Enumerated(EnumType.STRING)
    private FormatExtention format ;
    private int duree;
}
