package com.oodlefinance.alex.megremis.external.api.v1;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@ToString
public class MessageDTO {
    final Integer id;
    final String message;
}
