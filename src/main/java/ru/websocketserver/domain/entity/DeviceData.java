package ru.websocketserver.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "device_data")
public class DeviceData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 64)
    @Column(name = "mac")
    private String mac;

    @Column(name = "temp")
    private Integer temp;

    @Column(name = "backlight")
    private Integer backlight;

    @Column(name = "volume")
    private Integer volume;

    @Size(max = 64)
    @Column(name = "working_hours")
    private String workingHours;

}