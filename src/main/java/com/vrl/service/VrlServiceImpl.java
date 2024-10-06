package com.vrl.service;

import com.vrl.dto.VrlDto;
import com.vrl.entity.VrlEntity;
import com.vrl.exceptions.ResourceNotFoundException;
import com.vrl.repository.VrlEntityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VrlServiceImpl implements VrlService {
    VrlEntity entity= new VrlEntity();
    private VrlEntityRepository repo;

    public VrlServiceImpl(VrlEntityRepository repo) {
        this.repo = repo;
    }

    @Override
    public VrlDto addVrlPassenger(VrlDto dto) {
        VrlEntity entity =dtoToentity(dto);

//        entity.setId(dto.getId());
//        entity.setName(dto.getName());
//        entity.setMobile(dto.getMobile());
//        entity.setEmailID(dto.getEmailID());
       VrlEntity savedResult = repo.save(entity);



        VrlDto dto1 = EntityToDto(savedResult);
        return dto1;
//        ResponseDto.setEmailID(savedResult.getEmailID());
//        ResponseDto.setId(savedResult.getId());
//        ResponseDto.setMobile(savedResult.getMobile());
//        ResponseDto.setName(savedResult.getName());
//        return ResponseDto;
    }

    @Override
    public void deleteVrlPassenger(long vrlUserId) {
        repo.deleteById(vrlUserId);
    }

    @Override
    public VrlEntity UpdateVrlPassenger(long vrlUserId,VrlDto dto) {
        VrlEntity vrlEntity ;
        Optional<VrlEntity> byId = repo.findById(vrlUserId);
        if(byId.isPresent()) {
            vrlEntity = byId.get();
        }else {
            throw new ResourceNotFoundException("user is not found:"+vrlUserId);

        }



        vrlEntity.setMobile(dto.getMobile());
        vrlEntity.setName(dto.getName());
        vrlEntity.setEmailID(dto.getEmailID());
        VrlEntity saved = repo.save(vrlEntity);
       return saved;

        //return savedEnt;



    }

    @Override //pagenation concept
    public List<VrlDto> DisplayVrlallPassenger(int pageSize, int pageNo, String sortBy, String sortDir) {
        Pageable pageable=null;
        if(sortDir.equalsIgnoreCase("asc")){
            pageable  = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        } else if (sortDir.equalsIgnoreCase("desc")) {
            pageable=PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        }
       // Pageable pageable = //PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());//when it declare the page it will
                                                           //not return list it return page
        Page<VrlEntity> all = repo.findAll(pageable);
        List<VrlEntity> pud = all.getContent();
        //Using Java 8 feature
        List<VrlDto> neall =pud.stream().map(p->EntityToDto(p)).collect(Collectors.toList());
        return neall;

    }

    @Override
    public VrlEntity vrlgetbyid(long vrlUserId) {
        VrlEntity vrlEntity = repo.findById(vrlUserId).orElseThrow(
                ()->new ResourceNotFoundException("User Record is not found:"+vrlUserId));

        return vrlEntity;

    }

    VrlEntity dtoToentity(VrlDto dto){
        VrlEntity entity = new VrlEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setMobile(dto.getMobile());
        entity.setEmailID(dto.getEmailID());
        return entity;

    }

    VrlDto EntityToDto(VrlEntity vr){
        VrlDto dto1 = new VrlDto();
        dto1.setEmailID(vr.getEmailID());
        dto1.setId(vr.getId());
        dto1.setMobile(vr.getMobile());
        dto1.setName(vr.getName());
        return dto1;

    }


}
