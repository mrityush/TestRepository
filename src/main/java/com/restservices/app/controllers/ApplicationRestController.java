package com.restservices.app.controllers;

import com.restservices.app.command.IPRangeParameter;
import com.restservices.app.dto.ErrorResponseDto;
import com.restservices.app.dto.ResponseDto;
import com.restservices.app.dto.SuccessResponseDto;
import com.restservices.app.exceptions.DeviceNotFoundException;
import com.restservices.app.exceptions.InvalidIpPassedException;
import com.restservices.app.exceptions.IpNotMatchingWithDeviceException;
import com.restservices.app.service.interfaces.AllocationService;
import com.restservices.app.service.interfaces.HeartBeatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mrityunjaya on 7/12/17.
 */
@RestController
public class ApplicationRestController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AllocationService allocationService;
    @Autowired
    private HeartBeatService heartBeatService;


    @RequestMapping(value = "/ip/fill", method = RequestMethod.GET)
    public Boolean setIpRange(Model model) {
        Boolean responseDto = allocationService.allocateIps();
        return responseDto;
    }

    @RequestMapping(value = "/ip/range", method = RequestMethod.POST)
    public ResponseDto setIpRange(@RequestBody final IPRangeParameter rangeParameter, Model model) {
        ResponseDto responseDto = allocationService.setIpRange(rangeParameter);
        return responseDto;
    }

    @RequestMapping(value = "/ip/refresh", method = RequestMethod.POST)
    public ResponseDto setIpRange(@RequestParam final String macAddress, @RequestParam final String ipAddress, HttpServletRequest request, Model model) throws InvalidIpPassedException, IpNotMatchingWithDeviceException, DeviceNotFoundException, Exception {
        Boolean result = heartBeatService.refresh(macAddress, ipAddress);
        ResponseDto responseDto = null;
        if (result) responseDto = new SuccessResponseDto("Succesfully updated the IP");
        else responseDto = new ErrorResponseDto("Error in updating the IP");
        return responseDto;
    }

    @RequestMapping(value = "/ip/allocate", method = RequestMethod.POST)
    public ResponseDto allocateNewIp(@RequestParam final String macAddress, HttpServletRequest request, Model model) throws DeviceNotFoundException {
        ResponseDto responseDto = null;
        try {
            String result = allocationService.allocate(macAddress);
            responseDto = new SuccessResponseDto("IP Allotted : " + result);
        } catch (Exception e) {
            responseDto = new ErrorResponseDto("Error in allocating IP " + e);
        }
        return responseDto;
    }


}
