package ru.websocketserver.domain.response;

import lombok.Builder;
import lombok.Data;
import ru.websocketserver.domain.entity.DeviceData;

import java.util.List;

@Data
@Builder
public class DeviceDataResponse {

    private List<DeviceData> data;
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalPages;

}
