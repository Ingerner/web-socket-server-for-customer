package ru.websocketserver.domain.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Table(name = "device_turning")
public class DeviceDataTurning {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 64)
    @Column(name = "mac")
    private String mac;

    @Size(max=64)
    @Column(name = "process")
    private String process;

    @Column(name = "date")
    private LocalDateTime dateTime;
}
