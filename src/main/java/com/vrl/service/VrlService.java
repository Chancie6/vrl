package com.vrl.service;

import com.vrl.dto.VrlDto;
import com.vrl.entity.VrlEntity;

import java.util.List;

public interface VrlService {


    public VrlDto addVrlPassenger(VrlDto dto);

    void deleteVrlPassenger(long vrlUserId);

    VrlEntity UpdateVrlPassenger(long vrlUserId,VrlDto dto);


    List<VrlDto> DisplayVrlallPassenger(int pageSize, int pageNo, String sortBy, String sortDir);

    VrlEntity vrlgetbyid(long vrlUserId);
}
