package com.project.bibliotheque.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournaleDto extends DocumentDto {
    private Integer edition;
}
