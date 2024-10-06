package com.vrl.controller;

import com.vrl.dto.VrlDto;
import com.vrl.entity.VrlEntity;
import com.vrl.service.VrlService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/VrlPassenger")
@RestController
public class VrlController {
    private VrlService vrlss;

    public VrlController(VrlService vrlss) {
        this.vrlss = vrlss;
    }

    @PostMapping("/addVrlPassenger")   //validation happening here
    public ResponseEntity<?> addVrlPassenger(@Valid @RequestBody VrlDto dto, BindingResult result ){
         //condition for validation
        if (result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        VrlDto vrlDto = vrlss.addVrlPassenger(dto);
        return new ResponseEntity<>(vrlDto, HttpStatus.CREATED);




    }
    @DeleteMapping("/deleteVrlPassenger")
    public ResponseEntity<String> deleteVrlPassenger(
            @RequestParam long VrlUserId) {

        vrlss.deleteVrlPassenger(VrlUserId);
        return new ResponseEntity<>("user id has deleted",HttpStatus.OK);


    }
    //http://localhost:8080/api/v1/VrlPassenger
    @PutMapping("/{VrlUserId}")
public ResponseEntity<?>UpdateVrlPassenger(
        @PathVariable long VrlUserId,
        @RequestBody  VrlDto dto) {


        VrlEntity vrlEntity = vrlss.UpdateVrlPassenger(VrlUserId, dto);
        return new ResponseEntity<>(vrlEntity,HttpStatus.OK);
    }

   // http://localhost:8080/api/v1/VrlPassenger?pageSize=3&pageNo=0
    //http://localhost:8080/api/v1/VrlPassenger?pageSize=3&pageNo=0&sortBy=nome
    //http://localhost:8080/api/v1/VrlPassenger?pageSize=3&pageNo=0&sortBy=nome&sortDir=desc
    @GetMapping
    public ResponseEntity<List<VrlDto>>DisplayVrlallPassenger(
            @RequestParam(name = "pageSize",defaultValue = "5",required = false)int pageSize,
            @RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(name = "sortBy",defaultValue = "id",required = false)String sortBy,
            @RequestParam(name = "sortDir",defaultValue = "id",required = false)String sortDir
    ){
        List<VrlDto> vrel =vrlss.DisplayVrlallPassenger(pageSize,pageNo,sortBy,sortDir);
        return new ResponseEntity<>(vrel,HttpStatus.OK);


    }
    @GetMapping("/vrlgetbyid")
 public ResponseEntity<VrlEntity>vrlgetbyid(
         @RequestParam long VrlUserId
 ){

        VrlEntity vrlgetbyid = vrlss.vrlgetbyid(VrlUserId);
        return new ResponseEntity<>(vrlgetbyid,HttpStatus.OK);
 }

}
